package com.example.megagame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;

public class Mode_devine_prix extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView txt_Title;
    private ImageView img;
    private int imageID=1;
    private int Score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_devine_prix);

        button1 = (Button) findViewById(R.id.button7);
        button2 = (Button) findViewById(R.id.button8);
        button3 = (Button) findViewById(R.id.button9);
        button4 = (Button) findViewById(R.id.button10);
        txt_Title = (TextView) findViewById(R.id.textView4);
        img = (ImageView) findViewById(R.id.image);

       setImage(imageID, img);

       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               switch (imageID){
                   case 1:
                       Answer(false);
               }
           }
       });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (imageID){
                    case 1:
                        Answer(false);
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (imageID){
                    case 1:
                        Answer(false);
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (imageID){
                    case 1:
                        Answer(true);
                }
            }
        });
    }
    private void setImage(int imageID,ImageView img){
        switch (imageID) {
            case 1:
                img.setImageResource(R.drawable.a);
                txt_Title.setText("Rhein II");
                button1.setText("8 950 €");
                button2.setText("620 €");
                button3.setText("585,4 M €");
                button4.setText("3,2 M €");
                break;
            case 2:
                img.setImageResource(R.drawable.b);
                break;

        }
    }
    private void Answer(boolean win){
        AlertDialog response= new AlertDialog.Builder(this).create();
        if (win){
            response.setMessage(getString(R.string.str_good_answer));
            Score++;
        }
        else{
            response.setMessage(getString(R.string.str_wrong_answer));
        }
        response.setCancelable(false);
        response.setCanceledOnTouchOutside(false);
        response.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.str_Yes), new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                imageID++;
                setImage(imageID, img);
            }
        });
        response.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.str_No), new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        response.show();
    }
}