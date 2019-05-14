package com.bhx.common.utils;

import android.support.annotation.NonNull;

public class Utils {

    private Utils() {

    }

    /**
     * @param reference
     * @param <T>
     * @return
     */
    public static <T> T checkNotNull(final T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

}
