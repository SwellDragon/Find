package com.swelldragon.find;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.youth.banner.Banner;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class AuctionActivity extends AppCompatActivity {
    public static List<Integer> images=new ArrayList<>();
    Banner banner;
    TextView name_textview;
    TextView price_textview;
    TextView deadline_textview;
    TextView status_textview;
    TextView highest_bidder_textview;
    ImageButton auction_back;
    Button auction_button;
    Sale_List_Object data;
    Sale_List_Object data1;
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
        data1 =intent.getParcelableExtra("saledata");
        final List<Sale_List_Object> sale_list_objects=LitePal.where("name = ?",data1.getName()).find(Sale_List_Object.class);
        if(sale_list_objects.size()==1){
            data = sale_list_objects.get(0);
        }

        name_textview = (TextView) findViewById(R.id.auction_name);
        price_textview= (TextView) findViewById(R.id.auction_price);
        deadline_textview= (TextView) findViewById(R.id.auction_deadline);
        status_textview =(TextView)findViewById(R.id.auction_status);
        highest_bidder_textview=(TextView)findViewById(R.id.auction_highest_bidder);
        banner = (Banner) findViewById(R.id.auction_banner);
        auction_button = (Button) findViewById(R.id.auction_button);
        banner.setImageLoader(new GlideImageLoader()); //设置图片加载器
        auction_back = (ImageButton)findViewById(R.id.auction_back);
        auction_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        images.add(data.getPhoto());
        banner.setImages(images);//设置图片集合
        banner.start();//banner设置方法全部调用完毕时最后调用
        if(!data.getStatus().equals("正在进行")){
            auction_button.setText(data.getStatus());
        }
        else{
            auction_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AuctionDialogFragment auctionDialogFragment = new AuctionDialogFragment();
                    Bundle bundle = new Bundle();
//                    bundle.putFloat("nowprice",data.getPrice());


                    if(sale_list_objects.size()==1){
                        bundle.putParcelable("thissale",sale_list_objects.get(0));
                    }
                    auctionDialogFragment.setArguments(bundle);
                    auctionDialogFragment.show(getFragmentManager(), "Auctiondialog");
                }
            });
        }
        name_textview.setText(data.getName());
        price_textview.setText(String.valueOf(data.getPrice()));
        deadline_textview.setText(data.getDeadline());
        status_textview.setText(data.getStatus());
        highest_bidder_textview.setText(data.getHighest_bidder());

    }

    @Override
    protected void onResume() {
        super.onResume();
        final List<Sale_List_Object> sale_list_objects=LitePal.where("name = ?",data1.getName()).find(Sale_List_Object.class);
        if(sale_list_objects.size()==1){
            data = sale_list_objects.get(0);
        }
        price_textview.setText(String.valueOf(data.getPrice()));
    }
}
