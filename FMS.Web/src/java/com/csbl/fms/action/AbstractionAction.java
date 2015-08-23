package com.csbl.fms.action;


import com.csbl.fms.manager.SessionManager;
import com.csbl.fms.spring.bean.UserBean;
import static com.csbl.fms.util.Constant.USER_HANDLE;
import com.opensymphony.xwork2.ActionSupport;



public class AbstractionAction extends ActionSupport
{
    
    protected SessionManager sessionManager;
    protected String message;
    protected UserBean userBean;
    protected String userName;

        
    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public String getUserName() {
        UserBean ub = (UserBean)sessionManager.getObjectFromSession(USER_HANDLE);
        return ub.getUserFullName()+"("+ub.getUserId()+")";
    }

            
}
