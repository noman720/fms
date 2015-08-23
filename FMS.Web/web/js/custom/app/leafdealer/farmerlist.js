$(window).load(function (){
   showFarmerList();
    
});

function showFarmerList()
{
    showDialog();
    var value = "actionType=getFarmerList";
    $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "farmerservlet.do",
            dataType  : "json",
            success   :	function(response){
                
                var rows = "";
                //var dealerList = response["dealerList"];

                for(var i = 0; i<response.length; i++)
                {
                    var farmerBean = response[i];
                    var farmerId = farmerBean["farmerId"];
                    var nationalId = farmerBean["nationalId"];
                    var name = farmerBean["farmerName"];
                    var mobileNo = farmerBean["mobileNo"];
                    rows += "<tr><td align=\"left\">"+farmerId+"</td><td align=\"left\">"+nationalId+"</td><td align=\"center\">"+name+"</td><td align=\"center\">"+mobileNo+"</td><td align=\"center\"><a class=\"details\" onclick=\"showDetailsInPopup('"+farmerId+"')\">details</a></td></tr>";
                }
                $("#farmertable tbody").empty();
                $("#farmertable tbody").append(rows);
                $("#totalFarmerValue").text(response.length);
                $("#farmerList").show();
                $("#farmertable").dataTable({
                    bJQueryUI:true
                });
                /*$("#farmertable").dataTable({
                    bJQueryUI:true,
                    "aoColumnDefs": [
                                      { "bSortable": false, "aTargets": [ 0 ] }
                                    ]
                });*/
                hideDialog();
            }
    });
}

function showDetailsInPopup(farmerId)
    {
        showDialog();
        var value = "actionType=farmerDetails&farmerId="+farmerId;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "farmerservlet.do",
            dataType  : "json",
            success   :	function(response){
                clearDealerDetailsInPopup();
                
                $("#postcode").text(response["postCode"]);
                $("#farmerId").text(response["farmerId"]);
                $("#nationalId").text(response["nationalId"]);
                $("#farmerName").text(response["farmerName"]);
                $("#fatherName").text(response["fatherName"]);
                $("#motherName").text(response["motherName"]);
                $("#presentAddress").text(response["presentAddress"]);
                $("#permanentAddress").text(response["permanentAddress"]);
                $("#mobileNo").text(response["mobileNo"]);
                $("#emailNo").text(response["email"]);
                $("#gender").text(response["gender"]);                
                
                //showPopup();
                hideDialog();
                //$('#basic-modal-content').attr('src', $(this).attr("href"));
                $('#basic-modal-content').modal();
/*
                $('#basic-modal-content').modal({
                    persist: true,
                    onClose: function (dialog) {
                        dialog.container.fadeOut('slow', function () {
                            $.modal.close();
                        });
                    }
                });
                        */
                // TO DO for Table Sorter
                
            }
        });
    }

    function clearDealerDetailsInPopup()
    {
        $("#postcode").text("");
        $("#farmerId").text("");
        $("#nationalId").text("");
        $("#farmerName").text("");
        $("#fatherName").text("");
        $("#motherName").text("");
        $("#presentAddress").text("");
        $("#permanentAddress").text("");
        $("#mobileNo").text("");
        $("#emailNo").text("");
        $("#gender").text("");
        
    }
    
    
    
$('#basic-modal-content').dialog({
    autoOpen: false,
    title: "Customers",
    show: "blind",
    hide: "explode",
    modal: true,
    width: 500
});

$('#farmertable').dataTable({
    bJQueryUI: true
});

function showPopup() {
    var target = $(this);
    $('#basic-modal-content').dialog("open");
    $('#basic-modal-content').dialog("widget").position({
        my: 'left top',
        at: 'left bottom',
        of: target
    });
}