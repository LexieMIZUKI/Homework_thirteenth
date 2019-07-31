package com.lexieluv.homeworkthirteenth.adapter;

import image.SmartImage;
import image.SmartImageView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lexieluv.homeworkthirteenth.R;
import com.lexieluv.homeworkthirteenth.entity.FoodBean;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.*;

//网络实现的数据适配器
public class MyAdapter extends BaseAdapter {
    ArrayList<FoodBean.Food> data;
    Context context;

    public MyAdapter(ArrayList<FoodBean.Food> data, Context context) {
        super();
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold holder;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.item_listview,null);
            holder = new ViewHold();
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_explain = (TextView)convertView.findViewById(R.id.tv_explain);
            holder.tv_price = (TextView)convertView.findViewById(R.id.tv_price);
            holder.tv_place = (TextView)convertView.findViewById(R.id.tv_place);
            holder.tv_amount = (TextView)convertView.findViewById(R.id.tv_amount);
            holder.iv_food = (SmartImageView) convertView.findViewById(R.id.iv_food);

            convertView.setTag(holder);
        } else {
            holder = (ViewHold) convertView.getTag();
        }
        FoodBean.Food food = data.get(position);
        holder.tv_title.setText(food.getName());
        holder.tv_explain.setText(food.getDescription());
        holder.tv_price.setText("￥"+food.getPrice());
        holder.tv_amount.setText("已售:"+food.getCount());
        holder.tv_place.setText(food.getAction());
        holder.iv_food.setImageUrl(food.getImg());
        return convertView;
    }

    class ViewHold{
        TextView tv_title,tv_explain,tv_price,tv_place,tv_amount;
        SmartImageView iv_food;
    }
}
