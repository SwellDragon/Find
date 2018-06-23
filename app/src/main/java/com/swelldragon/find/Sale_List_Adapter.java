package com.swelldragon.find;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class Sale_List_Adapter extends BaseQuickAdapter<Sale_List_Object, BaseViewHolder> {
    public Sale_List_Adapter(int layoutResId, List data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, Sale_List_Object item) {
        helper.setText(R.id.name,item.getName());
        helper.setText(R.id.price,Double.toString(item.getPrice()));
        helper.setText(R.id.deadline,item.getDeadline());
        helper.setImageResource(R.id.sale_photo,item.getPhoto());
        helper.addOnClickListener(R.id.sale_photo);
        helper.addOnClickListener(R.id.name);
    }
}
