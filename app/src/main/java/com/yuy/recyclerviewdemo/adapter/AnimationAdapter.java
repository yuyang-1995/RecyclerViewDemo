package com.yuy.recyclerviewdemo.adapter;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yuy.recyclerviewdemo.R;
import com.yuy.recyclerviewdemo.data.DataServer;
import com.yuy.recyclerviewdemo.entity.Status;
import com.yuy.recyclerviewdemo.utils.ClickableMovementMethod;
import com.yuy.recyclerviewdemo.utils.SpannableStringUtils;
import com.yuy.recyclerviewdemo.utils.ToastUtils;
import com.yuy.recyclerviewdemo.utils.Utils;


/**
 * Author: yuyang
 * Date:2019/6/25 22:55
 */
public class AnimationAdapter extends BaseQuickAdapter<Status, BaseViewHolder> {


    public AnimationAdapter() {
        super(R.layout.layout_animation, DataServer.getSampleData(100));
    }



    @Override
    protected void convert(BaseViewHolder helper, Status item) {
        helper.addOnClickListener(R.id.img).addOnClickListener(R.id.tweetName);
        switch (helper.getLayoutPosition() % 3){
            case 0:
                helper.setImageResource(R.id.img, R.mipmap.animation_img1);
                break;
            case 1:
                helper.setImageResource(R.id.img, R.mipmap.animation_img2);
                break;
            case 2:
                helper.setImageResource(R.id.img, R.mipmap.animation_img3);
                break;
            default:
                break;
        }

        helper.setText(R.id.tweetName, "Hoteis in Rio de Janeiro");
        String msg = "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\"";
        ((TextView) helper.getView(R.id.tweetText)).setText(SpannableStringUtils.getBuilder(msg).append("landscapes and nedes").setClickSpan(clickableSpan).create());
        ((TextView) helper.getView(R.id.tweetText)).setMovementMethod(ClickableMovementMethod.getInstance());
        ((TextView) helper.getView(R.id.tweetText)).setFocusable(false);
        ((TextView) helper.getView(R.id.tweetText)).setClickable(false);
        ((TextView) helper.getView(R.id.tweetText)).setLongClickable(false);

    }

    private ClickableSpan clickableSpan = new ClickableSpan() {
        @Override
        public void onClick(View widget) {
            ToastUtils.showShortToast("事件触发了 landscapes and nedes");
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setColor(Utils.getContext().getResources().getColor(R.color.clickspan_color));
            ds.setUnderlineText(true);
        }
    };


}
