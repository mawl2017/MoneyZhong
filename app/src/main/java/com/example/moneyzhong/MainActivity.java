package com.example.moneyzhong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_one,tv_two,tv_threen;
    private TextView btn_one,btn_two,btn_threen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_one=(TextView)findViewById(R.id.tv_one);
        tv_two=(TextView)findViewById(R.id.tv_two);
        tv_threen=(TextView)findViewById(R.id.tv_threen);

        btn_one=(TextView)findViewById(R.id.btn_sel_one);
        btn_two=(TextView)findViewById(R.id.btn_sel_two);
        btn_threen=(TextView)findViewById(R.id.btn_sel_threen);


        btn_one.setOnClickListener(this::onClick);
        btn_two.setOnClickListener(this::onClick);
        btn_threen.setOnClickListener(this::onClick);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sel_one:
                String strOne=getOne();

                lotteryTicket();
                break;
            case R.id.btn_sel_two:

                break;
            case R.id.btn_sel_threen:

                break;

        }
    }

    /**
     * 双色球
     * @return
     */
    private String getOne() {
        String str="";

        return null;
    }



    private static void lotteryTicket(){
        String seq = "";
        for(int i=0; i<6; i++){ //6个红球
            seq = generateNum(seq, 33);//范围：[1,33]
        }
        generateNum("", 16);//1个蓝球，范围：[1,16]
    }

    private static String generateNum(String seq , int r){
        Long n = System.currentTimeMillis()%r+1;
        while (seq.contains(n+",")){//避免重复
            n = System.currentTimeMillis()%r+1;
        }
        try{
            Thread.sleep((int)(Math.random()*1000));//随机时间休眠
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        String str=(r==16? " + ": " ")+ n;
        Log.d("info","测试数据是=="+str);
        return seq + n + ",";
    }

}