package com.practice.park.park.api.Park;

/**
 * Created by xuyating on 2017/11/7.
 */

public class ParkInfo {
    public String _id;
    public String ParkName;
    public String Name;
    public String YearBuilt;
    public String OpenTime;
    public String Image;
    public String Introduction;

    public String getId() {
        return _id == null ? "" : _id;
    }

    public void setId(String _id) {
        this._id = _id == null ? "" : _id;
    }

    public String getParkName() {
        return ParkName == null ? "" : ParkName;
    }

    public void setParkName(String parkName) {
        this.ParkName = parkName == null ? "" : parkName;
    }

    public String getName() {
        return Name == null ? "" : Name;
    }

    public void setName(String Name) {
        this.Name = Name == null ? "" : Name;
    }

    public String getYearBuilt() {
        return YearBuilt == null ? "" : YearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.YearBuilt = yearBuilt == null ? "" : yearBuilt;
    }

    public String getOpenTime() {
        return OpenTime == null ? "" : OpenTime;
    }

    public void setOpenTime(String openTime) {
        this.OpenTime = openTime == null ? "" : openTime;
    }

    public String getImage() {
        return Image == null ? "" : Image;
    }

    public void setImage(String image) {
        this.Image = image == null ? "" : image;
    }

    public String getIntroduction() {
        return Introduction == null ? "" : Introduction;
    }

    public void setIntroduction(String introduction) {
        this.Introduction = introduction == null ? "" : introduction;
    }

    @Override
    public String toString() {
        return "ParkInfo{" +
                "_id='" + _id + '\'' +
                ", ParkName='" + ParkName + '\'' +
                ", Name='" + Name + '\'' +
                ", YearBuilt='" + YearBuilt + '\'' +
                ", OpenTime='" + OpenTime + '\'' +
                ", Image='" + Image + '\'' +
                ", Introduction='" + Introduction + '\'' +
                '}';
    }
}
