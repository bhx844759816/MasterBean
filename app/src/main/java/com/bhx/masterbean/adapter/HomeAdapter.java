package com.bhx.masterbean.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
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
public class HomeAdapter extends CommonAdapter<HomeModel> {
    private OnItemClickListener mListener;

    public HomeAdapter(Context context, List<HomeModel> datas) {
        super(context, datas);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_home;
    }

    @Override
    public void convert(ViewHolder holder, HomeModel model, int position) {
        holder.setText(R.id.id_home_item_title, model.getTitle());
        holder.setText(R.id.id_home_item_good_num, model.getClick_num());
        holder.setText(R.id.id_home_item_look_num, model.getView_num());
        ImageView image = holder.getView(R.id.id_home_item_img);
        Glide.with(mContext).load(Constants.BASE_IMAGE_URL + model.getImg()).into(image);
        List<HomeModel.TagIdBean> tagList = model.getTag_id();
        if (tagList != null && tagList.size() > 0) {
            FlowLayout flowLayout = holder.getView(R.id.id_home_item_label);
            flowLayout.removeAllViews();
            for (HomeModel.TagIdBean tagIdBean : tagList) {
                addView(flowLayout, tagIdBean.getTag_name());
            }
        }
        holder.setOnItemClickListener(v -> mListener.onItemClick(v, position));
    }

    private void addView(FlowLayout layout, String text) {
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.rightMargin = DensityUtil.dip2px(mContext, 5);
        lp.bottomMargin = DensityUtil.dip2px(mContext, 5);
        TextView view = new TextView(mContext);
        view.setTextSize(9);
        view.setText(text);
        view.setTextColor(mContext.getResources().getColor(R.color.text_default));
        view.setBackground(mContext.getResources().getDrawable(R.drawable.drawable_flow_label));
        layout.addView(view, lp);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
