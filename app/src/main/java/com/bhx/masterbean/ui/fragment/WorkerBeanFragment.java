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

import com.bhx.masterbean.R;

import butterknife.OnCheckedChanged;

/**
 * 匠豆界面
 */
public class WorkerBeanFragment extends Fragment {

    private WorkBeanLevelFragment mWorkBeanLevelFragment;

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
        return view;
    }

    @OnCheckedChanged({R.id.id_worker_bean_level_rb, R.id.id_worker_bean_record_rb, R.id.id_worker_bean_rank_rb})
    public void onCheckedChange(CompoundButton view, boolean isChecked) {
        switch (view.getId()) {
            case R.id.id_worker_bean_level_rb:
                if (isChecked) {

                }
                break;
            case R.id.id_worker_bean_record_rb:
                if (isChecked) {

                }
                break;
            case R.id.id_worker_bean_rank_rb:
                if (isChecked) {

                }
                break;
        }
    }

    private void showWorkBeanLevelFragment() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        if (mWorkBeanLevelFragment == null) {
            mWorkBeanLevelFragment = new WorkBeanLevelFragment();
            transaction.add(R.id.id_worker_bean_fragment, mWorkBeanLevelFragment);
        } else {
            transaction.show(mWorkBeanLevelFragment);
        }
        transaction.commit();
    }
}
