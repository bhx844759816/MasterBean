package com.bhx.masterbean.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bhx.common.ui.widget.FlowLayout;
import com.bhx.common.utils.DensityUtil;
import com.bhx.masterbean.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 搜索界面
 */
public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.id_hot_label_flowLayout)
    FlowLayout mHotLabelFlowLayout;
    @BindView(R.id.id_hot_history_flowLayout)
    FlowLayout mHotHistoryFlowLayout;
    private String mNames[] = {
            "welcome", "android", "TextView",
            "apple", "jamy", "kobe bryant",
            "apple", "jamy", "kobe bryant",
            "apple", "jamy", "kobe bryant"
    };

    private String mNames_h[] = {
            "哈哈", "大雨", "小雨1",
            "苹果大", "大学大学", "老师",
            "苹果", "大学", "老师",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initChildViews();
        initHistoryChildViews();
    }

    private void initChildViews() {
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.rightMargin = DensityUtil.dip2px(this, 10);
        lp.bottomMargin = DensityUtil.dip2px(this, 10);
        for (int i = 0; i < mNames.length; i++) {
            TextView view = new TextView(this);
            view.setText(mNames[i]);
            view.setTextColor(getResources().getColor(R.color.text_default));
            view.setBackground(getResources().getDrawable(R.drawable.drawable_flow_label));
            mHotLabelFlowLayout.addView(view, lp);
        }
    }

    private void initHistoryChildViews() {
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.rightMargin = DensityUtil.dip2px(this, 10);
        lp.bottomMargin = DensityUtil.dip2px(this, 10);
        for (int i = 0; i < mNames_h.length; i++) {
            TextView view = new TextView(this);
            view.setText(mNames_h[i]);
            view.setTextColor(getResources().getColor(R.color.text_default));
            view.setBackground(getResources().getDrawable(R.drawable.drawable_flow_label));
            mHotHistoryFlowLayout.addView(view, lp);
        }
    }

}
