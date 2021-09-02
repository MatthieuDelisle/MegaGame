package com.example.megagame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity2 extends AppCompatActivity {

    private Button button;
    private Button button2;
    private Button button3;
    private FloatingActionButton arrow_up;
    private FloatingActionButton arrow_down;
    private TextView nb_seconds;


    public static int seconds=20;
    public static String gamemode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        arrow_up = (FloatingActionButton) findViewById(R.id.btn_arrow_up);
        arrow_down = (FloatingActionButton) findViewById(R.id.btn_arrow_down);
        nb_seconds = (TextView) findViewById(R.id.txt_nb_seconds);


        arrow_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                seconds++;
                String s = String.valueOf(seconds);
                nb_seconds.setText(s);
            }
        });
        arrow_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (seconds>1) {
                    seconds--;
                    String s = String.valueOf(seconds);
                    nb_seconds.setText(s);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamemode = "classique";
                open_mode_classique();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seconds = Integer.parseInt((String) nb_seconds.getText());
                gamemode = "montre";
                open_mode_classique();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamemode="prix";
                open_mode_prix();
            }
        });
    }

    public void  open_mode_prix(){
        Intent intent = new Intent(this, Mode_devine_prix.class);
        startActivity(intent);
    }

    public void open_mode_classique(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

