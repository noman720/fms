
package com.csbl.fms.service;

import com.app.dal.service.AppIdService;

public interface FmsIdService extends AppIdService
{
    
    public String getDealerId(String postCode);
    
    public String getFarmerId(String postCode);
    
    public String getRandomPassword();
    
}
