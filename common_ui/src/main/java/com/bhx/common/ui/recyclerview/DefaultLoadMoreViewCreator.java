package com.bhx.common.ui.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bhx.common.ui.R;

/**
 * 上拉加载更多样式
 */
public class DefaultLoadMoreViewCreator extends LoadViewCreator {
    private TextView mTextView;
    private ProgressBar mRefreshBar;

    @Override
    public View getLoadView(Context context, ViewGroup parent) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.view_load_more_layout, parent, false);
        mRefreshBar = contentView.findViewById(R.id.id_load_progressBar);
        mTextView = contentView.findViewById(R.id.id_load_refresh_text);
        return contentView;
    }

    @Override
    public void onPull(int currentDragHeight, int loadViewHeight, int currentLoadStatus) {
        switch (currentLoadStatus) {
            case LoadRefreshRecyclerView.LOAD_STATUS_PULL_DOWN_REFRESH://上拉加载更多状态
                mRefreshBar.setVisibility(View.GONE);
                mTextView.setText("上拉加载");
                break;
            case RefreshRecyclerView.REFRESH_STATUS_LOOSEN_REFRESHING://正在刷新状态
                mTextView.setText("释放刷新");
                break;
        }
    }

    @Override
    public void onLoading() {
        mTextView.setText("正在刷新");
        mRefreshBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStopLoad() {
        mTextView.setText("上拉加载");
        mRefreshBar.setVisibility(View.GONE);
    }

    @Override
    public void noLoadMoreData() {
        mTextView.setText("没有更多数据了");
        mRefreshBar.setVisibility(View.GONE);
    }
}
