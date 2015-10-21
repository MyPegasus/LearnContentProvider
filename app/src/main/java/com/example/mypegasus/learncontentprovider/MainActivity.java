package com.example.mypegasus.learncontentprovider;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv = new ContentValues();
                cv.put("name", "Java");
                getContentResolver().insert(MyProvider.URI, cv);
                cv.put("name", "Swift");
                getContentResolver().insert(MyProvider.URI, cv);
                cv.put("name", "C#");
                getContentResolver().insert(MyProvider.URI, cv);

            }
        });
    }
}
