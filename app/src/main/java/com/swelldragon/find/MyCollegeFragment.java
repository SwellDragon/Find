package com.swelldragon.find;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;


public class MyCollegeFragment extends Fragment {
    public static List<Integer> images=new ArrayList<>();
    Banner banner;
    public MyCollegeFragment(){
        super();
        images.clear();
        images.add(R.drawable.banner1);
        images.add(R.drawable.banner2);
        images.add(R.drawable.banner3);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


         View view = inflater.inflate(R.layout.fragment_my_college,null);
        banner = (Banner) view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        return view;

    }
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }
    // TODO: Rename method, update argument and hook method into UI event

}
