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
    private TextView txt_Score;
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
        txt_Score = (TextView) findViewById(R.id.textView3);
        txt_Score.setText("Score : "+Score);
        img = (ImageView) findViewById(R.id.image);

       setImage(imageID, img);

       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               switch (imageID){
                   case 1:
                       Answer(false);
                       break;
                   case 2:
                       Answer(false);
                       break;
                   case 3:
                       Answer(true);
                       break;
                   case 4:
                       Answer(false);
                       break;
                   case 5:
                       Answer(false);
                       break;
                   case 6:
                       Answer(false);
                       break;
                   case 7:
                       Answer(false);
                       break;
                   case 8:
                       Answer(false);
                       break;
               }
           }
       });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (imageID){
                    case 1:
                        Answer(false);
                        break;
                    case 2:
                        Answer(true);
                        break;
                    case 3:
                        Answer(false);
                        break;
                    case 4:
                        Answer(false);
                        break;
                    case 5:
                        Answer(true);
                        break;
                    case 6:
                        Answer(false);
                        break;
                    case 7:
                        Answer(false);
                        break;
                    case 8:
                        Answer(true);
                        break;
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (imageID){
                    case 1:
                        Answer(false);
                        break;
                    case 2:
                        Answer(false);
                        break;
                    case 3:
                        Answer(false);
                        break;
                    case 4:
                        Answer(false);
                        break;
                    case 5:
                        Answer(false);
                        break;
                    case 6:
                        Answer(false);
                        break;
                    case 7:
                        Answer(false);
                        break;
                    case 8:
                        Answer(false);
                        break;
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (imageID){
                    case 1:
                        Answer(true);
                        break;
                    case 2:
                        Answer(false);
                        break;
                    case 3:
                        Answer(false);
                        break;
                    case 4:
                        Answer(true);
                        break;
                    case 5:
                        Answer(false);
                        break;
                    case 6:
                        Answer(true);
                        break;
                    case 7:
                        Answer(true);
                        break;
                    case 8:
                        Answer(false);
                        break;
                }
            }
        });
    }
    private void setImage(int imageID,ImageView img){
        switch (imageID) {
            case 1:
                img.setImageResource(R.drawable.a);
                txt_Title.setText("Photographie (Rhein II)");
                button1.setText("180,4 k €");
                button2.setText("1,62 k €");
                button3.setText("585,4 M €");
                button4.setText("3,2 M €");
                break;
            case 2:
                img.setImageResource(R.drawable.b);
                txt_Title.setText("Parapluie peau crocodile");
                button1.setText("6,3 k €");
                button2.setText("42 k €");
                button3.setText("272 k €");
                button4.setText("1 M €");
                break;
            case 3:
                img.setImageResource(R.drawable.c);
                txt_Title.setText("Peinture femme africaine");
                button1.setText("6 €");
                button2.setText("6,6 k €");
                button3.setText("66,6 k €");
                button4.setText("6,6 M €");
                break;
            case 4:
                img.setImageResource(R.drawable.d);
                txt_Title.setText("Guitare faite avec le même tronc de bois");
                button1.setText("12 €");
                button2.setText("850 €");
                button3.setText("1,3 k €");
                button4.setText("85 k €");
                break;
            case 5:
                img.setImageResource(R.drawable.e);
                txt_Title.setText("Vrai costume Dark Vador");
                button1.setText("106 k €");
                button2.setText("750 K €");
                button3.setText("34 k €");
                button4.setText("2,2 M €");
                break;
            case 6:
                img.setImageResource(R.drawable.f);
                txt_Title.setText("Sculpture tibétaine");
                button1.setText("25 k €");
                button2.setText("250 k €");
                button3.setText("2,5 M €");
                button4.setText("25 €");
                break;
            case 7:
                img.setImageResource(R.drawable.g);
                txt_Title.setText("Gant de Mickael Jackson");
                button1.setText("60 K €");
                button2.setText("650 M €");
                button3.setText("43 M €");
                button4.setText("350 k €");
                break;
            case 8:
                img.setImageResource(R.drawable.h);
                txt_Title.setText("Diamant Pink Star");
                button1.setText("69 €");
                button2.setText("69 M €");
                button3.setText("690 €");
                button4.setText("6,9 k €");
                break;



        }
    }
    private void end(){
        AlertDialog game_finished = new AlertDialog.Builder(this).create();
        game_finished.setCancelable(false);
        game_finished.setCanceledOnTouchOutside(false);
        game_finished.setMessage("Vous avez terminé ! Votre score : "+Score + " sur 8");
        game_finished.setButton(AlertDialog.BUTTON_NEUTRAL,getString(R.string.str_Ok), new AlertDialog.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        game_finished.show();
        }
    private void Answer(boolean win){
        AlertDialog response= new AlertDialog.Builder(this).create();
        if (win){
            response.setMessage(getString(R.string.str_good_answer));
            Score++;
            txt_Score.setText("Score : "+Score);
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
                if (imageID==9){
                    end();
                }
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