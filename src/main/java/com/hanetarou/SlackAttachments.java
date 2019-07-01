package com.hanetarou;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SlackAttachments {
    public String text;
    public int id;
    public String fallback;
}
