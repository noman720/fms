
    $(document).ready(function() {
        setComboBox();
        
    });



    function saveRecommendation()
    {
        if(!isValidRcommendationForm())
        {
            return;
        }
        showDialog();
        var recommendation = new Object();
        recommendation.postCode = $("#cmbPostCode").val().trim();
        recommendation.cropsName = $("#cmbCropsName").val().trim();
        recommendation.fertiName = $("#cmbFertiName").val().trim();
        recommendation.landAmount = $("#txtLandAmount").val().trim();
        recommendation.landUnit = $("#cmbLandUnit").val().trim();
        recommendation.fertiAmount = $("#txtFertiAmount").val().trim();
        recommendation.fertiUnit = $("#cmbFertiUnit").val().trim();
        
        var json = $.toJSON(recommendation);
        var value = "actionType=saveRecommendation&saveRecommendationJson="+json;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "recommendationservlet.do",
            dataType  : "json",
            success   :	function(res){
                            clearForm();
                            hideDialog();
                            showSuccessMessage('recommendation_success');
                        },
            error     :	function(err){
                            hideDialog();
                            showErrorMessage('recommendation_fail');
                        }       
        });
    }

    function isValidRcommendationForm()
    {
        
        var nationalId = $("#txtLandAmount").val().trim();
        if(nationalId.length === 0)
        {
            showErrorMessage('recommendation_landAmount_required');
            $("#txtLandAmount").focus();
            return false;
        }
        
        var dealerName = $("#txtFertiAmount").val().trim();
        if(dealerName.length === 0)
        {
            showErrorMessage('recommendation_fertiAmount_required');
            $("#txtFertiAmount").focus();
            return false;
        }
        
        return true;
        
    }
    
    function setComboBox()
    {
        var value = "actionType=getRecommendationToolbar";
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "recommendationservlet.do",
            dataType  : "json",
            success   :	function(response){
                setPostCodes(response);
                setCropsNames(response);
                setFertiNames(response);
                
                $("#cmbLandUnit").chosen({"disable_search": true});
                $("#cmbFertiUnit").chosen({"disable_search": true});
            }
            
        });
    }

    function setPostCodes(response)
    {
        var html = "";
        var  postCodes= response["postCodeList"];
        if( postCodes!== null && postCodes.length > 0)
        {
            for(var i=0;i<postCodes.length;i++)
            {
                html += "<option value=\""+postCodes[i]+"\">"+postCodes[i]+"</option>";
            }
        }

        $('#cmbPostCode').append(html);
        $("#cmbPostCode").chosen({"enable_search": true});
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
    
    function clearForm()
    {
        $('#txtFertiAmount').val("");
    }