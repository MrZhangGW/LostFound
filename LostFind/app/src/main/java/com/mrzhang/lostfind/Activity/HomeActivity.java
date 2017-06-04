package com.mrzhang.lostfind.Activity;

import android.app.Activity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.mrzhang.lostfind.Fragment.FriendsFragment;
import com.mrzhang.lostfind.Fragment.HomeFragment;
import com.mrzhang.lostfind.Fragment.MessageFragment;
import com.mrzhang.lostfind.Fragment.SettingFragment;
import com.mrzhang.lostfind.R;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Administrator on 2017/6/3.
 */

public class HomeActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener{
    BottomNavigationBar bottomNavigationBar;
    HomeFragment homeFragment;
    FriendsFragment friendsFragment;
    SettingFragment settingFragment;
    MessageFragment messageFragment;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        initView();
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher,"Home"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher,"Message"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher,"Friends"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_launcher,"Setting"))

                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }
    public void initView(){
        bottomNavigationBar=(BottomNavigationBar)findViewById(R.id.home_navigation_bar);
    }

    public  void  setDefaultFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.replace(R.id.id_content, homeFragment);
        transaction.commit();
    }
    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                transaction.replace(R.id.id_content, homeFragment);
                break;
            case 1:
                if (messageFragment == null) {
                    messageFragment = new MessageFragment();
                }
                transaction.replace(R.id.id_content, messageFragment);
                break;
            case 2:
                if (friendsFragment == null) {
                    friendsFragment = new FriendsFragment();
                }
                transaction.replace(R.id.id_content, friendsFragment);
                break;
            case 3:
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                }
                transaction.replace(R.id.id_content, settingFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
