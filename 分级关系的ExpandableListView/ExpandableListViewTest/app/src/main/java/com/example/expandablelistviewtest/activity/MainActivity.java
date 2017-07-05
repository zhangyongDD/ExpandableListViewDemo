package com.example.expandablelistviewtest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.expandablelistviewtest.R;
import com.example.expandablelistviewtest.adapter.MyExpandableListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ExpandableListView expandableListView;

    /**
     * 每个分组的名字的集合
     */
    private List<String> groupList;

    /**
     * 每个分组下的每个子项的 GridView 数据集合
     */
    private List<String> itemGridList;

    /**
     * 所有分组的所有子项的 GridView 数据集合
     */
    private List<List<String>> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableList);

        // 分组
        groupList = new ArrayList<>();
        groupList.add("分组1");
        groupList.add("分组2");

        // 每个分组下的每个子项的 GridView 数据集合
        itemGridList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            itemGridList.add("电脑" + (i + 1));
        }

        // 所有分组的所有子项的 GridView 数据集合
        itemList = new ArrayList<>();
        itemList.add(itemGridList);
        itemList.add(itemGridList);
        // 创建适配器
        MyExpandableListViewAdapter adapter = new MyExpandableListViewAdapter(MainActivity.this,
                groupList, itemList);
        expandableListView.setAdapter(adapter);
        // 隐藏分组指示器
        expandableListView.setGroupIndicator(null);
        // 默认展开第一组
        expandableListView.expandGroup(0);
    }
}
