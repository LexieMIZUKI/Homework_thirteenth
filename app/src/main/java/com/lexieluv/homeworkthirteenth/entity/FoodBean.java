package com.lexieluv.homeworkthirteenth.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FoodBean {
    /**
     * status : 1
     * data : [{"id":1,"name":"牛排","img":"http://www.imooc.com/data/shopping/img/niu.png","count":44,"price":"39.9","description":"超值单人套餐，10分钟极速配送","action":"新用户一元购"},{"id":2,"name":"地三鲜","img":"http://www.imooc.com/data/shopping/img/san.png","count":20,"price":"99.9","description":"营养搭配，科学膳食组合","action":"新用户一元购"},{"id":3,"name":"松仁大虾","img":"http://www.imooc.com/data/shopping/img/xia.png","count":99,"price":"12","description":"在这里可以尝尽各种美味","action":"新用户一元购"},{"id":4,"name":"冷饮","img":"http://www.imooc.com/data/shopping/img/lengying.png","count":20,"price":"9.9","description":"体验冷热酸甜想吃就吃的感觉","action":"新用户一元购"},{"id":5,"name":"牛排","img":"http://www.imooc.com/data/shopping/img/niu.png","count":44,"price":"39.9","description":"超值单人套餐，10分钟极速配送","action":"新用户一元购"},{"id":6,"name":"地三鲜","img":"http://www.imooc.com/data/shopping/img/san.png","count":20,"price":"99.9","description":"营养搭配，科学膳食组合","action":"新用户一元购"}]
     * msg : 成功
     */
    public ArrayList<Food> data;

    public FoodBean(ArrayList<Food> data) {
        this.data = data;
    }

    public ArrayList<Food> getData() {
        return data;
    }

    public void setData(ArrayList<Food> data) {
        this.data = data;
    }

    public static class Food {
        /**
         * name : 牛排
         * img : http://www.imooc.com/data/shopping/img/niu.png
         * count : 44
         * price : 39.9
         * description : 超值单人套餐，10分钟极速配送
         * action : 新用户一元购
         */
        private int count;
        private String name, description, price, action, img;//标题，评价，价格，限制说明，剩余份数,食物图片

        public Food(String name, String img, int count, String price, String description, String action) {
            this.count = count;
            this.name = name;
            this.description = description;
            this.price = price;
            this.action = action;
            this.img = img;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
