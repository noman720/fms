package com.csbl.fms.manager.impl;

import com.app.util.GsonUtil;
import com.app.util.ParamUtil;
import com.app.util.SQLBuilder;
import com.csbl.fms.manager.FertilizerManager;
import com.csbl.fms.spring.entity.Fertilizer;
import com.csbl.fms.util.TableName;
import java.util.List;
import org.apache.log4j.Logger;
 
public class FertilizerManagerImpl extends ManagerImpl implements FertilizerManager {

    private Logger _logger = Logger.getLogger(this.getClass());

    @Override
    public List<String> getAllFertilizerName()
    {
        
        List<String> fertilizerList = null;
        try
        {
            String sqlFertilizer = queryManager.getAllFertilizerIdSQL();
            fertilizerList = (List<String>) springJdbcDao.getPrimitiveList(sqlFertilizer, null,String.class);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get All Fertilizer Name List : ", e);
        }
        return fertilizerList;
    
    }
    
    
    @Override
    public String getFertilizerList()
    {
        String json = "";
        try
        {
            String sqlCropsList = queryManager.getFertilizerListSQL();
            Object [] params = new Object[] {};
            List<Fertilizer> fertilizerList = (List<Fertilizer>) springJdbcDao.getObjectList(sqlCropsList, params, Fertilizer.class);
            json = GsonUtil.getJson(fertilizerList);
            //System.out.println(json);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Fertilizer List: ", e);
        }
        return json;
    }
	
    
    
    @Override
    public String saveFertilizer(String saveFertilizerJson)
    {
        String json = "";
        try
        {
            //System.out.println("Json is: "+saveDealerJson);
            Fertilizer fertilizer = (Fertilizer) GsonUtil.parseObject(saveFertilizerJson, Fertilizer.class);
            fertilizer.setOid(idService.getOid());
            String sqlClass = SQLBuilder.getInsert(fertilizer, TableName.FERTILIZER);
            Object [] params = ParamUtil.getParams(fertilizer);
            springJdbcDao.saveObject(sqlClass, params);
            json="{\"success\":\"succes\"}";
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save Fertilizer: ");
        }
     

	return json;
    }
    
       
}