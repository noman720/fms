package com.csbl.fms.manager.impl;

import com.csbl.fms.manager.SeasionManager;
import java.util.List;
import org.apache.log4j.Logger;
 
public class SeasionManagerImpl extends ManagerImpl implements SeasionManager {

    private Logger _logger = Logger.getLogger(this.getClass());

    public List<String> getAllSeasionName()
    {
        List<String> seasionsList = null;
        try
        {
            String sqlSeasions = queryManager.getAllSeasionNameSQL();
            seasionsList = (List<String>) springJdbcDao.getPrimitiveList(sqlSeasions, null,String.class);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get All Seasion Name List : ", e);
        }
        return seasionsList;
    }

	
}