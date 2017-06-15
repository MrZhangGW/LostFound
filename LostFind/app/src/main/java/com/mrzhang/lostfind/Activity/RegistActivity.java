package com.mrzhang.lostfind.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mrzhang.lostfind.R;

import com.mrzhang.lostfind.bean.UserBean;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/6/3.
 */

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit_username,edit_psw,edit_email;
    Button   but_regist;
    UserBean userBean_reg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regist_layout);
        System.out.println("------>>初始化Bmob");
        Bmob.initialize(RegistActivity.this, "19defc682eb8904705353b5ae183ccaf");
        System.out.println("------>>初始化Bmob完成");
        initView();
    }

    public  void initView(){
        edit_username=(EditText)findViewById(R.id.regCount_editText);
        edit_psw=(EditText)findViewById(R.id.regPsw_editText);
        edit_email=(EditText)findViewById(R.id.regEmail_editText);
        but_regist=(Button)findViewById(R.id.but_regist2);
        but_regist.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.but_regist2:
                userBean_reg=new UserBean();
                userBean_reg.setUsername(edit_username.getText().toString().trim());
                userBean_reg.setEmail(edit_email.getText().toString().trim());
                userBean_reg.setPassword(edit_psw.getText().toString().trim());
                setBut_regist(userBean_reg);
                break;
        }
    }

    public  void setBut_regist(UserBean bu){
//注意：不能用save方法进行注册
        bu.signUp(new SaveListener<UserBean>() {
            @Override
            public void done(UserBean userBean, BmobException e) {
                if(e==null){
                    Toast.makeText(RegistActivity.this,"注册成功:"
                            +userBean.getUsername().toString(),Toast.LENGTH_LONG).show();
                    finish();
                }else{
                    Toast.makeText(RegistActivity.this,"注册失败:用户已存在!"
                            ,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
