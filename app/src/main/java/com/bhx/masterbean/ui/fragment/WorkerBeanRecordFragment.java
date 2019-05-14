package com.bhx.masterbean.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bhx.masterbean.R;
import com.bhx.masterbean.adapter.WorkerBeanRecordAdapter;
import com.bhx.masterbean.model.WorkerBeanRecordModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 匠豆记录的界面
 */
public class WorkerBeanRecordFragment extends Fragment {

    @BindView(R.id.id_worker_bean_record_recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    private WorkerBeanRecordAdapter mAdapter;
    private Context mContext;
    private List<WorkerBeanRecordModel> mRecordList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker_bean_record, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecordList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mRecordList.add(new WorkerBeanRecordModel());
        }
        mAdapter = new WorkerBeanRecordAdapter(mContext, mRecordList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
