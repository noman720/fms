package com.csbl.fms.manager.impl;

import com.app.util.ParamUtil;
import com.csbl.fms.manager.LoginManager;
import com.csbl.fms.spring.bean.UserBean;
import org.apache.log4j.Logger;
 
public class LoginManagerImpl extends ManagerImpl implements LoginManager {

    private Logger _logger = Logger.getLogger(this.getClass());
    
    @Override
    public UserBean getUserBean(UserBean ub)
    {
        UserBean userBean = null;
        try
        {
            userBean = (UserBean) springJdbcDao.getObject(queryManager.getUserForLogin(), ParamUtil.getParamsWithoutObject(ub.getUserId()), UserBean.class);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get User Bean for Login : ", e);
        }
        return userBean;
    }


	
}