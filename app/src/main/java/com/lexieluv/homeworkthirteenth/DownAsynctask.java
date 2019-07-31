package com.lexieluv.homeworkthirteenth;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.lexieluv.homeworkthirteenth.adapter.MyAdapter;
import com.lexieluv.homeworkthirteenth.entity.FoodBean;
import com.lexieluv.homeworkthirteenth.util.JsonUtils;
import com.lexieluv.homeworkthirteenth.util.NetUtils;

import java.util.ArrayList;


//异步任务类下载网络数据
public class DownAsynctask extends AsyncTask<String,Void,byte[]> {

    ArrayList<FoodBean.Food> data;
    MyAdapter myAdapter;
    Context context;

    public DownAsynctask(ArrayList<FoodBean.Food> data, MyAdapter myAdapter, Context context) {
        super();
        this.data = data;
        this.myAdapter = myAdapter;
        this.context = context;
    }

    @Override
    protected byte[] doInBackground(String... params)  {
        return NetUtils.getNetData(params[0]);
    }

    @Override
    protected void onPostExecute(byte[] result){
        super.onPostExecute(result);
        if(result != null){
            //把从网络上获取的byte类型的数据转换为String字符串
            String jsonString = new String(result);
            //用json解析工具来解析该字符串数据
            FoodBean fb = JsonUtils.parseJson(jsonString);
            //取出data数据，并保存到集合中
            data.addAll(fb.data);
            //刷新数据
            myAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(context,"网络异常",Toast.LENGTH_SHORT).show();
        }
    }

}
