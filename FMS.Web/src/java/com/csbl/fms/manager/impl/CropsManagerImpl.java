package com.csbl.fms.manager.impl;



import com.app.util.GsonUtil;
import com.app.util.ParamUtil;
import com.app.util.SQLBuilder;
import com.csbl.fms.manager.CropsManager;
import com.csbl.fms.spring.entity.Crops;
import com.csbl.fms.util.TableName;
import java.util.List;
import org.apache.log4j.Logger;
 
public class CropsManagerImpl extends ManagerImpl implements CropsManager {

    private Logger _logger = Logger.getLogger(this.getClass());

    @Override
    public List<String> getAllCropsName()
    {
        List<String> cropsList = null;
        try
        {
            String sqlCrops = queryManager.getAllCropsNameSQL();
            cropsList = (List<String>) springJdbcDao.getPrimitiveList(sqlCrops, null,String.class);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get All Shift Name List : ", e);
        }
        return cropsList;
    }

    @Override
    public String getCropsList()
    {
        String json = "";
        try
        {
            String sqlCropsList = queryManager.getCropsListSQL();
            Object [] params = new Object[] {};
            List<Crops> cropsList = (List<Crops>) springJdbcDao.getObjectList(sqlCropsList, params, Crops.class);
            json = GsonUtil.getJson(cropsList);
            //System.out.println(json);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Crops List: ", e);
        }
        return json;
    }
	
    
    @Override
    public String saveCrops(String saveCropsJson)
    {
        String json = "";
        try
        {
            //System.out.println("Json is: "+saveDealerJson);
            Crops crops = (Crops) GsonUtil.parseObject(saveCropsJson, Crops.class);
            crops.setOid(idService.getOid());
            String sqlClass = SQLBuilder.getInsert(crops, TableName.CROPS);
            Object [] params = ParamUtil.getParams(crops);
            springJdbcDao.saveObject(sqlClass, params);
            json="{\"success\":\"succes\"}";
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save Crops: ");
        }
        
        return json;
    }
}