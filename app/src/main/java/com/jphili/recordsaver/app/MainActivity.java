package com.jphili.recordsaver.app;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.inject.Inject;
import com.jphili.recordsaver.app.models.BasicObject;
import com.jphili.recordsaver.app.models.Model;
import com.jphili.recordsaver.db.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class MainActivity extends RoboActivity {

    @Inject
    private Repository repository;
    @InjectView(R.id.create_text_button)
    private Button createTextButton;
    @InjectView(R.id.content_view)
    private ScrollView contentView;

    private MediaRecorder recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        createTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> stringList = new ArrayList<String>();
                stringList.add("object");
                stringList.add("other");
                BasicObject basicObject = new BasicObject("val", 1l, stringList);
                repository.insert(UUID.randomUUID(), "title", basicObject.toJsonString());
                List<Model> models = repository.getData(null, null, "title");

                if(models.size() > 0) {
                    createTextView(models.get(0).getUuid().toString());
                } else {
                    createTextView("Crappy... not found!");
                }
            }
        });
    }

    private void createTextView(String text) {
        TextView textView = new TextView(this);
        textView.setText(text);
        contentView.addView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
