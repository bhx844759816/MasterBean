package com.bhx.masterbean.vm;

import android.app.Application;
import android.support.annotation.NonNull;

import com.bhx.common.mvvm.BaseViewModel;
import com.bhx.masterbean.vm.repository.RegisterRepository;

public class RegisterViewModel extends BaseViewModel<RegisterRepository> {

    public RegisterViewModel(@NonNull Application application) {
        super(application);
    }

}
