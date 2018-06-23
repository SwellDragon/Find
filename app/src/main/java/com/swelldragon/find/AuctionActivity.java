package com.swelldragon.find;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class AuctionActivity extends AppCompatActivity {
    public static List<Integer> images=new ArrayList<>();
    Banner banner;
    TextView name_textview;
    TextView price_textview;
    TextView deadline_textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction);
        //设置为无标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置为全屏模式
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        images.clear();
        Intent intent = getIntent();
        Sale_List_Object data =intent.getParcelableExtra("saledata");
        name_textview = (TextView) findViewById(R.id.auction_name);
        price_textview= (TextView) findViewById(R.id.auction_price);
        deadline_textview= (TextView) findViewById(R.id.auction_deadline);
        banner = (Banner) findViewById(R.id.auction_banner);
        banner.setImageLoader(new GlideImageLoader()); //设置图片加载器
        images.add(data.getPhoto());
        banner.setImages(images);//设置图片集合
        banner.start();//banner设置方法全部调用完毕时最后调用

        name_textview.setText(data.getName());
        price_textview.setText(String.valueOf(data.getPrice()));
        deadline_textview.setText(data.getDeadline());

    }
}
