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
        <!--<script type="text/javascript" src="js/custom/web/menu.js"></script>-->
    </head>
    <body>
        <div id="menu">
            <ul class="menu">
                <li>
                    <s:a href="home" cssClass="parent"><span>Home</span></s:a>
                </li>
                <li><a href="#" class="parent"><span>Dealer</span><a>
                    <ul>
                        <li><s:a href="dealerApplication"><span>Application</span></s:a></li>     
                    </ul>
                </li>
                <li><s:a href="underconstruction" cssClass="parent"><span>Gallery</span></s:a></li>                
                <li><s:a href="#" class="parent"><span>Projects</span></s:a>
                    <ul>
                        <li><s:a href="fms"><span>FMS</span></s:a></li>
                    </ul>
                </li>
                <li><a href="#" class="parent"><span>About</span></a>
                    <ul>
                        <li><s:a href="underconstruction"><span>History</span></s:a></li>
                        <li><s:a href="underconstruction"><span>Rules &amp; Regulations</span></s:a></li>
                        <li><s:a href="underconstruction"><span>Library</span></s:a></li>
                        <li><s:a href="underconstruction"><span>Hostel</span></s:a></li>
                    </ul>
                </li>
                <li>
                    <s:a href="underconstruction" cssClass="parent"><span>Help</span></s:a>
                </li>
                <li class="last">
                    <s:a href="contacts" cssClass="parent"><span>Contacts</span></s:a>
                </li>
                
            </ul>
        </div>
        <!-- <div id="copyright"><a href="http://apycom.com/"></a></div> -->
    </body>
</html>
