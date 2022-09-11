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

    public static final String  TAG="MainActivity";

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

        Log.d(TAG, "onCreate: 测试一下");



        Single.getInstance().SetLog();



        Log.d(TAG, "onCreate: 测试一下  第二次了 哈哈哈哈哈哈 ");


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sel_one:
                String strOne=getOne();

//                lotteryTicket();

                fucai();
                break;
            case R.id.btn_sel_two:
                daletou();
                break;
            case R.id.btn_sel_threen:
                qixingcai();
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

    //+++++++++++++++++++++++++++++
    /**
     * 七星彩 机选方法
     */
    private void qixingcai() {
        int[] qixingcai = new int[7];
        for (int i = 0; i < 7; i++) {
            qixingcai[i] = new Random().nextInt(10);
        }
        tv_threen.setText("七星彩：" + Arrays.toString(qixingcai));
    }

    /**
     * 大乐透 机选方法
     */
    private void daletou() {
        int[] r = new int[35];
        int[] b = new int[12];
        for (int i = 0; i < 35; i++) {
            r[i] = i + 1;
        }
        for (int i = 0; i < 12; i++) {
            b[i] = i + 1;
        }

        int[] red = new int[5];
        boolean[] flag = new boolean[35];
        for (int i = 0; i < 5; i++) {
            int j;
            do {
                j = new Random().nextInt(35);
            } while (flag[j]);
            red[i] = r[j];
            flag[j] = true;
        }
        int[] blue = new int[2];
        boolean[] flag1 = new boolean[12];
        for (int i = 0; i < 2; i++) {
            int j;
            do {
                j = new Random().nextInt(12);
            } while (flag[j]);
            blue[i] = b[j];
            flag[j] = true;
        }
        Arrays.sort(blue);
        Arrays.sort(red);

        tv_two.setText("红球：" + Arrays.toString(red) + "-蓝球：" + Arrays.toString(blue));
    }

    /**
     * 福彩机选 方法
     */
    private void fucai() {
        int[] r = new int[33];
        int[] b = new int[16];

        for (int i = 0; i < 33; i++) {
            r[i] = i + 1;
        }
        for (int k = 0; k < 16; k++) {
            b[k] = k + 1;
        }
        //在后台日志（logcat）中显示数组的值


        int[] red = new int[6];
        boolean[] flag = new boolean[33];//默认为false
        for (int i = 0; i < 6; i++) {
            int j;
            do {//r数组中随机选下标赋值给j
                j = new Random().nextInt(33);
            } while (flag[j]);//当j位置选过回去重新选
            red[i] = r[j];//选中标记成“已经选”
            flag[j] = true;
        }

        int blue = b[new Random().nextInt(16)];
        Arrays.sort(red);
        tv_one.setText("红球：" + Arrays.toString(red) + "-" + "蓝球：" + blue);

    }

}