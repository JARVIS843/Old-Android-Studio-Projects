

package com.example.resturant;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    Vibrator vibrator;
    LinearLayout os;
    LinearLayout ut;
    TextView tv;
    public static ArrayList<Dishes> totaloutput=new ArrayList<Dishes>();
    public  static int totalprice=0;
    int number = 1;
    public static String showmenu;
    Boolean showm = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.differentdishes);
        loadmessage();
        tv.bringToFront();
        ut = (LinearLayout) findViewById(R.id.unmovabletitle);
        ut.bringToFront();
        os=(LinearLayout) findViewById(R.id.otherstuff);
        os.bringToFront();

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


    }
    public void loadmessage(){
        tv.setMovementMethod(new ScrollingMovementMethod());
        showmenu="";
        for(int i = 0;i<totaloutput.size();i++){
            showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
        }
        TextView showm = findViewById(R.id.differentdishes);
        showm.setText(""+showmenu);
    }

    public void order(View v){
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
        Context c = getApplicationContext();
        Intent a = new Intent(c,SendEmail.class);
        startActivity(a);
    }
    public void reset(View v){
        TextView total = (TextView) findViewById(R.id.totaloutput);
        totalprice=0;
        total.setText("");
        totaloutput.clear();
        number=1;
        TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        showm = false;
        showmenu="";
        TextView showm = findViewById(R.id.differentdishes);
        showm.setText(""+showmenu);

    }


    public void sub(View v){
        TextView display = findViewById(R.id.displaynum);
        if(number>=1) {
            number++;
            display.setText("" + number);
        }


    }
    public void add(View v){
        TextView display = findViewById(R.id.displaynum);
        if(number>1)
        {
            number--;
            display.setText("" + number);
        }


    }


    public void location(View v){
        Context c = getApplicationContext();
        Intent startlocation = new Intent(c,Location.class);
        startActivity(startlocation);
    }


    public void chicken(View v){
        TextView chickenn =  findViewById(R.id.pg1r1ln);
        Dishes chiken = new Dishes();
        chiken.Dishes(chickenn,30,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
    }
    public void beef(View v){
        TextView beefn=  findViewById(R.id.pg1r1rn);
        Dishes chiken = new Dishes();
        chiken.Dishes(beefn,15,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
    }
    public void rottenflesh(View v){
        TextView rottenfleshn =  findViewById(R.id.pg1r2ln);
        Dishes chiken = new Dishes();
        chiken.Dishes(rottenfleshn,50,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
        if(Build.VERSION.SDK_INT>=26){
            vibrator.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
        }
        else{
            vibrator.vibrate(500);
        }
    }
    public void pork(View v){
        TextView porkn = findViewById(R.id.pg1r2rn);
        Dishes chiken = new Dishes();
        chiken.Dishes(porkn,20,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
    }
    public void mutton(View v){
        TextView muttonn = findViewById(R.id.pg1r3ln);

        Dishes chiken = new Dishes();

        chiken.Dishes(muttonn,100,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)&&(totaloutput.size()<=5)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+=" "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
    }
    public void rabbit(View v){
        TextView rabbitn = findViewById(R.id.pg1r3rn);
        Dishes chiken = new Dishes();
        chiken.Dishes(rabbitn,20,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
    }
    public void milk(View v){
        TextView milkn =  findViewById(R.id.pg2r1ln);
        Dishes chiken = new Dishes();
        chiken.Dishes(milkn,1,number);

        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
    }
    public void water(View v){
        TextView watern = findViewById(R.id.pg2r1rn);
        Dishes chiken = new Dishes();
        chiken.Dishes(watern,0,number);
        totaloutput.add(chiken);

        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
    }
    public void strength(View v){
        TextView strengthn =  findViewById(R.id.pg2r2ln);
        Dishes chiken = new Dishes();
        chiken.Dishes(strengthn,20,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
        if(Build.VERSION.SDK_INT>=26){
            vibrator.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
        }
        else{
            vibrator.vibrate(500);
        }
    }
    public void sugar(View v){
        TextView sugarn = findViewById(R.id.pg2r2rn);
        Dishes chiken = new Dishes();
        chiken.Dishes(sugarn,10,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
    }
    public void egg(View v){
        TextView eggn =  findViewById(R.id.pg2r3ln);

        Dishes chiken = new Dishes();
        chiken.Dishes(eggn,2,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
    }
    public void eye(View v){
        TextView eyen =  findViewById(R.id.pg2r3rn);
        Dishes chiken = new Dishes();
        chiken.Dishes(eyen,10,number);
        totaloutput.add(chiken);
        Toast.makeText(this, "You have chose a dish", Toast.LENGTH_SHORT).show();
        showm=true;
        if((showm ==true)){
            showmenu="";
            for(int i = 0;i<totaloutput.size();i++){
                showmenu+="  "+totaloutput.get(i).getAmount() +" "+totaloutput.get(i).getText()+"\n";
            }
            TextView showm = findViewById(R.id.differentdishes);
            showm.setText(""+showmenu);
        }
        number = 1;TextView display = findViewById(R.id.displaynum);
        display.setText("" + number);
        TextView total = (TextView) findViewById(R.id.totaloutput);
        int faketotal=0;
        for(int i = 0;i<totaloutput.size();i++){
            faketotal+=(totaloutput.get(i).getMoney()*totaloutput.get(i).getAmount());
        }
        totalprice=faketotal;
        total.setText("The total is: "+totalprice);
        total.setTextSize(25);
    }
    public static String getShowmenu() {
        return  showmenu;
    }
    public boolean getshowm(){
        return this.showm;
    }
    public ArrayList<Dishes> getTotaloutput(){
        return this.totaloutput;
    }
    public void dial(View v){
        Context c= getApplicationContext();
        Intent i = new Intent(c,Dial.class);
        startActivity(i);
    }


}

