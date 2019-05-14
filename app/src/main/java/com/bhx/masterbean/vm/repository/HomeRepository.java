package com.bhx.masterbean.vm.repository;

import com.bhx.common.http.RxHelper;
import com.bhx.masterbean.config.Constants;
import com.bhx.masterbean.model.home.BannerModelList;
import com.bhx.masterbean.model.home.HomeModelList;

/**
 * 首页请求
 */
public class HomeRepository extends BaseEventRepository {

    /**
     * 获取首页列表
     *
     * @param city
     */
    public void getHomeModel(String city,int pages) {
        addDisposable(apiService.getHomeModel(city,String.valueOf(pages))
                .compose(RxHelper.handleResult())
                .subscribe(homeModels -> {
                    HomeModelList list = new HomeModelList();
                    list.setHomeModelList(homeModels);
                    sendData(Constants.EVENT_KEY_HOME, Constants.TAG_HOMEMODEL, list);
                }));
    }

    /**
     * 获取首页Banner的数据
     */
    public void getBannerModel() {
        addDisposable(apiService.getBannerModel()
                .compose(RxHelper.handleResult())
                .subscribe(bannerModels -> {
                            BannerModelList bannerModelList = new BannerModelList();
                            bannerModelList.setList(bannerModels);
                            sendData(Constants.EVENT_KEY_HOME, Constants.TAG_BANNER, bannerModelList);
                        }
                ));
    }
}
