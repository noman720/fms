
package com.csbl.fms.manager;

import java.io.Serializable;

public interface RegistrationManager extends Serializable{
    
    public String saveDealer(String saveDealerJsn);
    
    public String saveDealerApp(String saveDealerAppJson);
    
    public String getApplicantDealerList(String appYear, String postCode);
    
    public String getApplicantDealerDetails(String appYear, String nationalId);
    
    public String getParentDealerIdList(String dealerRole);
    
    public String saveFarmer(String saveFarmerJsn);
    
    public String getPostCodesJson();
    
}
