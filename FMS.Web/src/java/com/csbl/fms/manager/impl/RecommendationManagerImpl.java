
package com.csbl.fms.manager.impl;

import com.app.util.GsonUtil;
import com.app.util.ParamUtil;
import com.app.util.SQLBuilder;
import com.csbl.fms.manager.CropsManager;
import com.csbl.fms.manager.FertilizerManager;
import com.csbl.fms.manager.PostCodeManager;
import com.csbl.fms.manager.RecommendationManager;
import com.csbl.fms.spring.entity.Recommendation;
import com.csbl.fms.util.Constant;
import com.csbl.fms.util.TableName;
import java.util.List;
import org.apache.log4j.Logger;

public class RecommendationManagerImpl extends ManagerImpl implements RecommendationManager, Constant {
    
    private Logger _logger = Logger.getLogger(this.getClass());
    private PostCodeManager postCodeManager;
    private CropsManager cropsManager;
    private FertilizerManager fertilizerManager;
    
    
    @Override
    public String makeRecommendationToolbar()
    {   
        String json = GsonUtil.getJson(getRecommendationBean());
        return json;
    }
    
    private Recommendation getRecommendationBean()
    {
        Recommendation recommendation = new Recommendation();
        
        try
        {
            
            List<Integer> postCodeList = postCodeManager.getAllPostCode();
            //String [] postCodes = postCodeList.toArray(new String[postCodeList.size()]);
            recommendation.setPostCodeList(postCodeList);
            
            List<String> cropsNamesList = cropsManager.getAllCropsName();
            //String [] cropsNames = cropsNamesList.toArray(new String[cropsNamesList.size()]);
            recommendation.setCropsNameList(cropsNamesList);
            
            List<String> fertilizerNamesList = fertilizerManager.getAllFertilizerName();
            //String [] fertilizerNames = fertilizerNamesList.toArray(new String[fertilizerNamesList.size()]);
            recommendation.setFertiNameList(fertilizerNamesList);
            
        }catch(Exception e)
        {
            _logger.error("An Exception occured while get Recommendation Grid Toolbar Data : ", e);
        }
        return recommendation;
    }
    
    @Override
    public String saveRecommendation(String saveRecommendationJson)
    {
        String json = "";
        try
        {
            Recommendation recommendation = (Recommendation) GsonUtil.parseObject(saveRecommendationJson, Recommendation.class);
            recommendation.setOid(idService.getOid());
            String sqlClass = SQLBuilder.getInsert(recommendation, TableName.RECOMMENDATION);
            Object [] params = ParamUtil.getParams(recommendation);
            springJdbcDao.saveObject(sqlClass, params);
            json="{\"success\":\"succes\"}";
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save Recommendation: "+e);
        }
        
        return json;
    }
    
    

    public PostCodeManager getPostCodeManager() {
        return postCodeManager;
    }

    public void setPostCodeManager(PostCodeManager postCodeManager) {
        this.postCodeManager = postCodeManager;
    }

    public CropsManager getCropsManager() {
        return cropsManager;
    }

    public void setCropsManager(CropsManager cropsManager) {
        this.cropsManager = cropsManager;
    }

    public FertilizerManager getFertilizerManager() {
        return fertilizerManager;
    }

    public void setFertilizerManager(FertilizerManager fertilizerManager) {
        this.fertilizerManager = fertilizerManager;
    }

    
    
}
