    
    $(document).ready(function() {
        $("#txtFertilizerId").focus();
    });
    
    $(window).load(function (){
        showFertilizerList();
     });
     
    function saveFertilizer()
    {
        if(!isValidFertilizerEntryForm())
        {
            return;
        }
        showDialog();
        var fertilizerEntry = new Object();
        fertilizerEntry.fertiId = $("#txtFertilizerId").val().trim();
        fertilizerEntry.fertiName = $("#txtFertilizerName").val().trim();
        fertilizerEntry.fertiDescription = $("#txtAreaDescription").val().trim();
        var json = $.toJSON(fertilizerEntry);
        var value = "actionType=saveFertilizer&saveFertilizerJson="+json;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "fertilizerservlet.do",
            dataType  : "json",
            success   :	function(response){
                            clearForm();
                            hideDialog();
                            showFertilizerList();
                            showSuccessMessage('ferti_success');
                            
                        },
            error     :	function(err){
                            hideDialog();
                            showErrorMessage('ferti_fail');
                        }       
        });
    }
    
    function clearForm()
    {
        
       $('input[type="text"]').val("");
       $("#txtAreaDescription").val("");
    }
    
    function isValidFertilizerEntryForm()
    {
        
        var fertiId = $("#txtFertilizerId").val().trim();
        if(fertiId.length === 0)
        {
            showErrorMessage('ferti_fertiId_required');
            $("#txtFertilizerId").focus();
            return false;
        }
        
        var fertiName = $("#txtFertilizerName").val().trim();
        if(fertiName.length === 0)
        {
            showErrorMessage('ferti_fertiName_required');
            $("#txtFertilizerName").focus();
            return false;
        }
        
        var description = $("#txtAreaDescription").val().trim();
        if(description.length === 0)
        {
            showErrorMessage('ferti_fertiDescription_required');
            $("#txtAreaDescription").focus();
            return false;
        }
        
        return true;
        
    }
    
function showFertilizerList()
{
    var value = "actionType=getFertilizerList";
    $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "fertilizerservlet.do",
            dataType  : "json",
            success   :	function(response){
                
                var rows = "";
                for(var i = 0; i<response.length; i++)
                {
                    var fertilizerBean = response[i];
                    var fertiId = fertilizerBean["fertiId"];
                    var fertiName = fertilizerBean["fertiName"];
                    var description = fertilizerBean["fertiDescription"];
                    rows += "<tr><td align=\"center\">"+fertiId+"</td><td align=\"left\">"+fertiName+"</td><td align=\"left\">"+description+"</td></tr>";
                }
                $("#fertilizerTable tbody").empty();
                $("#fertilizerTable tbody").append(rows);
                $("#totalFertilizerValue").text(response.length);
                $("#fertilizerEntry").show();
                $("#fertilizerTable").dataTable({
                    bJQueryUI:true,
                    bDestroy: true,
                    bRetrieve: true
                });
                
            }
    });
}