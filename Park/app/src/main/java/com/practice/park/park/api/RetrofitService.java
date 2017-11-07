package com.practice.park.park.api;

import com.practice.park.park.api.Park.ResponsePark;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xuyating on 2017/11/7.
 * 使用retrofit+RxAndroid
 */

public interface RetrofitService {


    // 送出號碼牌
    @GET("/opendata/datalist/apiAccess")
    Observable<ResponsePark> getParkList(@Query("scope") String scope,
                                         @Query("rid") String rid);

}
