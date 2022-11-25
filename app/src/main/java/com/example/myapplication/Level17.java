package com.example.myapplication;
//#bdc3c7

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level17 extends AppCompatActivity {


    public int count = 0;
    Dialog dialog, dialogEnd, dialogLose;
    private long backPressedTime;
    private Toast backToast;
    public int numLeft, numRight, numLeft1, numRight1, numLeft2, numRight2, numLeftS, numLeft1n, numRightS, numRight1n; //переменные для кнопок
    Random random = new Random();
    Button btr, btl;
    public ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.end_alert);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
        dialogEnd.setCancelable(false);

        dialogLose = new Dialog(this);
        dialogLose.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogLose.setContentView(R.layout.lose_alert);
        dialogLose.getWindow().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
        dialogLose.setCancelable(false);
        pb = findViewById(R.id.pBar);

        final CountDownTimer tillTheEnd = new CountDownTimer(35000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                pb.setMax(35);
                pb.setProgress((int)(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                dialogLose.show();
            }
        }.start();

        final int[] progress = {
                R.id.p1, R.id.p2, R.id.p3, R.id.p4, R.id.p5,
                R.id.p6, R.id.p7, R.id.p8, R.id.p9, R.id.p10,
                R.id.p11, R.id.p12, R.id.p13, R.id.p14, R.id.p15
        };

        final Animation a = AnimationUtils.loadAnimation(Level17.this, R.anim.alpha);

        btl = findViewById(R.id.answ1);
        btr = findViewById(R.id.answ2);

        //начало

        randomize16to20();

        //конец
        btl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btr.setEnabled(false);
                if(numLeft>numRight){
                    btl.setBackgroundResource(R.drawable.correct_answ);
                    btr.setBackgroundResource(R.drawable.wrong_answer);

                    if(count<15) count++;
                    try{
                        for (int i=0; i<15; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.progress_point);
                        } }catch (Exception e){
                        Log.d("Error is in grey points", "LeftGreyPoints");
                    }

                    for(int i=0; i<count; i++){
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.green_progress_point);
                    }
                }else{
                    btr.setBackgroundResource(R.drawable.correct_answ);
                    btl.setBackgroundResource(R.drawable.wrong_answer);
                    if(count>0) if (count==1) count=0; else count=count-2;
                    try{
                        for (int i=0; i<14; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.progress_point);
                        } }catch (Exception e){
                        Log.d("Error is in left grey points 2", "LeftGreyPoints2");
                    }

                    for(int i=0; i<count; i++){
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.green_progress_point);
                    }
                }

                if (count == 15){
                    tillTheEnd.cancel();
                    dialogEnd.show();
                    //выход из уровня
                }else{




                    //начало

                    randomize16to20();

                    //конец



                    btl.startAnimation(a);
                    btr.startAnimation(a);
                    btr.setEnabled(true);
                }
                btl.setBackgroundResource(R.drawable.start_btn_stroke);
                btr.setBackgroundResource(R.drawable.start_btn_stroke);
            }
        });



        btr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btl.setEnabled(false);
                if(numRight>numLeft){
                    btr.setBackgroundResource(R.drawable.correct_answ);
                    btl.setBackgroundResource(R.drawable.wrong_answer);

                    if(count<15) count++;
                    try{
                        for (int i=0; i<15; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.progress_point);
                        } }catch (Exception e){
                        Log.d("Error is in right grey points", "RightGreyPoints");
                    }

                    for(int i=0; i<count; i++){
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.green_progress_point);
                    }

                }else {
                    btl.setBackgroundResource(R.drawable.correct_answ);
                    btr.setBackgroundResource(R.drawable.wrong_answer);
                    if(count>0) if (count==1) count=0; else count=count-2;

                    try{
                        for (int i=0; i<14; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.progress_point);
                        } }catch (Exception e){
                        Log.d("Error is in right grey points 2", "RightGreyPoints2");
                    }

                    for(int i=0; i<count; i++){
                        TextView tv = findViewById(progress[i]);
                        tv.setBackgroundResource(R.drawable.green_progress_point);
                    }

                }

                if (count == 15){
                    tillTheEnd.cancel();
                    dialogEnd.show();
                    //выход из уровня
                }else{


                    //начало

                    randomize16to20();

                    //конец



                    btl.startAnimation(a);
                    btr.startAnimation(a);
                    btl.setEnabled(true);
                }

                btl.setBackgroundResource(R.drawable.start_btn_stroke);
                btr.setBackgroundResource(R.drawable.start_btn_stroke);
            }

        });

    }

    public void randomize16to20() throws ArithmeticException {
        int rari, rale, rarim, ralep, ralem;

        rari = random.nextInt(1);
        rale = random.nextInt(1);

        if (rari == 0) {
            numLeft1 = random.nextInt(6);
            while (numLeft1==0) numLeft1 = random.nextInt(6);
            numLeft2 = random.nextInt(6);
            while (numLeft2==0) numLeft2 = random.nextInt(6);
            numLeftS = numLeft1 * numLeft1;

            rarim = random.nextInt(1);

            if (rarim == 0) {
                numLeft = numLeftS + numLeft2;

                btl.setText(numLeft1 + "² + " + numLeft2);
            } else {
                numLeft = numLeftS - numLeft2;

                btl.setText(numLeft1 + "² - " + numLeft2);
            }
        } else {
            numLeft1 = random.nextInt(6);
            while (numLeft1==0) numLeft1 = random.nextInt(6);
            numLeft2 = random.nextInt(6);
            while (numLeft2==0) numLeft2 = random.nextInt(6);
            numLeft1n = random.nextInt(6);
            while (numLeft1n==0) numLeft1n = random.nextInt(6);
            numLeftS = numLeft1 * numLeft1n;

            rarim = random.nextInt(1);

            if (rarim == 0) {
                numLeft = numLeftS + numLeft2;

                btl.setText(numLeft1 + " * " + numLeft1n + " + " + numLeft2);
            } else {
                numLeft = numLeftS - numLeft2;

                btl.setText(numLeft1 + " * " + numLeft1n + " - " + numLeft2);
            }
        }

        if (rale == 0) {
            numRight1 = random.nextInt(6);
            while (numRight1==0) numRight1 = random.nextInt(6);
            numRight2 = random.nextInt(6);
            while (numRight2==0) numRight2 = random.nextInt(6);
            numRightS = numRight1 * numRight1;

            rarim = random.nextInt(1);

            if (rarim == 0) {
                numRight = numRightS + numRight2;

                btr.setText(numRight1 + "² + " + numRight2);
            } else {
                numRight = numRightS - numRight2;

                btl.setText(numRight1 + "² - " + numRight2);
            }
        } else {
            numRight1 = random.nextInt(6);
            while (numRight1==0) numRight1 = random.nextInt(6);
            numRight2 = random.nextInt(6);
            while (numRight2==0) numRight2 = random.nextInt(6);
            numRight1n = random.nextInt(6);
            while (numRight1n==0) numRight1n = random.nextInt(6);
            numRightS = numRight1 * numRight1n;

            rarim = random.nextInt(1);

            if (rarim == 0) {
                numRight = numRightS + numRight2;

                btl.setText(numRight1 + " * " + numRight1n + " + " + numRight2);
            } else {
                numRight = numRightS - numRight2;

                btl.setText(numRight1 + " * " + numRight1n + " - " + numRight2);
            }
        }

        while (numLeft==numRight){
            rari = random.nextInt(1);
            rale = random.nextInt(1);

            if (rari == 0) {
                numLeft1 = random.nextInt(6);
                while (numLeft1==0) numLeft1 = random.nextInt(6);
                numLeft2 = random.nextInt(6);
                while (numLeft2==0) numLeft2 = random.nextInt(6);
                numLeftS = numLeft1 * numLeft1;

                rarim = random.nextInt(1);

                if (rarim == 0) {
                    numLeft = numLeftS + numLeft2;

                    btl.setText(numLeft1 + "² + " + numLeft2);
                } else {
                    numLeft = numLeftS - numLeft2;

                    btl.setText(numLeft1 + "² - " + numLeft2);
                }
            } else {
                numLeft1 = random.nextInt(6);
                while (numLeft1==0) numLeft1 = random.nextInt(6);
                numLeft2 = random.nextInt(6);
                while (numLeft2==0) numLeft2 = random.nextInt(6);
                numLeft1n = random.nextInt(6);
                while (numLeft1n==0) numLeft1n = random.nextInt(6);
                numLeftS = numLeft1 * numLeft1n;

                rarim = random.nextInt(1);

                if (rarim == 0) {
                    numLeft = numLeftS + numLeft2;

                    btl.setText(numLeft1 + " * " + numLeft1n + " + " + numLeft2);
                } else {
                    numLeft = numLeftS - numLeft2;

                    btl.setText(numLeft1 + " * " + numLeft1n + " - " + numLeft2);
                }
            }

            if (rale == 0) {
                numRight1 = random.nextInt(6);
                while (numRight1==0) numRight1 = random.nextInt(6);
                numRight2 = random.nextInt(6);
                while (numRight2==0) numRight2 = random.nextInt(6);
                numRightS = numRight1 * numRight1;

                rarim = random.nextInt(1);

                if (rarim == 0) {
                    numRight = numRightS + numRight2;

                    btr.setText(numRight1 + "² + " + numRight2);
                } else {
                    numRight = numRightS - numRight2;

                    btl.setText(numRight1 + "² - " + numRight2);
                }
            } else {
                numRight1 = random.nextInt(6);
                while (numRight1==0) numRight1 = random.nextInt(6);
                numRight2 = random.nextInt(6);
                while (numRight2==0) numRight2 = random.nextInt(6);
                numRight1n = random.nextInt(6);
                while (numRight1n==0) numRight1n = random.nextInt(6);
                numRightS = numRight1 * numRight1n;

                rarim = random.nextInt(1);

                if (rarim == 0) {
                    numRight = numRightS + numRight2;

                    btl.setText(numRight1 + " * " + numRight1n + " + " + numRight2);
                } else {
                    numRight = numRightS - numRight2;

                    btl.setText(numRight1 + " * " + numRight1n + " - " + numRight2);
                }
            }
        }
    }


    public void closeAlert(View view){
        dialog.dismiss();
    }

    public void closeEndAlert(View view){
        Intent intent = new Intent(Level17.this, MainMenu.class);
        startActivity(intent); finish();
        dialog.dismiss();
    }


    public void restartAlert(View view){
        Intent intent = new Intent(Level17.this, Level18.class);
        startActivity(intent); finish();
        dialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            try{
                Intent intent = new Intent(Level17.this, MainMenu.class);
                startActivity(intent); finish();
            }catch (Exception e){}
        }else{
            backToast = Toast.makeText(getBaseContext(), "Press again to leave the level", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
