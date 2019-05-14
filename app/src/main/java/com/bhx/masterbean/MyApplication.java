package com.bhx.masterbean;

import com.bhx.common.BaseApplication;
import com.bhx.common.http.RetrofitManager;
import com.bhx.masterbean.config.Constants;

/**
 *
 */
public class MyApplication extends BaseApplication {
    private static boolean sIsLoging = false; //全局记录是否登陆
    public static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoiMTE4MiIsInVzZXJfbmFtZSI6IjE1NzEzNjkzNTY5In0.NqsO3-sUKCHn7BTtnv2PCj8WDNBwvTqGQG0h1WpSavE";

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Retrofit
        RetrofitManager.getInstance().init(Constants.BASE_URL);
    }

    public static boolean isLoging() {
        return sIsLoging;
    }

    public static void setIsLoging(boolean isLoging) {
        sIsLoging = isLoging;
    }
}
