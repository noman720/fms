
package com.csbl.fms.manager.impl;

import com.app.util.GsonUtil;
import com.app.util.ParamUtil;
import com.app.util.SQLBuilder;
import com.csbl.fms.manager.CropsManager;
import com.csbl.fms.manager.DealerManager;
import com.csbl.fms.manager.FarmerManager;
import com.csbl.fms.manager.FertilizerAppManager;
import com.csbl.fms.manager.FertilizerManager;
import com.csbl.fms.manager.SeasionManager;
import com.csbl.fms.spring.bean.UserBean;
import com.csbl.fms.spring.entity.DealerTransaction;
import com.csbl.fms.spring.entity.FarmerTransaction;
import com.csbl.fms.spring.entity.FertilizerApplication;
import com.csbl.fms.spring.entity.Recommendation;
import com.csbl.fms.spring.entity.Trnasaction;
import com.csbl.fms.util.Constant;
import static com.csbl.fms.util.Constant.USER_HANDLE;
import com.csbl.fms.util.TableName;
import java.util.List;
import org.apache.log4j.Logger;

public class FertilizerAppManagerImpl extends ManagerImpl implements FertilizerAppManager, Constant {
    
    private Logger _logger = Logger.getLogger(this.getClass());
    private FarmerManager farmerManager;
    private DealerManager dealerManager;
    private SeasionManager seasionManager;
    private CropsManager cropsManager;
    private FertilizerManager fertilizerManager;
    
    
    @Override
    public String makeFertilizerAppToolbar()
    {   
        String json = GsonUtil.getJson(getFertilizerApplicationBean());
        return json;
    }
    
    private FertilizerApplication getFertilizerApplicationBean()
    {
        FertilizerApplication fertilizerApplication = new FertilizerApplication();
        
        try
        {
            List<String> farmerIdList = farmerManager.getFarmerIdList();
            fertilizerApplication.setFarmerIdList(farmerIdList);
            
            List<String> seasionList = seasionManager.getAllSeasionName();
            fertilizerApplication.setSeasionNameList(seasionList);
            
            List<String> cropsNamesList = cropsManager.getAllCropsName();
            fertilizerApplication.setCropsNameList(cropsNamesList);
            
            List<String> fertilizerNamesList = fertilizerManager.getAllFertilizerName();
            fertilizerApplication.setFertiNameList(fertilizerNamesList);
            
        }catch(Exception e)
        {
            _logger.error("An Exception occured while get Fertilizer Application Grid Toolbar Data : ", e);
        }
        return fertilizerApplication;
    }
    
    @Override
    public String getRecommendedValue(String postCode, String cropsName, String fertiName)
    {
        String json = "";
        try
        {
            String sqlClass = queryManager.getRecommendedValeSQL();
            Object [] params = new Object[] {postCode, cropsName, fertiName};
            Recommendation recommendation = (Recommendation) springJdbcDao.getObject(sqlClass, params, Recommendation.class);
            json = GsonUtil.getJson(recommendation);
            //System.out.println(json);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Recommended Value: ", e);
        }
        return json;
    }
    
    
    
    
    
    @Override
    public String saveFertilizerApplication(String saveFertilizerApplicationJson)
    {
        String json = "";
        try
        {
            FertilizerApplication fertilizerApplication = (FertilizerApplication) GsonUtil.parseObject(saveFertilizerApplicationJson, FertilizerApplication.class);
            fertilizerApplication.setOid(idService.getOid());
            fertilizerApplication.setCreatedBy(((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId());
            String sqlClass = SQLBuilder.getInsert(fertilizerApplication, TableName.TOTAL_FERTI_FARMER);
            Object [] params = ParamUtil.getParams(fertilizerApplication);
            springJdbcDao.saveObject(sqlClass, params);
            json="{\"success\":\""+fertilizerApplication.getFertiUnit()+"\"}";
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save Fertilizer Application: "+e);
        }
        
        return json;
    }
    
    
    @Override
    public String getFarmerAllotmentReport()
    {
        String json = "";
        try
        {
            String sql = queryManager.getFarmerAllotmentReportSQL();
            System.out.println(sql);
            String user = ((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId();
            Object[] params = new Object[]{user, user};
            List<Trnasaction> farmerTransReport = springJdbcDao.getObjectList(sql, params, Trnasaction.class);
            //json = "{\"allotmentReport\":"+GsonUtil.getJson(fertiAppList)+"}";
            json = GsonUtil.getJson(farmerTransReport);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Fertilizer Allotment Report: "+e);
        }
        
        return json;
    }
    
    
    //for author
    @Override
    public String getAuthorAllotmentReport()
    {
        String json = "";
        try
        {
            String sql = queryManager.getAuthorAllotmentReportSQL();
            String dealerId = "0000-D-00000000-000000";
            Object[] params = new Object[]{dealerId, dealerId};  //passes dealerRole country to find root dealer of the country
            List<Trnasaction> authorTransReport = springJdbcDao.getObjectList(sql, params, Trnasaction.class);
            //json = "{\"allotmentReport\":"+GsonUtil.getJson(fertiAppList)+"}";
            json = GsonUtil.getJson(authorTransReport);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Final Fertilizer Allotment and Transaction Report: "+e);
        }
        
        return json;
    }
    
    
      //for dealer
    @Override
    public String getDealerAllotmentReport()
    {
        String json = "";
        try
        {
            String sql = queryManager.getDealerAllotmentReportSQL();
            String user = ((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId();
            Object[] params = new Object[]{user, user};  //passes dealerRole country to find root dealer of the country
            List<Trnasaction> dealerTransReport = springJdbcDao.getObjectList(sql, params, Trnasaction.class);
            //json = "{\"allotmentReport\":"+GsonUtil.getJson(fertiAppList)+"}";
            json = GsonUtil.getJson(dealerTransReport);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Final Fertilizer Allotment and Transaction Report: "+e);
        }
        
        return json;
    }
    
    
    
    /***************************************************
     * Author Transaction
     * @return 
     */
    @Override
    public String makeAuthorTransactionToolbar() {
        String json = GsonUtil.getJson(getFertilizerTransactionBean());
        return json;
    }

    private FertilizerApplication getFertilizerTransactionBean()
    {
        FertilizerApplication fertilizerApplication = new FertilizerApplication();
        
        try
        {
//            List<String> farmerIdList = farmerManager.getFarmerIdList();
//            fertilizerApplication.setFarmerIdList(farmerIdList);
            
            List<String> dealerId = dealerManager.getDealerIdList();
            fertilizerApplication.setDealerIdList(dealerId);
            
            List<String> seasionList = seasionManager.getAllSeasionName();
            fertilizerApplication.setSeasionNameList(seasionList);
            
//            List<String> cropsNamesList = cropsManager.getAllCropsName();
//            fertilizerApplication.setCropsNameList(cropsNamesList);
            
            List<String> fertilizerNamesList = fertilizerManager.getAllFertilizerName();
            fertilizerApplication.setFertiNameList(fertilizerNamesList);
            
        }catch(Exception e)
        {
            _logger.error("An Exception occured while get Fertilizer Transaction for author Grid Toolbar Data : ", e);
        }
        return fertilizerApplication;
    }
    
    
    
    @Override
    public String getAllotedValueByDealer(String seasionYear, String seasionName, String fertiName, String dealerId)
    {
        String json = "";
        try
        {
            //alloted value
            String sqlClass = queryManager.getAllotedValueByAuthorSQL();
            Object [] params = new Object[] {seasionYear, seasionName, fertiName, dealerId};
            Trnasaction allotedValue = (Trnasaction) springJdbcDao.getObject(sqlClass, params, Trnasaction.class);
            
            //get transacted value
            String sqlClass2 = queryManager.getTransactedValueByAuthorSQL();
            Object [] params2 = new Object[] {seasionYear, seasionName, fertiName, dealerId};
            Trnasaction transactedValue = (Trnasaction) springJdbcDao.getObject(sqlClass2, params2, Trnasaction.class);
            
            //prepare json for passing to ui
            Trnasaction transValue = new Trnasaction();
            if(allotedValue != null)
            {
                transValue.setTotalAllotedAmount(allotedValue.getTotalAllotedAmount());
                transValue.setTotalAllotedAmountUnit(allotedValue.getTotalAllotedAmountUnit());
            }
            else{
                transValue.setTotalAllotedAmount(0.00);
                transValue.setTotalAllotedAmountUnit("Metrictone");
            }
            
            //transacted value
            if(transactedValue != null)
            {
                transValue.setTotalTransactedAmount(transactedValue.getTotalTransactedAmount());
                transValue.setTotalTransactedAmountUnit(transactedValue.getTotalTransactedAmountUnit());
            }
            else{
                transValue.setTotalTransactedAmount(0.00);
                transValue.setTotalTransactedAmountUnit("Metrictone");
            }
            
            json = GsonUtil.getJson(transValue);
            
            //System.out.println(json);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Transaction Value: ", e);
        }
        return json;
    }
    
    
    //saving dealer transaction
    
    @Override
    public String saveDealerTransaction(String saveTransactionJson, String toDealer)
    {
        String json = "";
        try
        {
            String user = ((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId();
            DealerTransaction dealerTrans = (DealerTransaction) GsonUtil.parseObject(saveTransactionJson, DealerTransaction.class);
            dealerTrans.setOid(idService.getOid());
            dealerTrans.setToDealer(toDealer);
            dealerTrans.setFromDealer(user);
            dealerTrans.setCreatedBy(user);
            String sqlClass = SQLBuilder.getInsert(dealerTrans, TableName.FERTI_DEALER_TRANSACTION);
            Object [] params = ParamUtil.getParams(dealerTrans);
            springJdbcDao.saveObject(sqlClass, params);
            json="{\"success\":\""+dealerTrans.getFertiUnit()+"\"}";
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save Dealer Transaction: "+e);
        }
        
        return json;
    }
    
    
    
    /*
     * for farmer transaction 
     */
     
    @Override
    public String makeFarmerTransactionToolbar() {
        String json = GsonUtil.getJson(getTransactionForFarmerBean());
        return json;
    }

    private FertilizerApplication getTransactionForFarmerBean()
    {
        FertilizerApplication fertilizerApplication = new FertilizerApplication();
        
        try
        {
            List<String> farmerIdList = farmerManager.getFarmerIdList();
            fertilizerApplication.setFarmerIdList(farmerIdList);
                        
            List<String> seasionList = seasionManager.getAllSeasionName();
            fertilizerApplication.setSeasionNameList(seasionList);
            
            List<String> fertilizerNamesList = fertilizerManager.getAllFertilizerName();
            fertilizerApplication.setFertiNameList(fertilizerNamesList);
            
        }catch(Exception e)
        {
            _logger.error("An Exception occured while get Fertilizer Transaction for author Grid Toolbar Data : ", e);
        }
        return fertilizerApplication;
    }
    
    
    //get alloted value and transacted value for farmer
    @Override
    public String getAllotedValueForFarmer(String seasionYear, String seasionName, String fertiName, String farmerId)
    {
        String json = "";
        try
        {
            //alloted value
            String sqlClass = queryManager.getAllotedValueForFarmerSQL();
            Object [] params = new Object[] {seasionYear, seasionName, fertiName, farmerId};
            Trnasaction allotedValue = (Trnasaction) springJdbcDao.getObject(sqlClass, params, Trnasaction.class);
            
            //get transacted value
            String sqlClass2 = queryManager.getTransactedValueForFarmerSQL();
            Object [] params2 = new Object[] {seasionYear, seasionName, fertiName, farmerId};
            Trnasaction transactedValue = (Trnasaction) springJdbcDao.getObject(sqlClass2, params2, Trnasaction.class);
            
            //prepare json for passing to ui
            Trnasaction transValue = new Trnasaction();
            if(allotedValue != null)
            {
                transValue.setTotalAllotedAmount(allotedValue.getTotalAllotedAmount());
                transValue.setTotalAllotedAmountUnit(allotedValue.getTotalAllotedAmountUnit());
            }
            else{
                transValue.setTotalAllotedAmount(0.00);
                transValue.setTotalAllotedAmountUnit("Metrictone");
            }
            
            //transacted value
            if(transactedValue != null)
            {
                transValue.setTotalTransactedAmount(transactedValue.getTotalTransactedAmount());
                transValue.setTotalTransactedAmountUnit(transactedValue.getTotalTransactedAmountUnit());
            }
            else{
                transValue.setTotalTransactedAmount(0.00);
                transValue.setTotalTransactedAmountUnit("Metrictone");
            }
            
            json = GsonUtil.getJson(transValue);
            
            //System.out.println(json);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Transaction Value: ", e);
        }
        return json;
    }
    
    
    //saving farmer transaction
    
    @Override
    public String saveFarmerTransaction(String saveTransactionJson)
    {
        String json = "";
        try
        {
            String user = ((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId();
            FarmerTransaction farmerTrans = (FarmerTransaction) GsonUtil.parseObject(saveTransactionJson, FarmerTransaction.class);
            farmerTrans.setOid(idService.getOid());
            farmerTrans.setCreatedBy(user);
            String sqlClass = SQLBuilder.getInsert(farmerTrans, TableName.FERTI_FARMER_TRANSACTION);
            Object [] params = ParamUtil.getParams(farmerTrans);
            springJdbcDao.saveObject(sqlClass, params);
            json="{\"success\":\""+farmerTrans.getFertiUnit()+"\"}";
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while save Farmer Transaction: "+e);
        }
        
        return json;
    }
    
    
    
    public FarmerManager getFarmerManager() {
        return farmerManager;
    }

    public void setFarmerManager(FarmerManager farmerManager) {
        this.farmerManager = farmerManager;
    }

    public DealerManager getDealerManager() {
        return dealerManager;
    }

    public void setDealerManager(DealerManager dealerManager) {
        this.dealerManager = dealerManager;
    }

    
    
    public SeasionManager getSeasionManager() {
        return seasionManager;
    }

    public void setSeasionManager(SeasionManager seasionManager) {
        this.seasionManager = seasionManager;
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
