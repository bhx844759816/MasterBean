package com.bhx.masterbean.vm.repository;

import com.bhx.common.http.BaseResponse;
import com.bhx.common.http.RxHelper;
import com.bhx.common.mvvm.BaseRepository;
import com.bhx.common.utils.LogUtils;
import com.bhx.masterbean.config.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 登陆的接口
 */
public class LoginRepository extends BaseEventRepository {


    /**
     * d登陆
     *
     * @param phone
     * @param code
     */
    public void doLoging(String phone, String code) {

    }

    /**
     * 获取验证码
     *
     * @param phone
     */
    public void getCheckedCode(String phone) {
        addDisposable(
                apiService.getCheckedCode(phone)
                        .compose(RxHelper.handleResult())
                        .doOnSubscribe(disposable -> {
                            if (!disposable.isDisposed()) {
                                sendData(Constants.EVENT_KEY_LOADING, Constants.TAG_LOADING, true);
                            }
                        })
                        .doFinally(() -> sendData(Constants.EVENT_KEY_LOADING, Constants.TAG_LOADING, false))
                        .subscribe(s -> {
                            //获取验证码成功
                            sendData(Constants.EVENT_KEY_LADING, Constants.TAG_CODE, true);
                        }, throwable -> {
                            //获取验证码失败
                            sendData(Constants.EVENT_KEY_LADING, Constants.TAG_CODE, false);
                        }));
    }
}
