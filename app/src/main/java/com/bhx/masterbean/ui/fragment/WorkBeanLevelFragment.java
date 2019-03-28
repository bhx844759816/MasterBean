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
import com.bhx.masterbean.adapter.WorkBeanLevelAdapter;
import com.bhx.masterbean.model.WorkBeanLevelModel;
import com.bhx.masterbean.utils.TimeLineItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 匠豆等级
 */
public class WorkBeanLevelFragment extends Fragment {

    @BindView(R.id.id_worker_bean_level_recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    private Context mContext;
    private WorkBeanLevelAdapter mAdapter;
    private List<WorkBeanLevelModel> mWorkerBeanList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work_bean_level, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new TimeLineItemDecoration());
        mWorkerBeanList = new ArrayList<>();
        initTestData();
        mAdapter = new WorkBeanLevelAdapter(mContext, mWorkerBeanList);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void initTestData() {
        for (int i = 0; i < 10; i++) {
            mWorkerBeanList.add(new WorkBeanLevelModel());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
