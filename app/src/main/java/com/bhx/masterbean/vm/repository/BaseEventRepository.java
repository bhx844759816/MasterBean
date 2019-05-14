package com.bhx.masterbean.vm.repository;

import com.bhx.common.event.LiveBus;
import com.bhx.common.http.RetrofitManager;
import com.bhx.common.mvvm.BaseRepository;
import com.bhx.masterbean.http.ApiService;

public class BaseEventRepository extends BaseRepository {
    public  ApiService apiService;

    public BaseEventRepository() {
        apiService = RetrofitManager.getInstance().createApiService(ApiService.class);
    }

    /**
     * 发送数据
     *
     * @param eventKey key
     * @param t        数据实体
     */
    protected void sendData(Object eventKey, Object t) {
        sendData(eventKey, null, t);
    }


    protected void sendData(Object eventKey, String tag, Object t) {
        LiveBus.getDefault().postEvent(eventKey, tag, t);
    }
}
