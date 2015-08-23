
package com.csbl.fms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.apache.log4j.Logger;

public class DBUtil implements Constant {

    private Logger _logger = Logger.getLogger(this.getClass());


    public String getQueryManagerName(String url)
    {
        if(url == null || url.trim().isEmpty())
        {
            return null;
        }
        if(url.contains(MYSQL))
        {
            return "mysqlQueryManager";
        }
        else if(url.contains(ORACLE))
        {
            return "oracleQueryManager";
        }
        return null;
    }

    public void closeConnection(Connection connection, PreparedStatement statement)
    {
        try
        {
            if(!statement.isClosed())
            {
                statement.close();
            }
            if(!connection.isClosed())
            {
                connection.close();
            }
        }
        catch(Exception e)
        {
            _logger.error("An Exception occured while close Connection with Database : ", e);
        }
    }


}
