
package com.csbl.fms.spring.entity;

import java.util.List;

public class Recommendation {
    private String oid;
    private String postCode;
    private String cropsName;
    private String fertiName;
    private double landAmount;
    private String landUnit;
    private double fertiAmount;
    private String fertiUnit;
    private List<Integer> postCodeList;
    private List<String> cropsNameList;
    private List<String> fertiNameList;

    public Recommendation() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCropsName() {
        return cropsName;
    }

    public void setCropsName(String cropsName) {
        this.cropsName = cropsName;
    }

    public String getFertiName() {
        return fertiName;
    }

    public void setFertiName(String fertiName) {
        this.fertiName = fertiName;
    }

    public double getLandAmount() {
        return landAmount;
    }

    public void setLandAmount(double landAmount) {
        this.landAmount = landAmount;
    }

    public String getLandUnit() {
        return landUnit;
    }

    public void setLandUnit(String landUnit) {
        this.landUnit = landUnit;
    }

    public double getFertiAmount() {
        return fertiAmount;
    }

    public void setFertiAmount(double fertiAmount) {
        this.fertiAmount = fertiAmount;
    }

    public String getFertiUnit() {
        return fertiUnit;
    }

    public void setFertiUnit(String fertiUnit) {
        this.fertiUnit = fertiUnit;
    }

    public List<Integer> getPostCodeList() {
        return postCodeList;
    }

    public void setPostCodeList(List<Integer> postCodeList) {
        this.postCodeList = postCodeList;
    }

    public List<String> getCropsNameList() {
        return cropsNameList;
    }

    public void setCropsNameList(List<String> cropsNameList) {
        this.cropsNameList = cropsNameList;
    }

    public List<String> getFertiNameList() {
        return fertiNameList;
    }

    public void setFertiNameList(List<String> fertiNameList) {
        this.fertiNameList = fertiNameList;
    }
    
    
    
    
}
