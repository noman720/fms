$(window).load(function (){
    
   showDealerList();
    
});

function showDealerList()
{
    //alert('sdfsd');
    var value = "actionType=getDealerListByParentId";
    $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "dealerservlet.do",
            dataType  : "json",
            success   :	function(response){
                
                var rows = "";
                for(var i = 0; i<response.length; i++)
                {
                    var dealerBean = response[i];
                    var appYear = dealerBean["appYear"];
                    var dealerId = dealerBean["dealerId"];
                    var nationalId = dealerBean["nationalId"];
                    var name = dealerBean["dealerName"];
                    var mobileNo = dealerBean["mobileNo"];
                    rows += "<tr><td align=\"center\">"+appYear+"</td><td align=\"left\">"+dealerId+"</td><td align=\"left\">"+nationalId+"</td><td align=\"left\">"+name+"</td><td align=\"center\">"+mobileNo+"</td><td align=\"center\"><a class=\"details\" onclick=\"showDetailsInPopup('"+dealerId+"')\">details</a></td></tr>";
                }
                $("#dealertable tbody").empty();
                $("#dealertable tbody").append(rows);
                $("#totalDealerValue").text(response.length);
                $("#dealerList").show();
                $("#dealertable").dataTable({
                    bJQueryUI:true
                });
                
            }
    });
}

function showDetailsInPopup(dealerId)
    {
        //showDialog();
        var value = "actionType=dealerDetails&dealerId="+dealerId;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "dealerservlet.do",
            dataType  : "json",
            success   :	function(response){
                clearDealerDetailsInPopup();
                
                $("#appYear").text(response["appYear"]);
                $("#postcode").text(response["postCode"]);
                $("#dealerRole").text(response["dealerRole"]);
                $("#dealerId").text(response["dealerId"]);
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
                
                $('#basic-modal-content').modal();
                // TO DO for Table Sorter
                
            }
        });
    }

    function clearDealerDetailsInPopup()
    {
        $("#appYear").text("");
        $("#postcode").text("");
        $("#dealerRole").text("");
        $("#dealerId").text("");
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
    }
    
    
