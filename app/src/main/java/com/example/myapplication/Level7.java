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

public class Level7 extends AppCompatActivity {


    public int count = 0;
    Dialog dialog, dialogEnd, dialogLose;
    private long backPressedTime;
    private Toast backToast;
    public int numLeft, numRight, numLeft1, numRight1, numLeft2, numRight2; //переменные для кнопок
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

        final CountDownTimer tillTheEnd = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                pb.setMax(30);
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

        final Animation a = AnimationUtils.loadAnimation(Level7.this, R.anim.alpha);
        btl = findViewById(R.id.answ1);
        btr = findViewById(R.id.answ2);

        randomize5();

        btl.startAnimation(a);
        btr.startAnimation(a);

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
                    randomize5();
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
                    randomize5();
                    btl.startAnimation(a);
                    btr.startAnimation(a);
                    btl.setEnabled(true);
                }

                btl.setBackgroundResource(R.drawable.start_btn_stroke);
                btr.setBackgroundResource(R.drawable.start_btn_stroke);
            }

        });

    }

    public void randomize5(){
        numLeft1 = random.nextInt(11);
        while(numLeft1==0) numLeft1 = random.nextInt(11);
        numLeft2 = random.nextInt(11);
        while(numLeft2==0) numLeft2 = random.nextInt(11);
        numRight1 = random.nextInt(11);
        while(numRight1==0) numRight1 = random.nextInt(11);
        numRight2 = random.nextInt(11);
        while(numRight2==0) numRight2 = random.nextInt(11);

        numRight = numRight1 * numRight2;
        numLeft = numLeft1 * numLeft2;

        while(numLeft==numRight){
            numLeft1 = random.nextInt(11);
            while(numLeft1==0) numLeft1 = random.nextInt(11);
            numLeft2 = random.nextInt(11);
            while(numLeft2==0) numLeft2 = random.nextInt(11);
            numRight1 = random.nextInt(11);
            while(numRight1==0) numRight1 = random.nextInt(11);
            numRight2 = random.nextInt(11);
            while(numRight2==0) numRight2 = random.nextInt(11);

            numRight = numRight1 * numRight2;
            numLeft = numLeft1 * numLeft2;
        }


        btl.setText(numLeft1 + " × " + numLeft2);
        btr.setText(numRight1 + " × " + numRight2);
    }

    public void closeAlert(View view){
        dialog.dismiss();
    }

    public void closeEndAlert(View view){
        Intent intent = new Intent(Level7.this, MainMenu.class);
        startActivity(intent); finish();
        dialog.dismiss();
    }


    public void restartAlert(View view){
        Intent intent = new Intent(Level7.this, Level8.class);
        startActivity(intent); finish();
        dialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            try{
                Intent intent = new Intent(Level7.this, MainMenu.class);
                startActivity(intent); finish();
            }catch (Exception e){}
        }else{
            backToast = Toast.makeText(getBaseContext(), "Press again to leave the level", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
}
