
    $(document).ready(function() {
        //showDialog();
        setComboBox();
        
               
        //$("#cmbFertiUnit").val("Liter");
        //$("#cmbDealerId").change(function(){
        //    getAllotedValue();
        //});
        
        $("#cmbSeasionYear").change(function(){
            getAllotedValue();
        });
        $("#cmbSeasionName").change(function(){
            getAllotedValue();
        });
        
        $("#cmbFertiName").change(function(){
            getAllotedValue();
        });
        
    });



    function saveTransaction()
    {
        if(!isValidTransactionForm())
        {
            return;
        }
        showDialog();
        //alert(fertiUnit);
        var saveDataObj = new Object();
        //saveDataObj.farmerId = $("#cmbDealerId").val().trim();
        saveDataObj.seasionYear = $("#cmbSeasionYear").val().trim();
        saveDataObj.seasionName = $("#cmbSeasionName").val().trim();
        //saveDataObj.cropsName = $("#cmbCropsName").val().trim();
        saveDataObj.fertiName = $("#cmbFertiName").val().trim();
        //saveDataObj.landAmount = $("#txtLandAmount").val().trim();
        //saveDataObj.landUnit = $("#cmbLandUnit").val().trim();
        saveDataObj.fertiAmount = $("#txtFertiNewTranAmount").val().trim();
        saveDataObj.fertiUnit = $("#cmbFertiUnitNewTran").val().trim();
        //alert(fertiUnit);
        var json = $.toJSON(saveDataObj);
        //alert(json.toString());
       
       var dealerId = $("#cmbDealerId").val().trim();
       
        var value = "actionType=saveTransactionForDealer&dealerId="+dealerId+"&saveTransactionForDealerJson="+json;
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

    function isValidTransactionForm()
    {
        
//        var landAmount = $("#txtLandAmount").val().trim();
//        if(landAmount.length === 0)
//        {
//            showErrorMessage('fertilizerapp_landAmount_required');
//            $("#txtLandAmount").focus();
//            return false;
//        }
        
        var fertiAmount = $("#txtFertiNewTranAmount").val().trim();
        if(fertiAmount.length === 0)
        {
            showErrorMessage('fertilizerapp_fertiAmount_required');
            $("#txtFertiNewTranAmount").focus();
            return false;
        }
        
        return true;
        
    }
    
    function setComboBox()
    {
        var value = "actionType=getTransactionToolbarForDealer";
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "fertilizerappservlet.do",
            dataType  : "json",
            success   :	function(response){
                
                setDealersId(response);
                setSeasionYears();
                setSeasionNames(response);
                //setCropsNames(response);
                setFertiNames(response);
                
                //$("#cmbLandUnit").chosen({"disable_search": true});
                $("#cmbFertiUnitTotal").chosen({"disable_search": true});
                $("#cmbFertiUnitTran").chosen({"disable_search": true});
                $("#cmbFertiUnitDue").chosen({"disable_search": true});
                $("#cmbFertiUnitNewTran").chosen({"disable_search": true});
            }
            
        });
    }

    function setDealersId(response)
    {
        var html = "";
        var  dealerId= response["dealerIdList"];
        if( dealerId!== null && dealerId.length > 0)
        {
            for(var i=0;i<dealerId.length;i++)
            {
                html += "<option value=\""+dealerId[i]+"\">"+dealerId[i]+"</option>";
            }
        }

        $('#cmbDealerId').append(html);
        $("#cmbDealerId").chosen({"enable_search": true});
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
        for(var i=-1; i<1; i++)
        {
            html += "<option value=\""+(year+i)+"\">"+(year+i)+"</option>";
        }
        $('#cmbSeasionYear').append(html);
        $("#cmbSeasionYear").chosen({"disable_search": true});
    }
    
    function clearForm()
    {
        $('#txtFertiTotalAmount').val("");
        $('#txtFertiTotalTranAmount').val("");
        $('#txtFertiDueAmount').val("");
        $('#txtFertiNewTranAmount').val("");
        
    }
    
    
    
    function getAllotedValue()
    {
        showDialog();
        if(!isValidComboBoxValues())
        {
            return;
        }
        //clearForm();
        
//        var postCode = $("#cmbDealerId").val().trim();
//        postCode = postCode.substr(0,4);
//        var cropsName = $("#cmbCropsName").val().trim();
        var dealerId = $("#cmbDealerId").val().trim();
        var seasionYear = $("#cmbSeasionYear").val().trim();
        var seasionName = $("#cmbSeasionName").val().trim();
        var fertiName = $("#cmbFertiName").val().trim();
        
        var value = "actionType=getAllotedValueForDealer&dealerId="+dealerId+"&seasionYear="+seasionYear+"&seasionName="+seasionName+"&fertiName="+fertiName;
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
                
                //set values in the txt feild
                $("#txtFertiTotalAmount").val(response.totalAllotedAmount);
                $("#txtFertiTotalTranAmount").val(response.totalTransactedAmount);
                $("#txtFertiDueAmount").val(response.totalAllotedAmount-response.totalTransactedAmount);
                $("#txtFertiNewTranAmount").val(0.00);
                 
                $("#txtFertiNewTranAmount").on('input', function(){
                    var input = this.value;
                    calculateValues(response, input);
                });
                //return response.fertiUnit;
           }
            
            
        });
    }
    
    function calculateValues(response, input)
    {
            var dueAmount = response.totalAllotedAmount-(response.totalTransactedAmount + parseFloat(input));
            $("#txtFertiDueAmount").val(dueAmount);
    }
    
    function isValidComboBoxValues()
    {
//        var farmerId = $("#cmbDealerId").val().trim();
//        if(farmerId.length === 0)
//        {
//            showErrorMessage('fertilizerapp_farmerid_required');
//            $("#cmbDealerId").focus();
//            return false;
//        }
        
        var cropsName = $("#cmbSeasionName").val().trim();
        if(cropsName.length === 0)
        {
            showErrorMessage('fertilizerapp_cropsname_required');
            $("#cmbSeasionName").focus();
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