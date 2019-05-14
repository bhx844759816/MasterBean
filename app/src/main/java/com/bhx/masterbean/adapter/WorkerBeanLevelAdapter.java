package com.bhx.masterbean.adapter;

import android.content.Context;
import android.view.View;

import com.bhx.common.ui.recyclerview.CommonAdapter;
import com.bhx.common.ui.recyclerview.ViewHolder;
import com.bhx.masterbean.R;
import com.bhx.masterbean.model.WorkerBeanLevelModel;

import java.util.List;

/**
 * 显示匠豆等级列表适配器
 */
public class WorkerBeanLevelAdapter extends CommonAdapter<WorkerBeanLevelModel> {

    public WorkerBeanLevelAdapter(Context context, List<WorkerBeanLevelModel> datas) {
        super(context, datas);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_worker_bean_level;
    }

    @Override
    public void convert(ViewHolder holder, WorkerBeanLevelModel item, int position) {
        holder.setOnItemClickListener(v -> {
            boolean isVisibility = holder.getView(R.id.id_worker_bean_level_content).getVisibility() == View.VISIBLE;
            holder.setViewVisibility(R.id.id_worker_bean_level_content, isVisibility ? View.GONE : View.VISIBLE);
            startArrowAnim(holder.getView(R.id.id_worker_bean_level_arrow), isVisibility ? 0 : -180);
        });
    }

    /**
     * 旋转箭头
     * @param view
     * @param angle
     */
    private void startArrowAnim(View view, int angle) {
        view.animate().setDuration(500).rotation(angle).start();
    }
}
