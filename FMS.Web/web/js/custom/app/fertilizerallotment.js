
    $(document).ready(function() {
        
        $('#fertilizerallotmentdatatable').dataTable({
                "sScrollY": 200,
		"bJQueryUI": true,
		"sPaginationType": "full_numbers"
        });
        getFertilizerAllotment();
       
        
    });

    function getFertilizerAllotment()
    {
        showDialog();
        var value = "actionType=makeFertilizerAllotmentToolbar";
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "farmerservlet.do",
            dataType  : "json",
            success   :	function(response){
                var html = getToolbar(response);
                $("#fertilizerAllotmentForm").empty();
                $("#fertilizerAllotmentForm").append(html);

                $("#farmer-select").chosen({"enable_search": true});
                $("#seasion-select").chosen({"enable_search": true});
                $("#year-select").chosen({"enable_search": true});
                $("#crops-select").chosen({"enable_search": true});
                $("#fertilizer-select").chosen({"enable_search": true});
                
                $("#btnAddToolbar").click(function(){
                    showData();
                });
                $("#btnCancelToolbar").click(function(){
                    //clearAttendanceReportClasswise();
                    //$("#attendancereportclasswise").hide();
                });
                
                $("#btnSave").click(function(){
                    saveData();
                });
                hideDialog();
            }
        });
    }


    function getToolbar(response)
    {
        var html = "";
        html += "<table class=\"fertilizerallotmenttoolbar\">";
        html += "<tr><td align=\"center\" colspan=\"3\"><div class=\"reportheading\">Fertilizer Allotment</div></td></tr>";
        html += "<tr><td><label>Farmer ID<span class=\"required\">*</span> : </label></td><td style=\"width: 20px;\">&nbsp;</td><td style=\"padding-left: 15px;\"><select style=\"width:210px;\" id=\"farmer-select\" tabindex=\"7\">";
        var farmers = response["farmers"];
        if(farmers != null && farmers.length > 0)
        {
            for(var i=0;i<farmers.length;i++)
            {
                html += "<option value=\""+farmers[i]+"\">"+farmers[i]+"</option>";
            }
        }
        html += "</select></td></tr>";
        
        html += "<tr><td><label>Year<span class=\"required\">*</span> : </label></td><td style=\"width: 20px;\">&nbsp;</td><td style=\"padding-left: 15px;\"><select style=\"width:210px;\" id=\"year-select\" tabindex=\"7\">";
        var year = (new Date).getFullYear();
        for(var i=0; i<2; i++)
        {
            html += "<option value=\""+(year+i)+"\">"+(year+i)+"</option>";
        }
        
        html += "</select></td></tr>";
        
        html += "<tr><td><label>Seasion Name<span class=\"required\">*</span> : </label></td><td style=\"width: 20px;\">&nbsp;</td><td style=\"padding-left: 15px;\"><select style=\"width:210px;\" id=\"seasion-select\" tabindex=\"7\">";
        var seasionName = response["seasions"];
        if(seasionName != null && seasionName.length > 0)
        {
            for(var i=0;i<seasionName.length;i++)
            {
                html += "<option value=\""+seasionName[i]+"\">"+seasionName[i]+"</option>";
            }
        }
        html += "</select></td></tr>";     
        
        html += "<tr><td><label>Crops<span class=\"required\">*</span> : </label></td><td style=\"width: 20px;\">&nbsp;</td><td style=\"padding-left: 15px;\"><select style=\"width:210px;\" id=\"crops-select\" tabindex=\"7\">";
        var crops = response["crops"];
        if(crops != null && crops.length > 0)
        {
            for(var i=0;i<crops.length;i++)
            {
                html += "<option value=\""+crops[i]+"\">"+crops[i]+"</option>";
            }
        }
        html += "</select></td></tr>";
        html += "<tr><td><label>Fertilizer<span class=\"required\">*</span> : </label></td><td style=\"width: 20px;\">&nbsp;</td><td style=\"padding-left: 15px;\"><select style=\"width:210px;\" id=\"fertilizer-select\" tabindex=\"7\">";
        var fertilizer = response["fertilizer"];
        if(fertilizer !== null && fertilizer.length > 0)
        {
            for(var j=0; j<fertilizer.length; j++)
            {
                html += "<option value=\""+fertilizer[j]+"\">"+fertilizer[j]+"</option>";
            }
        }
        
        html += "</select></td></tr>";
        html += "<tr><td><label>Land Amount<span class=\"required\">*</span> : </label></td><td style=\"width: 20px;\">&nbsp;</td><td><input type=\"text\" id=\"txtLandAmount\" value=\"\" class=\"amount\"/></td></tr>";
        html += "<tr><td><label>Fertilizer Amount<span class=\"required\">*</span> : </label></td><td style=\"width: 20px;\">&nbsp;</td><td><input type=\"text\" id=\"txtFertilizerAmount\" value=\"\" class=\"amount\"/></td></tr>";
        html += "<tr></tr><td/><tr><td align=\"center\" colspan=\"3\"><input type=\"button\" value=\"Add\" class=\"btn btn-primary  btn-large\" id=\"btnAddToolbar\"/>&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"Cancel\" class=\"btn btn-small\" id=\"btnCancelToolbar\"/></td></tr>";
        html += "</table>";
        html += "</br><hr>";
        html += prepareTableGrid();
        html += createButtons();
        return html;
    }
    
    
    function createTable()
    {
        var html = "";
        return html;
    }
    
    function prepareTableGrid()
    {
        var html = "<table id=\"fertilizerallotmentdatatable\" class=\"display\"><thead><tr><th class=\"farmerId\">Farmer ID</th><th class=\"seasionName\">Seasion Name</th><th class=\"cropsName\">Crops Name</th><th class=\"fertilizerName\">Fertilizer Name</th><th class=\"landAmount\">Land Amount</th><th class=\"fertilizerAmount\">Fertilizer Amount</th></tr></thead><tbody></tbody></table><br/></br><hr></br>";
        return html;
    }
    
    function createButtons()
    {
        var html = "<table><thead align=\"center\" colspan=\"2\"><input type=\"button\" value=\"Save\" class=\"btn btn-primary  btn-large\" id=\"btnSave\"/>&nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"Cancel\" class=\"btn btn-small\" id=\"btnCancel\"/></thead></table></br>";
        return html;
    }
    
    
    var fertilizerArray = new Array();
    
    function showData()
    {
        var userData = new Object();
        userData.farmerId = $("#farmer-select").val().trim();
        userData.seasionName = $("#seasion-select").val().trim();
        userData.cropsName = $("#crops-select").val().trim();
        userData.fertiName = $("#fertilizer-select").val().trim();
        userData.landAmount = $("#txtLandAmount").val().trim();
        userData.fertiAmount = $("#txtFertilizerAmount").val().trim();
        
        $('#fertilizerallotmentdatatable').dataTable().fnAddData( [
        userData.farmerId,
        userData.seasionName,
        userData.cropsName,
        userData.fertiName,
        userData.landAmount,
        userData.fertiAmount
    ] );
    
        fertilizerArray.push(userData);
        
                
    }
    
    function getFertilizerJson()
    {
        var jsonfy = $.toJSON(fertilizerArray);
        return jsonfy;
    }
    
    function saveData()
    {
        showDialog();
        var fertiJson = getFertilizerJson();
        fertiJson = encodeURIComponent(fertiJson);
        var value = "actionType=saveFertiAllotment&saveFertiAllotmentJson="+fertiJson;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "farmerservlet.do",
            dataType  : "json",
            success   :	function(res){
                            clearForm();
                            hideDialog();
                            showSuccessMessage('farmer_allotment_success');
                            
                        },
            error     :	function(err){
                            hideDialog();
                            showErrorMessage('farmer_allotment_fail');
                        }       
        });
    }
    
    
    
    function clearForm()
    {
        fertilizerArray = [];
        $('input[type="text"]').val("");
        $('#fertilizerallotmentdatatable').dataTable().fnClearTable();
    }