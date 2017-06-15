package com.mrzhang.lostfind.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.mrzhang.lostfind.Adapter.FriendListAdapter;
import com.mrzhang.lostfind.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/3.
 */

public class FriendsFragment extends Fragment {
    ExpandableListView listview;
    private  List<String> groupArray;
    private  List<List<String>> childArray;
    FriendListAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.friends_fragment, container, false);
        setDatas();
        listview=(ExpandableListView)view.findViewById(R.id.expandableListView1);
        adapter=new FriendListAdapter(groupArray,childArray,getActivity());
        listview.setAdapter(adapter);
        return view;
    }
    public void  setDatas(){
        groupArray = new  ArrayList<String>();
        childArray = new  ArrayList<List<String>>();

        groupArray.add("LOL" );
        groupArray.add("Actual" );


        List<String> tempArray = new  ArrayList<String>();
        tempArray.add("易大师" );
        tempArray.add("菊花信" );
        tempArray.add("蛮三刀" );
        tempArray.add("艾瑞莉娅" );

        childArray.add(tempArray);

         tempArray = new  ArrayList<String>();
        tempArray.add("admin" );
        tempArray.add("Mrzhang" );
        tempArray.add("Mrzhanggw" );
        childArray.add(tempArray);
    }
}
