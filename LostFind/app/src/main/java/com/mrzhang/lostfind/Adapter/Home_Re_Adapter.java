package com.mrzhang.lostfind.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrzhang.lostfind.R;

import java.util.List;

import com.mrzhang.lostfind.bean.LostMessage;
import com.thinkcool.circletextimageview.CircleTextImageView;

/**
 * Created by Administrator on 2017/6/4.
 */

public class Home_Re_Adapter extends RecyclerView.Adapter<Home_Re_Adapter.ViewHolder> {
    public List<LostMessage> datas;
    public Home_Re_Adapter(List<LostMessage> datas){
        this.datas=datas;
    }
    @Override
    public Home_Re_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_re_item,
        parent,false);
        ViewHolder viewHolder =new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ViewGroup.LayoutParams params =  holder.itemView.getLayoutParams();//得到item的LayoutParams布局参数

        params.height = (int)(350+Math.random()*400) ;//把随机的高度赋予itemView布局

        holder.itemView.setLayoutParams(params);//把params设置给itemView布局


        holder.h_re_img.setImageResource(R.mipmap.item_img1);
        holder.h_re_headimg.setImageResource(R.mipmap.item_headimg);
        holder.h_re_username.setText(datas.get(position).getLost_username());
        holder.h_re_date.setText(datas.get(position).getLost_date());
        holder.h_re_context.setText(datas.get(position).getLost_context());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CircleTextImageView h_re_headimg;
        public TextView h_re_username;
        public TextView h_re_date;
        public TextView h_re_context;
        public ImageView h_re_img;
        public ViewHolder(View view){
            super(view);
            h_re_headimg=(CircleTextImageView)view.findViewById(R.id.h_reg_headimg);
            h_re_username=(TextView)view.findViewById(R.id.h_reg_username);
            h_re_date=(TextView)view.findViewById(R.id.h_reg_date);
            h_re_context=(TextView) view.findViewById(R.id.h_reg_context);
            h_re_img=(ImageView) view.findViewById(R.id.h_reg_img);
        }
    }

}
