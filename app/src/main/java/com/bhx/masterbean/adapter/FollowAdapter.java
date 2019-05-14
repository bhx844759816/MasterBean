package com.bhx.masterbean.adapter;

import android.content.Context;

import com.bhx.common.ui.recyclerview.CommonAdapter;
import com.bhx.common.ui.recyclerview.ViewHolder;
import com.bhx.masterbean.R;
import com.bhx.masterbean.model.FollowModel;

import java.util.List;

/**
 * 关注界面的适配器
 */
public class FollowAdapter extends CommonAdapter<FollowModel> {

    public FollowAdapter(Context context, List<FollowModel> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_follow;
    }

    @Override
    public void convert(ViewHolder holder, FollowModel item, int position) {

    }
}
