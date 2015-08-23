
package com.csbl.fms.action;

import com.csbl.fms.spring.bean.UserBean;
import com.csbl.fms.util.Constant;
import com.opensymphony.xwork2.Action;

public class AuthorMenuAction extends AbstractionAction implements Action, Constant{
    
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
    
    
    
}
