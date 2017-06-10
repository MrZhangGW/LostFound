package com.mrzhang.lostfind.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2017/6/4.
 */

public class LostMessage extends BmobObject{
     String lost_username;
     String lost_date;
     String lost_context;

    public String getLost_username() {
        return lost_username;
    }

    public void setLost_username(String lost_username) {
        this.lost_username = lost_username;
    }

    public String getLost_date() {
        return lost_date;
    }

    public void setLost_date(String lost_date) {
        this.lost_date = lost_date;
    }

    public String getLost_context() {
        return lost_context;
    }

    public void setLost_context(String lost_context) {
        this.lost_context = lost_context;
    }
}
