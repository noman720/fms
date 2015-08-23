<%-- 
    Document   : menu
    Created on : 6 Mar, 2013, 8:53:52 PM
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
        <link type="text/css" href="css/lib/menu.css" rel="stylesheet"/>
        <script type="text/javascript" src="js/lib/menu.js"></script>
        <script type="text/javascript" src="js/custom/web/menu.js"></script>
    </head>
    <body>
        <div id="menu">
            <ul class="menu">
                <li><s:a href="authorhome" cssClass="parent"><span>Home</span></s:a></li>
                <li><a href="#" class="parent"><span>Dealer</span></a>
                    <ul>
                        <li><s:a href="dealerselection"><span>Dealer Selection</span></s:a></li>
                        <li><s:a href="author-underconstruction"><span>Dealer Report</span></s:a></li>
                    </ul>
                </li>
                <li><a href="#" class="parent"><span>Entry</span></a>
                    <ul>
                        <li><s:a href="cropsentry"><span>Crops Entry</span></s:a></li>
                        <li><s:a href="fertilizerentry"><span>Fertilizer Entry</span></s:a></li>
                        <li><s:a href="fertilizer-recommendation"><span>Recommendation Entry</span></s:a></li>
                    </ul>
                </li>
                <li><a href="#" class="parent"><span>Transaction</span></a>
                    <ul>
                        <li><s:a href="final-allotment-report"><span>Allotment Report</span></s:a></li>
                        <li><s:a href="final-allotment-transaction"><span>Transaction</span></s:a></li>
                    </ul>
                </li>
                <li><a href="#" class="last"><span>Settings</span></a>
                    <ul>
                        <li><s:a href="author-underconstruction"><span>Change Password</span></s:a></li>
                        <li><s:a href="author-underconstruction"><span>Update Profile</span></s:a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--<div id="copyright"><a href="http://apycom.com/"></a></div> -->
    </body>
</html>
