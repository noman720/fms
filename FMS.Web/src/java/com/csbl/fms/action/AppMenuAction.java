package com.csbl.fms.action;

import com.csbl.fms.spring.bean.UserBean;
import com.csbl.fms.util.Constant;
import com.opensymphony.xwork2.Action;


public class AppMenuAction extends AbstractionAction implements Action, Constant
{

    private String getRoleName()
    {
        return ((UserBean) sessionManager.getObjectFromSession(USER_HANDLE)).getRoleName();
    }
    
    public String checkAuthor()
    {
        if(getRoleName().equalsIgnoreCase("Admin"))
        {
            return "success";
        }
        else
        {
            sessionManager.sessionOut();
            return "login";
        }
    }
    
    public String checkRootDealer()
    {
        if(getRoleName().equalsIgnoreCase("rootdealer"))
        {
            return "success";
        }
        else
        {
            sessionManager.sessionOut();
            return "login";
        }
    }
    
    public String checkLeafDealer()
    {
        if(getRoleName().equalsIgnoreCase("leafdealer"))
        {
            return "success";
        }
        else
        {
            sessionManager.sessionOut();
            return "login";
        }
    }
    
    
    
    
    
    public String dealerselection()
    {
        if(getRoleName().equalsIgnoreCase("Admin"))
            return "Admin";
        else
        {
            sessionManager.sessionOut();
            return "login";
        }
    }
    
    public String dealerregistrationform()
    {
        return SUCCESS;
    }
    
    public String farmerregistrationform()
    {
        return SUCCESS;
    }
    
    public String appUnderconstruction()
    {
        return SUCCESS;
    }
	
    public String dealerList()
    {
        return SUCCESS;
    }
    
    public String fetilizerAllotment()
    {
        return SUCCESS;
    }
}
