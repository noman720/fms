
    $(document).ready(function() {
        //showDialog();
        setComboBox();
        
               
        //$("#cmbFertiUnit").val("Liter");
        $("#cmbFarmerId").change(function(){
            getRecommendedValue();
        });
        
        $("#cmbCropsName").change(function(){
            getRecommendedValue();
        });
        
        $("#cmbFertiName").change(function(){
            getRecommendedValue();
        });
        
    });



    function saveFertilizerApplication()
    {
        if(!isValidFertiAppForm())
        {
            return;
        }
        showDialog();
        //alert(fertiUnit);
        var saveDataObj = new Object();
        saveDataObj.farmerId = $("#cmbFarmerId").val().trim();
        saveDataObj.seasionYear = $("#cmbSeasionYear").val().trim();
        saveDataObj.seasionName = $("#cmbSeasionName").val().trim();
        saveDataObj.cropsName = $("#cmbCropsName").val().trim();
        saveDataObj.fertiName = $("#cmbFertiName").val().trim();
        saveDataObj.landAmount = $("#txtLandAmount").val().trim();
        saveDataObj.landUnit = $("#cmbLandUnit").val().trim();
        saveDataObj.fertiAmount = $("#txtFertiAmount").val().trim();
        saveDataObj.fertiUnit = $("#cmbFertiUnit").val().trim();
        //alert(fertiUnit);
        var json = $.toJSON(saveDataObj);
        //alert(json.toString());
       
        var value = "actionType=saveFertilizerApp&saveFertilizerAppJson="+json;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "fertilizerappservlet.do",
            dataType  : "json",
            success   :	function(res){
                            clearForm();
                            hideDialog();
                            showSuccessMessage('fertilizerapp_success');
                        },
            error     :	function(err){
                            hideDialog();
                            showErrorMessage('fertilizerapp_fail');
                        }       
        });
    }

    function isValidFertiAppForm()
    {
        
        var landAmount = $("#txtLandAmount").val().trim();
        if(landAmount.length === 0)
        {
            showErrorMessage('fertilizerapp_landAmount_required');
            $("#txtLandAmount").focus();
            return false;
        }
        
        var fertiAmount = $("#txtFertiAmount").val().trim();
        if(fertiAmount.length === 0)
        {
            showErrorMessage('fertilizerapp_fertiAmount_required');
            $("#txtFertiAmount").focus();
            return false;
        }
        
        return true;
        
    }
    
    function setComboBox()
    {
        var value = "actionType=getFertilizerAppToolbar";
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "fertilizerappservlet.do",
            dataType  : "json",
            success   :	function(response){
                
                setFarmersId(response);
                setSeasionYears();
                setSeasionNames(response);
                setCropsNames(response);
                setFertiNames(response);
                
                $("#cmbLandUnit").chosen({"disable_search": true});
                $("#cmbFertiUnit").chosen({"disable_search": true});
            }
            
        });
    }

    function setFarmersId(response)
    {
        var html = "";
        var  farmersId= response["farmerIdList"];
        if( farmersId!== null && farmersId.length > 0)
        {
            for(var i=0;i<farmersId.length;i++)
            {
                html += "<option value=\""+farmersId[i]+"\">"+farmersId[i]+"</option>";
            }
        }

        $('#cmbFarmerId').append(html);
        $("#cmbFarmerId").chosen({"enable_search": true});
    }
    
    function setCropsNames(response)
    {
        var html = "";
        var  cropsNames= response["cropsNameList"];
        if( cropsNames!== null && cropsNames.length > 0)
        {
            for(var i=0;i<cropsNames.length;i++)
            {
                html += "<option value=\""+cropsNames[i]+"\">"+cropsNames[i]+"</option>";
            }
        }

        $('#cmbCropsName').append(html);
        $("#cmbCropsName").chosen({"enable_search": true});
    }
    
    function setFertiNames(response)
    {
        var html = "";
        var  fertiNames= response["fertiNameList"];
        if( fertiNames!== null && fertiNames.length > 0)
        {
            for(var i=0;i<fertiNames.length;i++)
            {
                html += "<option value=\""+fertiNames[i]+"\">"+fertiNames[i]+"</option>";
            }
        }

        $('#cmbFertiName').append(html);
        $("#cmbFertiName").chosen({"enable_search": true});
    }
    
    function setSeasionNames(response)
    {
        var html = "";
        var  seasionNames= response["seasionNameList"];
        if( seasionNames!== null && seasionNames.length > 0)
        {
            for(var i=0;i<seasionNames.length;i++)
            {
                html += "<option value=\""+seasionNames[i]+"\">"+seasionNames[i]+"</option>";
            }
        }

        $('#cmbSeasionName').append(html);
        $("#cmbSeasionName").chosen({"enable_search": true});
    }
    
    function setSeasionYears()
    {
        var html = "";
        var year = (new Date).getFullYear();
        for(var i=0; i<2; i++)
        {
            html += "<option value=\""+(year+i)+"\">"+(year+i)+"</option>";
        }
        $('#cmbSeasionYear').append(html);
        $("#cmbSeasionYear").chosen({"disable_search": true});
    }
    
    function clearForm()
    {
        $('#txtFertiAmount').val("");
        $('#txtLandAmount').val("");
        
    }
    
    
    
    function getRecommendedValue()
    {
        showDialog();
        if(!isValidComboBoxValues())
        {
            return;
        }
        //clearForm();
        
        var postCode = $("#cmbFarmerId").val().trim();
        postCode = postCode.substr(0,4);
        var cropsName = $("#cmbCropsName").val().trim();
        var fertiName = $("#cmbFertiName").val().trim();
        
        var value = "actionType=getRecommendedValue&postCode="+postCode+"&cropsName="+cropsName+"&fertiName="+fertiName;
        $.ajax({
            cache     : false,           
            type      : "post",
            data      : value,
            url       : "fertilizerappservlet.do",
            dataType  : "json",
            async     : false,
            success   :	function(response){
                 if(response === null)
                    {
                        hideDialog();
                        showErrorMessage('fertilizerapp_suggestion_required');
                        return;
                    }
                
                
                //var html = "";
                //html += "<option value=\""+response.fertiUnit+"\">"+response.fertiUnit+"</option>";
                //$("#cmbFertiUnit").empty();
                //$("#cmbFertiUnit").append(html);
                //$("#cmbFertiUnit").val($(this).val());
                
                
                
                 
                $("#txtLandAmount").on('input', function(){
                    var input = this.value;
                    calculateValues(response, input);
                });
                //return response.fertiUnit;
           }
            
            
        });
    }
    
    function calculateValues(response, input)
    {
            var fertiAmount = formatNumber((input * response.fertiAmount), 2);
            $("#txtFertiAmount").val(fertiAmount);
    }
    
    function isValidComboBoxValues()
    {
        var farmerId = $("#cmbFarmerId").val().trim();
        if(farmerId.length === 0)
        {
            showErrorMessage('fertilizerapp_farmerid_required');
            $("#cmbFarmerId").focus();
            return false;
        }
        
        var cropsName = $("#cmbCropsName").val().trim();
        if(cropsName.length === 0)
        {
            showErrorMessage('fertilizerapp_cropsname_required');
            $("#cmbCropsName").focus();
            return false;
        }
        
        var fertiName = $("#cmbFertiName").val().trim();
        if(fertiName.length === 0)
        {
            showErrorMessage('fertilizerapp_fertiname_required');
            $("#cmbFertiName").focus();
            return false;
        }
        
        return true;
    }