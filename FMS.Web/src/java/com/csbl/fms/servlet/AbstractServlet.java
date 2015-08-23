package com.csbl.fms.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

public abstract class AbstractServlet extends HttpServlet {
	

    protected ApplicationContext appContext = null;

    @Override
    public void init() throws ServletException 
    {
        super.init();
        appContext = ContextLoader.getCurrentWebApplicationContext();
    }
	
}
