
package com.csbl.fms.manager;

import java.util.List;


public interface CropsManager extends Manager{
    
    public List<String> getAllCropsName();
    
    public String getCropsList();
    
    public String saveCrops(String saveCropsJson);
    
}
