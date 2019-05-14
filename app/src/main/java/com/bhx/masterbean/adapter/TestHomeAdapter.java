package com.bhx.masterbean.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bhx.common.ui.recyclerview.CommonAdapter;
import com.bhx.common.ui.recyclerview.ViewHolder;
import com.bhx.common.ui.widget.FlowLayout;
import com.bhx.common.utils.DensityUtil;
import com.bhx.masterbean.R;
import com.bhx.masterbean.config.Constants;
import com.bhx.masterbean.model.home.HomeModel;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 首页列表布局
 */
public class TestHomeAdapter extends CommonAdapter<HomeModel> {

    public TestHomeAdapter(Context context, List<HomeModel> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_home;
    }

    @Override
    public void convert(ViewHolder holder, HomeModel model, int position) {

    }


}
