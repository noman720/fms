
package com.csbl.fms.service;


public interface QueryManager {

    public String getUserForLogin();
    public String getSaveUserSQL();
    
//    public String saveDealerSQL();
        
//    public String getDealerListSQL();

    public String getParentDealerIdListSQL();
    
    //////////////////////////////////////////////
    public String getApplicantDealerByAppYearAndPostCodeSQL();
    public String getApplicantDealerDetailsSQL();
    public String getUpdateAppDealerSQL();
    
    /////////////////////////////////////////////
    public String getAllCropsNameSQL();    
    public String getAllFertilizerIdSQL();
    public String getAllPostCodeSQL(); 
    
    /////////////////////////////////////////////
    public String getFarmerListByDealerSQL();
    public String getFarmerDetailsSQL();
    public String getFarmerIdListByDealerSQL();
    
    ////////////////////////////////////////////
    public String getAllSeasionNameSQL();
    public String getCropsListSQL();
    public String getFertilizerListSQL();
       
    ////////////////////////////////////////////
    public String getDealerListByParentIdSQL();
    public String getDealerDetailsSQL();
    public String getDealerIdListByUserSQL();
    
    ////////////////////////////////////////////
    public String getRecommendedValeSQL();
    
    ////////////////////////////////////////////
    public String getFarmerAllotmentReportSQL();
    
    ////////////////////////////////////////////
    public String getAuthorAllotmentReportSQL();
    
    ////////////////////////////////////////////
    public String getDealerAllotmentReportSQL();    
    
    ////////////////////////////////////////////
    public String getAllotedValueByAuthorSQL();
    
    public String getTransactedValueByAuthorSQL();
    
    ///////////////////////////////////////////
    public String getAllotedValueForFarmerSQL();
    
    public String getTransactedValueForFarmerSQL();
    
    
    
    
}
