package com.practice.park.park.api.Park;

/** Created by xuyating on 2017/11/7. */
public class ResponsePark {
  public ParkResult result;

    public ParkResult getResult() {
        return result;
    }

    public void setResult(ParkResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponsePark{" +
                "result=" + result +
                '}';
    }
}
