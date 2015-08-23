
    $(document).ready(function(){
        /*$('#newslist').mouseover(function() {
            $(this).find("li").each(function( index ) {
                $(this).addClass('newslistmouseover');
                console.log(index);
            });
        });*/
        $('#newslist').find("li").mouseover(function() {
            //console.log($(this).index());
            $(this).addClass('newslistmouseover');
        });

        $('#newslist').mouseout(function() {
            $(this).find("li").each(function( index ) {
                $(this).removeClass('newslistmouseover');
            });
        });

    });