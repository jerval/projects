function json() {
    var param = $("#jsonForm").serializeArray();
    // var param = [{name: 'username', value: 'Hello'},{name: 'password', value: 'World'}]  ;
    $.ajax({
        type : "POST" ,
        url : "textResult!json",
        data : param ,
        cache : false ,
        dataType : "json",
        async : false ,
        success : function(data){
            if(data["data"]){
                   $.each(data["data"],function(i,item){
                       add(item.name,item.pass);
 	                 });
	               }
        // close();
        }
    });
}
function add(name,pass){
     $("#jsonresult").append("name:");
     $("#jsonresult").append(name);
     $("#jsonresult").append("    pass:");
     $("#jsonresult").append(pass);
}