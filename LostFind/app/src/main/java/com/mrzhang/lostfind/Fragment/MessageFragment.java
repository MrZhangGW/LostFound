package com.mrzhang.lostfind.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.mrzhang.lostfind.Adapter.Message_Re_Adapter;
import com.mrzhang.lostfind.R;
import com.mrzhang.lostfind.bean.FindMessage;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2017/6/3.
 */

public class MessageFragment extends Fragment {
    private RecyclerView recycler;
    public ArrayList<FindMessage> datas = null;
    private Message_Re_Adapter message_re_adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container
            , Bundle savedInstanceState) {
        System.out.println("--->>进入oncreateView方法");
        View view = inflater.inflate(R.layout.message_fragemnt, container, false);
        System.out.println("--->>得到View");
        recycler = (RecyclerView) view.findViewById(R.id.message_recycler_view);
        System.out.println("--->>得到recycleView");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        System.out.println("--->>得到linearLayoutManager");
        recycler.setLayoutManager(linearLayoutManager);
        System.out.println("--->>为recylerView设置Layout");
//        recycler.addItemDecoration();
//        recycler.setHasFixedSize(false);
        message_re_adapter = new Message_Re_Adapter(getdatas());
        System.out.println("--->>初始化homeReAdapter，得到数据");
        recycler.setAdapter(message_re_adapter);
        System.out.println("--->>设置homeReAdapter");
        return view;
    }

    public ArrayList<FindMessage> getdatas() {

        datas = new ArrayList<>();
        FindMessage findMessage = new FindMessage();
        findMessage.setFind_username("蛮三刀");
        findMessage.setFind_date("2017/5/21");
        findMessage.setFind_context("我捡到了剑，剑圣7分46秒来蓝buff处领取~~~");
        System.out.println("-->>日期" + findMessage.getFind_date());
        datas.add(findMessage);
        findMessage = new FindMessage();
        findMessage.setFind_username("菊花信");
        findMessage.setFind_date("2017/5/22");
        findMessage.setFind_context("我捡到了大刀，交给了纳什男爵，21分请蛮三刀去找男爵要~~~");
        datas.add(findMessage);
        findMessage = new FindMessage();
        findMessage.setFind_username("易大师");
        findMessage.setFind_date("2017/5/23");
        findMessage.setFind_context("我捡到了长枪，菊花信3分39秒来红Buff处领取~~~");
        datas.add(findMessage);
        Bmob.initialize(getActivity(), "19defc682eb8904705353b5ae183ccaf");
        BmobQuery<FindMessage> bmobQuery= new BmobQuery<FindMessage>();
        bmobQuery.findObjects(new FindListener<FindMessage>() {
            @Override
            public void done(List<FindMessage> list, BmobException e) {
                if (e==null){
                    for(FindMessage findMessage:list){
                        datas.add(findMessage);
                        System.out.println("--->>查询找寻失主信息成功");
                    }
                }else{
                    System.out.println("--->>查询找寻失主信息失败"+e.getMessage());
                }
            }
        });



        for (int i = 0; i < datas.size(); i++) {
            System.out.println("--->>" + datas.get(i).getFind_date());
        }
        return datas;
    }
}
