package com.csbl.fms.servlet;

import com.csbl.fms.manager.CropsManager;
import com.csbl.fms.util.Constant;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CropsServlet extends  AbstractServlet implements Constant{


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
        String actionType = null;
        if(req.getParameter("actionType") != null)
        {
            actionType = req.getParameter("actionType").toString();
        }
        CropsManager cropsManager = (CropsManager) appContext.getBean("cropsManager");
        
        if(actionType != null && actionType.equalsIgnoreCase("getCropsList"))
        {
            String json = cropsManager.getCropsList();
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("saveCrops"))
        {
            String saveCropsJson = req.getParameter("saveCropsJson");
            //System.out.println("Json is :"+saveCropsJson);
            String json = cropsManager.saveCrops(saveCropsJson);
            //System.out.println("Returned Json is :"+json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        out.flush();
        out.close();
    }
	

}
