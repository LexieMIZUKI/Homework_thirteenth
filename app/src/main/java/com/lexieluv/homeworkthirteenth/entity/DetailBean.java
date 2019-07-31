package com.lexieluv.homeworkthirteenth.entity;


public class DetailBean {
    /**
     * name : 松仁大虾
     * img : http://www.imooc.com/data/shopping/img/xia.png
     * originalprice : 27.8
     * tPrice : 22
     * price : 19.9
     * description : 该菜品口感纯正，价格公道，分量十足。欢迎进店品尝。门店地址：北京市海淀区XX路YY胡同999号。10月28日之前进店还能享受90折优惠呢！还等什么，手机下单立减五元！
     */

    private String name;
    private String img;
    private double originalprice;
    private int tPrice;
    private String price;
    private String description;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public double getOriginalprice() {
            return originalprice;
        }

        public void setOriginalprice(double originalprice) {
            this.originalprice = originalprice;
        }

        public int getTPrice() {
            return tPrice;
        }

        public void setTPrice(int tPrice) {
            this.tPrice = tPrice;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
}
