package com.bhx.masterbean.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.bhx.common.mvvm.BaseViewModel;
import com.bhx.masterbean.vm.repository.LoginRepository;

public class LoginModel extends BaseViewModel<LoginRepository> {

    public LoginModel(@NonNull Application application) {
        super(application);
    }

    /**
     * 获取验证码
     *
     * @param phone
     */
    public void getPhoneCheckCode(String phone) {
        if(mRepository != null){
            mRepository.getCheckedCode(phone);
        }
    }
}
