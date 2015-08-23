package com.csbl.fms.manager;



public interface SessionManager extends Manager
{
    public Object getObjectFromSession(String key);

    public void sessionOut();

    public void setAttributeInSession(String key, Object value);
	
}
