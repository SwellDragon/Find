package com.swelldragon.find;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;


public class Sale_Object_Fragment extends Fragment {
   String tag;
    List<Sale_List_Object> saledata = new ArrayList<Sale_List_Object>();
    RecyclerView recyclerView;
    Sale_List_Adapter sale_list_adapter;
    LinearLayoutManager layoutmanager;
    public Sale_Object_Fragment() {

    }

    @SuppressLint("ValidFragment")
    public Sale_Object_Fragment(String tag) {

        this.tag=tag;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_sale_object, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.sale_list);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(tag.equals("正在进行")){
            saledata = LitePal.where("status = ?","正在进行").find(Sale_List_Object.class);
        }
        else if(tag.equals("已参拍")){
            saledata = LitePal.where("join = ? and status = ?","1","正在进行").find(Sale_List_Object.class);
        }
        else if(tag.equals("已结束")){
            saledata = LitePal.where("join = ? and status = ?","1","已结束").find(Sale_List_Object.class);
        }
        else if (tag.equals("已拍下")){
            saledata = LitePal.where("join = ? and status = ? and highest_bidder = ?","1","已结束","SwellDragon").find(Sale_List_Object.class);
        }

        sale_list_adapter = new Sale_List_Adapter(R.layout.sale_list,saledata);
        layoutmanager = new LinearLayoutManager(this.getActivity());
        sale_list_adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                final Activity mainActivity =  getActivity();//从Fragment取得Activity实例
                Intent intent = new Intent(mainActivity,AuctionActivity.class);
                intent.putExtra("saledata",saledata.get(position));
                startActivity(intent);
            }
        });
        sale_list_adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int a=view.getId();
                switch (a){
                    case R.id.sale_photo:
//                        ImageView imageView=(ImageView)view.findViewById(view.getId());
//                        Dialog dialog1 = new Dialog(getActivity(),android.R.style.Theme_Black_NoTitleBar);
//                        ImageView imageView1 = new ImageView(getActivity());
//                        imageView1.setImageDrawable(imageView.getDrawable());
//                        dialog1.setContentView(imageView1);
//
//                        dialog1.show();
                        Toast.makeText(getActivity(), "onItemChildClick" + position+"photo"+view, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.name:
                        Toast.makeText(getActivity(), "onItemChildClick" + position+"txt", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setAdapter(sale_list_adapter);
    }
}
