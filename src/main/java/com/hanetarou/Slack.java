package com.hanetarou;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Slack {
    public boolean ok;
    public boolean has_more;
    public SlackMessage[] messages;
}
