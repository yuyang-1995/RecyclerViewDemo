package com.yuy.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yuy.recyclerviewdemo.adapter.DemoMultipleItemRvAdapter;
import com.yuy.recyclerviewdemo.base.BaseActivity;
import com.yuy.recyclerviewdemo.data.DataServer;
import com.yuy.recyclerviewdemo.entity.MultipleItem;
import com.yuy.recyclerviewdemo.entity.NormalMultipleEntity;

import java.util.List;

public class MultipleItemRvAdapterUseActivity extends BaseActivity {


    private List<NormalMultipleEntity> mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_use);


        setTitle("MultipleItemRvAdapter");
        setBackBtn();

        RecyclerView mRecyclerView = findViewById(R.id.rv_list);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);

        mData = DataServer.getNormalMultipleEntities();


        DemoMultipleItemRvAdapter multipleItemRvAdapter = new DemoMultipleItemRvAdapter(mData);

        multipleItemRvAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                int type = mData.get(position).type;
                if (type == NormalMultipleEntity.SINGLE_TEXT) {
                    return MultipleItem.TEXT_SPAN_SIZE;
                } else if (type == NormalMultipleEntity.SINGLE_IMG) {
                    return MultipleItem.IMG_SPAN_SIZE;
                } else {
                    return MultipleItem.IMG_TEXT_SPAN_SIZE;
                }
            }
        });

        mRecyclerView.setAdapter(multipleItemRvAdapter);

    }

}
