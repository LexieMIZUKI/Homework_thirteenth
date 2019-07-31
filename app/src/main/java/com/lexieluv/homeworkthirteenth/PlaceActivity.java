package com.lexieluv.homeworkthirteenth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class PlaceActivity extends AppCompatActivity {
    final List<String> list = new ArrayList<String>();
    @Override
    public void onCreate(Bundle savedInstancestate) {
        super.onCreate(savedInstancestate);
        setContentView(R.layout.layout_place);
        addData();
        ListView listView = findViewById(R.id.lv_place);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));
    }

    private void addData() {
        list.add("-A-");
        list.add("安庆");
        list.add("安宁");
        list.add("鞍山");
        list.add("安阳");
        list.add("-B-");
        list.add("白山");
        list.add("白银");
        list.add("保定");
        list.add("宝鸡");
        list.add("-C-");
        list.add("成都");
    }
}
