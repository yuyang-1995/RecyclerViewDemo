package com.yuy.recyclerviewdemo.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuy.recyclerviewdemo.R;
import com.yuy.recyclerviewdemo.entity.HomeItem;

import java.util.List;

public class MainAdapter extends BaseQuickAdapter<HomeItem, BaseViewHolder> {


    public MainAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeItem item) {
        helper.setText(R.id.text, item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResource());
    }

}
