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
        <link type="text/css" rel="stylesheet" href="css/custom/app/registrationform.css" />
        <link type="text/css" rel="stylesheet" href="css/custom/app/registrationmodal.css" media="print, projection, screen"/>
        
        <script type="text/javascript" src="js/lib/jquery.js"></script>
        <script type="text/javascript" src="js/lib/jquery-ui.js"></script>
        <script type="text/javascript" src="js/lib/chosen.jquery.js" ></script>
        <script type="text/javascript" src="js/lib/jquery.numeric.js"></script>
        <script type="text/javascript" src="js/lib/jquery.json-2.2.js"></script>
        <script type="text/javascript" src="js/lib/jquery.i18n.properties-1.0.9.js"></script>
        <script type="text/javascript" src="js/lib/jquery_notification.js"></script>
        <script type="text/javascript" src="js/lib/jquery.simplemodal.js" ></script>
        <script type="text/javascript" src="js/custom/app/registrationform.js"></script>
        <script type="text/javascript" src="js/custom/app/custom.js"></script>
        
    </head>
    <body>
        
    <center>
        <br/>
        <h2>Farmer Registration</h2>
        <table border="0" class="farmerregistrationform">
            
            <tr>
                <td><label>Post Code<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2" style="padding-left: 15px;">
                    <select id="cmbPostCode" class="cmbPostCode" style="width:175px;" tabindex="7"></select>
                </td>
            </tr>
            <tr>
                <td><label>Dealer ID<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" id="txtDealerId" class="txtParentId" value=""/></td>
            </tr>
            <tr>
                <td><label>National ID<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" id="txtNationalId" class="txtNationalId" value=""/></td>
            </tr>
            <tr>
                <td><label>Farmer Name<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" id="txtFarmerName" class="txtDealerName" value=""/></td>
            </tr>
            <tr>
                <td><label>Father Name<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" id="txtFatherName" class="txtFatherName" value=""/></td>
            </tr>
            <tr>
                <td><label>Mother Name<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" id="txtMotherName" class="txtMotherName" value=""/></td>
            </tr>
            <tr>
                <td><label>Present Address<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2">
                    <textarea style="width: 166px; height: 99px;" id="txtPresentAddress" class="txtPresentAddress" value=""></textarea>
                </td>
            </tr>
            <tr>
                <td><label>Permanent Address<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2">
                    <textarea style="width: 166px; height: 99px;" id="txtPermanentAddress" class="txtPermanentAddress" value=""></textarea>
                </td>
            </tr>
            <tr>
                <td><label>Mobile No<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" id="txtMobileNo" class="txtMobileNo" value=""/></td>
            </tr>
            <tr>
                <td><label>Email</label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" id="txtEmail" class="txtEmail" value=""/></td>
            </tr>
            <tr>
                <td><label>Gender <span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td>
                    &nbsp;
                    <input type="radio" name="type" id="rdoMale" value="Male"/> Male
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="type" id="rdoFemale" value="Female"/> Female
                </td>
            </tr>
            <tr>
                <td><label>Birth Date<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2"><input type="text" id="txtBirthDate" class="txtBirthDate" value=""/></td>
            </tr>
            <tr>
                <td><label>Blood Group</label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td><input type="text" id="txtBloodGroup" class="txtBloodGroup" value=""/></td>
            </tr>
            
            
            <!--
            <tr>
                <td><label>Type<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2" style="padding-left: 15px;">
                    <select id="cmbTransactionType" style="width:175px;">
                        <option value="Paid">Paid</option>
                        <option value="Adjustment">Adjustment</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Paid<span style="color: red;">*</span></label></td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2"><input type="text" id="txtPaidAmount" class="txtPaidAmount" value="" style="text-align: right;" onkeyup="calculateDues()" /></td>
            </tr>
            
            -->
            <tr>
                <td>&nbsp;</td>
                <td style="width: 20px;">&nbsp;</td>
                <td colspan="2" style="padding-left: 16px;padding-top: 12px;"><input type="button" id="btnSubmitSave" class="btn btn-primary btn-large" value="Save" onclick="saveFarmer()" /></td>
            </tr>
        </table>
    </center>
    
    <div id="overlay" class="web_dialog_overlay"></div>

    <div id="dialog" class="web_dialog"></div>
    
    
    <!-- modal content -->
        <div id="basic-modal-content">
            <br/>
                <center>
                    <div>
                        <b>Farmer ID : </b> <span id="farmerId"></span>
                    </div>
                    <br/>
                    <div>
                        <span style="color: red">Collect this ID for future</span>
                    </div>
                </center>
            <br/>
        </div>
        <!-- preload the images -->
        <div style="display: none;">
            <img src='images/x.png' alt='' />
        </div>
        
        
    </body>
</html>
