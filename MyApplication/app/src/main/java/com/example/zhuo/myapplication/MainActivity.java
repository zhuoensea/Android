package com.example.zhuo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //逐级递增：Log.v()日志信息，Log.d()调试信息，Log.i()重要数据，Log.w()警告信息，Log.e()错误信息
        Log.d("MainActivity", "onCreate execute");
        //第一个参数tag，用于对打印信息进行过滤；第二个参数msg，即要打印的内容
    }
}
