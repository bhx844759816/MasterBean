package com.bhx.masterbean.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bhx.common.mvvm.BaseMVVMFragment;
import com.bhx.common.selectcity.callback.OnPickListener;
import com.bhx.common.selectcity.model.City;
import com.bhx.common.selectcity.model.LocateState;
import com.bhx.common.selectcity.model.LocatedCity;
import com.bhx.common.selectcity.ui.CityPicker;
import com.bhx.common.ui.recyclerview.DefaultLoadMoreViewCreator;
import com.bhx.common.ui.recyclerview.DefaultRefreshViewCreator;
import com.bhx.common.ui.recyclerview.LoadRefreshRecyclerView;
import com.bhx.common.ui.recyclerview.RefreshRecyclerView;
import com.bhx.common.utils.DensityUtil;
import com.bhx.masterbean.R;
import com.bhx.masterbean.adapter.BannerViewHolder;
import com.bhx.masterbean.adapter.HomeAdapter;
import com.bhx.masterbean.config.Constants;
import com.bhx.masterbean.model.home.BannerModelList;
import com.bhx.masterbean.model.home.BannerModel;
import com.bhx.masterbean.model.home.HomeModel;
import com.bhx.masterbean.model.home.HomeModelList;
import com.bhx.masterbean.ui.ArticleDetailActivity;
import com.bhx.masterbean.ui.SearchActivity;
import com.bhx.masterbean.utils.SpacesItemDecoration;
import com.bhx.masterbean.vm.HomeViewModel;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment2 extends BaseMVVMFragment<HomeViewModel> {

    @BindView(R.id.id_home_location)
    TextView mHomeLocation;
    @BindView(R.id.id_home_message)
    ImageView mHomeMessage;
    @BindView(R.id.id_refresh_recyclerView)
    LoadRefreshRecyclerView mRecyclerView;
    Unbinder unbinder;

    private MZBannerView mBannerView;
    private List<BannerModel> mBannerModelList;
    private List<HomeModel> mHomeModeList;
    private HomeAdapter mAdapter;
    private boolean isLoadMore;
    private boolean isRefresh;

    @Override
    protected Object getEventKey() {
        return Constants.EVENT_KEY_HOME;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    /**
     * 为了实例化自定义布局
     *
     * @param inflater  父类的inflater
     * @param container 父类的容器
     */
    @Override
    public void onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        mBannerView = (MZBannerView) inflater.inflate(R.layout.view_banner_layout2,
                container, false);
    }

    @Override
    protected void initView(Bundle bundle) {
        super.initView(bundle);
        unbinder = ButterKnife.bind(this, rootView);
        mHomeModeList = new ArrayList<>();
        mBannerModelList = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(DensityUtil.dip2px(mContext, 10)));
        mAdapter = new HomeAdapter(mContext, mHomeModeList);
        mAdapter.setOnItemClickListener((view, position) -> {
            Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
            intent.putExtra("article_id", mHomeModeList.get(position).getId());
            startActivity(intent);
        });
        //设置BannerView的点击事件
        mBannerView.setBannerPageClickListener((view, i) -> {
            //TODO banner点击事件
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addRefreshViewCreator(new DefaultRefreshViewCreator());
        mRecyclerView.addLoadViewCreator(new DefaultLoadMoreViewCreator());
        mRecyclerView.setOnLoadMoreListener(() -> {
            isLoadMore = true;
            mViewModel.loadMoreHomeModel("郑州");
        });
        mRecyclerView.addHeaderView(mBannerView);
        mRecyclerView.setOnRefreshListener(() -> {
            isRefresh = true;
            mViewModel.refreshHomeModel("郑州");
        });
        //注册广播接收
        register();
    }

    @OnClick({R.id.id_home_location, R.id.id_home_search, R.id.id_home_message})
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
                                new Handler().postDelayed(() -> CityPicker.from(HomeFragment2.this).locateComplete(new LocatedCity("郑州", "河南", "101280601"),
                                        LocateState.SUCCESS), 3000);
                            }

                            @Override
                            public void onCancel() {

                            }
                        })
                        .show();
                break;
            case R.id.id_home_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.id_home_message:
                break;
        }
    }

    /**
     * 设置轮播图数据
     */
    private void setBanner() {
        if (mBannerModelList.size() == 1) {
            mBannerView.setCanLoop(false);
            mBannerView.setIndicatorVisible(false);
        }
        mBannerView.setPages(mBannerModelList, (MZHolderCreator<BannerViewHolder>) BannerViewHolder::new);
    }

    /**
     * 注册事件接收者
     */
    private void register() {
        //注册获取首页轮播图的事件监听
        registerObserver(Constants.TAG_BANNER, BannerModelList.class)
                .observe(this, bannerModelList -> {
                    if (bannerModelList != null) {
                        List<BannerModel> list = bannerModelList.getList();
                        mBannerModelList.clear();
                        mBannerModelList.addAll(list);
                        setBanner();
                    }
                });
        //注册资讯列表得事件监听
        registerObserver(Constants.TAG_HOMEMODEL, HomeModelList.class)
                .observe(this, homeModelList -> {
                    if (homeModelList != null) {
                        List<HomeModel> list = homeModelList.getHomeModelList();
                        if (isRefresh) {
                            mRecyclerView.resetLoadMoreState();
                            isRefresh = false;
                            mRecyclerView.onStopRefresh();
                            mHomeModeList.clear();
                        }
                        if(isLoadMore){
                            isLoadMore = false;
                            mRecyclerView.onStopLoad();
                            if(list.isEmpty()){
                                mRecyclerView.setNoLoadMoreData();
                            }
                        }
                        mHomeModeList.addAll(list);
                        mAdapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    protected void lazyLoad() {
        //获取资讯列表
        mViewModel.refreshHomeModel("郑州");
        //获取广告轮播图
        mViewModel.getBannerModel();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
