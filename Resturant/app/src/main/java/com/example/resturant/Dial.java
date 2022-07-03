
package com.example.resturant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dial extends MainActivity {
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        button = (Button) findViewById(R.id.dial);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phone = new Intent(Intent.ACTION_DIAL);
                phone.setData(Uri.parse("tel:"+1234567890));
                if(phone.resolveActivity(getPackageManager())!=null)
                    startActivity(phone);
            }
        });

    }
    public void gotoback(View v){
        Context c = getApplicationContext();
        Intent back = new Intent(c,MainActivity.class);
        startActivity(back);
    }

}