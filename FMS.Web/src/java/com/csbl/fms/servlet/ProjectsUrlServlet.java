package com.csbl.fms.servlet;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProjectsUrlServlet extends HttpServlet{


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
            //System.out.println(actionType);
        }
        //System.out.println(req.getParameter("jsonData"));
        if(actionType != null && actionType.equalsIgnoreCase("getProject"))
        {    
            try{
            Desktop.getDesktop().open( new File("H:\\FMS\\Workspace\\Source\\FMS.Web\\otherprojects\\javadoc\\index.html"));
            }catch(Exception e){
                //log.error("Error occured when open help file :", e);
                e.printStackTrace();
            }
            
            //System.out.println("getProject Method is working....");
          /*  
            try {
                final URI myURI = new URI("H:\\FMS\\Workspace\\Source\\FMS.Web\\otherprojects\\javadoc\\index.html");
                open(myURI);
            } catch (URISyntaxException ex) {
                ex.printStackTrace();
            }
              */         
        }
        
        out.flush();
        out.close();
    }
    /*
    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
          try {
            Desktop.getDesktop().browse(uri);
          } catch (IOException e) {e.printStackTrace();}
        } else {}
    }
    */
}
