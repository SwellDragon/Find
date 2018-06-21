package com.swelldragon.find;

import java.sql.Time;

public class Sale_List_Object {
    private String name;
    private float price;
    private String deadline;
    private int photo;
    public  Sale_List_Object(String name,float price,String deadline,int photo){
        this.name=name;
        this.price=price;
        this.deadline=deadline;
        this.photo=photo;
    }

    public float getPrice() {
        return price;
    }

    public int getPhoto() {
        return photo;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getName() {
        return name;
    }
}
