package com.jphili.recordsaver.app.models;

import com.google.gson.Gson;

public abstract class Model {
    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
