
    $(document).ready(function() {
        getDealerSelectionToolbar();
        
    });

    function showDealerList()
    {
        showDialog();
        clearDealerList();
        var appYear = $("#appYear-select").val();
        var postCode = $("#postcode-select").val();
        var value = "actionType=applicantDealerListByPostCode&appYear="+appYear+"&postCode="+postCode;

        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "registrationservlet.do",
            dataType  : "json",
            success   :	function(response){
                $("#appYear").text(appYear);
                $("#postcode").text(postCode);
                var rows = "";
                var dealerList = response["dealerList"];

                for(var i = 0; i<dealerList.length; i++)
                {
                    var dealerBean = dealerList[i];
                    var dealerRole = dealerBean["dealerRole"];
                    var name = dealerBean["dealerName"];
                    var nationalId = dealerBean["nationalId"];
                    var mobileNo = dealerBean["mobileNo"];
                    var isSelected = dealerBean["isSelected"];
                    rows += "<tr><td align=\"left\">"+dealerRole+"</td><td align=\"left\">"+name+"</td><td align=\"center\">"+nationalId+"</td><td align=\"center\">"+mobileNo+"</td><td align=\"center\">"+isSelected+"</td><td align=\"center\"><a class=\"details\" onclick=\"showDetailsInPopup('"+appYear+"','"+nationalId+"')\">details</a></td></tr>";
                }
                $("#appDealerListSortable tbody").empty();
                $("#appDealerListSortable tbody").append(rows);
                $("#totalDealerValue").text(dealerList.length);
                $("#appDealerList").show();
                $("#appDealerListSortable").dataTable({
                    bJQueryUI:true,
                    bDestroy: true,
                    bRetrieve: true
                });
                hideDialog();
            }
        });
    }

    function clearDealerList()
    {
        $("#totalDealerValue").text("");
        $("#appDealerListSortable tbody").empty();    
    }

    function getDealerSelectionToolbar()
    {
        var value = "actionType=getPostCodes";
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "registrationservlet.do",
            dataType  : "json",
            success   :	function(response){
                var html = getToolbar(response);
                $("#dealerselectiontoolbar").empty();
                $("#dealerselectiontoolbar").append(html);
                $("#appYear-select").chosen({"disable_search": true});
                $("#postcode-select").chosen({"enable_search": true});
                $("#dealerselectiontoolbar").show();
                
                $("#btnSearchByAppYearAndPostCode").click(function(){
                    showDealerList();
                    //alert("hkhkj");
                });
                
                $("#btnCancel").click(function(){
                    clearDealerList();
                });
            }
            
        });
    }

    function getToolbar(response)
    {
        var html = "";
        html += "<table class=\"dealerselectiontoolbar\">";
        html += "<tr>";
        html += "<td><label>Application Year<span class=\"required\">*</span> : </label></td><td><select style=\"width:100px;\" id=\"appYear-select\" tabindex=\"7\">";
        var year = (new Date).getFullYear();
        for(var i=-1; i<2; i++)
        {
            html += "<option value=\""+(year+i)+"\">"+(year+i)+"</option>";
        }
        
        html+="</select></td><td></td><td><label>Region (Post Code)<span class=\"required\">*</span> : </label></td><td><select style=\"width:100px;\" id=\"postcode-select\" tabindex=\"7\">";
        var  postCodes= response["postCodeList"];
        if( postCodes!== null && postCodes.length > 0)
        {
            for(var i=0;i<postCodes.length;i++)
            {
                html += "<option value=\""+postCodes[i]+"\">"+postCodes[i]+"</option>";
            }
        }
        html+="</select></td><td></td>";
        html+="<td><input type=\"button\" value=\"Search\" class=\"btn btn-primary  btn-large\" id=\"btnSearchByAppYearAndPostCode\"/></td><td><input type=\"button\" value=\"Cancel\" class=\"btn\" id=\"btnCancel\"/></td>";
        html += "</tr>";
        html += "</table>";
        return html;
    }

    function showDetailsInPopup(appYear, nationalId)
    {
        showDialog();
        var value = "actionType=applicantDealerDetails&appYear="+appYear+"&nationalId="+nationalId;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "registrationservlet.do",
            dataType  : "json",
            success   :	function(response){
                clearDealerDetailsInPopup();
                $("#appYearDetails").text(response["appYear"]);
                $("#postcodeDetails").text(response["postCode"]);
                $("#dealerRole").text(response["dealerRole"]);
                $("#nationalId").text(response["nationalId"]);
                $("#dealerName").text(response["dealerName"]);
                $("#fatherName").text(response["fatherName"]);
                $("#motherName").text(response["motherName"]);
                $("#presentAddress").text(response["presentAddress"]);
                $("#permanentAddress").text(response["permanentAddress"]);
                $("#mobileNo").text(response["mobileNo"]);
                $("#emailNo").text(response["email"]);
                $("#gender").text(response["gender"]);
                $("#bankAccount").text(response["bankAccount"]);
                $("#isSelected").text(response["isSelected"]);
                
                hideDialog();
                $('#basic-modal-content').modal();
                // TO DO for Table Sorter
                
                $("#btnSubmitSelect").click(function(){
                    if(response["isSelected"] === "No")
                        {
                            showPopupModal(response);
                        }
                    else{
                            hideDialog();
                            showErrorMessage('dealer_registration_exists');
                            return;
                        }
                    
                });
                
            }
        });
    }

    function clearDealerDetailsInPopup()
    {
        $("#appYearDetails").text("");
        $("#postcodeDetails").text("");
        $("#dealerRole").text("");
        $("#nationalId").text("");
        $("#dealerName").text("");
        $("#fatherName").text("");
        $("#motherName").text("");
        $("#presentAddress").text("");
        $("#permanentAddress").text("");
        $("#mobileNo").text("");
        $("#emailNo").text("");
        $("#gender").text("");
        $("#bankAccount").text("");
        $("#isSelected").text("");
    }
    
    function showPopupModal(response)
    {
        $.modal.close();
        setCmbDealerIdList(response);
        $('#popup-modal-content').modal();
        $("#btnSubmitSave").click(function(){
            saveDealer(response);
            //alert("hkhkj");
        });
        
        //$.modal.close();
    }
    
    function setCmbDealerIdList(response)
    {

        var value = "actionType=getParentDealerIdList&dealerRole="+response["dealerRole"];
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "registrationservlet.do",
            dataType  : "json",
            success   :	function(response){
                
                var html = "";
                var  parentDealerIdList = response["parentDealerIdList"];
                if( parentDealerIdList !== null && parentDealerIdList.length > 0)
                {
                    for(var i=0; i<parentDealerIdList.length; i++)
                    {
                        html += "<option value=\""+parentDealerIdList[i]["dealerId"]+"\">"+parentDealerIdList[i]["dealerId"]+"</option>";
                    }
                }
                
                $('#cmbParentDealerId').append(html);
                $("#cmbParentDealerId").chosen({"enable_search": true});
            }
            
        });
    }
    
    
    function saveDealer(response)
    {
        var dealerRegistration = new Object();
        dealerRegistration.appYear = response["appYear"];
        dealerRegistration.postCode = response["postCode"];
        dealerRegistration.dealerRole = response["dealerRole"];
        dealerRegistration.parentId = $('#cmbParentDealerId').val().trim();
        dealerRegistration.nationalId = response["nationalId"];
        dealerRegistration.dealerName = response["dealerName"];
        dealerRegistration.fatherName = response["fatherName"];
        dealerRegistration.motherName = response["motherName"];
        dealerRegistration.presentAddress = response["presentAddress"];
        dealerRegistration.permanentAddress = response["permanentAddress"];
        dealerRegistration.mobileNo = response["mobileNo"];
        dealerRegistration.email = response["email"];
        dealerRegistration.gender = response["gender"];
        dealerRegistration.bankAccount = response["bankAccount"];
        
        $.modal.close();
        
        showDialog();
        
        var json = $.toJSON(dealerRegistration);
        var value = "actionType=saveDealer&saveDealerJson="+json;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "registrationservlet.do",
            dataType  : "json",
            success   :	function(res){
                            //clearForm();
                            hideDialog();
                            showSuccessMessage('dealer_registration_success');
                            showDealerList();
                            $("#dealerId").text(res.dealerId);
                            $('#dealerId-modal-content').modal();
                            
                        },
            error     :	function(err){
                            hideDialog();
                            showErrorMessage('dealer_registration_fail');
                        }       
        });
    }
    
    