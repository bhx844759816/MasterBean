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

import com.bhx.common.utils.DensityUtil;
import com.bhx.masterbean.R;
import com.bhx.masterbean.adapter.FollowAdapter;
import com.bhx.masterbean.model.FollowModel;
import com.bhx.masterbean.utils.AllSpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 关注界面
 */
public class FollowFragment extends Fragment {

    @BindView(R.id.id_fragment_follow_recyclerView)
    RecyclerView mRecyclerView;
    Unbinder unbinder;
    private Context mContext;
    private List<FollowModel> mFollowModeList;
    private FollowAdapter mFollowAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mFollowModeList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FollowModel model = new FollowModel();
            mFollowModeList.add(model);
        }
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new AllSpaceItemDecoration(DensityUtil.dip2px(mContext, 10)));
        mFollowAdapter = new FollowAdapter(mContext, mFollowModeList);
        mRecyclerView.setAdapter(mFollowAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
