package com.csbl.fms.service.impl;

import com.app.dal.service.impl.AppIdServiceImpl;
import com.csbl.fms.service.FmsIdService;
import java.util.Date;

public class FmsIdServiceImpl extends AppIdServiceImpl implements FmsIdService
{
    
    @Override
    public synchronized String getDealerId(String postCode)
    {
        Date today = new Date();
        String todayAsString = df.format(today);
        String fId = postCode+"-D-"+todayAsString;
        return fId;
    }
    
    @Override
    public synchronized String getFarmerId(String postCode)
    {
        Date today = new Date();
        String todayAsString = df.format(today);
        String fId = postCode+"-F-"+todayAsString;
        return fId;
    }
    
    @Override
    public synchronized String getRandomPassword()
    {
        return super.getRandomWord();
    }

    @Override
    public String getOid() {
        return super.getOid();
    }
	
}
