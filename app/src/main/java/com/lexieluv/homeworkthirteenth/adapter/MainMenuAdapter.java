package com.lexieluv.homeworkthirteenth.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lexieluv.homeworkthirteenth.R;
import com.lexieluv.homeworkthirteenth.entity.Menu;

import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuViewHolder>{
    protected Context context;
    protected List<Menu> menus;

    public MainMenuAdapter(Context context, List<Menu> menus) {
        this.context = context;
        this.menus = menus;
    }

    @NonNull
    @Override
    public MainMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainMenuViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_top,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MainMenuViewHolder holder, int position) {
            Menu menu = menus.get(position);
            holder.icon.setImageResource(menu.getIcon());
            holder.name.setText(menu.getName());
    }

    @Override
    public int getItemCount() {
        return null != menus?menus.size():0;
    }
}

class MainMenuViewHolder extends RecyclerView.ViewHolder{
    public ImageView icon;
    public TextView name;
    public MainMenuViewHolder(View itemView) {
        super(itemView);
        icon = itemView.findViewById(R.id.item_main_icon);
        name = itemView.findViewById(R.id.item_main_name);
    }
}
