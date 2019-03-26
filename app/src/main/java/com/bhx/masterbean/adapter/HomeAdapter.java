package com.bhx.masterbean.adapter;

import android.content.Context;
import android.view.View;

import com.bhx.common.adapter.rv.MultiItemTypeAdapter;
import com.bhx.common.adapter.rv.ViewHolder;
import com.bhx.masterbean.model.HomeModel;

/**
 * 首页列表布局
 */
public class HomeAdapter extends MultiItemTypeAdapter<HomeModel> {


    public HomeAdapter(Context context) {
        super(context);
        //添加首页布局得
        addItemViewType(new HomeBannerItemViewType());
        //添加默认布局得
        addItemViewType(new HomeDefaultItemViewType());

    }


    @Override
    public void onViewHolderCreated(ViewHolder holder, View itemView) {
        //设置布局


    }
}
