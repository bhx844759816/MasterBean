package com.bhx.common.mvvm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.bhx.common.base.BaseActivity;
import com.bhx.common.event.LiveBus;
import com.bhx.common.utils.ReflexUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * MVVM模式的基类
 *
 * @param <T>
 */
public abstract class BaseMVVMActivity<T extends BaseViewModel> extends BaseActivity {
    protected T mViewModel;
    private List<Object> eventKeys = new ArrayList<>();

    @Override
    protected void initView() {
        mViewModel = VMProviders(this, ReflexUtils.getInstance(this, 0));
        if (mViewModel != null) {
            //注册监听事件
            dataObserver();
        }
    }

    protected <T extends ViewModel> T VMProviders(AppCompatActivity fragment, @NonNull Class modelClass) {
        return (T) ViewModelProviders.of(fragment).get(modelClass);
    }

    /**
     * 注册监听事件
     */
    protected void dataObserver() {

    }

    protected <T> MutableLiveData<T> registerObserver(String tag, Class<T> tClass) {
        return registerObserver(getEventKey(), tag, tClass);
    }

    /**
     * 获取EventKey用于事件传递的绑定
     *
     * @return
     */
    protected abstract Object getEventKey();

    /**
     * 区分具体
     *
     * @param eventKey getEventKey()获取的key
     * @param tag      针对一个页面不同的请求分tag进行事件监听
     * @param tClass   预留参数
     * @param <T>      返回类型
     * @return
     */
    protected <T> MutableLiveData<T> registerObserver(Object eventKey, String tag, Class<T> tClass) {
        String event;
        if (TextUtils.isEmpty(tag)) {
            event = (String) eventKey;
        } else {
            event = eventKey + tag;
        }
        eventKeys.add(event);
        return LiveBus.getDefault().subscribe(eventKey, tag, tClass);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (eventKeys != null && eventKeys.size() > 0) {
            for (int i = 0; i < eventKeys.size(); i++) {
                LiveBus.getDefault().clear(eventKeys.get(i));
            }
            eventKeys.clear();
        }
    }
}
