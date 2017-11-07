package com.practice.park.park.api.Park;

import java.util.ArrayList;

/** Created by xuyating on 2017/11/7. */
public class ParkResult {

  public Integer offset;
  public Integer limit;
  public Integer count;
  public String sort;
  public ArrayList<ParkInfo> results;

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public String getSort() {
    return sort == null ? "" : sort;
  }

  public void setSort(String sort) {
    this.sort = sort == null ? "" : sort;
  }

  public ArrayList<ParkInfo> getResults() {
    return results == null ? new ArrayList<ParkInfo>() : results;
  }

  public void setResults(ArrayList<ParkInfo> results) {
    this.results = results;
  }

  @Override
  public String toString() {
    return "ParkResult{"
        + "offset="
        + offset
        + ", limit="
        + limit
        + ", count="
        + count
        + ", sort='"
        + sort
        + '\''
        + ", results="
        + results
        + '}';
  }
}
