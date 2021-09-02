package com.example.megagame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private EditText txt_Number = null;
    private Button btn_Compare;
    private TextView lbl_Result;
    private ProgressBar pgb_Score;
    private TextView lbl_Output;

    private static int totalTime = Activity2.seconds;
    private static int remainingSeconds = totalTime;
    private static int searchedValue;
    private static int score;
    private static int enteredValue;
    private static boolean hasBackPressed = false;
    private static Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        txt_Number = (EditText) (findViewById(R.id.txt_Number));
        btn_Compare = (Button) (findViewById(R.id.btn_Compare));
        lbl_Result = (TextView) (findViewById(R.id.lbl_Result));
        pgb_Score = (ProgressBar) (findViewById(R.id.pgb_Score));
        lbl_Output = (TextView) (findViewById(R.id.lbl_Output));

        btn_Compare.setOnClickListener(btnCompareListener);
        txt_Number.setOnEditorActionListener(btnEnterListener);
        totalTime = Activity2.seconds;

        init(timer);
        Log.i("DEBUG", "nb secondes : "+ totalTime);
    }

    private void init(Timer timer) {
        score = 0;

        hasBackPressed=false;
        remainingSeconds = totalTime;
        searchedValue = 1 + (int) (Math.random() * 100);
        Log.i("DEBUG", "Valeur cherchée : " + searchedValue);

        pgb_Score.setProgress(0);
        lbl_Result.setText("");
        lbl_Output.setText("");
        txt_Number.setText("");
        txt_Number.requestFocus();

        if (Activity2.gamemode == "montre") {

            pgb_Score.setMax(remainingSeconds);
            pgb_Score.setProgress(remainingSeconds);
            montre(timer);
        }
    }



    private void congratulations() {
        lbl_Result.setText(R.string.str_congrats);

        AlertDialog retryAlert = new AlertDialog.Builder(this).create();
        retryAlert.setTitle(R.string.app_name);
        retryAlert.setMessage(getString(R.string.str_msg, score));

        //retryAlert.setCancelable(false);
        retryAlert.setCanceledOnTouchOutside(false);

        retryAlert.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.str_Yes), new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Timer timer = new Timer();
                init(timer);
            }
        });

        retryAlert.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.str_No), new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        retryAlert.show();
    };

    private TextView.OnEditorActionListener btnEnterListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            Log.i("DEBUG", "Bouton entrer cliqué");
            btnCompareListener.onClick(btn_Compare);

            return false;
        }
    };

    private void gameOver() {
        AlertDialog gameOver = new AlertDialog.Builder(this).create();
        gameOver.setTitle(getString(R.string.str_gameOver));


        if (Activity2.gamemode == "classique") {
            gameOver.setMessage(getString(R.string.str_gameOverMsg));
        }
        else if (Activity2.gamemode == "montre"){
            gameOver.setMessage(getString(R.string.str_temps_imparti));
        }
        //gameOver.setCancelable(false);
        gameOver.setCanceledOnTouchOutside(false);

        gameOver.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.str_Yes), new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Timer timer = new Timer();
                init(timer);
            }
        });
        gameOver.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.str_No), new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        gameOver.show();
    };




    private View.OnClickListener btnCompareListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i("DEBUG", "Bouton comparer cliqué");

            String str_number = txt_Number.getText().toString();


            if (str_number.equals("")) return;

            enteredValue = Integer.parseInt(str_number);
            lbl_Output.append("  " + str_number + "\r\n");

            score++;
            if (Activity2.gamemode == "classique") {
                Log.i("Debug", "classique");
                pgb_Score.incrementProgressBy(1);
                if (score == 10) {
                    gameOver();
                }
            }
            else if(Activity2.gamemode=="montre"){
                if (remainingSeconds == 0 && enteredValue != searchedValue){
                    gameOver();
                }
                if (remainingSeconds == 0 && enteredValue == searchedValue){
                    congratulations();
                }
            }

            if (remainingSeconds>0){

                if (enteredValue == searchedValue) {
                    congratulations();

                } else if (enteredValue < searchedValue) {
                    lbl_Result.setText(R.string.str_greater);
                    txt_Number.setText("");
                    txt_Number.requestFocus();
                } else {
                    lbl_Result.setText(R.string.str_lower);
                    txt_Number.setText("");
                    txt_Number.requestFocus();
                }

            }


        }

    };

    private void montre(Timer timer) {



        TimerTask task = new TimerTask() {
            public void run() {
                remainingSeconds--;
                if (checkBack()){
                    timer.cancel();
                }
                pgb_Score.incrementProgressBy(-1);

                if (remainingSeconds == 0) {
                    timer.cancel();

                }
                if (enteredValue == searchedValue){
                    timer.cancel();

                }
            }

        };

        if(!hasBackPressed){
            timer.schedule(task, 1000, 1000);
        }


    }

    public boolean checkBack(){

        return hasBackPressed;
    }
    public void onBackPressed(){

        hasBackPressed = true;
        super.onBackPressed();

    }




}

