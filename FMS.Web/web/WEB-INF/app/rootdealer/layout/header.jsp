<%-- 
    Document   : header
    Created on : 30 Nov, 2012, 11:43:23 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link type="text/css" rel="stylesheet" href="css/custom/app/header.css">
    </head>
    <body>
        <!--<img src="images/school_logo.jpg" alt="Logo"/>-->
        <div class="header-container">
            <div class="headername">
                <span>Fertilizer Distribution System</span>
            </div>
            <div class="right-side">
                <span>
                    <s:a href="logout">Sign out</s:a>
                    <br/>
                    <span class="userName"><s:property value="userName"/></span>
                </span>
                
            </div>
        </div>
    </body>
</html>
