package com.csbl.fms.action;


import com.csbl.fms.manager.LoginManager;
import com.csbl.fms.spring.bean.UserBean;
import com.csbl.fms.util.Constant;
import com.opensymphony.xwork2.ModelDriven;



public class LoginAction extends AbstractionAction implements ModelDriven<UserBean>, Constant
{    
    //private UserBean userBean;
    private LoginManager loginManager;
    
    public String login()
    {
        if(!isLogin())
        {
            return "fail";
        }
        
        return getUserBean().getRoleName();
    }

    public String logout()
    {
        sessionManager.sessionOut();
        return SUCCESS;
    }

    private boolean isLogin()
    {
        boolean isLogin = false;
        UserBean uBean = loginManager.getUserBean(userBean);
        
        if(uBean == null)
        {
            setMessage("Incorrect Login ID");
        }
        else if(!uBean.isEnabled())
        {
            setMessage("Login ID is not enabled");
        }
        else if(!uBean.getUserPassword().equals(userBean.getUserPassword()))
        {
            setMessage("Incorrect Password");
        }
        else
        {
            sessionManager.setAttributeInSession(USER_HANDLE, uBean);
            setUserBean(uBean);
            isLogin = true;
        }
        return isLogin;
    }

    

    @Override
    public UserBean getModel() {
        return userBean;
    }

    public LoginManager getLoginManager() {
        return loginManager;
    }

    public void setLoginManager(LoginManager loginManager) {
        this.loginManager = loginManager;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
    

}
