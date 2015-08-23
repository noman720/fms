
package com.csbl.fms.action;

import com.csbl.fms.manager.RegistrationManager;
import com.csbl.fms.spring.bean.DealerBean;
import com.csbl.fms.util.Constant;
import com.opensymphony.xwork2.ModelDriven;

public class RegistrationAction extends AbstractionAction implements ModelDriven<DealerBean>, Constant{

    DealerBean dealerBean;
    RegistrationManager registrationManager;

    
    public String dealerRegistration()
    {
        if(!isSaveDealer())
        {
            return "fail";
        }
        return SUCCESS;
    }
    
    boolean isSaveDealer()
    {
        System.out.println("isSaveDealer Method working....");
        /*String confirm = registrationManager.saveDealer("");
        if(!confirm.equalsIgnoreCase("success"))
        {
            return false;
        }
        */
        return true;
    }
    
    public String farmerRegistration()
    {
        return SUCCESS;
    }
    
    
    @Override
    public DealerBean getModel() {
        return dealerBean;
    }
    
    public DealerBean getDealerBean() {
        return dealerBean;
    }

    public void setDealerBean(DealerBean dealerBean) {
        this.dealerBean = dealerBean;
    }

    public RegistrationManager getRegistrationManager() {
        return registrationManager;
    }

    public void setRegistrationManager(RegistrationManager registrationManager) {
        this.registrationManager = registrationManager;
    }
        
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
    
    
    
    
}
