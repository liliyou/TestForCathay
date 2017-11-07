package com.practice.park.park;

import android.util.Log;

import com.practice.park.park.api.ApiManager;
import com.practice.park.park.api.Park.ParkInfo;
import com.practice.park.park.api.Park.ParkResult;
import com.practice.park.park.api.Park.ResponsePark;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/** Created by xuyating on 2017/11/7. */
public class MainPresenter extends BasePresenter {
  private IMain iMain;

  public MainPresenter(IMain iMain) {
    this.iMain = iMain;
  }

  public ArrayList<ParkInfo> getInitParkList() {
    return new ParkResult().getResults();
  }

  public void loadParkList(String scope, String rid) {
    iMain.showProgressBar();
    iMain.refreshList(new ParkResult().getResults());

    ApiManager.getInstance()
        .getDataService()
        .getParkList(scope, rid)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            new Observer<ResponsePark>() {
              @Override
              public void onSubscribe(Disposable d) {
                Log.i("park_api", "Disposable" + d);
                addDisposable(d);
              }

              @Override
              public void onNext(ResponsePark responsePark) {
                Log.i("park_api", "onNext" + responsePark.toString());
                iMain.refreshList(responsePark.getResult().getResults());
              }

              @Override
              public void onError(Throwable e) {
                Log.i("park_api", "onError");
                iMain.hideProgressBar();
              }

              @Override
              public void onComplete() {
                Log.i("park_api", "onComplete");
                iMain.hideProgressBar();
              }
            });
  }
}
