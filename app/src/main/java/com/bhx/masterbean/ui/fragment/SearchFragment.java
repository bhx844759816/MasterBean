package com.bhx.masterbean.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bhx.common.utils.LogUtils;
import com.bhx.masterbean.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.Unbinder;

/**
 * 发现界面
 */
public class SearchFragment extends Fragment {


    @BindView(R.id.id_search_radioGroup)
    RadioGroup mRadioGroup;
    @BindView(R.id.id_search_viewpager)
    ViewPager mViewpager;
    Unbinder unbinder;
    @BindView(R.id.id_search_collection)
    RadioButton mSearchCollection;
    @BindView(R.id.id_search_bean)
    RadioButton mSearchBean;
    @BindView(R.id.id_search_follow)
    RadioButton mSearchFollow;
    private List<Fragment> mFragmentList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.i("SearchFragment onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        LogUtils.i("SearchFragment onCreateView");
        return view;
    }

    private void initView() {
        initFragmentList();
        mSearchCollection.setChecked(true);
        //默认加载3个
        mViewpager.setOffscreenPageLimit(3);
        mViewpager.setAdapter(new MyViewPageAdapter(getChildFragmentManager()));
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        mSearchCollection.setChecked(true);
                        break;
                    case 1:
                        mSearchBean.setChecked(true);
                        break;
                    case 2:
                        mSearchFollow.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initFragmentList() {
        mFragmentList = new ArrayList<>();
        Fragment collectionFragment = new CollectionFragment();
        Fragment workerBeanFragment = new WorkerBeanFragment();
        Fragment followFragment = new FollowFragment();
        mFragmentList.add(collectionFragment);
        mFragmentList.add(workerBeanFragment);
        mFragmentList.add(followFragment);
    }

    private class MyViewPageAdapter extends FragmentPagerAdapter {

        public MyViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

    @OnCheckedChanged({R.id.id_search_collection, R.id.id_search_bean, R.id.id_search_follow})
    public void onCheckChange(CompoundButton view, boolean isSelect) {
        switch (view.getId()) {
            case R.id.id_search_collection: // 收藏界面
                if (isSelect) {
                    mViewpager.setCurrentItem(0);
                }
                break;
            case R.id.id_search_bean: // 匠豆界面
                if (isSelect) {
                    mViewpager.setCurrentItem(1);
                }
                break;
            case R.id.id_search_follow:// 关注界面
                if (isSelect) {
                    mViewpager.setCurrentItem(2);
                }
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
