package com.mrzhang.lostfind.Activity;

import cn.bmob.v3.Bmob;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mrzhang.lostfind.R;

import com.mrzhang.lostfind.bean.UserBean;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edit_username,edit_psw;
    Button but_login,but_regist;
    UserBean userBean=null;
    Intent intent;
    boolean isAutoLogin=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("------>>初始化Bmob");
        Bmob.initialize(MainActivity.this, "19defc682eb8904705353b5ae183ccaf");
        System.out.println("------>>初始化Bmob完成");
        initView();
    }
    public void initView(){
        but_login=(Button)findViewById(R.id.but_login);
        but_regist=(Button)findViewById(R.id.but_regist);
        edit_username=(EditText)findViewById(R.id.edit_username);
        edit_psw=(EditText)findViewById(R.id.edit_psw);
        but_login.setOnClickListener(this);
        but_regist.setOnClickListener(this);
        userBean = BmobUser.getCurrentUser(UserBean.class);
        intent=getIntent();
        isAutoLogin=intent.getBooleanExtra("NotAutoLogin",true);
        if(userBean!=null&&isAutoLogin){
            edit_username.setText(userBean.getUsername());
            intent =new Intent();
            intent.setClass(MainActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.but_login:
                userBean = new UserBean();
                userBean.setUsername(edit_username.getText().toString().trim());
                userBean.setPassword(edit_psw.getText().toString().trim());
                userBean.login(new SaveListener<UserBean>() {
                    @Override
                    public void done(UserBean userBean, BmobException e) {
                        if(e==null){
                            intent =new Intent();
                            intent.setClass(MainActivity.this,HomeActivity.class);
                            intent.putExtra("username",userBean.getUsername());
                            startActivity(intent);
                            finish();
                        }else {

                            Toast.makeText(MainActivity.this,"登录失败，请检查用户名和密码后重新登陆"
                                    ,Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
            case R.id.but_regist:
                intent =new Intent();
                intent.setClass(MainActivity.this,RegistActivity.class);
                startActivity(intent);
                finish();
                break;

        }
    }
}
