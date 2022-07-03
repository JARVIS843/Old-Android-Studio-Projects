

package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Base64;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class EditImage extends AppCompatActivity {
    ImageView imageView;
    RadioButton r1; //Individual BUtton
    RadioButton r2;  //Group select
    EditText endx;
    EditText endy;
    EditText startx;
    EditText starty;
    int startxs;
    int startys;
    int endxs;
    int endys;
    int width;
    int height;
    EditText color;
    Bitmap decodedByte;
    String colors;
    int r;
    int g;
    int b;
    String inputColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image);
        imageView = (ImageView) findViewById(R.id.displayingimage);
        Intent recieve = getIntent();
        String editing = recieve.getStringExtra("decodeme");
        byte[] decodedString = Base64.decode(editing, Base64.DEFAULT);
        decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        imageView.setImageBitmap(decodedByte);
        r1 = (RadioButton) findViewById(R.id.single);
        r2 = (RadioButton) findViewById(R.id.groupselect);
        endx = (EditText) findViewById(R.id.Endx);
        endy = (EditText) findViewById(R.id.Endy);
        startx = (EditText) findViewById(R.id.startx);
        starty = (EditText) findViewById(R.id.starty);
        color = (EditText) findViewById(R.id.color);
        getWH();

            if (r1.isSelected()) {
                endx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(0)});
                endy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(0)});
                startxs = Integer.valueOf(startx.getText().toString());
                startys =Integer.valueOf(starty.getText().toString()) ;
                colors = color.getText().toString();
                int num = 1;
                int index1 = 0;
                int index2 = 0;
                for(int i = 0;i<colors.length();i++){
                    if(colors.charAt(i)==' '){
                        if(num==1){
                            r = Integer.parseInt(colors.substring(0,i));
                            index1 = i;
                            num++;
                        }
                        else if(num ==2){
                            g = Integer.parseInt(colors.substring(index1,i));
                            index2 = i;
                            break;
                        }
                    }
                }
                b = Integer.parseInt(colors.substring(index2,colors.length()));
                decodedByte.setPixel(startxs, startys, Color.rgb(r, g, b));
                imageView.setImageBitmap(decodedByte);
            }
            else if(r2.isSelected()){
                endxs = Integer.valueOf(endx.getText().toString());
                endys = Integer.valueOf(endy.getText().toString());
                startxs = Integer.valueOf(startx.getText().toString());
                startys =Integer.valueOf(starty.getText().toString()) ;
                colors = color.getText().toString();
                int num = 1;
                int index1 = 0;
                int index2 = 0;
                for(int i = 0;i<colors.length();i++){
                    if(colors.charAt(i)==' '){
                        if(num==1){
                            r = Integer.parseInt(colors.substring(0,i));
                            index1 = i;
                            num++;
                        }
                        else if(num ==2){
                            g = Integer.parseInt(colors.substring(index1,i));
                            index2 = i;
                            break;
                        }
                    }
                }
                b = Integer.parseInt(colors.substring(index2,colors.length()));

                decodedByte.setPixel(startxs, startys, Color.rgb(r, g, b));
                for(int row = startys ; row<= endys;row++){
                    for(int column = startxs;column<=endxs;column++){
                        decodedByte.setPixel(startxs, startys, Color.rgb(r, g, b));
                    }
                }
                imageView.setImageBitmap(decodedByte);
            }


    }
    public void getWH(){    //Get Width and Height of the Image
        width = decodedByte.getWidth();
        height = decodedByte.getHeight();
        Toast.makeText(this, "The width is: "+width+" The height is: "+height, Toast.LENGTH_SHORT).show();
    }

}



