
package com.csbl.fms.manager.impl;

import com.app.util.GsonUtil;
import com.app.util.ParamUtil;
import com.app.util.SQLBuilder;
import com.csbl.fms.manager.PostCodeManager;
import com.csbl.fms.manager.RegistrationManager;
import com.csbl.fms.spring.bean.UserBean;
import com.csbl.fms.spring.entity.Dealer;
import com.csbl.fms.spring.entity.Farmer;
import com.csbl.fms.spring.entity.Recommendation;
import static com.csbl.fms.util.Constant.USER_HANDLE;
import com.csbl.fms.util.TableName;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class RegistrationManagerImpl extends ManagerImpl implements RegistrationManager{
    
    private Logger _logger = Logger.getLogger(this.getClass());
    private PostCodeManager postCodeManager;
    
    @Override
    public String saveDealer(String saveDealerJson)
    {
        String json = "";
        try
        {
            //System.out.println("Json is: "+saveDealerJson);
            Dealer dealerReg = (Dealer) GsonUtil.parseObject(saveDealerJson, Dealer.class);
            
            // save to dealer table
            dealerReg.setOid(idService.getOid());
            dealerReg.setCreatedBy(((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId());
            dealerReg.setDealerId(idService.getDealerId(dealerReg.getPostCode()));
            String sqlClass = SQLBuilder.getInsert(dealerReg, TableName.DEALER);
            Object [] params = ParamUtil.getParams(dealerReg);
            springJdbcDao.saveObject(sqlClass, params);
            
            // update in appdealer table
            String updateSql = queryManager.getUpdateAppDealerSQL();
            Object [] paramUpdate = new Object[]{dealerReg.getAppYear(), dealerReg.getNationalId()};
            springJdbcDao.saveObject(updateSql, paramUpdate);
            
            //save to user table
            String userSql = queryManager.getSaveUserSQL();
            Object [] paramUser = new Object[]{
                idService.getOid(), dealerReg.getDealerId(), dealerReg.getDealerName(), 
                idService.getRandomPassword(), true, new Date(), 
                dealerReg.getEmail(), getRoleName(dealerReg.getDealerRole())
            };
            springJdbcDao.saveObject(userSql, paramUser);
            
            json="{\"dealerId\":\""+dealerReg.getDealerId()+"\"}";
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save Dealer : ", e);
        }
        
        return json;
    }
    
    @Override
    public String saveDealerApp(String saveDealerAppJson)
    {
        String json = "";
        try
        {
            //System.out.println("Json is: "+saveDealerJson);
            Dealer dealerReg = (Dealer) GsonUtil.parseObject(saveDealerAppJson, Dealer.class);
            dealerReg.setOid(idService.getOid());
            String sqlClass = SQLBuilder.getInsert(dealerReg, TableName.DEALER_APP);
            Object [] params = ParamUtil.getParams(dealerReg);
            springJdbcDao.saveObject(sqlClass, params);
            json="{\"success\":\"succes\"}";
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save Dealer Application: ", e);
        }
        
        return json;
    }
    
    @Override
    public String getApplicantDealerList(String appYear, String postCode)
    {
        String json = "";
        try
        {
            String sql = queryManager.getApplicantDealerByAppYearAndPostCodeSQL();
            Object[] params = new Object[]{appYear, postCode};
            List<Dealer> dealerList = springJdbcDao.getObjectList(sql, params, Dealer.class);
            json = "{\"dealerList\":"+GsonUtil.getJson(dealerList)+"}";
            
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Applicant Dealer List : ", e);
        }
        
        return json;
    }
    
    @Override
    public String getApplicantDealerDetails(String appYear, String nationalId)
    {
        String json = "";
        try
        {
            String sql = queryManager.getApplicantDealerDetailsSQL();
            Object[] params = new Object[]{appYear, nationalId};
            Dealer dealerDetails = (Dealer) springJdbcDao.getObject(sql, params, Dealer.class);
            json = GsonUtil.getJson(dealerDetails).toString();
            
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Applicant Dealer Details : ", e);
        }
        
        return json;
    }
    
    
    @Override
    public String getParentDealerIdList(String dealerRole)
    {
        String json = "";
        try
        {
            String sql = queryManager.getParentDealerIdListSQL();
            Object[] params = new Object[]{dealerRole};
            List<Dealer> dealerList = springJdbcDao.getObjectList(sql, params, Dealer.class);
            json = "{\"parentDealerIdList\":"+GsonUtil.getJson(dealerList)+"}";
            
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Applicant Dealer List : ", e);
        }
        
        return json;
    }
    
    @Override
    public String saveFarmer(String saveFarmerJson)
    {
        String json = "";
        try
        {
            //System.out.println("Json is: "+saveDealerJson);
            Farmer farmerReg = (Farmer) GsonUtil.parseObject(saveFarmerJson, Farmer.class);
            farmerReg.setOid(idService.getOid());
            farmerReg.setFarmerId(idService.getFarmerId(farmerReg.getPostCode()));
            String userId = ((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId();
            farmerReg.setDealerId(userId);
            farmerReg.setCreatedBy(userId);
            String sqlClass = SQLBuilder.getInsert(farmerReg, TableName.FARMER);
            Object [] params = ParamUtil.getParams(farmerReg);
            springJdbcDao.saveObject(sqlClass, params);
            json="{\"farmerId\":\""+farmerReg.getFarmerId()+"\"}";
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save Farmer : ", e);
        }
        
        return json;
    }

    @Override
    public String getPostCodesJson()
    {
        Recommendation recommendation = new Recommendation();
        String json = "";
        try
        {
            List<Integer> postCodeList = postCodeManager.getAllPostCode();
            recommendation.setPostCodeList(postCodeList);
            json = GsonUtil.getJson(recommendation);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get PostCodes : ", e);
        }
        
        return json;
    }
    
    private String getRoleName(String roleName)
    {
        if(roleName.equalsIgnoreCase("Union"))
            return "leafdealer";
        else
            return "rootdealer";
    }
    
    public PostCodeManager getPostCodeManager() {
        return postCodeManager;
    }

    public void setPostCodeManager(PostCodeManager postCodeManager) {
        this.postCodeManager = postCodeManager;
    }
    
    
}
