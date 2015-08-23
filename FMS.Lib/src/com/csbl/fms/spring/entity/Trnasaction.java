/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csbl.fms.spring.entity;

/**
 *
 * @author NOMAN
 */
public class Trnasaction {
    
    
    private String farmerId;
    private String dealerId;
    private int seasionYear;
    private String seasionName;
    private String fertiName;
    private double totalAllotedAmount;
    private String totalAllotedAmountUnit;
    private double totalTransactedAmount;
    private String totalTransactedAmountUnit;

    public Trnasaction() {
    }

    
    
    public double getTotalAllotedAmount() {
        return totalAllotedAmount;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
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

    public String getFertiName() {
        return fertiName;
    }

    public void setFertiName(String fertiName) {
        this.fertiName = fertiName;
    }

    public void setTotalAllotedAmount(double totalAllotedAmount) {
        this.totalAllotedAmount = totalAllotedAmount;
    }

    public String getTotalAllotedAmountUnit() {
        return totalAllotedAmountUnit;
    }

    public void setTotalAllotedAmountUnit(String totalAllotedAmountUnit) {
        this.totalAllotedAmountUnit = totalAllotedAmountUnit;
    }


    public double getTotalTransactedAmount() {
        return totalTransactedAmount;
    }

    public void setTotalTransactedAmount(double totalTransactedAmount) {
        this.totalTransactedAmount = totalTransactedAmount;
    }

    public String getTotalTransactedAmountUnit() {
        return totalTransactedAmountUnit;
    }

    public void setTotalTransactedAmountUnit(String totalTransactedAmountUnit) {
        this.totalTransactedAmountUnit = totalTransactedAmountUnit;
    }

    
    
    
}
