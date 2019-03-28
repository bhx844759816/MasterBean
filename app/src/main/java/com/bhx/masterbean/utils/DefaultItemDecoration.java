package com.bhx.masterbean.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DefaultItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public DefaultItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        outRect.bottom = space;
        outRect.left = space;
        outRect.right = space;
//        int pos = parent.getChildLayoutPosition(view);
//        //排除下拉刷新View
//        if (pos > 0) {
//            outRect.top = space;
//            outRect.left = space;
//            outRect.right = space;
//        }
    }
}
