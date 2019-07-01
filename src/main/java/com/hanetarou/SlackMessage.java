package com.hanetarou;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackMessage {
    public String type;
    public String ts;
    public String user;
    public String text;
    public SlackAttachments[] attachments;
}