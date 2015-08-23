/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csbl.fms.spring.entity;

/**
 *
 * @author NOMAN
 */
public class DealerTransaction {
    private String oid;
    private String fromDealer;
    private String toDealer;
    private int seasionYear;
    private String seasionName;
    private String fertiName;
    private double fertiAmount;
    private String fertiUnit;
    private String createdBy;

    public DealerTransaction() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFromDealer() {
        return fromDealer;
    }

    public void setFromDealer(String fromDealer) {
        this.fromDealer = fromDealer;
    }

    public String getToDealer() {
        return toDealer;
    }

    public void setToDealer(String toDealer) {
        this.toDealer = toDealer;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    
}
