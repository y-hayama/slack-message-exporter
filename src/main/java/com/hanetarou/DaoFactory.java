package com.hanetarou;

/**
 * DaoFactory
 */
public class DaoFactory {
    public SlackDao getSlackDao(String token) {
        return new SlackImpl(token);
    }
}