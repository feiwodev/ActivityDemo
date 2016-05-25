package com.zeno.activitydemo;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity
        extends AppCompatActivity
{

    private static final String TAG = "zeno";
    private static final String FLAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG, FLAG + "--onCreate");
        setContentView(R.layout.activity_main);


    }

    /**
     * 显示调用 ，MainActivity会先执行onPause暂停掉自己，然后SecondActivity进程onCreate--->onResume
     * 最后MainActivity执行onStop
     * @param view
     */
    public void onClick(View view)
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    /**
     * 隐式调用
     * @param view
     */
    public void filterOnClick(View view)
    {
        Intent intent = new Intent();
        /**
         * 过滤规则中有多个action ，只要有一个与之相同，则可匹配成功
         * intent 必须有action ， category 可以没有
         */
        intent.setAction("com.zeno.secondActivity") ;
        intent.setAction("com.zeno.secondActivity2") ;
        // 如果过滤规则没有此action则不能调用成功
        // intent 可以有多个action ， 但都必须和过滤规则匹配
//        intent.setAction("com.zeno.sec") ;
        intent.setDataAndType(Uri.parse("http://www.baidu.com"),"text/plan") ;
        /**
         * category 可以没有 , 一旦有就必须和过滤规则一致
         */
        intent.addCategory("com.zeno.info") ;
        // 使用隐式调用时，需要判断调用的Activity是否存在
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }else {
            Log.e(TAG,"invoke activity not found") ;
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG, FLAG + "--onStart");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.i(TAG, FLAG + "--onRestart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, FLAG + "--onResume");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i(TAG, FLAG + "--onPause");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i(TAG, FLAG + "--onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG, FLAG + "--onDestroy");
    }

    /*
    * 在Activity中配置了如下属性
    * android:configChanges="orientation|screenSize"
    * 还需要重写onConfigurationChanged方法，如此才能保证Activity在
    * 旋转屏幕时 ，Activity不会被销毁重建
    * */
    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }
}
