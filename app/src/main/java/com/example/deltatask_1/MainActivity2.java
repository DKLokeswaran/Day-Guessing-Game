package com.example.deltatask_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    MainActivity main=new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView scre=(TextView) findViewById(R.id.scrView);
        int c=main.getScore();
        scre.setText("You Scored: "+c);
    }


    public void again(View view){

        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }
    public void exitGame(View view){
        this.finishAffinity();
    }
}