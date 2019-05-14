package com.bhx.masterbean.ui;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bhx.common.mvvm.BaseMVVMActivity;
import com.bhx.common.ui.widget.CommonLoadingDialog;
import com.bhx.common.utils.PhoneUtils;
import com.bhx.common.utils.ToastUtils;
import com.bhx.masterbean.R;
import com.bhx.masterbean.base.BaseLoadingActivity;
import com.bhx.masterbean.config.Constants;
import com.bhx.masterbean.vm.LoginModel;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * 修改包名 修改签名
 * <p>
 * 登陆界面
 */
public class LoginActivity extends BaseLoadingActivity<LoginModel> {

    @BindView(R.id.id_login_input_phone)
    EditText mInputPhone;
    @BindView(R.id.id_login_input_psd)
    EditText mInputPsd;
    @BindView(R.id.id_login_code)
    TextView mLoginCode;
    @BindView(R.id.id_login_go_register)
    TextView mLoginGoRegister;
    private int mCount;//计数

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.id_login_code, R.id.id_login_go, R.id.id_login_go_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.id_login_code:
                String phone = mInputPhone.getText().toString().trim();
                if (!PhoneUtils.isMobile(phone)) {
                    ToastUtils.toastShort("请输入合法的手机号");
                    return;
                }
                mCount = 60;
                sendPhoneCode(phone);
                break;
            case R.id.id_login_go:
                break;
            case R.id.id_login_go_register:
                break;
        }
    }

    @Override
    protected void dataObserver() {
    }

    @Override
    protected Object getEventKey() {
        return null;
    }

    /**
     * 发送手机验证码
     */
    private void sendPhoneCode(String phone) {
        addDisposable(Observable.interval(0, 1, TimeUnit.SECONDS)//设置0延迟，每隔一秒发送一条数据
                .take(mCount + 1) //
                .doOnSubscribe(disposable -> {
                    mViewModel.getPhoneCheckCode(phone);
                    mLoginCode.setTextColor(getResources().getColor(R.color.editText_hint_color));
                    mLoginCode.setEnabled(false);//在发送数据的时候设置为不能点击
                })
                .observeOn(AndroidSchedulers.mainThread())//操作UI主要在UI线程
                .subscribe(aLong -> {
                    mCount--;
                    mLoginCode.setText(String.valueOf(mCount));
                }, throwable -> {
                }, () -> {
                    mLoginCode.setEnabled(true);
                    mLoginCode.setTextColor(getResources().getColor(R.color.colorPrimary));
                    mLoginCode.setText(getResources().getString(R.string.send_phone_code_retry));//数据发送完后设置为原来的文字
                }));
    }
}
