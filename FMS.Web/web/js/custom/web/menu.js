
    $(document).ready(function(){
        $("#menu ul li").click(function(){
            var page = $(this).find('a').attr('name');
            if(page != null)
            {
                $('#mainpage').empty();
                $('#mainpage').load(page);
            }
        });
    });