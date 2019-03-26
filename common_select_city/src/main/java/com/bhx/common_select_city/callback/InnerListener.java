package com.bhx.common_select_city.callback;

import com.bhx.common_select_city.model.City;

public interface InnerListener {
    void dismiss(int position, City data);
    void locate();
}
