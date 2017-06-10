package com.mrzhang.lostfind.Mannage;

import com.mrzhang.lostfind.Activity.MainActivity;
import com.mrzhang.lostfind.bean.LostMessage;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Administrator on 2017/6/9.
 */

public class LMessageManager {
    LMessageManager(){
        System.out.println("------>>初始化Bmob");
        Bmob.initialize(Bmob.getApplicationContext(), "19defc682eb8904705353b5ae183ccaf");
        System.out.println("------>>初始化Bmob完成");
    }
    public void addLMessage(LostMessage lostMessage){
            lostMessage.save(new SaveListener<String>() {
                @Override
                public void done(String objectId, BmobException e) {
                    if(e==null){
                        System.out.println("创建数据成功：" + objectId);
                    }else{
                        System.out.println("bmob"+"失败：");
                    }
                }
            });
    }

    public  void delLMessage(LostMessage lostMessage){
        lostMessage.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    System.out.println("bmob"+"成功");
                }else{
                    System.out.println("bmob"+"失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
    public List<LostMessage>  queryLMessage(){
        List <LostMessage> lostMessageList=new ArrayList<LostMessage>();
        BmobQuery<LostMessage> bmobQuery= new BmobQuery<LostMessage>();
        bmobQuery.findObjects(new FindListener<LostMessage>() {
            @Override
            public void done(List<LostMessage> list, BmobException e) {
                if (e==null){
                    for(LostMessage lostMessage:list){
//                        lostMessageList.add(lostMessage);
                    }
                }else{
                    System.out.println("查询失败"+e.getErrorCode());
                }
            }
        });
        return lostMessageList;
    }
}
