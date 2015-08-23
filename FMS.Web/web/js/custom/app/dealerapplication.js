    
    $(document).ready(function() {
        setComboBox();
        $("#cmbAppYear").focus();
        
        
    });
    
    function saveDealerApplication()
    {
        if(!isValidDealerApplicationForm())
        {
            return;
        }
        showDialog();
        var dealerRegistration = new Object();
        //stdTransaction.transactionDate = $("#txtTrnDate").val().trim();
        dealerRegistration.appYear = $("#cmbAppYear").val().trim();
        dealerRegistration.postCode = $("#cmbPostCode").val().trim();
        dealerRegistration.dealerRole = $("#cmbDealerRole").val().trim();
        dealerRegistration.nationalId = $("#txtNationalId").val().trim();
        dealerRegistration.dealerName = $("#txtDealerName").val().trim();
        dealerRegistration.fatherName = $("#txtFatherName").val().trim();
        dealerRegistration.motherName = $("#txtMotherName").val().trim();
        dealerRegistration.presentAddress = $("#txtPresentAddress").val().trim();
        dealerRegistration.permanentAddress = $("#txtPermanentAddress").val().trim();
        dealerRegistration.mobileNo = $("#txtMobileNo").val().trim();
        dealerRegistration.email = $("#txtEmail").val().trim();
        dealerRegistration.gender = $('input:radio[name=type]:checked').val().trim();
        dealerRegistration.bankAccount = $("#txtBankAccount").val().trim();
        
        var json = $.toJSON(dealerRegistration);
        var value = "actionType=saveDealerApp&saveDealerAppJson="+json;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "registrationservlet.do",
            dataType  : "json",
            success   :	function(res){
                            clearForm();
                            hideDialog();
                            showSuccessMessage('dealer_application_success');
                            
                        },
            error     :	function(err){
                            hideDialog();
                            showErrorMessage('dealer_registration_fail');
                        }       
        });
    }
    
    
    
    function clearForm()
    {
        
       $('input[type="text"]').val("");
       $("#txtPresentAddress").val("");
       $("#txtPermanentAddress").val("");
       $("input:radio").attr("checked", false);
    }
    
    function isValidDealerApplicationForm()
    {     
        var nationalId = $("#txtNationalId").val().trim();
        if(nationalId.length === 0)
        {
            showErrorMessage('dealer_registration_national_id_required');
            $("#txtNationalId").focus();
            return false;
        }
        
        var dealerName = $("#txtDealerName").val().trim();
        if(dealerName.length === 0)
        {
            showErrorMessage('dealer_registration_dealer_name_required');
            $("#txtDealerName").focus();
            return false;
        }
        
        return isValidCommonForm();
        
    }
    
    
    function isValidCommonForm(){
        
        var fatherName = $("#txtFatherName").val().trim();
        if(fatherName.length === 0)
        {
            showErrorMessage('dealer_registration_father_name_required');
            $("#txtFatherName").focus();
            return false;
        }
        
        var motherName = $("#txtMotherName").val().trim();
        if(motherName.length === 0)
        {
            showErrorMessage('dealer_registration_mother_name_required');
            $("#txtMotherName").focus();
            return false;
        }
        
        var presentAddress = $("#txtPresentAddress").val().trim();
        if(presentAddress.length === 0)
        {
            showErrorMessage('dealer_registration_present_address_required');
            $("#txtPresentAddress").focus();
            return false;
        }
        
        var permanentAddress = $("#txtPermanentAddress").val().trim();
        if(permanentAddress.length === 0)
        {
            showErrorMessage('dealer_registration_permanent_address_required');
            $("#txtPermanentAddress").focus();
            return false;
        }
        
        var mobileNo = $("#txtMobileNo").val().trim();
        if(mobileNo.length === 0)
        {
            showErrorMessage('dealer_registration_mobile_no_required');
            $("#txtMobileNo").focus();
            return false;
        }
        
        var selectedRadio = $('input:radio[name=type]:checked').val();
        if(selectedRadio == null)
        {
            showErrorMessage('dealer_registration_select_gender_required');
            return false;
        }
       
        var bankAccount = $("#txtBankAccount").val().trim();
        if(bankAccount.length === 0)
        {
            showErrorMessage('dealer_registration_bankaccount_required');
            $("#txtBankAccount").focus();
            return false;
        }
       
        return true;
    }
  
  
    
    function calculateDues()
    {
        var payable = $("#txtPayableAmount").val();
        var paid = $("#txtPaidAmount").val();
        var dues = payable - paid;
        dues = formatNumber(dues, 2);
        $("#txtDueAmount").val(dues);
    }
    
    
    function setComboBox()
    {
        var value = "actionType=getPostCodes";
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "registrationservlet.do",
            dataType  : "json",
            success   :	function(response){
                
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
                
                html="";
                var year = (new Date).getFullYear();
                for(var i=0; i<2; i++)
                {
                    html += "<option value=\""+(year+i)+"\">"+(year+i)+"</option>";
                }
                $('#cmbAppYear').append(html);
                $("#cmbAppYear").chosen({"disable_search": true});
                $("#cmbDealerRole").chosen({"disable_search": true});
            }
            
        });
    }