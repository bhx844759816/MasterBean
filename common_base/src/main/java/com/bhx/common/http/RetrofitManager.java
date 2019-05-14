package com.bhx.common.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit单例获取ApiService类
 */
public class RetrofitManager {

    private static volatile RetrofitManager INSTANCE;

    private Retrofit retrofit;//Retrofit对象

    public static RetrofitManager getInstance() {
        if (INSTANCE == null) {
            synchronized (RetrofitManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RetrofitManager();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 初始化Retrofit
     */
    public void init(String baseUrl) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * 创建请求的代理接口
     *
     * @param clazz Api接口
     */
    public <T> T createApiService(Class<T> clazz) {
        if (retrofit == null) {
            throw new RuntimeException("retrofit is null ,RetrofitManager is not init in Application");
        }
        return retrofit.create(clazz);
    }
}
