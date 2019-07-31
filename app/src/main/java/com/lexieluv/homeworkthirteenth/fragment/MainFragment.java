package com.lexieluv.homeworkthirteenth.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lexieluv.homeworkthirteenth.DataUtil;
import com.lexieluv.homeworkthirteenth.DownAsynctask;
import com.lexieluv.homeworkthirteenth.FoodActivity;
import com.lexieluv.homeworkthirteenth.PlaceActivity;
import com.lexieluv.homeworkthirteenth.R;
import com.lexieluv.homeworkthirteenth.adapter.MainMenuAdapter;
import com.lexieluv.homeworkthirteenth.adapter.MyAdapter;
import com.lexieluv.homeworkthirteenth.entity.FoodBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainFragment extends Fragment {
    //城市选项属性
    private ImageView choose_city;
    private TextView city;
    Context context;

    //菜单图标
    protected int[] icons = {
            R.drawable.fly1,R.drawable.car,
            R.drawable.autombile1,R.drawable.cake,
            R.drawable.food,R.drawable.watch,
            R.drawable.cp,R.drawable.phone
    };
    //菜单格式
    protected String[] menus;
    //主菜单
    protected RecyclerView main_top;

    //listview菜单,网络加载
    private ListView main_list;
    private ArrayList<FoodBean.Food> data;
    private MyAdapter myAdapter;
    private ExecutorService es;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //主菜单
        menus = this.getActivity().getResources().getStringArray(R.array.main_menu);
        main_top = getView().findViewById(R.id.main_top);

        main_top.setLayoutManager(new GridLayoutManager(getActivity(),4));
        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(getActivity(), DataUtil.getMainMenu(icons,menus));
        main_top.setAdapter(mainMenuAdapter);


        //城市列表跳转
        choose_city = this.getActivity().findViewById(R.id.choose_city);
        city = this.getActivity().findViewById(R.id.city);

        choose_city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlaceActivity.class);
                startActivity(intent);
            }
        });

        //解析json数据,实现数据显示
        main_list = getView().findViewById(R.id.main_list);
        data = new ArrayList<FoodBean.Food>();
        myAdapter = new MyAdapter(data,getContext());

        main_list.setAdapter(myAdapter);
        //使用线程池来实现异步任务的多线程下载
        es = Executors.newFixedThreadPool(10);
        new DownAsynctask(data,myAdapter,getContext()).executeOnExecutor(es,"http://www.imooc.com/api/shopping?type=11");

        //第一个listview设置点击事件
        main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    startActivity(new Intent(getActivity(),FoodActivity.class));
                }
            }
        });
    }
}
