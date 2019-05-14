package com.bhx.masterbean.adapter;

import android.content.Context;

import com.bhx.common.ui.recyclerview.CommonAdapter;
import com.bhx.common.ui.recyclerview.ViewHolder;
import com.bhx.masterbean.R;
import com.bhx.masterbean.model.WorkerBeanRecordModel;

import java.util.List;

/**
 * 金币记录的适配器
 */
public class WorkerBeanRecordAdapter extends CommonAdapter<WorkerBeanRecordModel> {
    public WorkerBeanRecordAdapter(Context context, List<WorkerBeanRecordModel> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_worker_bean_record;
    }

    @Override
    public void convert(ViewHolder holder, WorkerBeanRecordModel item, int position) {

    }
}
