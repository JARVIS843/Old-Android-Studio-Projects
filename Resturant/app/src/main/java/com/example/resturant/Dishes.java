


package com.example.resturant;

import android.widget.TextView;

public class Dishes {
    private TextView text;
    private int money;
    private int amount;



    public void Dishes(TextView t, int price,int amount){
        text =t;
        money = price;
        this.amount=amount;
    }

    public String getText(){
        return text.getText().toString();
    }

    public int getMoney(){
        return money;
    }
    public int getAmount(){
        return amount;
    }


}

