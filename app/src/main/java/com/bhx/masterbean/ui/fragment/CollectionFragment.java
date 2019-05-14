package com.bhx.masterbean.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bhx.common.ui.recyclerview.DefaultRefreshViewCreator;
import com.bhx.common.ui.recyclerview.RefreshRecyclerView;
import com.bhx.common.utils.DensityUtil;
import com.bhx.masterbean.R;
import com.bhx.masterbean.adapter.HomeAdapter;
import com.bhx.masterbean.adapter.TestHomeAdapter;
import com.bhx.masterbean.model.home.HomeModel;
import com.bhx.masterbean.utils.DefaultItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 收藏界面
 */
public class CollectionFragment extends Fragment {

    @BindView(R.id.id_collection_recyclerView)
    RefreshRecyclerView mRecyclerView;
    Unbinder unbinder;
    private Context mContext;
    private List<HomeModel> mHomeModeList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mHomeModeList = new ArrayList<>();
        initTestData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DefaultItemDecoration(DensityUtil.dip2px(mContext, 10)));
        mRecyclerView.setAdapter(new TestHomeAdapter(mContext, mHomeModeList));
        mRecyclerView.addRefreshViewCreator(new DefaultRefreshViewCreator());
        mRecyclerView.setOnRefreshListener(() ->
                new Handler().postDelayed(() ->
                        mRecyclerView.onStopRefresh(), 2000));
    }

    private void initTestData() {
        for (int i = 0; i < 5; i++) {
            HomeModel model = new HomeModel();
            mHomeModeList.add(model);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
