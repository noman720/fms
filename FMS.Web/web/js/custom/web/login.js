
    $(document).ready(function(){
        $("#userId").focus();
        $("#cross-icon").click(function(){
            $("#error-message").hide();
        });
    });
    
    
    function isValidated()
    {
        alert('this is alert');
        var selectedRadio = $('input:radio[name=loginType]:checked').val();
        if(selectedRadio == null)
        {
            showErrorMessage('Please Select Login Type');
            return false;
        }
        
        var userId = $("#userId").val().trim();
        if(userId.length === 0)
        {
            showErrorMessage('Please Enter Login ID');
            $("#userId").focus();
            return false;
        }
    }

    