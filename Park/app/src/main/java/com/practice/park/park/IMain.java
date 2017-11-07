package com.practice.park.park;

import com.practice.park.park.api.Park.ParkInfo;

import java.util.ArrayList;

/** Created by xuyating on 2017/8/5. */

public interface IMain {

  void showProgressBar();

  void hideProgressBar();

  void refreshList(ArrayList<ParkInfo> parkInfos);
}
