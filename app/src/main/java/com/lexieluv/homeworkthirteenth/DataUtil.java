package com.lexieluv.homeworkthirteenth;


import com.lexieluv.homeworkthirteenth.entity.Menu;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    //主菜单 数据获取格式
    public static List<Menu> getMainMenu(int[] icons, String[] names){
        List<Menu> menus = new ArrayList<>();
        for(int i = 0;i < icons.length;i++){
            Menu menu = new Menu(icons[i],names[i]);
            menus.add(menu);
        }
        return menus;
    }
}
