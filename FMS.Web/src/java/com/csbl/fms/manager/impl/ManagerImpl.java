package com.csbl.fms.manager.impl;


import com.app.dal.spring.dao.SimpleJdbcDao;
import com.app.dal.spring.dao.SpringJdbcDao;
import com.csbl.fms.converter.EntityToBeanConverter;
import com.csbl.fms.manager.Manager;
import com.csbl.fms.manager.SessionManager;
import com.csbl.fms.service.FmsIdService;
import com.csbl.fms.service.QueryManager;
import com.csbl.fms.util.DBUtil;
import com.csbl.fms.util.DataTableJsonUtil;
import com.csbl.fms.util.DataTablesUtil;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
 
public class ManagerImpl implements Manager {

    protected SpringJdbcDao springJdbcDao;
    protected SimpleJdbcDao simpleJdbcDao;
    //protected HibernateDao hibernateDao;
    protected DriverManagerDataSource dataSource;
    protected DataTablesUtil dataTablesParamUtility;
    protected DBUtil dbUtil;
    protected DataTableJsonUtil dataTableJsonUtil;
    protected FmsIdService idService;
    protected EntityToBeanConverter entityConverter;
    protected QueryManager queryManager;
    protected SessionManager sessionManager;

    
    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DriverManagerDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DBUtil getDbUtil() {
        return dbUtil;
    }

    public void setDbUtil(DBUtil dbUtil) {
        this.dbUtil = dbUtil;
    }

    public SpringJdbcDao getSpringJdbcDao() {
        return springJdbcDao;
    }

    public void setSpringJdbcDao(SpringJdbcDao springJdbcDao) {
        this.springJdbcDao = springJdbcDao;
    }
    
    public DataTablesUtil getDataTablesParamUtility() {
        return dataTablesParamUtility;
    }

    public void setDataTablesParamUtility(DataTablesUtil dataTablesParamUtility) {
        this.dataTablesParamUtility = dataTablesParamUtility;
    }

    public EntityToBeanConverter getEntityConverter() {
        return entityConverter;
    }

    public void setEntityConverter(EntityToBeanConverter entityConverter) {
        this.entityConverter = entityConverter;
    }

    /*
    public HibernateDao getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDao hibernateDao) {
        this.hibernateDao = hibernateDao;
    }
    */
    public SimpleJdbcDao getSimpleJdbcDao() {
        return simpleJdbcDao;
    }

    public void setSimpleJdbcDao(SimpleJdbcDao simpleJdbcDao) {
        this.simpleJdbcDao = simpleJdbcDao;
    }

    public DataTableJsonUtil getDataTableJsonUtil() {
        return dataTableJsonUtil;
    }

    public void setDataTableJsonUtil(DataTableJsonUtil dataTableJsonUtil) {
        this.dataTableJsonUtil = dataTableJsonUtil;
    }

    public FmsIdService getIdService() {
        return idService;
    }

    public void setIdService(FmsIdService idService) {
        this.idService = idService;
    }   

    public QueryManager getQueryManager() {
        return queryManager;
    }

    public void setQueryManager(QueryManager queryManager) {
        this.queryManager = queryManager;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    
    
    
    	
}