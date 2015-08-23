
package com.csbl.fms.manager.impl;

import com.app.util.GsonUtil;
import com.app.util.SQLBuilder;
import com.csbl.fms.manager.FarmerManager;
import com.csbl.fms.spring.bean.UserBean;
import com.csbl.fms.spring.entity.Farmer;
import com.csbl.fms.spring.entity.FertilizerApplication;
import com.csbl.fms.util.Constant;
import com.csbl.fms.util.TableName;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class FarmerManagerImpl extends ManagerImpl implements FarmerManager, Constant {
    
    private Logger _logger = Logger.getLogger(this.getClass());
    
    
    
    @Override
    public String getFarmerListByDealerId()
    {
        String json = "";
        try
        {
            String sqlFarmers = queryManager.getFarmerListByDealerSQL();
            Object [] params = new Object[] {((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId()};
            List<Farmer> farmerList = (List<Farmer>) springJdbcDao.getObjectList(sqlFarmers, params, Farmer.class);
            json = GsonUtil.getJson(farmerList);
            //System.out.println(json);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get All Farmer ID List : ", e);
        }
        return json;
        
    }
    
    @Override
    public List<String> getFarmerIdList()
    {
        List<String> farmerIdList = null;
        try
        {
            String sqlFarmersId = queryManager.getFarmerIdListByDealerSQL();
            Object [] params = new Object[] {((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId()};
            farmerIdList = (List<String>) springJdbcDao.getPrimitiveList(sqlFarmersId, params, String.class);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get All Farmer ID List : ", e);
        }
        return farmerIdList;
        
    }
    
    @Override
    public String saveFertiAllotment(String saveFertiAllotmentJson)
    {
        String json = "";
        try{
            FertilizerApplication[] faArray = (FertilizerApplication[]) GsonUtil.parseObject(saveFertiAllotmentJson, FertilizerApplication[].class);
            List<FertilizerApplication> fertiList = new LinkedList<FertilizerApplication>();
            for(FertilizerApplication fa : faArray)
            {
                fa.setOid(idService.getOid());
                fertiList.add(fa);
            }
            
            String sqlClass = SQLBuilder.getInsertSimpleJdbc(fertiList.get(0), TableName.TOTAL_FERTI_FARMER);
            simpleJdbcDao.saveObjectList(sqlClass, fertiList);
            json="{\"message\":\"success\"}";
            
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save FertiAllotment : ", e);
        }
        return json;
    }
    
    
    @Override
    public String getFarmerDetails(String farmerId)
    {
        String json = "";
        try
        {
            String sql = queryManager.getFarmerDetailsSQL();
            Object[] params = new Object[]{farmerId};
            Farmer farmerDetails = (Farmer) springJdbcDao.getObject(sql, params, Farmer.class);
            json = GsonUtil.getJson(farmerDetails).toString();
            
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Applicant Farmer Details : ", e);
        }
        
        return json;
    }
    
    
}
