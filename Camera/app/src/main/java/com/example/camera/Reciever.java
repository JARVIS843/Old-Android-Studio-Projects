

package com.example.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class Reciever extends AppCompatActivity {
    Intent send;
    String text;
    ImageView imageView;
    EditText editText;
    String rating;
    RatingBar r;
    String j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciever);
        r = (RatingBar) findViewById(R.id.ratingBar1);
        rating = ""+r.getRating();
        imageView = (ImageView) findViewById(R.id.seimage);
        editText = (EditText) findViewById(R.id.comment);
        Intent it = getIntent();
        j = it.getStringExtra("jjj");
        byte[] decodedString = Base64.decode(j, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        imageView.setImageBitmap(decodedByte);
    }
    public void backtomain(View v){
        rating = ""+r.getRating();
        Toast.makeText(v.getContext(), "The Rating is "+rating, Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                text = editText.getText().toString();
                send = new Intent(Reciever.this,MainActivity.class);
                send.putExtra("asdf",text);
                send.putExtra("rating",rating);
                setResult(1,send);
                finish();
            }
        }, 2250);
    }
    public void sendImagetoedit(View v){
        Intent edit = new Intent(Reciever.this,EditImage.class);
        edit.putExtra("decodeme",j);
        startActivityForResult(edit,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}

