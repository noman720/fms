    
    $(document).ready(function() {
        $("#txtCropsId").focus();
    });
    
    $(window).load(function (){
        showCropsList();
     });
     
    function saveCrops()
    {
        if(!isValidCropsEntryForm())
        {
            return;
        }
        showDialog();
        var cropsEntry = new Object();
        cropsEntry.cropsId = $("#txtCropsId").val().trim();
        cropsEntry.cropsName = $("#txtCropsName").val().trim();
        cropsEntry.cropsDescription = $("#txtAreaDescription").val().trim();
        var json = $.toJSON(cropsEntry);
        var value = "actionType=saveCrops&saveCropsJson="+json;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "cropsservlet.do",
            dataType  : "json",
            success   :	function(response){
                            clearForm();
                            hideDialog();
                            showCropsList();
                            showSuccessMessage('crops_success');
                            
                        },
            error     :	function(err){
                            hideDialog();
                            showErrorMessage('crops_fail');
                        }       
        });
    }
    
    function clearForm()
    {
        
       $('input[type="text"]').val("");
       $("#txtAreaDescription").val("");
    }
    
    function isValidCropsEntryForm()
    {
        
        var cropsId = $("#txtCropsId").val().trim();
        if(cropsId.length === 0)
        {
            showErrorMessage('crops_cropsId_required');
            $("#txtCropsId").focus();
            return false;
        }
        
        var cropsName = $("#txtCropsName").val().trim();
        if(cropsName.length === 0)
        {
            showErrorMessage('crops_cropsName_required');
            $("#txtCropsName").focus();
            return false;
        }
        
        var description = $("#txtAreaDescription").val().trim();
        if(description.length === 0)
        {
            showErrorMessage('crops_cropsDescription_required');
            $("#txtAreaDescription").focus();
            return false;
        }
        
        return true;
        
    }
    
function showCropsList()
{
    var value = "actionType=getCropsList";
    $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "cropsservlet.do",
            dataType  : "json",
            success   :	function(response){
                
                var rows = "";
                for(var i = 0; i<response.length; i++)
                {
                    var cropsBean = response[i];
                    var cropsId = cropsBean["cropsId"];
                    var cropsName = cropsBean["cropsName"];
                    var description = cropsBean["cropsDescription"];
                    rows += "<tr><td align=\"center\">"+cropsId+"</td><td align=\"left\">"+cropsName+"</td><td align=\"left\">"+description+"</td></tr>";
                }
                $("#cropsTable tbody").empty();
                $("#cropsTable tbody").append(rows);
                $("#totalCropsValue").text(response.length);
                $("#cropsEntry").show();
                $("#cropsTable").dataTable({
                    bJQueryUI:true,
                    bDestroy: true,
                    bRetrieve: true
                });
                
            }
    });
}