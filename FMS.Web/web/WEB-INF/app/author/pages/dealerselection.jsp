<%-- 
    Document   : attendancereport
    Created on : 3 Apr, 2013, 11:54:11 PM
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
        <link type="text/css" rel="stylesheet" href="css/lib/modal.css" media="print, projection, screen"/>
        <link type="text/css" rel="stylesheet" href="css/custom/app/author/dealerselectiontoolbar.css" />
        <link type="text/css" rel="stylesheet" href="css/custom/app/author/dealerselectionbypostcode.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/jquery.dataTables.css" />
        
        
        <script type="text/javascript" src="js/lib/jquery.js"></script>
        <script type="text/javascript" src="js/lib/jquery-ui.js"></script>
        <script type="text/javascript" src="js/lib/jquery.i18n.properties-1.0.9.js"></script>
        <script type="text/javascript" src="js/lib/jquery_notification.js"></script>
        <script type="text/javascript" src="js/lib/chosen.jquery.js" ></script>
        <script type="text/javascript" src="js/lib/jquery.numeric.js"></script>
        <script type="text/javascript" src="js/lib/jquery.json-2.2.js"></script>
        <script type="text/javascript" src="js/lib/jquery.simplemodal.js" ></script>
        <script type="text/javascript" src="js/custom/app/custom.js"></script>
        <script type="text/javascript" src="js/custom/app/author/dealerselection.js"></script>
        <script type="text/javascript" charset="utf8" src="js/lib/jquery.dataTables.js"></script>
        
    </head>
    <body>
        
       
        <center>
            <div id="dealerselectiontoolbar" class="dealerselectiontoolbar" style="display: none;">  
            </div>
            
            <div class="appDealerList" id="appDealerList" style="display: none;">
                <center>
                <table class="appDealerListHeader" border="0 " width="100%">
                    <tr>
                        <td align="center" colspan="6"><div class="reportheading">Applicant Dealer</div></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"></td>
                        <td class="secondcolumn"><label>Application Year : </label></td>
                        <td class="thirdcolumn"><label id="appYear"></label></td>
                        <td class="fourthcolumn"><label>Region (Post Code) : </label></td>
                        <td class="fifthcolumn"><label id="postcode"></label></td>
                        <td class="firstcolumn"></td>
                    </tr>
                </table>
                </center>
                <br/>
                <hr/>
                <br/>
                <center>
                    <table id="appDealerListSortable" class="appDealerlistSortable" border="0" width="100%" align="center">
                        <thead>
                            <tr>
                                <th align="left">Category</th>
                                <th align="left">Name</th>
                                <th align="left">National ID</th>
                                <th align="center">Mobile</th>
                                <th align="center">Is Selected</th>
                                <th align="center">Details</th>
                            </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                    <div>
                        <b>Total : </b> <span id="totalDealerValue"></span>
                    </div>
                </center>
                <br/>
            </div>
        </center>
        <br/>
        
        <div id="overlay" class="web_dialog_overlay"></div>

        <div id="dialog" class="web_dialog"></div>

        <!-- modal content -->
        <div id="basic-modal-content">
            <div id="appDealerDetails">
                <center>
                <table class="appDealerDetailsHeader" id="appDealerDetailsHeader" border="0" width="100%">
                    <tr>
                        <td align="center" colspan="2"><div class="reportheading" id="header">Applicant Dealer Details</div></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Application Year : </label></td>
                        <td class="secondcolumn"><label id="appYearDetails"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Region (Post Code) : </label></td>
                        <td class="secondcolumn"><label id="postcodeDetails"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Category : </label></td>
                        <td class="secondcolumn"><label id="dealerRole"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>National ID : </label></td>
                        <td class="secondcolumn"><label id="nationalId"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Name : </label></td>
                        <td class="secondcolumn"><label id="dealerName"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Father Name : </label></td>
                        <td class="secondcolumn"><label id="fatherName"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Mother Name : </label></td>
                        <td class="secondcolumn"><label id="motherName"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Present Address : </label></td>
                        <td class="secondcolumn"><address id="presentAddress"></address></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Permanent Address : </label></td>
                        <td class="secondcolumn"><address id="permanentAddress"></address></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Mobile No : </label></td>
                        <td class="secondcolumn"><label id="mobileNo"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Email : </label></td>
                        <td class="secondcolumn"><label id="emailNo"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Gender : </label></td>
                        <td class="secondcolumn"><label id="gender"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Bank Account No : </label></td>
                        <td class="secondcolumn"><label id="bankAccount"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Selection Status : </label></td>
                        <td class="secondcolumn"><label id="isSelected"></label></td>
                    </tr>
                    <tr>
                        <td align="center" colspan="2" style="padding-left: 16px;padding-top: 12px;"><input type="button" id="btnSubmitSelect" class="btn btn-primary btn-large" value="Select" /></td>
                    </tr>
                    
                </table>
                </center>
                
            </div>
        </div>
        
        
        <!-- pop-up modal content -->
        <div id="popup-modal-content">
            <div id="parentDealer">
                <center>
                    <table class="tblParentDealer" id="tblParentDealer" border="0" width="90%">
                        <tr>
                            <td align="center" colspan="2"><div class="reportheading" >Parent Dealer</div></td>
                        </tr>
                        <tr>
                            <td class="firstcolumn"><label>Parent Dealer Id : </label></td>
                            <td style="padding-left: 15px;">
                                <select id="cmbParentDealerId" class="cmbParentDealerId" style="width:200px;" tabindex="10"></select>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2" style="padding-left: 16px;padding-top: 12px;"><input type="button" id="btnSubmitSave" class="btn btn-primary btn-large" value="Save" /></td>
                        </tr>
                        
                    </table>
                </center>
            </div>
        </div>
        
        <!-- modal content -->
        <div id="dealerId-modal-content">
            <br/>
                <center>
                    <div>
                        <b>Dealer ID : </b> <span id="dealerId"></span>
                    </div>
                    <br/>
                    <div>
                        <span style="color: red">Collect this ID for future</span>
                    </div>
                </center>
            <br/>
        </div>
        <!-- pre-load the images -->
        <div style="display: none;">
            <img src='images/x.png' alt='' />
        </div>

    </body>
</html>
