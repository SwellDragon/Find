package com.swelldragon.find;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Time;

public class Sale_List_Object implements Parcelable {
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

    protected Sale_List_Object(Parcel in) {
        name = in.readString();
        price = in.readFloat();
        deadline = in.readString();
        photo = in.readInt();
    }

    public static final Creator<Sale_List_Object> CREATOR = new Creator<Sale_List_Object>() {
        @Override
        public Sale_List_Object createFromParcel(Parcel in) {
            return new Sale_List_Object(in);
        }

        @Override
        public Sale_List_Object[] newArray(int size) {
            return new Sale_List_Object[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeFloat(price);
        parcel.writeString(deadline);
        parcel.writeInt(photo);
    }

}
