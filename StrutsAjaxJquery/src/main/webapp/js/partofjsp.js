function jsp2() {
	$.ajax({
        type : "POST" ,
        url : "textResult!jsp2",
        //data : param ,
        cache : false ,
        dataType : "html",
        async : false ,
        success : function(data){
           // var txt = decodeURI(data);
            $("#jsppartresult").html(data);
           // close();
        }
    });
}