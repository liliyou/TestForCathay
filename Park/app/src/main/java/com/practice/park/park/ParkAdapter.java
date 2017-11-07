package com.practice.park.park;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.practice.park.park.api.Park.ParkInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/** Created by xuyating on 2017/11/7. */
public class ParkAdapter extends RecyclerView.Adapter {

  private Context context;
  private ArrayList<ParkInfo> parkInfos;

  public ParkAdapter(Context context, ArrayList<ParkInfo> parkInfos) {
    this.context = context;
    this.parkInfos = parkInfos;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_park, parent, false);
    return new ParkAdapter.ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
    ParkAdapter.ViewHolder holder = (ParkAdapter.ViewHolder) viewHolder;
    ParkInfo parkInfo = parkInfos.get(position);
    Glide.with(context).load(parkInfo.getImage()).into(holder.imgPark);
    holder.txtParkTitle.setText(parkInfo.getParkName());
    holder.txtParkName.setText(parkInfo.getName());
  }

  @Override
  public int getItemCount() {
    return parkInfos.size();
  }

  public void refreshItem(ArrayList<ParkInfo> parkInfos) {
    this.parkInfos = parkInfos;
    notifyDataSetChanged();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.image_park)
    ImageView imgPark;

    @BindView(R.id.textview_park_title)
    TextView txtParkTitle;

    @BindView(R.id.textview_park_name)
    TextView txtParkName;

    ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
