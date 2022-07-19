package com.test.testui;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG ="MAin_LED_ybf";

   private EditText editText;
    private RadioGroup mradio;
    private Button ok;
    private int mcheck =1;
    private SeekBar mTextSize;
    private TextView mtextSize;
    private int mSize;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        editText = findViewById(R.id.ed_str);
        mradio = findViewById(R.id.radiogroup);
        ok = findViewById(R.id.ok);
        mTextSize = findViewById(R.id.seebar_size);
        mtextSize = findViewById(R.id.size);
        ok.setOnClickListener(this);
        mradio.check(R.id.bt1);
        mradio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getId(checkedId);
            }
        });

        mTextSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mSize = progress;
                mtextSize.setText(mSize+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public int getId(int check){
        switch (check){
            case R.id.bt1:
                mcheck = 1;
                break;
            case R.id.bt2:
                mcheck = 2;
                break;
            case R.id.bt3:
                mcheck = 3;
                break;
            case R.id.bt4:
                mcheck = 4;
                break;
            case R.id.bt5:
                mcheck = 5;
                break;
            case R.id.bt6:
                mcheck = 6;
                break;
        }
        Log.i(TAG,"checkedId = "+mcheck);
        return check;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:
                startLEDActivity();
                break;
        }
    }

    public void startLEDActivity(){
        Intent intent = new Intent(this,LEDActivity.class);
        Bundle bundle=new Bundle();
        bundle.putString("str",editText.getText().toString());
        bundle.putInt("check",mcheck);
        bundle.putInt("textsize",mSize);
        intent.putExtra("led",bundle);
        startActivity(intent);
       // finish();
    }
}