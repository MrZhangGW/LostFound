package com.mrzhang.lostfind.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mrzhang.lostfind.Activity.MainActivity;
import com.mrzhang.lostfind.R;

import com.mrzhang.lostfind.bean.UserBean;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2017/6/3.
 */

public class SettingFragment extends Fragment {
    Button exit_login;
    TextView tV_loginUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        exit_login=(Button)view.findViewById(R.id.but_exit_login);
        tV_loginUser=(TextView)view.findViewById(R.id.tV_loginUser);
        UserBean userBean= BmobUser.getCurrentUser(UserBean.class);
        tV_loginUser.setText(userBean.getUsername());
        exit_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(getActivity(), MainActivity.class);
                intent.putExtra("NotAutoLogin",false);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }
}
