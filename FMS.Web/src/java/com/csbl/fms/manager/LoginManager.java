package com.csbl.fms.manager;

import com.csbl.fms.spring.bean.UserBean;


 
public interface LoginManager extends Manager {

    public UserBean getUserBean(UserBean ub);
    
	
}