package com.lexieluv.homeworkthirteenth;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.lexieluv.homeworkthirteenth.fragment.MainFragment;
import com.lexieluv.homeworkthirteenth.fragment.MeFragment;
import com.lexieluv.homeworkthirteenth.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinearLayout menu_main,menu_me,menu_shop;
    private MainFragment mainFragment = new MainFragment();
    private ShopFragment shopFragment = new ShopFragment();
    private MeFragment meFragment = new MeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content,mainFragment)
                .add(R.id.content,shopFragment)
                .hide(shopFragment)
                .add(R.id.content,meFragment)
                .hide(meFragment)
                .commit();
    }

    private void initView() {
        menu_main = findViewById(R.id.menu_main);
        menu_shop = findViewById(R.id.menu_shop);
        menu_me = findViewById(R.id.menu_me);

        menu_main.setOnClickListener(this);
        menu_shop.setOnClickListener(this);
        menu_me.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_main://主页
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .show(mainFragment)
                        .hide(meFragment)
                        .hide(shopFragment)
                        .commit();
                break;
            case R.id.menu_shop://购物页
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .hide(meFragment)
                        .show(shopFragment)
                        .commit();
                break;
            case R.id.menu_me://我的页面
                this.getSupportFragmentManager()
                        .beginTransaction()
                        .hide(mainFragment)
                        .show(meFragment)
                        .hide(shopFragment)
                        .commit();
                break;
        }
    }
}
