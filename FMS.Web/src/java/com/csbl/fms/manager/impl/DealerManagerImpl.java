package com.csbl.fms.manager.impl;


import com.app.util.GsonUtil;
import com.csbl.fms.manager.DealerManager;
import com.csbl.fms.spring.bean.UserBean;
import com.csbl.fms.spring.entity.Dealer;
import com.csbl.fms.util.Constant;
import static com.csbl.fms.util.Constant.USER_HANDLE;
import java.util.List;
import org.apache.log4j.Logger;
 
public class DealerManagerImpl extends ManagerImpl implements DealerManager, Constant {

    private Logger _logger = Logger.getLogger(this.getClass());

    @Override
    public synchronized String getDealerListByParentId()
    {
        String json = "";
        try
        {
            String sqlDealerList = queryManager.getDealerListByParentIdSQL();
            Object [] params = new Object[] {((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId()};
            List<Dealer> dealerList = (List<Dealer>) springJdbcDao.getObjectList(sqlDealerList, params, Dealer.class);
            json = GsonUtil.getJson(dealerList);
            //System.out.println(json);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Dealer List By ParentId: ", e);
        }
        return json;
    }
    
    @Override
    public String getDealerDetails(String dealerId)
    {
        String json = "";
        try
        {
            String sql = queryManager.getDealerDetailsSQL();
            Object[] params = new Object[]{dealerId};
            Dealer dealerDetails = (Dealer) springJdbcDao.getObject(sql, params, Dealer.class);
            json = GsonUtil.getJson(dealerDetails).toString();
            
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get Dealer Details : ", e);
        }
        
        return json;
    }
	
    
    @Override
    public List<String> getDealerIdList()
    {
        List<String> dealerIdList = null;
        try
        {
            String sqlDealersId = queryManager.getDealerIdListByUserSQL();
            Object [] params = new Object[] {((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getUserId()};
            dealerIdList = (List<String>) springJdbcDao.getPrimitiveList(sqlDealersId, params, String.class);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get All Dealer ID List by user id: ", e);
        }
        return dealerIdList;
        
    }
}