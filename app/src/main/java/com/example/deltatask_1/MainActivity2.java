package com.example.deltatask_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    MainActivity main=new MainActivity();
    TextView scre, hiScoreDsp, msgDsp;
    int highscore[]={0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        scre=(TextView) findViewById(R.id.scrView);
        hiScoreDsp =findViewById(R.id.scr);
        msgDsp =findViewById(R.id.msg);
        int score=main.getScore();
        scre.setText("You Scored: "+score);
        getHighScore();
        for (int i=1;i<=3;i++){
            if(score>highscore[i-1]){
                int k=3-i;
                while (k>0){
                    highscore[k]=highscore[k-1];
                    k--;
                }
                highscore[i-1]=score;
                break;
            }
        }
        if(highscore[0]<=score){
            msgDsp.setText("Congrats, this is a new high score");
        }
        hiScoreDsp.setText("High Score: "+highscore[0]);
        saveHighscore();
    }


    public void again(View view){

        Intent intent=new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void mainMenu(View view){
        Intent intent=new Intent(MainActivity2.this,LauncherActivity.class);
        startActivity(intent);
        finish();
    }
    public void saveHighscore(){
        SharedPreferences sharedPreferences=this.getSharedPreferences("pref", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        for(int i=1;i<=3;i++){
            editor.putInt("highScore"+i,highscore[i-1]);
        }
        editor.commit();
    }
    public void getHighScore(){
        SharedPreferences sharedPreferences=getSharedPreferences("pref", MODE_PRIVATE);
        for (int i=1;i<=3;i++){
            highscore[i-1]=sharedPreferences.getInt("highScore"+i,0);
        }
    }
}