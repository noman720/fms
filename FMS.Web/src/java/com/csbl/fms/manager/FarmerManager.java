
package com.csbl.fms.manager;

import java.util.List;

public interface FarmerManager extends Manager{
        
    public String getFarmerListByDealerId();
    
    public String saveFertiAllotment(String saveFertiAllotmentJson);
    
    public String getFarmerDetails(String farmerId);
    
    public List<String> getFarmerIdList();
            
    
}
