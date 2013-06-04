function textTest() {
   // var param = $("#textForm").serializeArray();
  //var param = [{name: 'username', value: 'Hello'},{name: 'password', value: 'World'}]  ;
  //var param = {"user.username": "aaaaaa", "user.password": "Hello"} ;
   var param = {"username": "aaaaaa", "password": "Hello"} ;
    $.ajax({
        type : "POST" ,
        url : "textResult!text",
        data : param ,
        cache : false ,
        dataType : "text",
        async : false ,
        success : function(data){
            var txt = decodeURI(data);
            $("#textresult").html(txt);
           // close();
        }
    });
}
