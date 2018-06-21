package com.swelldragon.find;

import android.content.Context;
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
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SaleFragment extends Fragment {
    RecyclerView recyclerView;
    List<Sale_List_Object> saledata = new ArrayList<Sale_List_Object>();
    Sale_List_Object sale_list_object;
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
        Sale_List_Adapter sale_list_adapter = new Sale_List_Adapter(R.layout.sale_list,saledata);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutmanager);

        recyclerView.setAdapter(sale_list_adapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
}
