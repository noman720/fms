
package com.csbl.fms.spring.entity;

public class Fertilizer {
    private String oid;
    private String fertiId;
    private String fertiName;
    private String fertiDescription;

    public Fertilizer() {
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFertiId() {
        return fertiId;
    }

    public void setFertiId(String fertiId) {
        this.fertiId = fertiId;
    }

    public String getFertiName() {
        return fertiName;
    }

    public void setFertiName(String fertiName) {
        this.fertiName = fertiName;
    }

    public String getFertiDescription() {
        return fertiDescription;
    }

    public void setFertiDescription(String fertiDescription) {
        this.fertiDescription = fertiDescription;
    }
    
    
}
