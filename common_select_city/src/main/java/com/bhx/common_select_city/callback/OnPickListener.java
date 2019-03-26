package com.bhx.common_select_city.callback;

import com.bhx.common_select_city.model.City;

public interface OnPickListener {
    void onPick(int position, City data);
    void onLocate();
    void onCancel();
}
