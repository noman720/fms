$(window).load(function (){
   showTransactionReport();
    
});

function showTransactionReport()
{
    showDialog();
    var value = "actionType=getAuthorTransactionReport";
    $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "fertilizerappservlet.do",
            dataType  : "json",
            success   :	function(response){
                
                var rows = "";
                //var dealerList = response["dealerList"];

                for(var i = 0; i<response.length; i++)
                {
                    var fertilizerAppBean = response[i];
                    //var farmerId = fertilizerAppBean["farmerId"];
                    var year = fertilizerAppBean["seasionYear"];
                    var seasionName = fertilizerAppBean["seasionName"];
                    var landAmount = fertilizerAppBean["landAmount"]+" ("+fertilizerAppBean["landUnit"]+")";
                    var fertilizerName = fertilizerAppBean["fertiName"];
                    var fertilizerAmount = fertilizerAppBean["fertiAmount"]+" ("+fertilizerAppBean["fertiUnit"]+")";
                    rows += "<tr><td align=\"left\">"+year+"</td><td align=\"center\">"+seasionName+"</td><td align=\"center\">"+landAmount+"</td><td align=\"center\">"+fertilizerName+"</td><td align=\"center\">"+fertilizerAmount+"</td></tr>";
                }
                $("#reporttable tbody").empty();
                $("#reporttable tbody").append(rows);
                $("#totalFarmerValue").text(response.length);
                $("#allotmentreport").show();
                $("#reporttable").dataTable({
                    bJQueryUI:true
                });
                /*$("#reporttable").dataTable({
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

$('#reporttable').dataTable({
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