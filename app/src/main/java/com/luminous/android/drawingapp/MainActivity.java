package com.luminous.android.drawingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    WritingView writingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writingView = findViewById(R.id.canvasView);
        writingView = new WritingView(this);
    }
}