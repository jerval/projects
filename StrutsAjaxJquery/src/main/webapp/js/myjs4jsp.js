function jsp1() {
	$.ajax({
        type : "POST" ,
        url : "textResult!jsp1",
        //data : param ,
        cache : false ,
        dataType : "text",
        async : false ,
        success : function(data){
           // var txt = decodeURI(data);
            $("#jspresult").html(data);
           // close();
        }
    });
}