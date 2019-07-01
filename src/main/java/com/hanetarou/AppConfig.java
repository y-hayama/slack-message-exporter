package com.hanetarou;

import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private static AppConfig instnace;
    private String slack_token;
    private String slack_channel;
    private String slack_oldest_date;
    private String slack_log;

    private AppConfig() throws IOException {
        Properties env = new Properties();
        env.load(AppConfig.class.getClass().getResourceAsStream("/env.properties"));
        slack_token = env.getProperty("SLACK_TOKEN");
        slack_channel = env.getProperty("SLACK_CHANNEL_ID");
        slack_oldest_date = env.getProperty("SLACK_OLDEST_DATE");
        slack_log = env.getProperty("SLACK_LOG");
    }

    public static AppConfig getInstance() throws IOException {
        if (instnace == null) {
            instnace = new AppConfig();
        }
        return instnace;
    }

    public String getSlackToken() { return slack_token; }
    public String getSlackChannel() { return slack_channel; }
    public String getSlackOldestDate() { return slack_oldest_date; }
    public String getSlackLog() { return slack_log; }
}
