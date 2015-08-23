<%-- 
    Document   : ProjectsUrl
    Created on : Oct 17, 2013, 12:19:01 PM
    Author     : NOMAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
        <link type="text/css" rel="stylesheet" href="css/lib/button.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/jquery-ui.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/chosen.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/loader.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/jquery_notification.css"/>
        <link type="text/css" rel="stylesheet" href="css/custom/web/rightside.css">
        
        <script type="text/javascript" src="js/lib/jquery.js"></script>
        <script type="text/javascript" src="js/lib/jquery-ui.js"></script>
        <script type="text/javascript" src="js/lib/chosen.jquery.js" ></script>
        <script type="text/javascript" src="js/lib/jquery.numeric.js"></script>
        <script type="text/javascript" src="js/lib/jquery.json-2.2.js"></script>
        <script type="text/javascript" src="js/lib/jquery.i18n.properties-1.0.9.js"></script>
        <script type="text/javascript" src="js/lib/jquery_notification.js"></script>
        <script type="text/javascript" src="js/custom/web/projectsurl.js"></script>
        <script type="text/javascript" src="js/custom/app/custom.js"></script>
    
    </head>
   
    <body>
        
        <h1>Hello World!</h1>
        <a href="" class="newslistmouseout" onclick="getProject()">View Project</a>
        <input type="button" id="btnSubmitSave" class="btn btn-primary btn-large" value="Open" onclick="getProject()" />
       
    </body>
</html>
