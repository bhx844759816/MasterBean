package com.bhx.masterbean.adapter;

import android.content.Context;
import android.view.View;

import com.bhx.common.adapter.rv.MultiItemTypeAdapter;
import com.bhx.common.ui.recyclerview.CommonAdapter;
import com.bhx.common.ui.recyclerview.ViewHolder;
import com.bhx.masterbean.R;
import com.bhx.masterbean.model.HomeModel;

import java.util.List;

/**
 * 首页列表布局
 */
public class HomeAdapter extends CommonAdapter<HomeModel> {

    public HomeAdapter(Context context, List<HomeModel> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_home;
    }

    @Override
    public void convert(ViewHolder holder, HomeModel model, int position) {
//        holder.setText(R.id.id_home_item, model.getItem());
    }
}
