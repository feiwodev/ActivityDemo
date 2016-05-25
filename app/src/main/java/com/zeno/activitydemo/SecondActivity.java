package com.zeno.activitydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity
        extends AppCompatActivity
{

    private static final String TAG = "zeno" ;
    private static final String FLAG = "SecondActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.i(TAG,FLAG+"--onCreate") ;
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG,FLAG+"--onStart") ;
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.i(TAG,FLAG+"--onRestart") ;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG,FLAG+"--onResume") ;
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i(TAG,FLAG+"--onPause") ;
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i(TAG,FLAG+"--onStop") ;
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG,FLAG+"--onDestroy") ;
    }
}
