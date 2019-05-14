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
import com.bhx.masterbean.adapter.WorkerBeanRankAdapter;
import com.bhx.masterbean.model.WorkerBeanRankModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 匠豆排行的Fragment
 */
public class WorkerBeanRankFragment extends Fragment {

    @BindView(R.id.id_worker_bean_rank_recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    private Context mContext;
    private WorkerBeanRankAdapter mAdapter;
    private List<WorkerBeanRankModel> mRankModelList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker_bean_rank, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mRankModelList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mRankModelList.add(new WorkerBeanRankModel());
        }
        mAdapter = new WorkerBeanRankAdapter(mContext, mRankModelList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
