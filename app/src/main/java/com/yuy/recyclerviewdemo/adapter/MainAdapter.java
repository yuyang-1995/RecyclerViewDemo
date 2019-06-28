package com.yuy.recyclerviewdemo.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuy.recyclerviewdemo.R;
import com.yuy.recyclerviewdemo.entity.MainItem;

import java.util.List;

public class MainAdapter extends BaseQuickAdapter<MainItem, BaseViewHolder> {


    public MainAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MainItem item) {

        helper.setText(R.id.text, item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResource());
    }

}
