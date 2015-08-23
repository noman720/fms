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
        <link type="text/css" rel="stylesheet" href="css/lib/jquery-ui.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/chosen.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/loader.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/jquery.dataTables.css" />
        <link type="text/css" rel="stylesheet" href="css/lib/modal.css" media="print, projection, screen"/>
        <link type="text/css" rel="stylesheet" href="css/custom/app/rootdealer/showdealerlist.css" />
        
        
        <script type="text/javascript" src="js/lib/jquery.js"></script>
        <script type="text/javascript" src="js/lib/jquery-ui.js"></script>
        <script type="text/javascript" src="js/lib/chosen.jquery.js" ></script>
        <script type="text/javascript" src="js/lib/jquery.simplemodal.js" ></script>
        <script type="text/javascript" src="js/custom/app/custom.js"></script>
        <script type="text/javascript" src="js/custom/app/rootdealer/dealerlist.js"></script>
        <script type="text/javascript" charset="utf8" src="js/lib/jquery.dataTables.js"></script>
        
        
        
    </head>
    <body>

        <center>
        <div id="dealerList" class="dealerList">
            
            <div>
                <span class="reportheading">Farmer List</span>
            </div>
            <br/>
            <hr/>   
            <br/>
            <div style="width: 90%">
            <table id="dealertable" class="dealertable">
                <thead>
                  <tr>
                      <th>Year</th>
                      <th>ID</th>
                      <th>National ID </th>
                      <th>Name</th>
                      <th>Mobile</th>
                      <th>Details</th>
                  </tr>
                </thead>
                <tbody>
                </tbody>
                <tfoot>
                    <tr>
                        <th align="center" colspan="6"><b>Total : </b> <span id="totalDealerValue"></span></th>
                    </tr>
                </tfoot>
            </table>
            </div>
            <br/><br/><br/>
            
            
        </div>
        
        </center>

        <br/><br/>
        
        <div id="overlay" class="web_dialog_overlay"></div>

        <div id="dialog" class="web_dialog"></div>

        
        <!-- modal content -->
        <div id="basic-modal-content">
            <div id="DealerDetails">
                <center>
                <table class="DealerDetailsTable" id="DealerDetailsTable" border="0" width="100%">
                    <tr>
                        <td align="center" colspan="2"><div class="reportheading" id="header">Dealer Details</div></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Application Year : </label></td>
                        <td class="secondcolumn"><label id="appYear"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Region (Post Code) : </label></td>
                        <td class="secondcolumn"><label id="postcode"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Dealer Role : </label></td>
                        <td class="secondcolumn"><label id="dealerRole"></label></td>
                    </tr>
                    <tr>
                        <td class="firstcolumn"><label>Dealer ID : </label></td>
                        <td class="secondcolumn"><label id="dealerId"></label></td>
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
                        <td class="firstcolumn"><label>Bank Account : </label></td>
                        <td class="secondcolumn"><label id="bankAccount"></label></td>
                    </tr>
                </table>
                </center>
                
            </div>
        </div>
               
        <!-- pre-load the images -->
        <div style="display: none;">
            <img src='images/x.png' alt='' />
        </div>
        
    </body>
</html>
