package com.ucb.midterm.news;

public class News {
    private String headline;
    private String content;

    public News(String headline, String content) {
        this.headline = headline;
        this.content = content;
    }

    public String getHeadline() {
        return headline;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return headline;
    }
}