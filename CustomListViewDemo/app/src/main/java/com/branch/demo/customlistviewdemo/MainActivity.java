package com.branch.demo.customlistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import android.widget.SimpleAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List mDatalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listView);
        mDatalist = getData();

        /**
         * SimpleAdapter 方式
         */
//        SimpleAdapter adapter = new SimpleAdapter(
//                this,mDatalist,R.layout.layout_listitem,
//                new String[]{"img","txt1","txt2"},
//                new int[]{R.id.layout_listitem_img,R.id.layout_listitem_txt1,R.id.layout_listitem_txt2,});
//        listview.setAdapter(adapter);

        /**
         * BaseAdapter 方式
         */
        listview.setAdapter(new ListAdapter());


    }


    /**
     * 初始化数据
     * @return 返回数据
     */
    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("img",R.drawable.icon);
        map.put("txt1", "标题 1");
        map.put("txt2", "内容 1");

        list.add(map);

        map = new HashMap<>();
        map.put("img",R.drawable.icon);
        map.put("txt1", "标题 2");
        map.put("txt2", "内容 2");

        list.add(map);

        map = new HashMap<>();
        map.put("img",R.drawable.icon);
        map.put("txt1", "标题 3");
        map.put("txt2", "内容 3");

        list.add(map);

        return list;
    }

    /**
     * 自定义Adapter
     */
    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mDatalist.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null)
            {
                view= LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_listitem,parent,false);
            }

            TextView text1 = (TextView) view.findViewById(R.id.layout_listitem_txt1);
            TextView text2 = (TextView) view.findViewById(R.id.layout_listitem_txt2);
            ImageView imgview = (ImageView)view.findViewById(R.id.layout_listitem_img);
            Button button = (Button)view.findViewById(R.id.layout_listitem_btn);

            Map map = (Map)mDatalist.get(position);

            text1.setText((String) map.get("txt1"));
            text2.setText((String) map.get("txt1"));
            imgview.setImageResource((int)map.get("img"));
            /**
             * 消息响应
             */
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Branch","on button click");
                }
            });

            return view;

        }
    }
}
