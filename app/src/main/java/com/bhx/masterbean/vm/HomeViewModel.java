package com.bhx.masterbean.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.bhx.common.mvvm.BaseViewModel;
import com.bhx.masterbean.vm.repository.HomeRepository;

public class HomeViewModel extends BaseViewModel<HomeRepository> {

    private int pages = 1;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }


    /**
     * 获取首页banner图
     */
    public void getBannerModel() {
        mRepository.getBannerModel();
    }

    /**
     * 刷新首页数据
     * @param city
     */
    public void refreshHomeModel(String city){
        pages = 1;
        mRepository.getHomeModel(city,pages);
    }

    /**
     * 加载更多首页数据
     * @param city
     */
    public void loadMoreHomeModel(String city){
        pages++;
        mRepository.getHomeModel(city,pages);
    }
}
