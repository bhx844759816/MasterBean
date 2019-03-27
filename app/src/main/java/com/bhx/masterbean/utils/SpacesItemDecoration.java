package com.bhx.masterbean.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        int pos = parent.getChildLayoutPosition(view);
        //排除下拉刷新View
        if (pos > 0) {
            outRect.bottom = space;
        }
        //排除banner
        if (pos > 1) {
            outRect.left = space;
            outRect.right = space;
        }

    }
}
