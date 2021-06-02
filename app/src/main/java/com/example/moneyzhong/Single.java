package com.example.moneyzhong;

import android.util.Log;

public class Single {

    private static final Single instance=new Single();

    private Single(){};


    public static Single getInstance(){
        return instance;
    }


    public void SetLog(){
        Log.d("info","添加日志");
    }

}
