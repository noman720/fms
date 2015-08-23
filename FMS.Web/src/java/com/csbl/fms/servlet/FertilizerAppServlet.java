package com.csbl.fms.servlet;

import com.csbl.fms.manager.FertilizerAppManager;
import com.csbl.fms.util.Constant;
import static com.csbl.fms.util.Constant.CONTENT_TYPE_JSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FertilizerAppServlet extends  AbstractServlet implements Constant{


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
        FertilizerAppManager fertilizerAppManager = (FertilizerAppManager) appContext.getBean("fertilizerAppManager");
        
        if(actionType != null && actionType.equalsIgnoreCase("getFertilizerAppToolbar"))
        {
            String json = fertilizerAppManager.makeFertilizerAppToolbar();
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("getRecommendedValue"))
        {
            String postCode = req.getParameter("postCode");
            String cropsName = req.getParameter("cropsName");
            String fertiName = req.getParameter("fertiName");
            //System.out.println(postCode+"\n"+cropsName+"\n"+fertiName);
            String json = fertilizerAppManager.getRecommendedValue(postCode, cropsName, fertiName);
            //System.out.println(json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        //saving fertilizer allotment
        if(actionType != null && actionType.equalsIgnoreCase("saveFertilizerApp"))
        {
            String saveFertilizerAppJson = req.getParameter("saveFertilizerAppJson");
            //System.out.println("JSON from UI2Servlet :"+saveFertilizerAppJson);
            String json = fertilizerAppManager.saveFertilizerApplication(saveFertilizerAppJson);
            out.write(json);
            //System.out.println(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        //get allotment report for leaf dealer
        if(actionType != null && actionType.equalsIgnoreCase("getFarmerAllotmentReport"))
        {
            //String saveFertilizerAppJson = req.getParameter("saveFertilizerAppJson");
            //System.out.println("JSON from UI2Servlet :"+saveFertilizerAppJson);
            String json = fertilizerAppManager.getFarmerAllotmentReport();
            out.write(json);
            //System.out.println(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        //get allotment report for author
        if(actionType != null && actionType.equalsIgnoreCase("getAuthorAllotmentReport"))
        {
            //String saveFertilizerAppJson = req.getParameter("saveFertilizerAppJson");
            //System.out.println("JSON from UI2Servlet :"+saveFertilizerAppJson);
            String json = fertilizerAppManager.getAuthorAllotmentReport();
            out.write(json);
            //System.out.println(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        
        //get allotment report for dealer
        if(actionType != null && actionType.equalsIgnoreCase("getDealerAllotmentReport"))
        {
            //String saveFertilizerAppJson = req.getParameter("saveFertilizerAppJson");
            //System.out.println("JSON from UI2Servlet :"+saveFertilizerAppJson);
            String json = fertilizerAppManager.getDealerAllotmentReport();
            out.write(json);
            System.out.println(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        
        /***********************************************************************************/
        //FOR TRANSACTION
        if(actionType != null && actionType.equalsIgnoreCase("getTransactionToolbar"))
        {
            String json = fertilizerAppManager.makeAuthorTransactionToolbar();
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        //geting alloted value for author
        if(actionType != null && actionType.equalsIgnoreCase("getAllotedValue"))
        {
            String seasionYear = req.getParameter("seasionYear");
            String seasionName = req.getParameter("seasionName");
            String fertiName = req.getParameter("fertiName");
            String dealerId = "0000-D-00000000-000000";
            //System.out.println(postCode+"\n"+cropsName+"\n"+fertiName);
            String json = fertilizerAppManager.getAllotedValueByDealer(seasionYear, seasionName, fertiName, dealerId);
            System.out.println(json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        
        //saving transaction by author
        if(actionType != null && actionType.equalsIgnoreCase("saveTransaction"))
        {
            String saveTransactionJson = req.getParameter("saveTransactionJson");
            //System.out.println("JSON from UI2Servlet :"+saveFertilizerAppJson);
            String toDealer = "0000-D-00000000-000000";
            String json = fertilizerAppManager.saveDealerTransaction(saveTransactionJson, toDealer);
            out.write(json);
            //System.out.println(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        /*
         * for dealer to dealer transaction
         */
        if(actionType != null && actionType.equalsIgnoreCase("getTransactionToolbarForDealer"))
        {
            String json = fertilizerAppManager.makeAuthorTransactionToolbar();
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        
        //geting alloted value for dealer
        if(actionType != null && actionType.equalsIgnoreCase("getAllotedValueForDealer"))
        {
            String seasionYear = req.getParameter("seasionYear");
            String seasionName = req.getParameter("seasionName");
            String fertiName = req.getParameter("fertiName");
            String dealerId = req.getParameter("dealerId");
            System.out.println(seasionYear+"//"+seasionName+"//"+fertiName+"//"+dealerId);
            String json = fertilizerAppManager.getAllotedValueByDealer(seasionYear, seasionName, fertiName, dealerId);
            System.out.println(json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        //saving transaction by dealer
        if(actionType != null && actionType.equalsIgnoreCase("saveTransactionForDealer"))
        {
            String saveTransactionJson = req.getParameter("saveTransactionForDealerJson");
            //System.out.println("JSON from UI2Servlet :"+saveFertilizerAppJson);
            String toDealer = req.getParameter("dealerId");
            String json = fertilizerAppManager.saveDealerTransaction(saveTransactionJson, toDealer);
            out.write(json);
            //System.out.println(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        
        /*
         * for dealer to farmer transaction
         */
        if(actionType != null && actionType.equalsIgnoreCase("getTransactionToolbarForFarmer"))
        {
            String json = fertilizerAppManager.makeFarmerTransactionToolbar();
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        
        //geting alloted value for farmer
        if(actionType != null && actionType.equalsIgnoreCase("getAllotedValueForFarmer"))
        {
            String seasionYear = req.getParameter("seasionYear");
            String seasionName = req.getParameter("seasionName");
            String fertiName = req.getParameter("fertiName");
            String farmerId = req.getParameter("farmerId");
            System.out.println(seasionYear+"//"+seasionName+"//"+fertiName+"//"+farmerId);
            String json = fertilizerAppManager.getAllotedValueForFarmer(seasionYear, seasionName, fertiName, farmerId);
            System.out.println(json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        //saving transaction by dealer
        if(actionType != null && actionType.equalsIgnoreCase("saveTransactionForFarmer"))
        {
            String saveTransactionJson = req.getParameter("saveTransactionForFarmerJson");
            //System.out.println("JSON from UI2Servlet :"+saveFertilizerAppJson);
            //String toDealer = req.getParameter("dealerId");
            String json = fertilizerAppManager.saveFarmerTransaction(saveTransactionJson);
            out.write(json);
            //System.out.println(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        out.flush();
        out.close();
    }
	

}
