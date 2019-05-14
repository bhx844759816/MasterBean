package com.bhx.masterbean.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.bhx.common.utils.ToastUtils;
import com.bhx.masterbean.R;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.Unbinder;

/**
 * 匠豆界面
 */
public class WorkerBeanFragment extends Fragment {

    Unbinder unbinder;
    private WorkBeanLevelFragment mWorkBeanLevelFragment;//匠豆等级界面
    private WorkerBeanRankFragment mWorkerBeanRankFragment;//匠豆排行的界面
    private WorkerBeanRecordFragment mWorkerBeanRecordFragment;//匠豆记录界面

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_worker_bean, container, false);
        showWorkBeanLevelFragment();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnCheckedChanged({R.id.id_worker_bean_level_rb, R.id.id_worker_bean_record_rb, R.id.id_worker_bean_rank_rb})
    public void onCheckedChange(CompoundButton view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.id_worker_bean_level_rb:
                if (isChecked) {
                    ToastUtils.toastShort("匠豆等级");
                    showWorkBeanLevelFragment();
                }
                break;
            case R.id.id_worker_bean_record_rb:
                if (isChecked) {
                    ToastUtils.toastShort("匠豆等级");
                    showWorkerBeanRecordFragment();
                }
                break;
            case R.id.id_worker_bean_rank_rb:
                if (isChecked) {
                    ToastUtils.toastShort("匠豆排行");
                    showWorkerBeanRankFragment();
                }
                break;
        }
    }

    private void showWorkBeanLevelFragment() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        if (mWorkBeanLevelFragment == null) {
            mWorkBeanLevelFragment = new WorkBeanLevelFragment();
            transaction.add(R.id.id_worker_bean_fragment, mWorkBeanLevelFragment);
        } else {
            transaction.show(mWorkBeanLevelFragment);
        }
        transaction.commit();
    }

    private void showWorkerBeanRankFragment() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        if (mWorkerBeanRankFragment == null) {
            mWorkerBeanRankFragment = new WorkerBeanRankFragment();
            transaction.add(R.id.id_worker_bean_fragment, mWorkerBeanRankFragment);
        } else {
            transaction.show(mWorkerBeanRankFragment);
        }
        transaction.commit();
    }

    private void showWorkerBeanRecordFragment() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        if (mWorkerBeanRecordFragment == null) {
            mWorkerBeanRecordFragment = new WorkerBeanRecordFragment();
            transaction.add(R.id.id_worker_bean_fragment, mWorkerBeanRecordFragment);
        } else {
            transaction.show(mWorkerBeanRecordFragment);
        }
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (mWorkBeanLevelFragment != null) {
            transaction.hide(mWorkBeanLevelFragment);
        }
        if (mWorkerBeanRankFragment != null) {
            transaction.hide(mWorkerBeanRankFragment);
        }
        if (mWorkerBeanRecordFragment != null) {
            transaction.hide(mWorkerBeanRecordFragment);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
