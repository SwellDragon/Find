package com.swelldragon.find;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.icu.util.ValueIterator;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.format.Time;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SaleFragment extends Fragment {
    RecyclerView recyclerView;
    List<Sale_List_Object> saledata = new ArrayList<Sale_List_Object>();
    Sale_List_Object sale_list_object;
    Spinner sort;
    List<String> sortlist = new ArrayList<>();
    Spinner area;
    List<String> arealist = new ArrayList<String>();
    Spinner item;
    List<String> itemlist = new ArrayList<>();
    ArrayAdapter sortadapter;
    ArrayAdapter areaadapter;
    ArrayAdapter itemadapter;
    Sale_List_Adapter sale_list_adapter;
    LinearLayoutManager layoutmanager;
    SearchView sale_searchView;

    public SaleFragment() {
        // Required empty public constructor
        super();
        init();
    }

    public void init(){
        Time time = new Time();
        time.setToNow();
        time.year++;
        String st = time.format("%Y-%m-%d %H:%M:%S");
        sale_list_object = new Sale_List_Object("你若盛开，清风自来",12,st,R.drawable.book1);
        saledata.add(sale_list_object);
        sale_list_object = new Sale_List_Object("活着",15,st,R.drawable.book2);
        saledata.add(sale_list_object);
        sale_list_object = new Sale_List_Object("努力到自己无能为力",13,st,R.drawable.book3);
        saledata.add(sale_list_object);
        sale_list_object = new Sale_List_Object("自卑与超越",12,st,R.drawable.book4);
        saledata.add(sale_list_object);
        sale_list_object = new Sale_List_Object("舍与得",12,st,R.drawable.book5);
        saledata.add(sale_list_object);
        sale_list_object = new Sale_List_Object("18岁后的经济学",12,st,R.drawable.book6);
        saledata.add(sale_list_object);

        sortlist.add("默认排序");
        sortlist.add("热度排序");

        arealist.add("西南地区");
        arealist.add("华南地区");
        arealist.add("东北地区");

        itemlist.add("书");
        itemlist.add("电子产品");

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_sale, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.Sale_list);
        sale_searchView = (SearchView) view.findViewById(R.id.sale_searchview);
        sort = (Spinner) view.findViewById(R.id.sale_sort_type);
        area = (Spinner) view.findViewById(R.id.sale_area_type);
        item = (Spinner) view.findViewById(R.id.sale_item_type);
        sortadapter = new ArrayAdapter(this.getContext(),R.layout.sale_item_select,sortlist);
        areaadapter = new ArrayAdapter(this.getContext(),R.layout.sale_item_select,arealist);
        itemadapter = new ArrayAdapter(this.getContext(),R.layout.sale_item_select,itemlist);
        sale_searchView.setIconified(true);//设置searchView处于展开状态
        sale_list_adapter = new Sale_List_Adapter(R.layout.sale_list,saledata);
        layoutmanager = new LinearLayoutManager(this.getActivity());
        sale_list_adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                final MainActivity mainActivity = (MainActivity) getActivity();//从Fragment取得Activity实例
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
        sort.setAdapter(sortadapter);
        area.setAdapter(areaadapter);
        item.setAdapter(itemadapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
//        sale_searchView.setFocusable(true);
//
//        sale_searchView.setFocusableInTouchMode(true);
//
//        sale_searchView.requestFocus();
        sale_searchView.clearFocus();
    }
    // TODO: Rename method, update argument and hook method into UI event
}
