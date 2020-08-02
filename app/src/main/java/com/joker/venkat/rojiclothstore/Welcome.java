package com.joker.venkat.rojiclothstore;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    TextView textView1,t;
    Animation downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try {
            this.getSupportActionBar().hide();

        }catch (Exception e){
        }








        Thread th = new Thread(){
            @Override
            public void run(){
                try {

                    sleep(1000);
                }catch (Exception e){
                }finally {
                    Intent obj = new Intent(Welcome.this,IntroActivity.class);
                    startActivity(obj);
                }
            }
        };
        th.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
