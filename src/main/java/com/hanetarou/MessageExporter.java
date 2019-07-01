package com.hanetarou;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;

/**
 * Slack message exporter
 */
public final class MessageExporter {

    /**
     * 
     * @param args The arguments of the program.
     * @throws IOException
     * @throws ParseException
     */
    public static void main(String[] args) throws IOException, ParseException {
        int count = 1000;
        AppConfig config = AppConfig.getInstance();

        // unixtimeを取得
        float latest = new Date().getTime() / 1000;
        float oldest = new SimpleDateFormat("yyyy/MM/dd").parse(config.getSlackOldestDate()).getTime() / 1000;

        System.out.println("Export start");


        // Slackの過去メッセージをエクスポートする
        JSONObject slack;
        SlackDao slackdao = new DaoFactory().getSlackDao(config.getSlackToken());
        BufferedWriter bw = Files.newBufferedWriter(Paths.get(config.getSlackLog()), Charset.defaultCharset());
        do {
            System.out.println("export " + new Date((long)(latest * 1000)).toString() + " to " + new Date((long)(oldest * 1000)).toString());

            // メッセージの取得に成功したらファイルに出力
            slack = slackdao.getPrivateChannelsHistory(config.getSlackChannel(), count, latest, oldest);
            //System.out.println(slack.toString());
            if(slack.getBoolean("ok") == false) {
                System.out.println("Get private channels history failed");
                System.out.println(slack.toString());
                System.exit(1);
            }
            else {
                bw.write(slack.toString());
            }

            // latestタイムを設定
            if (slack.getBoolean("has_more") == true) {
                latest = slack.getJSONArray("messages").getJSONObject(count-1).getFloat("ts");
            }
        } while (slack.getBoolean("has_more") == true);
        bw.flush();    

        System.out.println("Export finish");
    }
}
