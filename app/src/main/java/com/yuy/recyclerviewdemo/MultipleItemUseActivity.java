package com.yuy.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yuy.recyclerviewdemo.R;
import com.yuy.recyclerviewdemo.adapter.MultipleItemQuickAdapter;
import com.yuy.recyclerviewdemo.base.BaseActivity;
import com.yuy.recyclerviewdemo.data.DataServer;
import com.yuy.recyclerviewdemo.entity.MultipleItem;

import java.util.List;

public class MultipleItemUseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_use);
        setTitle("MultipleItem Use");
        setBackBtn();
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        final List<MultipleItem> data = DataServer.getMultipleItemData();
        final MultipleItemQuickAdapter multipleItemAdapter = new MultipleItemQuickAdapter(this, data);
        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return data.get(position).getSpanSize();
            }
        });
        mRecyclerView.setAdapter(multipleItemAdapter);
    }

}
