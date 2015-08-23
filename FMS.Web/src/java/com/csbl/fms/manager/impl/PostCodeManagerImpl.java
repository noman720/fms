package com.csbl.fms.manager.impl;


import com.csbl.fms.manager.PostCodeManager;
import java.util.List;
import org.apache.log4j.Logger;
 
public class PostCodeManagerImpl extends ManagerImpl implements PostCodeManager {

    private Logger _logger = Logger.getLogger(this.getClass());

    @Override
    public List<Integer> getAllPostCode()
    {
        List<Integer> postCodeList = null;
        try
        {
            String sqlPostCode = queryManager.getAllPostCodeSQL();
            postCodeList = (List<Integer>) springJdbcDao.getPrimitiveList(sqlPostCode, null, Integer.class);
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while get All Shift Name List : ", e);
        }
        return postCodeList;
    }

	
}