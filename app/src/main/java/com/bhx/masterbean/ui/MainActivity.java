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
import com.bhx.masterbean.ui.fragment.ChannelFragment;
import com.bhx.masterbean.ui.fragment.HomeFragment;
import com.bhx.masterbean.ui.fragment.SearchFragment;

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
    private Fragment mChannelFragment;
    private Fragment mSearchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        showHomeFragment();
        mNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            int id = menuItem.getItemId();
            switch (id) {
                case R.id.item_bottom_home:
                    showHomeFragment();
                    break;
                case R.id.item_bottom_channel:
                    showChannelFragment();
                    break;
                case R.id.item_bottom_search:
                    showSearchFragment();
                    break;
                case R.id.item_bottom_my:
                    break;
            }
            return true;
        });
    }


    /**
     * 展示首页Fragment
     */
    public void showHomeFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        if (mHomeFragment == null) {
            mHomeFragment = new HomeFragment();
            transaction.add(R.id.id_fragment_content, mHomeFragment);
        } else {
            transaction.show(mHomeFragment);
        }
        transaction.commit();
    }

    private void showChannelFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        if (mChannelFragment == null) {
            mChannelFragment = new ChannelFragment();
            transaction.add(R.id.id_fragment_content, mChannelFragment);
        } else {
            transaction.show(mChannelFragment);
        }
        transaction.commit();
    }

    private void showSearchFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        if (mSearchFragment == null) {
            mSearchFragment = new SearchFragment();
            transaction.add(R.id.id_fragment_content, mSearchFragment);
        } else {
            transaction.show(mSearchFragment);
        }
        transaction.commit();
    }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mChannelFragment != null) {
            transaction.hide(mChannelFragment);
        }
        if (mSearchFragment != null) {
            transaction.hide(mSearchFragment);
        }
    }
}
