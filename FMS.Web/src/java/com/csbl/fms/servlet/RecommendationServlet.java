package com.csbl.fms.servlet;

import com.csbl.fms.manager.RecommendationManager;
import com.csbl.fms.util.Constant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecommendationServlet extends  AbstractServlet implements Constant{


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        manageRequest(req, res);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        manageRequest(req, res);
    }

    private void manageRequest(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        PrintWriter out = res.getWriter();
        req.setCharacterEncoding("ISO-8859-1");
        String actionType = null;
        if(req.getParameter("actionType") != null)
        {
            actionType = req.getParameter("actionType").toString();
        }
        RecommendationManager recommendationManager = (RecommendationManager) appContext.getBean("recommendationManager");
        
        if(actionType != null && actionType.equalsIgnoreCase("getRecommendationToolbar"))
        {
            String json = recommendationManager.makeRecommendationToolbar();
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("saveRecommendation"))
        {
            String saveRecommendationJson = req.getParameter("saveRecommendationJson");
            //System.out.println(saveRecommendationJson);
            String json = recommendationManager.saveRecommendation(saveRecommendationJson);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        out.flush();
        out.close();
    }
	

}
