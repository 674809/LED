package com.test.testui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LEDActivity extends Activity {
    private String TAG ="LED_ybf";
    LEDView view;
    private  String mStr;
    private int msid ;
    private int textSize;

    Handler mhandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            setLEDView(msid,mStr);
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 隐藏状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.led_activity);
        view=   findViewById(R.id.ledview);
        Intent intent  = getIntent();
        Bundle bundle = intent.getBundleExtra("led");
        mStr = bundle.getString("str");
        msid = bundle.getInt("check",1);
        textSize = bundle.getInt("textsize",40);
        Log.i(TAG," sid ="+msid + "----mstr ="+mStr + "textSize ="+textSize);
        mhandler.sendEmptyMessageDelayed(0,300);


    }

    @Override
    protected void onResume() {
        super.onResume();
        mhandler.sendEmptyMessageDelayed(0,300);

    }

    public void setLEDView(int  colorid, String mstr){
      //  Log.i(TAG,"setLEDView ="+colorid +"----str="+mStr);
        switch (colorid){
            case 1:
                view.setLED(mstr,getColor(R.color.read),textSize,50);
                break;
            case 2:
                view.setLED(mstr,getColor(R.color.white),textSize,50);
            break;
            case 3:
                view.setLED(mstr,getColor(R.color.purple_200),textSize,50);
            break;
            case 4:
                view.setLED(mstr,getColor(R.color.purple_500),textSize,50);
            break;
            case 5:
                view.setLED(mstr,getColor(R.color.teal_200),textSize,50);
            break;
            case 6:
                view.setLED(mstr,getColor(R.color.teal_700),textSize,50);
            break;
        }
    }
}
