package com.bhx.masterbean.adapter;

import android.content.Context;

import com.bhx.common.ui.recyclerview.CommonAdapter;
import com.bhx.common.ui.recyclerview.ViewHolder;
import com.bhx.masterbean.R;
import com.bhx.masterbean.model.WorkerBeanRankModel;

import java.util.List;

/**
 * 匠豆排行界面的适配器
 */
public class WorkerBeanRankAdapter extends CommonAdapter<WorkerBeanRankModel> {

    public WorkerBeanRankAdapter(Context context, List<WorkerBeanRankModel> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_worker_bean_rank;
    }

    @Override
    public void convert(ViewHolder holder, WorkerBeanRankModel item, int position) {

    }
}
