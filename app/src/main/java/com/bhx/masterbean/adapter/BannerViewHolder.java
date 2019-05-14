package com.bhx.masterbean.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bhx.common.utils.LogUtils;
import com.bhx.masterbean.R;
import com.bhx.masterbean.config.Constants;
import com.bhx.masterbean.model.home.BannerModel;
import com.bumptech.glide.Glide;
import com.zhouwei.mzbanner.holder.MZViewHolder;

public class BannerViewHolder implements MZViewHolder<BannerModel> {
    private ImageView mImageView;
    private Context mContext;

    @Override
    public View createView(Context context) {
        // 返回页面布局
        mContext = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_banner_item, null);
        mImageView = view.findViewById(R.id.banner_image);
        return view;
    }

    @Override
    public void onBind(Context context, int i, BannerModel bannerModel) {
        Glide.with(mContext)
                .load(Constants.BASE_IMAGE_URL + bannerModel.getPath())
                .into(mImageView);
    }
}
