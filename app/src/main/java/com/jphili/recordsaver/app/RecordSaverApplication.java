package com.jphili.recordsaver.app;

import android.app.Application;

import com.jphili.recordsaver.db.DbHelper;
import com.jphili.recordsaver.db.Repository;

public class RecordSaverApplication extends Application {

    private Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new Repository(new DbHelper(this));
    }



    public Repository getRepository() {
        return repository;
    }
}
