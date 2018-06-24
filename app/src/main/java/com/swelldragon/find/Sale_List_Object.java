package com.swelldragon.find;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.LitePalSupport;

import java.sql.Time;

public class Sale_List_Object extends LitePalSupport implements Parcelable {
    private String name;
    private float price;
    private String deadline;
    private int photo;
    private String status;
    private String highest_bidder;
    private int join;
    public  Sale_List_Object(){

    }
    public  Sale_List_Object(String name,float price,String deadline,int photo,String status,String highest_biddder,int join){
        this.name=name;
        this.price=price;
        this.deadline=deadline;
        this.photo=photo;
        this.status=status;
        this.highest_bidder=highest_biddder;
        this.join = join;
    }

    protected Sale_List_Object(Parcel in) {
        name = in.readString();
        price = in.readFloat();
        deadline = in.readString();
        photo = in.readInt();
        status=in.readString();
        highest_bidder=in.readString();
        join=in.readInt();
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeFloat(price);
        parcel.writeString(deadline);
        parcel.writeInt(photo);
        parcel.writeString(status);
        parcel.writeString(highest_bidder);
        parcel.writeInt(join);
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

    @Override
    public int describeContents() {
        return 0;
    }

    public int getJoin() {
        return join;
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

    public String getStatus() {
        return status;
    }

    public String getHighest_bidder() {
        return highest_bidder;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHighest_bidder(String highest_bidder) {
        this.highest_bidder = highest_bidder;
    }

    public void setJoin(int join) {
        this.join = join;
    }
}
