<%-- 
    Document   : studenttransaction
    Created on : 13 May, 2013, 11:12:34 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link type="text/css" rel="stylesheet" href="css/lib/button.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/jquery-ui.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/chosen.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/loader.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/jquery_notification.css"/>
        <link type="text/css" rel="stylesheet" href="css/custom/app/leafdealer/fertilizerapplication.css" />
        
        
        <script type="text/javascript" src="js/lib/jquery.js"></script>
        <script type="text/javascript" src="js/lib/jquery-ui.js"></script>
        <script type="text/javascript" src="js/lib/chosen.jquery.js" ></script>
        <script type="text/javascript" src="js/lib/jquery.numeric.js"></script>
        <script type="text/javascript" src="js/lib/jquery.json-2.2.js"></script>
        <script type="text/javascript" src="js/lib/jquery.i18n.properties-1.0.9.js"></script>
        <script type="text/javascript" src="js/lib/jquery_notification.js"></script>
        <script type="text/javascript" src="js/custom/app/custom.js"></script>
        <script type="text/javascript" src="js/custom/app/leafdealer/fertilizerapplication.js"></script>
        
        
    </head>
    <body>
        
    <center>
        <div id="fertiApplicationForm" class="fertiApplicationForm"> 
        <h2>Fertilizer Allotment Application</h2>
        <br><br>
        <hr>
        <table border="0" class="fertiApplicationTable" id="fertiApplicationTable">
            <tr>
                <td><label>Farmer ID<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2" style="padding-left: 15px;">
                    <select id="cmbFarmerId" class="cmbFarmerId" style="width:200px;" tabindex="7">
                        <option style="display:none">--select--</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Seasion Year<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2" style="padding-left: 15px;">
                    <select id="cmbSeasionYear" class="cmbSeasionYear" style="width:200px;" tabindex="7"></select>
                </td>
            </tr>
            <tr>
                <td><label>Seasion Name<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2" style="padding-left: 15px;">
                    <select id="cmbSeasionName" class="cmbSeasionName" style="width:200px;" tabindex="7"></select>
                </td>
            </tr>
            <tr>
                <td><label>Crops Name<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2" style="padding-left: 15px;">
                    <select id="cmbCropsName" class="cmbCropsName" style="width:200px;" tabindex="7"></select>
                </td>
                
            </tr>
            <tr>
                <td><label>Fertilizer Name<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2" style="padding-left: 15px;">
                    <select id="cmbFertiName" class="cmbFertiName" style="width:200px;" tabindex="7"></select>
                </td>
                
            </tr>
            <tr>
                <td><label>Land Amount<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" placeholder="0.00" id="txtLandAmount" class="txtLandAmout" /></td>
                <td style="width: 10px;">
                    <select id="cmbLandUnit" class="cmbLandUnit" style="width:80px;" tabindex="2">
                        <option value="Acre">Acre</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Fertilizer Amount<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" placeholder="0.00" id="txtFertiAmount" class="txtFertiAmount" readonly="true" title="You can take more upto 10% of suggested amount"/></td>
                <td style="width: 10px;">
                    <select id="cmbFertiUnit" class="cmbFertiUnit" style="width:80px;" tabindex="2">
                        <option value="Kilogram">Kilogram</option>
                        <option value="Liter">Liter</option>
                    </select>
                </td>
                
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2" style="padding-left: 16px;padding-top: 12px;"><input type="button" id="btnSubmitSave" class="btn btn-primary btn-large" value="Save" onclick="saveFertilizerApplication();" /></td>
            </tr>
        </table>
        </div>
    </center>
    
        
    </body>
</html>
