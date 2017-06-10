package com.mrzhang.lostfind.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrzhang.lostfind.Adapter.Home_Re_Adapter;
import com.mrzhang.lostfind.R;

import java.util.ArrayList;

import com.mrzhang.lostfind.bean.LostMessage;

/**
 * Created by Administrator on 2017/6/3.
 */

public class HomeFragment extends Fragment {
    private RecyclerView recycler;
    public ArrayList<LostMessage> datas =null;
    private Home_Re_Adapter homeReAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {
        System.out.println("--->>进入oncreateView方法");
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        System.out.println("--->>得到View");
        recycler=(RecyclerView)view.findViewById(R.id.home_recycler_view);
        System.out.println("--->>得到recycleView");
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        System.out.println("--->>得到linearLayoutManager");
        recycler.setLayoutManager(linearLayoutManager);
        System.out.println("--->>为recylerView设置Layout");
//        recycler.addItemDecoration();
//        recycler.setHasFixedSize(false);
        homeReAdapter = new Home_Re_Adapter(getdatas());
        System.out.println("--->>初始化homeReAdapter，得到数据");
        recycler.setAdapter(homeReAdapter);
        System.out.println("--->>设置homeReAdapter");
        return view;
    }
    public ArrayList<LostMessage> getdatas(){
        datas=new ArrayList<>();
        LostMessage lostMessage=new LostMessage();
        lostMessage.setLost_username("易大师");
        lostMessage.setLost_date("2017/5/23");
        lostMessage.setLost_context("我的剑丢了~~——我的剑就是你的剑！");
        System.out.println("-->>日期"+lostMessage.getLost_date());
        datas.add(lostMessage);
        lostMessage=new LostMessage();
        lostMessage.setLost_username("蛮三刀");
        lostMessage.setLost_date("2017/5/22");
        lostMessage.setLost_context("我的大刀丢了~~——我的光辉时刻就是开大刀的时刻！");
        datas.add(lostMessage);
        lostMessage=new LostMessage();
        lostMessage.setLost_username("菊花信");
        lostMessage.setLost_date("2017/5/21");
        lostMessage.setLost_context("我的长枪丢了~~——一点寒芒先到，随后枪出如龙！");
        datas.add(lostMessage);
        for(int i=0;i<datas.size();i++){
            System.out.println("--->>"+datas.get(i).getLost_date());
        }
        return datas;
    }
}
