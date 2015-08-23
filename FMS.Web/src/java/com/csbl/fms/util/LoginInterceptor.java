package com.csbl.fms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.xwork.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics, Constant {
	
    private Logger _logger = Logger.getLogger(this.getClass());
    

    @Override
    public void init()
    {
        _logger.info("Intializing LoginInterceptor...");
    }

    @Override
    public void destroy()
    {
        
    }

    @Override   
    public String intercept(ActionInvocation invocation) throws Exception
    {
        final ActionContext context = invocation.getInvocationContext();
        HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
        HttpSession session = request.getSession(true);
        Object user = session.getAttribute(USER_HANDLE);
        if (user == null)
        {
            String loginAttempt = request.getParameter(LOGIN_ATTEMPT);
            if (!StringUtils.isBlank(loginAttempt))
            {
                //String action = invocation.getResultCode();
                //System.out.println("Action Name: "+action);
                //String invoc = invocation.invoke();    // action response
                //System.out.println("Action Response: "+invoc);
                return invocation.invoke();
            }
            //System.out.println("User not found: login");
            return "login";
        }   
        else
        {
            return invocation.invoke();
        }
    }
	
	
}
