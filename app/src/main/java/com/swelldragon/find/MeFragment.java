package com.swelldragon.find;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.Resource;
import com.makeramen.roundedimageview.RoundedImageView;
import com.youth.banner.Banner;

public class MeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_me,null);
        Button morebuttom= (Button)view.findViewById(R.id.me_more);
        Button mysalebuttom=(Button)view.findViewById(R.id.me_mysale_button) ;
        morebuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MainActivity mainActivity = (MainActivity) getActivity();//从Fragment取得Activity实例
                Intent intent = new Intent(mainActivity,MoreActivity.class);
                startActivity(intent);
            }
        });
        mysalebuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MainActivity mainActivity = (MainActivity) getActivity();//从Fragment取得Activity实例
                Intent intent = new Intent(mainActivity,MysaleActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
