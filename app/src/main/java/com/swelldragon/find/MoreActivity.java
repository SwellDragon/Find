package com.swelldragon.find;

import android.app.ListActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MoreActivity extends AppCompatActivity {
    private String[] mListTitle = { "联系找找", "评论找找", "安利找找", "常见问题","用户反馈","夜间模式","消息设置"};
    private int[] image = { R.drawable.me_more_contact_find_image,R.drawable.me_more_comment_find_image,R.drawable.me_more_recommend_find_image,
            R.drawable.me_more_common_problem_image,R.drawable.me_more_user_suggest_image,R.drawable.me_more_night_mode_image,R.drawable.headphoto};
    ListView mListView = null;
    ArrayList<Map<String,Object>> mData= new ArrayList<Map<String,Object>>();
    RoundedImageView more_back_ImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //设置为无标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置为全屏模式
        //hhhhh
        setContentView(R.layout.activity_more);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        more_back_ImageView = (RoundedImageView)findViewById(R.id.more_back_ImageView);
        more_back_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mListView = (ListView)findViewById(R.id.me_more_listview);
        int lengh = mListTitle.length;
        for(int i =0; i < lengh; i++) {
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("image", image[i]);
            item.put("title", mListTitle[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,mData,R.layout.me_more_menu,
                new String[]{"image","title",},new int[]{R.id.image,R.id.title,});
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                switch(position){

                }
//                Toast.makeText(MoreActivity.this,"您选择了标题：" + mListTitle[position] + "内容："+mListTitle[position], Toast.LENGTH_LONG).show();
            }
        });
        super.onCreate(savedInstanceState);
    }
}
