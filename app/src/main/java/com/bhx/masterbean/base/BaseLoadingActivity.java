package com.bhx.masterbean.base;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.bhx.common.mvvm.BaseMVVMActivity;
import com.bhx.common.mvvm.BaseViewModel;
import com.bhx.common.ui.widget.CommonLoadingDialog;
import com.bhx.masterbean.config.Constants;
import com.bhx.masterbean.ui.LoginActivity;

public abstract class BaseLoadingActivity<T extends BaseViewModel> extends BaseMVVMActivity<T> {

    @Override
    protected void dataObserver() {
        registerObserver(Constants.EVENT_KEY_LOADING, Constants.TAG_LOADING, Boolean.class).observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean != null && aBoolean) {
                    showLoadingDialog();
                } else {
                    dismissLoadingDialog();
                }
            }
        });
    }

    protected void showLoadingDialog() {
        CommonLoadingDialog.showDialog(BaseLoadingActivity.this);
    }

    protected void dismissLoadingDialog() {
        CommonLoadingDialog.dismissDialog(BaseLoadingActivity.this);
    }
}
