package com.example.deltatask_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int date,month,year,first_two,last_two,key,day,rnd0,i,rnd,dummy,fakeYear,a=0;
    public static int score=0;
    String fakeMonth;
    String[] options={"Option1","Option2","Option3","Option4"};
    Random random= new Random();
    String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    String[] monthFake={"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};


    ArrayList<Integer> array=new ArrayList<>();
    ArrayList<Integer> fakearray=new ArrayList<>();
    public static boolean leap_finder(int n)
    {
        if((n%4)==0)
        {
            if((n%400)==0)
                return true;
            else
            {
                if((n%100)==0)
                    return false;
                else
                    return true;
            }
        }
        else
            return false;
    }


    public int year_converter1(int n)
    {
        int result =0,i=0;
        while(i<=1)
        {
            result+=(Math.pow(10,i)*(n%10));
            n/=10;
            i++;
        }
        return result;
    }


    public int final_result(int n)
    {
        if(n>=0)
            return n%7;
        else if((n%7)==0)
            return 0;
        else
            return 7+(n%7);
    }


    public void setQuestion() {
        year = random.nextInt(400)+1800;
        month= random.nextInt(12)+1;
        if((month==1)|| (month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12))
            date= random.nextInt(31)+1;
        else if((month==4)||(month==6)||(month==9)||(month==11))
            date= random.nextInt(30)+1;
        else {
            if (leap_finder(year))
                date = random.nextInt(29) + 1;
            else
                date = random.nextInt(28) + 1;
        }
            fakeMonth=monthFake[month-1];
            fakeYear=year;
            if(month>2)
                month-=2;
            else
            {
                month+=10;
                year--;
            }
            last_two=year_converter1(year);
            first_two=year/100;
            key=(int)(date+Math.floor(((13*month-1)/5))+last_two+Math.floor(last_two/4)+Math.floor(first_two/4)-2*first_two);
            day=final_result(key);
            array.add(day);
    }



    public void setOptions(){
        rnd0 =random.nextInt(4);
        options[rnd0]=days[day];
        if(rnd0==0)
            dummy=1;
        else
            dummy=0;
        while(a<=2){
            for(i=0;i<7;i++){
                rnd=random.nextInt(2);
                if((rnd==1)&&(!array.contains(i))&&(dummy!=rnd0)&&(dummy<4)){
                    options[dummy]=days[i];
                    dummy++;
                    if(dummy==rnd0)
                        dummy++;
                    a++;
                    array.add(i);
                    if(a>2)
                        break;
                }
            }
        }
        a=0;
        fakearray.clear();
        fakearray=(ArrayList<Integer>) array.clone();
        array.clear();

    }


    public void setScreenOri(TextView ques,TextView[] opt){
        ques.setText(date+" "+fakeMonth+" "+fakeYear);
        for(int i=0;i<4;i++){
            opt[i].setText(options[i]);
        }
        TextView scr=findViewById(R.id.score);
        scr.setText("Your Current Score:"+score);
    }

    public void setScreen(TextView ques,TextView[] opt){
        setQuestion();
        setOptions();
        ques.setText(date+" "+fakeMonth+" "+fakeYear);
        for(int i=0;i<4;i++){
            opt[i].setText(options[i]);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        score=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView ques=findViewById(R.id.question);
        TextView[] opt={findViewById(R.id.option1),findViewById(R.id.option2),findViewById(R.id.option3),findViewById(R.id.option4)};
        setScreen(ques,opt);
    }


    public void clicked1(View view){
        TextView scr=findViewById(R.id.score);
        if(rnd0==0){
            score++;
            scr.setText("Your Current Score:"+score);
            TextView ques=findViewById(R.id.question);
            TextView[] opt={findViewById(R.id.option1),findViewById(R.id.option2),findViewById(R.id.option3),findViewById(R.id.option4)};
            setScreen(ques,opt);
        }
        else {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    }
    public void clicked2(View view){
        TextView scr=findViewById(R.id.score);
        if(rnd0==1){
            score++;
            scr.setText("Your Current Score:"+score);
            TextView ques=findViewById(R.id.question);
            TextView[] opt={findViewById(R.id.option1),findViewById(R.id.option2),findViewById(R.id.option3),findViewById(R.id.option4)};
            setScreen(ques,opt);
        }
        else {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    }
    public void clicked3(View view){
        TextView scr=findViewById(R.id.score);
        if(rnd0==2){
            score++;
            scr.setText("Your Current Score:"+score);
            TextView ques=findViewById(R.id.question);
            TextView[] opt={findViewById(R.id.option1),findViewById(R.id.option2),findViewById(R.id.option3),findViewById(R.id.option4)};
            setScreen(ques,opt);
        }
        else {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    }
    public void clicked4(View view){
        TextView scr=findViewById(R.id.score);
        if(rnd0==3){
            score++;
            scr.setText("Your Current Score:"+score);
            TextView ques=findViewById(R.id.question);
            TextView[] opt={findViewById(R.id.option1),findViewById(R.id.option2),findViewById(R.id.option3),findViewById(R.id.option4)};
            setScreen(ques,opt);
        }
        else {
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }
    }

    public int getScore() {
        return score;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Date",date);
        outState.putString("Month",fakeMonth);
        outState.putInt("Year",fakeYear);
        outState.putStringArray("Options",options);
        outState.putInt("CorrectOption",rnd0);
        outState.putInt("Score",score);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        date=savedInstanceState.getInt("Date");
        fakeMonth=savedInstanceState.getString("Month");
        fakeYear=savedInstanceState.getInt("Year");
        options=savedInstanceState.getStringArray("Options");
        rnd0=savedInstanceState.getInt("CorrectOption");
        score=savedInstanceState.getInt("Score");
        TextView ques=findViewById(R.id.question);
        TextView[] opt={findViewById(R.id.option1),findViewById(R.id.option2),findViewById(R.id.option3),findViewById(R.id.option4)};
        setScreenOri(ques,opt);
    }
}