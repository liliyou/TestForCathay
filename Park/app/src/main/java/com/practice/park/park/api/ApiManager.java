package com.practice.park.park.api;

import com.practice.park.park.MainActivity;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

  private RetrofitService mDailyApi;
  private static ApiManager sApiManager;

  public static ApiManager getInstance() {
    if (sApiManager == null) {
      synchronized (ApiManager.class) {
        if (sApiManager == null) {
          sApiManager = new ApiManager();
        }
      }
    }
    return sApiManager;
  }

  /** 封装配置 */
  public RetrofitService getDataService() {
    OkHttpClient client =
        new OkHttpClient.Builder()
            // 添加应用拦截器
            .addInterceptor(new HttpInterceptor())
            // 添加网络拦截器
            //                .addNetworkInterceptor(new MyOkHttpInterceptor())
            .build();
    if (mDailyApi == null) {
      Retrofit retrofit =
          new Retrofit.Builder()
              .baseUrl(MainActivity.domain)
              // 将client与retrofit关联
              .client(client)
              .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
              .addConverterFactory(GsonConverterFactory.create())
              .build();
      mDailyApi = retrofit.create(RetrofitService.class);
    }
    return mDailyApi;
  }
}
