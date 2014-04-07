package com.jphili.recordsaver.app.models;

import com.google.gson.Gson;

/**
 * Created by ThoughtWorker on 4/6/14.
 */
public abstract class Model {
    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
