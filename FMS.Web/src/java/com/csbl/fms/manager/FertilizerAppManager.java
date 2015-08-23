
package com.csbl.fms.manager;

public interface FertilizerAppManager extends Manager{
    
    public String makeFertilizerAppToolbar();
    
    public String saveFertilizerApplication(String saveFertilizerApplicationJson);
    
    public String getRecommendedValue(String postCode, String cropsName, String fertiName);
    
    /*********************************************
     * FOR FARMER ALLOTMET REPORT
     *********************************************/
    public String getFarmerAllotmentReport();
    
    /*********************************************
     * FOR AUTHOR ALLOTMET REPORT
     *********************************************/
    public String getAuthorAllotmentReport();
    
    /*********************************************
     * FOR DEALER ALLOTMET REPORT
     *********************************************/
    public String getDealerAllotmentReport();
    
    
    /**********************************************
    TRANSACTION FOR DEALER OR AUTHOR
    ***********************************************/
    public String makeAuthorTransactionToolbar();
    
    public String getAllotedValueByDealer(String seasionYear, String seasionName, String fertiName, String dealerId);
    
    public String saveDealerTransaction(String saveTransactionJson, String toDealer);
    
    
    /**********************************************
    TRANSACTION FOR FARMER
    ***********************************************/
    public String makeFarmerTransactionToolbar();
    
    public String getAllotedValueForFarmer(String seasionYear, String seasionName, String fertiName, String farmerId);
    
    public String saveFarmerTransaction(String saveTransactionJson);
    
    
    
    
    
}
