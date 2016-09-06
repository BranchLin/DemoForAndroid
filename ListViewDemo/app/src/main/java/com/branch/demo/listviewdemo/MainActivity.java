package com.branch.demo.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listView);

//        listview.setAdapter(
//                new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getData())
//        );


        SimpleAdapter adapter = new SimpleAdapter(this, getMapData(),
                android.R.layout.simple_list_item_2, new String[] { "txt1",
                "txt2" }, new int[] { android.R.id.text1,
                android.R.id.text2 });
        listview.setAdapter(adapter);

    }

    private List<String> getData(){

        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");

        return data;
    }

    private ArrayList<Map<String, String>> getMapData(){

        ArrayList<Map<String, String>> data = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();
        map.put("txt1", "第一行标题");
        map.put("txt2", "第一行内容");
        data.add(map);


        map = new HashMap<>();
        map.put("txt1", "第二行标题");
        map.put("txt2", "第二行内容");
        data.add(map);

        map = new HashMap<>();
        map.put("txt1", "第三行标题");
        map.put("txt2", "第三行内容");
        data.add(map);

        return data;
    }
}
