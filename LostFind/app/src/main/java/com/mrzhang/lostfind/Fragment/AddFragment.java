package com.mrzhang.lostfind.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mrzhang.lostfind.R;
import com.mrzhang.lostfind.bean.FindMessage;
import com.mrzhang.lostfind.bean.LostMessage;
import com.mrzhang.lostfind.bean.UserBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/6/9.
 */

public class AddFragment extends Fragment implements View.OnClickListener {
    EditText addmess_edit;
    Button addmess_but1,addmess_but2;
    RadioGroup radioGroup;
    RadioButton Lost_radio,Find_radio;
    String isLostOrFind=new String();
    UserBean userBean=new UserBean();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.addmess_fragment, container, false);
        Bmob.initialize(getActivity(), "19defc682eb8904705353b5ae183ccaf");
        userBean = BmobUser.getCurrentUser(UserBean.class);
        addmess_edit=(EditText)view.findViewById(R.id.addmess_edit);
        addmess_but1=(Button) view.findViewById(R.id.addmess_but1);
        addmess_but2=(Button)view.findViewById(R.id.addmess_but2);
        radioGroup=(RadioGroup)view.findViewById(R.id.addmess_Radiogroup);
        Lost_radio=(RadioButton)view.findViewById(R.id.add_lost_radiobut);
        Find_radio=(RadioButton)view.findViewById(R.id.add_find_radiobut);
        addmess_but1.setOnClickListener(this);
        addmess_but2.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(checkedId==Lost_radio.getId()){
                    Find_radio.setChecked(false);
                    isLostOrFind=Lost_radio.getText().toString();
                }
                if(checkedId==Find_radio.getId()){
                    Lost_radio.setChecked(false);
                    isLostOrFind=Find_radio.getText().toString();
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addmess_but1:
                if(isLostOrFind.equals("Lost")){
                    LostMessage lostMessage=new LostMessage();
                    lostMessage.setLost_username(userBean.getUsername());
                    lostMessage.setLost_context(addmess_edit.getText().toString());
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String date=df.format(new Date());
                    lostMessage.setLost_date(date);
                    lostMessage.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if(e==null){
                                Toast.makeText(getActivity(),"发布丢失消息成功",Toast.LENGTH_LONG)
                                        .show();
                            }else{
                                System.out.println("--->>"+e.getMessage());
                                Toast.makeText(getActivity(),"发布丢失消息失败",Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });

                }

            case R.id.addmess_but2:
                if(isLostOrFind.equals("Find")){
                    FindMessage foundMessage =new FindMessage();
                    foundMessage.setFind_username(userBean.getUsername());
                    foundMessage.setFind_context(addmess_edit.getText().toString());
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String date=df.format(new Date());
                    foundMessage.setFind_date(date);
                    foundMessage.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if(e==null){
                                Toast.makeText(getActivity(),"发布寻找失主消息成功",Toast.LENGTH_LONG)
                                        .show();
                            }else{
                                System.out.println("--->>"+e.getMessage());
                                Toast.makeText(getActivity(),"发布寻找失主消息失败",Toast.LENGTH_LONG)
                                        .show();
                            }
                        }
                    });

                }else System.out.println("--->>不是find");


        }
    }
}
