
package com.csbl.fms.spring.entity;

import java.util.List;

public class FertilizerApplication {
    private String oid;
    private String farmerId;
    private int seasionYear;
    private String seasionName;
    private String cropsName;
    private String fertiName;
    private double landAmount;
    private String landUnit;
    private double fertiAmount;
    private String fertiUnit;
    private String createdBy;
    private List<String> farmerIdList;
    private List<String> dealerIdList;
    private List<String> seasionNameList;
    private List<String> cropsNameList;
    private List<String> fertiNameList;
    

    public FertilizerApplication() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public int getSeasionYear() {
        return seasionYear;
    }

    public void setSeasionYear(int seasionYear) {
        this.seasionYear = seasionYear;
    }

    public String getSeasionName() {
        return seasionName;
    }

    public void setSeasionName(String seasionName) {
        this.seasionName = seasionName;
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

    public double getFertiAmount() {
        return fertiAmount;
    }

    public void setFertiAmount(double fertiAmount) {
        this.fertiAmount = fertiAmount;
    }

    public String getLandUnit() {
        return landUnit;
    }

    public void setLandUnit(String landUnit) {
        this.landUnit = landUnit;
    }

    public String getFertiUnit() {
        return fertiUnit;
    }

    public void setFertiUnit(String fertiUnit) {
        this.fertiUnit = fertiUnit;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public List<String> getFarmerIdList() {
        return farmerIdList;
    }

    public void setFarmerIdList(List<String> farmerIdList) {
        this.farmerIdList = farmerIdList;
    }

    public List<String> getDealerIdList() {
        return dealerIdList;
    }

    public void setDealerIdList(List<String> dealerIdList) {
        this.dealerIdList = dealerIdList;
    }
    
    

    public List<String> getSeasionNameList() {
        return seasionNameList;
    }

    public void setSeasionNameList(List<String> seasionNameList) {
        this.seasionNameList = seasionNameList;
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
