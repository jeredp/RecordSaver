package com.jphili.recordsaver.app.models;

import com.google.gson.Gson;

import java.util.UUID;

public abstract class Model {

    private final UUID uuid;

    protected Model() {
        this.uuid = UUID.randomUUID();
    }

    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public UUID getUuid() {
        return uuid;
    }
}
