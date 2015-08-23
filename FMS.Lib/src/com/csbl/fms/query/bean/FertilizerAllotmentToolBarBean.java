
package com.csbl.fms.query.bean;

public class FertilizerAllotmentToolBarBean extends AbstractQueryBean{
    
    private String[] farmers;
    private String[] postCodes;
    private String[] seasions;
    private String[] crops;
    private String[] fertilizer;

    public FertilizerAllotmentToolBarBean() {
    }

    public String[] getFarmers() {
        return farmers;
    }

    public void setFarmers(String[] farmers) {
        this.farmers = farmers;
    }

    public String[] getSeasions() {
        return seasions;
    }

    public void setSeasions(String[] seasions) {
        this.seasions = seasions;
    }

    
    public String[] getPostCodes() {
        return postCodes;
    }

    public void setPostCodes(String[] postCodes) {
        this.postCodes = postCodes;
    }

    public String[] getCrops() {
        return crops;
    }

    public void setCrops(String[] crops) {
        this.crops = crops;
    }

    public String[] getFertilizer() {
        return fertilizer;
    }

    public void setFertilizer(String[] fertilizer) {
        this.fertilizer = fertilizer;
    }
    
    
    
}
