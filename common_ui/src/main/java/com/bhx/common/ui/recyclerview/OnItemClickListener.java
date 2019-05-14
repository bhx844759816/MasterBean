package com.bhx.common.ui.recyclerview;

import android.view.View;

/**
 * RecyclerView得点击事件
 */
public interface OnItemClickListener {

    void onItemClick(View view, int position);

    boolean onItemLongClick(View view, int position);

}
