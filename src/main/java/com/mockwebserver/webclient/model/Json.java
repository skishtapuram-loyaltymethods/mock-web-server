package com.mockwebserver.webclient.model;

public class Json {
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Json{" +
                "title='" + title + '\'' +
                '}';
    }
}
