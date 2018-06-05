package com.swelldragon.find;

import android.content.Intent;
import android.net.wifi.aware.DiscoverySession;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;

import java.util.logging.LogRecord;

public class WelomeActivity extends AppCompatActivity {
    private Timer mTimer;
    int i=0;
    ProgressBar load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置为无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置为全屏模式
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welome);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
//        Button button = (Button) findViewById(R.id.button2);
//        final android.support.constraint.ConstraintLayout loadview =(android.support.constraint.ConstraintLayout)findViewById(R.id.loadview);
        mTimer = new Timer();
        setTimerTask();
    }
    private void setTimerTask() {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);
            }
        }, 0, 30);//0ms后   10ms执行一次
    }
    private Handler handler = new Handler() {
        @Override

        public void handleMessage(Message msg) {
            if(i<=100){
                load = (ProgressBar) findViewById(R.id.progressBar);
                i++;
                load.setProgress(i);
            }
            else if(i==101){
                Intent intent = new Intent(WelomeActivity.this,sign.class);
                startActivity(intent);
                finish();
                i++;
            }
            super.handleMessage(msg);
        }
    };
}
