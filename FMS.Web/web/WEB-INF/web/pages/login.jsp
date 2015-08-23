<%-- 
    Document   : login
    Created on : 7 Mar, 2013, 1:15:26 AM
    Author     : Dell
--%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link type="text/css" rel="stylesheet" href="css/lib/button.css">
        <link type="text/css" rel="stylesheet" href="css/custom/web/login.css">
        <script type="text/javascript" src="js/lib/jquery.js"></script>
        <script type="text/javascript" src="js/custom/web/login.js"></script>
        
    </head>
    <body>

        <div class="login-container">
            
            <s:if test="message != null">
                <div class="flash-messages" id="error-message">
                    <div class="flash">
                        <span><s:property value="message"/></span>
                        <span class="cross-icon" id="cross-icon">
                            <img src="images/cross.png"/>
                        </span>
                    </div>
                </div>
            </s:if>
            
            <div class="auth-form" id="login">
                <s:form theme="simple" action="login">
                    <s:hidden name="loginAttempt" value="%{'1'}" />
                    <div class="auth-form-header">
                        <h1>Sign in</h1>
                    </div>
                    <div class="auth-form-body">
                        <s:label value="Login ID" cssClass="form-label"/>
                        <s:textfield id="userId" value="" name="userId" cssClass="userId" theme="simple"/>
                        <s:label value="Password" cssClass="form-label"/>
                        <a href="#">(forgot password)</a>
                        <s:password id="userPassword" value="" cssClass="userPassword" name="userPassword" theme="simple"/>
                        <s:submit value="Sign in" theme="simple" cssClass="btn btn-primary btn-large"/>
                    </div>
                </s:form>
            </div>
        </div>
        
        

            
            
            <br/><br/><br/>


    </body>
</html>
