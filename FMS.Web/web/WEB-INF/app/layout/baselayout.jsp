<%-- 
    Document   : baselayout
    Created on : 30 Nov, 2012, 11:43:23 AM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title"/></title>
        <link type="text/css" rel="stylesheet" href="css/custom/app/index.css">
        <link rel="shortcut icon" href="images/slider/ajax-loader.gif">
    </head>
    <body>

        <table align="center" width="100%" class="roottable">
            <tr>
                <td colspan="3">
                    <tiles:insertAttribute name="header"/>
                </td>
            </tr>
             <tr>
                <td colspan="3">
                    <tiles:insertAttribute name="menu"/>
                </td>
            </tr>
            <tr style="height: 450px;">
                <td class="extracolumn">&nbsp;</td>
                <td valign="top"><tiles:insertAttribute name="body"/></td>
                <td class="extracolumn">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="3" align="center"><tiles:insertAttribute name="footer"/></td>
            </tr>
        </table>



    </body>
</html>
