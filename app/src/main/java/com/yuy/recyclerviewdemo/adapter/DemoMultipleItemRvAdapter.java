package com.yuy.recyclerviewdemo.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;
import com.yuy.recyclerviewdemo.adapter.provider.ImgItemProvider;
import com.yuy.recyclerviewdemo.adapter.provider.TextImgItemProvider;
import com.yuy.recyclerviewdemo.adapter.provider.TextItemProvider;
import com.yuy.recyclerviewdemo.entity.NormalMultipleEntity;

import java.util.List;

/**
 * Author: yuyang
 * Date:2019/6/28 20:40
 */
public class DemoMultipleItemRvAdapter  extends MultipleItemRvAdapter<NormalMultipleEntity, BaseViewHolder> {


    public static final int TYPE_TEXT = 100;
    public static final int TYPE_IMG = 200;
    public static final int TYPE_TEXT_IMG = 300;

    public DemoMultipleItemRvAdapter(@Nullable List<NormalMultipleEntity> data) {
        super(data);

        //构造函数若有传其他参数可以在调用finishInitialize()之前进行赋值，赋值给全局变量
        //这样getViewType()和registerItemProvider()方法中可以获取到传过来的值
        //getViewType()中可能因为某些业务逻辑，需要将某个值传递过来进行判断，返回对应的viewType
        //registerItemProvider()中可以将值传递给ItemProvider

        finishInitialize();
    }

    @Override
    protected int getViewType(NormalMultipleEntity normalMultipleEntity) {
        //根据实体类判断并返回对应的viewType，具体判断逻辑因业务不同，这里这是简单通过判断type属性

        if (normalMultipleEntity.type == NormalMultipleEntity.SINGLE_TEXT) {
            return TYPE_TEXT;
        } else if (normalMultipleEntity.type == NormalMultipleEntity.SINGLE_IMG) {
            return TYPE_IMG;
        } else if (normalMultipleEntity.type == NormalMultipleEntity.TEXT_IMG) {
            return TYPE_TEXT_IMG;
        }
        return 0;
    }

    @Override
    public void registerItemProvider() {

        //注册相关的条目provider
        //Register related entries provider
        mProviderDelegate.registerProvider(new TextItemProvider());
        mProviderDelegate.registerProvider(new ImgItemProvider());
        mProviderDelegate.registerProvider(new TextImgItemProvider());

    }
}
