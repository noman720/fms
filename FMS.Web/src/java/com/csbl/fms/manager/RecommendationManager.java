
package com.csbl.fms.manager;

public interface RecommendationManager extends Manager{
    
    public String makeRecommendationToolbar();
    
    public String saveRecommendation(String saveRecommendationJson);
    
}
