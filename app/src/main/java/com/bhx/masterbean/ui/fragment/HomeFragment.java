package com.bhx.masterbean.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bhx.common.selectcity.callback.OnPickListener;
import com.bhx.common.selectcity.model.City;
import com.bhx.common.selectcity.model.LocateState;
import com.bhx.common.selectcity.model.LocatedCity;
import com.bhx.common.selectcity.ui.CityPicker;
import com.bhx.common.ui.recyclerview.DefaultRefreshViewCreator;
import com.bhx.common.ui.recyclerview.RefreshRecyclerView;
import com.bhx.common.utils.DensityUtil;
import com.bhx.masterbean.R;
import com.bhx.masterbean.adapter.HomeAdapter;
import com.bhx.masterbean.model.HomeModel;
import com.bhx.masterbean.ui.SearchActivity;
import com.bhx.masterbean.utils.SpacesItemDecoration;
import com.youth.banner.Banner;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 首页得Fragment
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.id_refresh_recyclerView)
    RefreshRecyclerView mRefreshRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.id_home_location)
    TextView mHomeLocation;
    private MZBannerView mzBannerView;
    private List<Integer> mBannerRes;
    private Context mContext;
    private List<HomeModel> mHomeModeList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mzBannerView = (MZBannerView) inflater.inflate(R.layout.view_banner_layout2, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    /**
     * 初始化View
     */
    private void initView() {
        mBannerRes = new ArrayList<>();
        mHomeModeList = new ArrayList<>();
        initTestData();
        initBanner();
        //添加默认样式得下拉刷新
        mRefreshRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRefreshRecyclerView.addItemDecoration(new SpacesItemDecoration(DensityUtil.dip2px(mContext, 10)));
        mRefreshRecyclerView.setAdapter(new HomeAdapter(mContext, mHomeModeList));
        mRefreshRecyclerView.addRefreshViewCreator(new DefaultRefreshViewCreator());
        mRefreshRecyclerView.addHeaderView(mzBannerView);
    }


    /**
     * 初始化Banner
     */
    private void initBanner() {
        if (mBannerRes.size() == 1) {
            mzBannerView.setCanLoop(false);
            mzBannerView.setIndicatorVisible(false);
        }
        mzBannerView.setPages(mBannerRes, new MZHolderCreator<BannerViewHolder>() {
            @Override
            public BannerViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });

    }

    @OnClick({R.id.id_home_location, R.id.id_home_message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.id_home_location:
                CityPicker.from(this)
                        .enableAnimation(true)
                        .setOnPickListener(new OnPickListener() {
                            @Override
                            public void onPick(int position, City data) {

                            }

                            @Override
                            public void onLocate() {
                                //开始定位，这里模拟一下定位
                                new Handler().postDelayed(() -> CityPicker.from(HomeFragment.this).locateComplete(new LocatedCity("郑州", "河南", "101280601"),
                                        LocateState.SUCCESS), 3000);
                            }

                            @Override
                            public void onCancel() {

                            }
                        })
                        .show();
                break;
            case R.id.id_home_message:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
        }
    }

    /**
     * Banner得视图绑定模块
     */
    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.view_banner_item, null);
            mImageView = view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mzBannerView != null)
            mzBannerView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mzBannerView != null)
            mzBannerView.pause();
    }

    private void initTestData() {
        mBannerRes.add(R.drawable.banner_test_02);
        mBannerRes.add(R.drawable.banner_test_03);
        mBannerRes.add(R.drawable.banner_test_04);
        for (int i = 0; i < 20; i++) {
            HomeModel model = new HomeModel();
            model.setItem("item" + i);
            mHomeModeList.add(model);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
