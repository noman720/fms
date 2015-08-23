package com.csbl.fms.servlet;

import com.csbl.fms.manager.FarmerManager;
import com.csbl.fms.util.Constant;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FarmerServlet extends  AbstractServlet implements Constant{


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
        FarmerManager farmerManager = (FarmerManager) appContext.getBean("farmerManager");
        
        if(actionType != null && actionType.equalsIgnoreCase("saveFertiAllotment"))
        {
            String saveFertiAllotmentJson = req.getParameter("saveFertiAllotmentJson");
            //System.out.println(saveFertiAllotmentJson);
            String json = farmerManager.saveFertiAllotment(saveFertiAllotmentJson);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("getFarmerList"))
        {
            String json = farmerManager.getFarmerListByDealerId();
            //System.out.println(json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("farmerDetails"))
        {
            String nationalId = req.getParameter("farmerId");
            String json = farmerManager.getFarmerDetails(nationalId);
            //System.out.println(json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        out.flush();
        out.close();
    }
	

}
