package com.jphili.recordsaver.app.models;

import android.net.Uri;

public class AudioRecord extends Model {

    private String localLocation;

    public AudioRecord(String localLocation) {
        this.localLocation = localLocation;
    }

    public String getLocalLocation() {
        return localLocation;
    }
}
