package com.csbl.fms.servlet;


import com.csbl.fms.manager.RegistrationManager;
import com.csbl.fms.util.Constant;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends  AbstractServlet implements Constant{


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
        req.setCharacterEncoding("ISO-8859-1");
        if(req.getParameter("actionType") != null)
        {
            actionType = req.getParameter("actionType").toString();
        }
        RegistrationManager rm = (RegistrationManager) appContext.getBean("registrationManager");
        
        if(actionType != null && actionType.equalsIgnoreCase("saveFarmer"))
        {
            String saveFarmerJson = req.getParameter("saveFarmerJson");
            //System.out.println("Json is :"+saveFarmerJson);
            String json = rm.saveFarmer(saveFarmerJson);
            //System.out.println("Returned Json is :"+json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
                
        
        if(actionType != null && actionType.equalsIgnoreCase("saveDealer"))
        {
            String saveDealerJson = req.getParameter("saveDealerJson");
            //System.out.println("Json is :"+saveDealerJson);
            String json = rm.saveDealer(saveDealerJson);
            //System.out.println("Returned Json is :"+json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("saveDealerApp"))
        {
            String saveDealerAppJson = req.getParameter("saveDealerAppJson");
            //System.out.println("Json is :"+saveDealerJson);
            String json = rm.saveDealerApp(saveDealerAppJson);
            //System.out.println("Returned Json is :"+json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("getPostCodes"))
        {
            String json = rm.getPostCodesJson();
            out.write(json);
            //System.out.println(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("applicantDealerListByPostCode"))
        {
            String appYear = req.getParameter("appYear");
            String postCode = req.getParameter("postCode");
            String json = rm.getApplicantDealerList(appYear, postCode);
            //System.out.println(json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("applicantDealerDetails"))
        {
            String appYear = req.getParameter("appYear");
            String nationalId = req.getParameter("nationalId");
            String json = rm.getApplicantDealerDetails(appYear, nationalId);
            //System.out.println(json);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        if(actionType != null && actionType.equalsIgnoreCase("getParentDealerIdList"))
        {
            String dealerRole = getDealerRole(req.getParameter("dealerRole"));
            String json = rm.getParentDealerIdList(dealerRole);
            out.write(json);
            res.setContentType(CONTENT_TYPE_JSON);
        }
        
        
        out.flush();
        out.close();
    }
    
    String getDealerRole(String dealerRole)
    {
        if(dealerRole.equalsIgnoreCase("Division"))
            return "Country";
        if(dealerRole.equalsIgnoreCase("District"))
            return "Division";
        if(dealerRole.equalsIgnoreCase("Thana"))
            return "District";
        if(dealerRole.equalsIgnoreCase("Union"))
            return "Thana";
        
        return "Admin";
    }
        
    
        
}
