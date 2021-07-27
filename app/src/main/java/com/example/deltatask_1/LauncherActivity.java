package com.example.deltatask_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }
    public void start(View v){
        Intent i=new Intent(LauncherActivity.this,MainActivity.class);
        startActivity(i);
    }
    public void hScore(View v){
        Intent intent=new Intent(LauncherActivity.this,HighScores.class);
        startActivity(intent);
    }
    public void finish(View v){
        this.finishAffinity();
    }
}