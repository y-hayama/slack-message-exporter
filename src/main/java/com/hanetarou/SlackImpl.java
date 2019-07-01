package com.hanetarou;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import org.json.JSONObject;

/*
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
*/

/**
 * SlackImpl
 */
public class SlackImpl implements SlackDao {
    //private final String ENDPOINT = "https://slack.com/api/channels.history";
    private final String ENDPOINT = "https://slack.com/api/groups.history";
    private String slack_token;
    private OkHttpClient httpClient;

    public SlackImpl(String token) {
        httpClient = new OkHttpClient();
        slack_token = token;
    }

    public JSONObject getPrivateChannelsHistory(String channel, int count, float latest, float oldest) throws IOException {
        Request request = new Request.Builder()
                        .url(String.format("%s?token=%s&channel=%s&count=%d&latest=%f&oldest=%f", ENDPOINT, slack_token, channel, count, latest, oldest))
                        .header("Content-Type", "application/x-www-form-urlencoded")
                        .build();
        Response response = httpClient.newCall(request).execute();
        return new JSONObject(response.body().string().toString());

        // jackson test
        //Slack slack = obj.readValue(json, Slack.class);
        //return new Slack();
    }
}
