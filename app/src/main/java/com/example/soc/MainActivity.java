package com.example.soc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout tabHome,tabStar,tabMe,tabData;
    ImageButton imgHome,imgStar,imgMe,imgData;

    TextView textHome,textStar,textMe,textData;
    Fragment homeFragment = new HomeFragment();
    Fragment dataFragment = new DataFragment();
    Fragment starFragment = new StarFragment();
    Fragment meFragment = new MeFragment();
    private MyReceiver2 myReceiver2;
    //String actionname="666";
    //Intent intent=new Intent(actionname);
    // Fragment初始化函数
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化LinearLayout和ImageButton
        tabHome = findViewById(R.id.linear_home);
        tabData = findViewById(R.id.linear_data);
        tabStar = findViewById(R.id.linear_star);
        tabMe = findViewById(R.id.linear_me);

        imgHome = (ImageButton)findViewById(R.id.img_home);
        imgData = (ImageButton)findViewById(R.id.img_data);
        imgStar = (ImageButton)findViewById(R.id.img_star);
        imgMe = (ImageButton)findViewById(R.id.img_setting);

        textHome = (TextView)findViewById(R.id.textView1);
        textData = (TextView)findViewById(R.id.textView2);
        textStar = (TextView)findViewById(R.id.textView3);
        textMe = (TextView)findViewById(R.id.textView4);
        // 设置控件的监听函数
        initEvent();
        // 初始化Fragment
        initFragment();
        selectTab(1);
        String[] permissions={Manifest.permission.RECEIVE_SMS};
        int requestCode=999;
        ActivityCompat.requestPermissions(this,permissions,requestCode);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 999) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 用户授予了短信权限，可以执行读取短信的操作
                // 执行读取短信的逻辑...
            } else {
                // 用户拒绝了短信权限，你可以根据需要进行适当的处理
            }
        }
    }

    public void initFragment(){

        // 要把四个fragment放到id为content的FrameLayout中去

        transaction.add(R.id.content, homeFragment);
        transaction.add(R.id.content, meFragment);
        transaction.add(R.id.content, starFragment);
        transaction.add(R.id.content,dataFragment);
        transaction.commit();
    }
    // 找到所有的控件

    // 利用函数控制页面切换
    private void selectTab(int i){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragment(transaction); // 将全部界面隐藏
        switch (i){
            case 1:
                transaction.show(homeFragment);
                // 设置图片为绿色的（表示选中）
                imgHome.setImageResource(R.drawable.home_g);
                textHome.setTextColor(getColor(R.color.green));
                break;
            case 2:
                transaction.show(dataFragment);
                imgData.setImageResource(R.drawable.data_g);
                textData.setTextColor(getColor(R.color.green));
                break;
            case 3:
                transaction.show(starFragment);
                imgStar.setImageResource(R.drawable.star_g);
                textStar.setTextColor(getColor(R.color.green));
                break;
            case 4:
                transaction.show(meFragment);
                imgMe.setImageResource(R.drawable.me_g);
                textMe.setTextColor(getColor(R.color.green));
                break;
            default:
                break;
        }
        transaction.commit();
    }

    // 隐藏所有的fragment
    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(homeFragment);
        transaction.hide(dataFragment);
        transaction.hide(starFragment);
        transaction.hide(meFragment);
    }
    // 监听响应函数
    @Override
    public void onClick(View v) {
        resetbut();
        int id=v.getId();
        if(id==R.id.linear_home)
            selectTab(1);
        else if(id==R.id.linear_data)
            selectTab(2);
        else if(id==R.id.linear_star)
            selectTab(3);
        else if(id==R.id.linear_me)
            selectTab(4);
    }

    // 还原初始图标函数
    private void resetbut() {
        imgHome.setImageResource(R.drawable.home_b);
        imgData.setImageResource(R.drawable.data_b);
        imgStar.setImageResource(R.drawable.star_b);
        imgMe.setImageResource(R.drawable.me_b);
        textHome.setTextColor(getColor(R.color.black));
        textData.setTextColor(getColor(R.color.black));
        textStar.setTextColor(getColor(R.color.black));
        textMe.setTextColor(getColor(R.color.black));
    }
    // 设置局部监听
    private void initEvent() {
        tabHome.setOnClickListener(this);
        tabData.setOnClickListener(this);
        tabStar.setOnClickListener(this);
        tabMe.setOnClickListener(this);
    }

}