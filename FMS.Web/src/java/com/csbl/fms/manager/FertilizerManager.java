
package com.csbl.fms.manager;

import java.util.List;


public interface FertilizerManager extends Manager{
    
    public List<String> getAllFertilizerName();
    
    public String getFertilizerList();
    
    public String saveFertilizer(String saveFertilizerJson);
        
}
