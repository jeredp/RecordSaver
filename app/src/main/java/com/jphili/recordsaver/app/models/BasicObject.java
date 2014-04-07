package com.jphili.recordsaver.app.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class BasicObject extends Model {

    private String stringVal;
    private Long longVal;
    public List<String> stringList;

    public BasicObject(String stringVal, Long longVal, List<String> stringList) {
        this.stringVal = stringVal;
        this.longVal = longVal;
        this.stringList = stringList;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public Long getLongVal() {
        return longVal;
    }

    public void setLongVal(Long longVal) {
        this.longVal = longVal;
    }
}
