package com.bhx.masterbean.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.bhx.common.utils.LogUtils;
import com.bhx.masterbean.R;
import com.bhx.masterbean.ui.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.id_bottom_navigationView)
    BottomNavigationView mNavigationView;
    @BindView(R.id.id_fragment_content)
    FrameLayout idFragmentContent;

    private Fragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
//        initFragment();
        mNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            switch (id) {
                case R.id.item_bottom_home:
                    LogUtils.i("show home fragment");
                    showHomeFragment();
                    break;
                case R.id.item_bottom_search:
                    break;
                case R.id.item_bottom_channel:
                    break;
                case R.id.item_bottom_my:
                    break;
            }
            return true;
        });
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_fragment_content, mHomeFragment);
        transaction.commit();
    }

    /**
     * 展示首页Fragment
     */
    public void showHomeFragment() {
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_fragment_content, mHomeFragment);
        transaction.commit();
    }
}
