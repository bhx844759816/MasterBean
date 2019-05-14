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
import com.bhx.common.ui.widget.GridRadioGroup;
import com.bhx.common.utils.DensityUtil;
import com.bhx.common.utils.ToastUtils;
import com.bhx.masterbean.R;
import com.bhx.masterbean.adapter.HomeAdapter;
import com.bhx.masterbean.adapter.TestHomeAdapter;
import com.bhx.masterbean.model.home.HomeModel;
import com.bhx.masterbean.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 频道
 */
public class ChannelFragment extends Fragment {

    @BindView(R.id.id_channel_refresh_recyclerView)
    RefreshRecyclerView mRecyclerView;
    Unbinder unbinder;
    private GridRadioGroup mRadioGroup;
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
        View view = inflater.inflate(R.layout.fragment_channel, container, false);
        mRadioGroup = (GridRadioGroup) inflater.inflate(R.layout.view_channel_top_item, container, false);
        initView(view);
        return view;
    }

    /**
     * 绑定View
     *
     * @param view
     */
    private void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        mHomeModeList = new ArrayList<>();
        initTestData();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(DensityUtil.dip2px(mContext, 10)));
        mRecyclerView.setAdapter(new TestHomeAdapter(mContext, mHomeModeList));
        mRecyclerView.addRefreshViewCreator(new DefaultRefreshViewCreator());
        mRecyclerView.addHeaderView(mRadioGroup);
        mRadioGroup.check(R.id.id_channel_grid_item_learn);
        mRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.id_channel_grid_item_learn: //学习交流
                    ToastUtils.toastShort("学习交流");
                    break;
                case R.id.id_channel_grid_item_club://社团活动
                    ToastUtils.toastShort("社团活动");
                    break;
                case R.id.id_channel_grid_item_social://社会实践
                    ToastUtils.toastShort("社会实践");
                    break;
                case R.id.id_channel_grid_item_hundred://百年小微
                    ToastUtils.toastShort("百年小微");
                    break;
                case R.id.id_channel_grid_item_case://成败案例
                    ToastUtils.toastShort("成败案例");
                    break;
                case R.id.id_channel_grid_item_business://创业之路
                    ToastUtils.toastShort("创业之路");
                    break;
            }
        });
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
