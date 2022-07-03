
package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.ImageReader;
import android.os.Bundle;

import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity {
    public static String EXTRA_MESSAGE="jjj";
    Intent Message;
    ImageView imageView;
    TextView textViewf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.fiimage);
        textViewf = (TextView) findViewById(R.id.bottomtext);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_CONTACTS)
                        != PackageManager.PERMISSION_GRANTED) {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, 0);
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Threre is something wrong with your app...", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {     //Camera result
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
            Context c = getApplicationContext();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] imageBytes = baos.toByteArray();
            String dimage = Base64.encodeToString(imageBytes, 0);
            Message = new Intent(MainActivity.this, Reciever.class);
            Message.putExtra("jjj", dimage);
        }
        if(requestCode==1){
            if(resultCode==1) {
                String text = data.getStringExtra("asdf");
                textViewf.setText("Comments: "+"\n"+"                    "+text);
                textViewf.setTextSize(25);
                String rating = data.getStringExtra("rating");
                Toast.makeText(getApplicationContext(), "Your rating is: "+ rating, Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void jump(View v){
        startActivityForResult(Message,1);
    }


}
