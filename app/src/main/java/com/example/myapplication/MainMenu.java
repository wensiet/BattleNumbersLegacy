package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void mmToLvl(View view){
        try{
            Intent intent = new Intent(MainMenu.this, Level1.class);
            startActivity(intent); finish();
        }catch (Exception e){}
    }

    public void mmToLvl2(View view){
        Intent intent = new Intent(MainMenu.this, Level2.class);
        startActivity(intent); finish();
    }

    public void mmToLvl3(View view){
        Intent intent = new Intent(MainMenu.this, Level3.class);
        startActivity(intent); finish();
    }

    public void mmToLvl4(View view){
        Intent intent = new Intent(MainMenu.this, Level4.class);
        startActivity(intent); finish();
    }

    public void mmToLvl5(View view){
        Intent intent = new Intent(MainMenu.this, Level5.class);
        startActivity(intent); finish();
    }

    public void mmToLvl6(View view){
        Intent intent = new Intent(MainMenu.this, Level6.class);
        startActivity(intent); finish();
    }

    public void mmToLvl7(View view){
        Intent intent = new Intent(MainMenu.this, Level7.class);
        startActivity(intent); finish();
    }

    public void mmToLvl8(View view){
        Intent intent = new Intent(MainMenu.this, Level8.class);
        startActivity(intent); finish();
    }

    public void mmToLvl9(View view){
        Intent intent = new Intent(MainMenu.this, Level9.class);
        startActivity(intent); finish();
    }

    public void mmToLvl10(View view){
        Intent intent = new Intent(MainMenu.this, Level10.class);
        startActivity(intent); finish();
    }

    public void mmToLvl11(View view){
        try{
        Intent intent = new Intent(MainMenu.this, Level11.class);
        startActivity(intent); finish();}catch (Exception e){}
    }

    public void mmToLvl12(View view){
        try{
            Intent intent = new Intent(MainMenu.this, Level12.class);
            startActivity(intent); finish();}catch (Exception e){}
    }

    public void mmToLvl13(View view){
        try{
            Intent intent = new Intent(MainMenu.this, Level13.class);
            startActivity(intent); finish();}catch (Exception e){}
    }

    public void mmToLvl16(View view){
        try{
            Intent intent = new Intent(MainMenu.this, Level16.class);
            startActivity(intent); finish();}catch (Exception e){}
    }

    public void mmToLvl17(View view){
        try{
            Intent intent = new Intent(MainMenu.this, Level17.class);
            startActivity(intent); finish();}catch (Exception e){}
    }

    public void mmToLvl18(View view){
        try{
            Intent intent = new Intent(MainMenu.this, Level18.class);
            startActivity(intent); finish();}catch (Exception e){}
    }


    @Override
    public void onBackPressed() {
        
        try{
            Intent intent = new Intent(MainMenu.this, MainActivity.class);
            startActivity(intent); finish();

        }catch (Exception e){}
    }
}
