package com.bhx.common.ui.widget;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bhx.common.ui.R;

/**
 * 通用的IOS的加载对话框
 */
public class CommonLoadingDialog extends DialogFragment {
    public static final String DIALOG_TAG = CommonLoadingDialog.class.getSimpleName();

    public static CommonLoadingDialog newInstance() {
        Bundle args = new Bundle();
        CommonLoadingDialog fragment = new CommonLoadingDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.dialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.common_ui_loading_dialog, container, false);
    }

    /**
     * 展示对话框
     *
     * @param activity
     */
    public static void showDialog(FragmentActivity activity) {
        CommonLoadingDialog fragment = (CommonLoadingDialog)
                activity.getSupportFragmentManager().findFragmentByTag(DIALOG_TAG);
        if (fragment == null) {
            fragment = CommonLoadingDialog.newInstance();
        }
        if (!fragment.isAdded()) {
            FragmentManager manager = activity.getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(fragment, DIALOG_TAG);
            transaction.commitAllowingStateLoss();
        }
    }

    /**
     * 取消展示dialog
     *
     * @param activity
     */
    public static void dismissDialog(FragmentActivity activity) {
        DialogFragment fragment = (DialogFragment) activity.getSupportFragmentManager().findFragmentByTag(DIALOG_TAG);
        if (fragment != null && fragment.isAdded()) {
            fragment.dismissAllowingStateLoss();
        }
    }
}
