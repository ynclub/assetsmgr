package com.travel.model;

import java.util.Date;

public class Menu {
    int mid;
    int cid;
    String mname;
    String mtype;
    String beginusedate;
    String assetcoding;
    float orivalue;
    float depreciation;
    float netvalue;
    String person;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
    }

    public String getBeginusedate() {
        return beginusedate;
    }

    public void setBeginusedate(String beginusedate) {
        this.beginusedate = beginusedate;
    }

    public String getAssetcoding() {
        return assetcoding;
    }

    public void setAssetcoding(String assetcoding) {
        this.assetcoding = assetcoding;
    }

    public float getOrivalue() {
        return orivalue;
    }

    public void setOrivalue(float orivalue) {
        this.orivalue = orivalue;
    }

    public float getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(float depreciation) {
        this.depreciation = depreciation;
    }

    public float getNetvalue() {
        return netvalue;
    }

    public void setNetvalue(float netvalue) {
        this.netvalue = netvalue;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
