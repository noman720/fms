<%-- 
    Document   : takeattendance
    Created on : 11 Mar, 2013, 3:00:44 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link type="text/css" rel="stylesheet" href="css/lib/button.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/jquery-ui.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/chosen.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/loader.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/jquery_notification.css"/>
        <link type="text/css" rel="stylesheet" href="css/lib/jquery.dataTables.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/modal.css" media="print, projection, screen"/>
        <link type="text/css" rel="stylesheet" href="css/custom/app/author/fertilizerentry.css" />
        
        
        <script type="text/javascript" src="js/lib/jquery.js"></script>
        <script type="text/javascript" src="js/lib/jquery-ui.js"></script>
        <script type="text/javascript" src="js/lib/chosen.jquery.js" ></script>
        <script type="text/javascript" src="js/lib/jquery.json-2.2.js"></script>
        <script type="text/javascript" src="js/lib/jquery.i18n.properties-1.0.9.js"></script>
        <script type="text/javascript" src="js/lib/jquery_notification.js"></script>
        <script type="text/javascript" src="js/custom/app/custom.js"></script>
        <script type="text/javascript" src="js/custom/app/author/fertilizerentry.js"></script>
        <script type="text/javascript" charset="utf8" src="js/lib/jquery.dataTables.js"></script>
        
        
        
    </head>
    <body>

        <center>
        <div id="fertilizerEntry" class="fertilizerEntry">
            
            <div>
                <span class="reportheading">Fertilizer Entry</span>
                </br></br>

            </div>
            <div>
                <table id="fertilizerEntryTable">
                    <tr>
                        <td><label>Fertilizer ID<span style="color: red;">*</span></label></td>
                        <td style="width: 20px;">&nbsp;</td>
                        <td><input type="text" id="txtFertilizerId" class="txtFertilizerId" value=""/></td>
                    </tr>
                    <tr>
                        <td><label>Fertilizer Name<span style="color: red;">*</span></label></td>
                        <td style="width: 20px;">&nbsp;</td>
                        <td><input type="text" id="txtFertilizerName" class="txtFertilizerName" value=""/></td>
                    </tr>
                    <tr>
                        <td><label>Description<span style="color: red;">*</span></label></td>
                        <td style="width: 20px;">&nbsp;</td>
                        <td>
                            <textarea style="width: 166px; height: 99px;" id="txtAreaDescription" class="txtAreaDescription" value=""></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td style="width: 20px;">&nbsp;</td>
                        <td style="padding-left: 16px;padding-top: 12px;"><input type="button" id="btnSubmitSave" class="btn btn-primary btn-large" value="Save" onclick="saveFertilizer();" /></td>
                    </tr>
                </table>
            </div>
            <br/>
            <hr/>   
            
            <div style="width: 100%">
            <table id="fertilizerTable" class="fertilizerTable">
                <thead>
                  <tr>
                      <th>Crops ID</th>
                      <th>Crops Name </th>
                      <th>Description</th>
                  </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                    <tr>
                        <th align="center" colspan="3"><b>Total : </b> <span id="totalFertilizerValue"></span></th>
                    </tr>
                </tfoot>
            </table>
            </div>
            
            
            
        </div>
        <br/><br/><br/>
        </center>

        
    </body>
</html>
