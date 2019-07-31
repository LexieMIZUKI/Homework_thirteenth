package com.lexieluv.homeworkthirteenth.util;
import com.google.gson.Gson;

import com.lexieluv.homeworkthirteenth.entity.FoodBean;

//解析Json数据的工具类
public class JsonUtils {
    public static FoodBean parseJson(String JsonString){
        Gson gson = new Gson();
        FoodBean fb = gson.fromJson(JsonString,FoodBean.class);
        return fb;
    }
}
