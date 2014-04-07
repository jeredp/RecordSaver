package com.jphili.recordsaver.app.models;

import com.google.gson.Gson;

import java.util.UUID;

public class Model {

    private final UUID uuid;
    private String title;
    private String jsonContent;

    protected Model() {
        this.uuid = UUID.randomUUID();
    }

    public Model(UUID uuid, String title, String jsonContent) {
        this.uuid = uuid;
        this.title = title;
        this.jsonContent = jsonContent;
    }

    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
