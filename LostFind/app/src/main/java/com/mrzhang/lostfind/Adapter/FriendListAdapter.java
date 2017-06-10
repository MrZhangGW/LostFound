package com.mrzhang.lostfind.Adapter;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrzhang.lostfind.R;
import com.thinkcool.circletextimageview.CircleTextImageView;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */

public class FriendListAdapter extends BaseExpandableListAdapter {
    private  List<String> groupArray;
    private  List<List<String>> childArray;
    private Activity friend;
    public FriendListAdapter(List<String> groupArray, List<List<String>> childArray, Activity friend) {
        this.groupArray = groupArray;
        this.childArray = childArray;
        this.friend=friend;
    }

    public  Object getChild(int  groupPosition, int  childPosition)
    {
        return  childArray.get(groupPosition).get(childPosition);
    }
    public  long  getChildId(int  groupPosition, int  childPosition)
    {
        return  childPosition;
    }
    public  int  getChildrenCount(int  groupPosition)
    {
        return  childArray.get(groupPosition).size();
    }
    public  View getChildView(int  groupPosition, int  childPosition,
                              boolean  isLastChild, View convertView, ViewGroup parent)
    {
        String string = childArray.get(groupPosition).get(childPosition);
        if(convertView==null){
            convertView=friend.getLayoutInflater().inflate(R.layout.child_listitem,null);
        }
        CircleTextImageView child_img=(CircleTextImageView)convertView.findViewById(R.id.child_imageView1);
        TextView  child_tv=(TextView)convertView.findViewById(R.id.child_textView1);
        child_img.setImageResource(R.mipmap.item_headimg);
        child_tv.setText(childArray.get(groupPosition).get(childPosition));
        return  convertView;
    }
    // group method stub
    public  Object getGroup(int  groupPosition)
    {
        return  groupArray.get(groupPosition);
    }
    public  int  getGroupCount()
    {
        return  groupArray.size();
    }
    public  long  getGroupId(int  groupPosition)
    {
        return  groupPosition;
    }
    public  View getGroupView(int  groupPosition, boolean  isExpanded,
                              View convertView, ViewGroup parent)
    {
        if(convertView==null){
            convertView=friend.getLayoutInflater().inflate(R.layout.group,null);
        }
        TextView group_tv=(TextView) convertView.findViewById(R.id.group_tv);
        group_tv.setText(groupArray.get(groupPosition));
        return  convertView;
    }
    // View stub to create Group/Children 's View

    public  boolean  hasStableIds()
    {
        return  false ;
    }
    public  boolean  isChildSelectable(int  groupPosition, int  childPosition)
    {
        if (childArray.get(groupPosition).size()>0)   return true;
        else return false;
    }

}
