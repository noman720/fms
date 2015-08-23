
    // Use to show Loader
    function showDialog()
    {
        $("#overlay").show();
        $("#dialog").html('<div id="circularG"><div id="circularG_1" class="circularG"></div><div id="circularG_2" class="circularG"></div><div id="circularG_3" class="circularG"></div><div id="circularG_4" class="circularG"></div><div id="circularG_5" class="circularG"></div><div id="circularG_6" class="circularG"></div><div id="circularG_7" class="circularG"></div><div id="circularG_8" class="circularG"></div></div>');
        $("#dialog").show();
    }

   // Use to hide Loader
   function hideDialog()
   {
       $("#overlay").hide();
       $("#dialog").hide();
       $("#dialog").empty();
   }

   function formatNumber(num,decimalpoint)
   {
       num = new Number(num).toFixed(decimalpoint);
       num = num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
       return num;
   }
   
    function showErrorMessage(id)
    {
        jQuery.i18n.properties({
            name:'Validation',
            path:'bundle/',
            mode:'both',
            language:'en',
            callback: function(){
                var txtMessage = jQuery.i18n.prop(id);
                showNotification({
                    message: txtMessage,
                    type: "error",
                    autoClose: true,
                    duration: 3
                });
            }
        });
    }
    
    function showSuccessMessage(id)
    {
        jQuery.i18n.properties({
            name:'Validation',
            path:'bundle/',
            mode:'both',
            language:'en',
            callback: function(){
                var txtMessage = jQuery.i18n.prop(id);
                showNotification({
                    message: txtMessage,
                    type: "success",
                    autoClose: true,
                    duration: 3
                });
            }
        });
    }