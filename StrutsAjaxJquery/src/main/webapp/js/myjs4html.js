function html() {
	$.ajax({
        type : "POST" ,
        url : "textResult!html1",
        //data : param ,
        cache : false ,
        dataType : "text",
        async : false ,
        success : function(data){
           // var txt = decodeURI(data);
            $("#htmlresult").html(data);
           // close();
        }
    });
}