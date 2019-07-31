package com.lexieluv.homeworkthirteenth.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lexieluv.homeworkthirteenth.R;
import com.lexieluv.homeworkthirteenth.entity.DetailBean;

import java.util.List;

import image.SmartImageView;


public class DetailAdapter extends BaseAdapter {

    private List<DetailBean> list;
    private LayoutInflater layoutInflater;

    public DetailAdapter(Context context, List<DetailBean> list) {
        super();
        this.list = list;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.description,null);
            viewHolder.name = convertView.findViewById(R.id.tv_title_second);
            viewHolder.img = convertView.findViewById(R.id.iv_food_second);
            viewHolder.originalprice = convertView.findViewById(R.id.tv_price_first);
            viewHolder.tPrice = convertView.findViewById(R.id.tv_price_second);
            viewHolder.price = convertView.findViewById(R.id.tv_price_third);
            viewHolder.description = convertView.findViewById(R.id.tv_description);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(list.get(position).getName());
        viewHolder.img.setImageUrl(list.get(position).getImg());
        viewHolder.originalprice.setText("￥"+list.get(position).getOriginalprice());
        viewHolder.tPrice.setText("团购价：￥"+list.get(position).getTPrice());
        viewHolder.price.setText("￥"+list.get(position).getPrice()+"拿下");
        viewHolder.description.setText(list.get(position).getDescription());
        return convertView;
    }

    class ViewHolder{
        public TextView name;
        public SmartImageView img;
        public TextView originalprice;
        public TextView tPrice;
        public TextView price;
        public TextView description;
    }
}
