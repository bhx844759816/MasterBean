package com.bhx.common.ui.recyclerview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.bhx.common.ui.R;

import org.w3c.dom.Text;

/**
 * 默认下拉刷新得处理样式
 */
public class DefaultRefreshViewCreator extends RefreshViewCreator {
    private ImageView mArrowView;
    private ImageView mRefreshView;
    private TextView mTextView;

    @Override
    public View getRefreshView(Context context, ViewGroup parent) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.view_refresh_layout, parent, false);
        mArrowView = contentView.findViewById(R.id.id_arrow);
        mRefreshView = contentView.findViewById(R.id.id_refresh);
        mTextView = contentView.findViewById(R.id.id_refresh_text);
        return contentView;
    }

    @Override
    public void onPull(int currentDragHeight, int refreshViewHeight, int currentRefreshStatus) {
        switch (currentRefreshStatus) {
            case RefreshRecyclerView.REFRESH_STATUS_NORMAL: //正常状态
                break;
            case RefreshRecyclerView.REFRESH_STATUS_PULL_DOWN_REFRESH://下拉刷新状态
                mArrowView.setVisibility(View.VISIBLE);
                mRefreshView.setVisibility(View.GONE);
                float rotation = -(refreshViewHeight + currentDragHeight) * 180f / refreshViewHeight;
                mArrowView.setRotation(rotation);
                mTextView.setText("下拉刷新");
                break;
            case RefreshRecyclerView.REFRESH_STATUS_LOOSEN_REFRESHING://正在刷新状态
                mArrowView.setRotation(180);
                mTextView.setText("释放刷新");
                break;
        }
    }

    @Override
    public void onRefreshing() {
        //正在刷新
        mTextView.setText("正在刷新");
        mArrowView.setVisibility(View.GONE);
        mRefreshView.setVisibility(View.VISIBLE);
        startRefreshViewAnim();
    }

    /**
     * 旋转动画
     */
    private void startRefreshViewAnim() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(mRefreshView, View.ROTATION, 0, 360);
        animator.setDuration(800);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();
    }

    @Override
    public void onStopRefresh() {
        //停止刷新
        mTextView.setText("下拉刷新");
        mArrowView.setRotation(0);
        mRefreshView.clearAnimation();
    }
}
