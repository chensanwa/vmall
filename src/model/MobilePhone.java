package model;

import java.util.Map;

public class MobilePhone {
    private String commodityCoding;     //商品编码
    private String name;            //商品名称
    private String description;         //商品描述
    private float price;        //价格
    private String serviceDescription;      //服务描述
    private String color;       //颜色
//    private String standard;        //制式
//    private String capacity;      //容量
    private Map<String,String> standardToCapacity;      //制式——容量
    private Map<String,String> packageToValue;      //套餐——套餐详情
    private String securityServices;        //保障服务

}
