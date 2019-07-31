package com.lexieluv.homeworkthirteenth.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.lexieluv.homeworkthirteenth.MainActivity;
import com.lexieluv.homeworkthirteenth.R;
import com.lexieluv.homeworkthirteenth.entity.FoodBean;

import java.util.ArrayList;
import java.util.List;


public class ShopFragment extends Fragment {
    protected List<FoodBean> list = new ArrayList<>();
    private ImageView back;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop,container,false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        back = getView().findViewById(R.id.back_main);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
    }
}
