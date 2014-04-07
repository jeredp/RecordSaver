package com.jphili.recordsaver.app.models;

import java.util.List;

public class BasicObject extends Model {

    private String stringVal;
    private Long longVal;
    public List<String> stringList;

    public BasicObject(String stringVal, Long longVal, List<String> stringList) {
        this.stringVal = stringVal;
        this.longVal = longVal;
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

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}
