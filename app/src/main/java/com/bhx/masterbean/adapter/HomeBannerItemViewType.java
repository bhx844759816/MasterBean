package com.bhx.masterbean.adapter;

import com.bhx.common.adapter.rv.ItemViewType;
import com.bhx.common.adapter.rv.ViewHolder;
import com.bhx.masterbean.R;
import com.bhx.masterbean.model.HomeModel;

import java.util.List;

/**
 * 首页顶部循环轮播图
 */
public class HomeBannerItemViewType implements ItemViewType<HomeModel> {
    @Override
    public int getItemViewLayoutId() {
        return R.layout.adapter_home_banner;
    }

    @Override
    public boolean isViewForType(HomeModel model, int position) {
        if (model.getItemType() == HomeModel.ITME_BANNER) {
            return true;
        }
        return false;
    }

    @Override
    public void convert(ViewHolder holder, HomeModel model, int position) {
        if (model.getItemType() == HomeModel.ITME_BANNER && model.getBannerItem() != null) {

        }
    }
}
