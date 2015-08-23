    
    function getProject()
    {
        
        showDialog();
        var json = "{\"actionName\":\"project\"}";
        var value = "actionType=getProject&jsonData="+json;
        $.ajax({
            cache     : false,
            type      : "post",
            data      : value,
            url       : "projectsurlservlet.do",
            dataType  : "json",
            success   :	function(res){
                
                hideDialog();
            },
            error     :	function(err){
                
                hideDialog();
            }       
        });
    }

    
    
    