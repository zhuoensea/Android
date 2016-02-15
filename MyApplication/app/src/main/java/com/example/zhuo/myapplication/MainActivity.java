package com.example.zhuo.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /******** 任何活动中都应该重写onCreate()方法 ********/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //引用布局文件activity_main.xml
        /******** LogCat ********
        * 逐级递增：Log.v()日志信息，Log.d()调试信息，Log.i()重要数据，Log.w()警告信息，Log.e()错误信息
        * 传入两个参数：第一个参数tag，用于对打印信息进行过滤；第二个参数msg，即要打印的内容 */
        Log.d("MainActivity", "onCreate execute");

        /******** Button ********/
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /******** Toast ********
                 * makeText()方法需要三个参数，第一个是Context，也就是Toast要求的上下文；第二个参数是Toast显示的文本内痛；第三个参数是Toast显示的时长 */
                //Toast.makeText(MainActivity.this, "You clicked Button 1", Toast.LENGTH_SHORT).show();

                /** Intent  在不同组件中传递数据 ********
                ******** 显式Intent ********
                 * 接收两个参数，第一个参数Context要求提供一个启动活动的上下文；第二个参数Class指定要启动的目标活动*/
                //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                /******** 隐式Intent ********
                 * 需要<action>, <category> 同时匹配才能响应*/
                //Intent intent = new Intent("com.example.zhuo.myapplication.activitytest.ACTION_START");
                /******** Intent实现程序间功能共享 ********/
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent.setData(Uri.parse("tel:10086"));
                /******** 利用Intent向下一个活动传递数据 ********/
                String data = "Hello ThirdActivity";
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra("extra_data", data);

                startActivity(intent);
            }
        });
    }

    /******** Menu ********/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /** inflate()方法接收两个参数，第一个传入创建菜单的资源文件，第二个传入要添加菜单的Menu对象 */
        getMenuInflater().inflate(R.menu.main, menu);
        return true; //true：允许菜单显示
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }
}
