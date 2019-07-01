package com.hanetarou;

import java.io.IOException;

import org.json.JSONObject;

/**
 * SlackDao
 */
public interface SlackDao {
    public JSONObject getPrivateChannelsHistory(String channel, int count, float latest, float oldest) throws IOException;
}