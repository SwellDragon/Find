package com.swelldragon.find;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_me,null);
        Button morebottom= (Button)view.findViewById(R.id.me_more);
        morebottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MainActivity mainActivity = (MainActivity) getActivity();//从Fragment取得Activity实例
                Intent intent = new Intent(mainActivity,MoreActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
