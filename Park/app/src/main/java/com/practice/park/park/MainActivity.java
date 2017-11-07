package com.practice.park.park;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.practice.park.park.api.Park.ParkInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMain {
  public static final String domain = "http://data.taipei/";
  private final String scope = "resourceAquire";
  private final String rid = "bf073841-c734-49bf-a97f-3757a6013812";

  @BindView(R.id.recyclerview_park)
  RecyclerView recyclerviewPark;
  @BindView(R.id.swiperefresh_park)
  SwipeRefreshLayout swiperefreshPark;

  private MainPresenter mainPresenter = new MainPresenter(this);;
  private ParkAdapter parkAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    initView();
//    mainPresenter.loadParkList(scope, rid);
  }

  private void initView() {
    swiperefreshPark.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        //重新加载刷新页面
        mainPresenter.loadParkList(scope, rid);
      }
    });

    swiperefreshPark.post(new Runnable() {
      @Override
      public void run() {
        mainPresenter.loadParkList(scope, rid);
      }
    });
    swiperefreshPark.setColorSchemeResources(android.R.color.holo_blue_light,
            android.R.color.holo_red_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_green_light);


    parkAdapter = new ParkAdapter(this, mainPresenter.getInitParkList());
    recyclerviewPark.setLayoutManager(new LinearLayoutManager(this));
    recyclerviewPark.setAdapter(parkAdapter);
  }

  @Override
  public void showProgressBar() {
    swiperefreshPark.setRefreshing(true);
  }

  @Override
  public void hideProgressBar() {
    swiperefreshPark.setRefreshing(false);
  }

  @Override
  public void refreshList(ArrayList<ParkInfo> parkInfos) {
    parkAdapter.refreshItem(parkInfos);
  }
}
