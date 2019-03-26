package com.bhx.masterbean.adapter;

import com.bhx.common.adapter.rv.ItemViewType;
import com.bhx.common.adapter.rv.ViewHolder;
import com.bhx.masterbean.R;
import com.bhx.masterbean.model.HomeModel;

/**
 * 显示默认布局
 */
public class HomeDefaultItemViewType implements ItemViewType<HomeModel> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.adapter_home_default;
    }

    @Override
    public boolean isViewForType(HomeModel model, int position) {
        if (model.getItemType() == HomeModel.ITME_HOME) {
            return true;
        }
        return false;
    }

    @Override
    public void convert(ViewHolder holder, HomeModel model, int position) {
        if (model.getItemType() == HomeModel.ITME_HOME && model.getHomeItem() != null) {
            //设置布局
        }
    }
}
