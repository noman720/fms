package com.csbl.fms.manager.impl;

import com.csbl.fms.manager.SessionManager;
import org.apache.struts2.ServletActionContext;

public class SessionServiceImpl implements SessionManager {
		
    @Override
    public Object getObjectFromSession(String key)
    {
        return ServletActionContext.getRequest().getSession().getAttribute(key);
    }

    @Override
    public void setAttributeInSession(String key, Object value) 
    {
        ServletActionContext.getRequest().getSession().setAttribute(key, value);
    }

    @Override
    public void sessionOut() 
    {
        ServletActionContext.getRequest().getSession().invalidate();
    }




	

}
