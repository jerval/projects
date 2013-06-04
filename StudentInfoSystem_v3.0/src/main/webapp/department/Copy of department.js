$().ready(function(){
   getArea();
   
   $("#insertButton").click(function(){
							var index = $("#areaId").val();
							newbuilding(index);
							
							});
});

function getArea(){
    $.ajax({
        type:"POST",
        url : "areaUse.action",
        cache: false,
        dataType : "json" ,
        async : false ,
        success : function(data){ 
               if(data["areas"]){
                   $.each(data["areas"],function(i,n){
                     addBody(n.id,n.company.companyName,n.dormitoryareaName);
 	                 });
 	                bindColor();
	               }
	               }             
     }); 
}

function addBody(id,companyName,dormitoryareaName){
  $("#areaData").append("<tr class='tabletrcontent' onClick='areaClick("+id+")'>"+
               "<td height='30'>"+companyName+"</td>"+
               "<td >"+dormitoryareaName+"</td></tr>");
  
}


 function bindColor(){    
         $("#areaData tr").hover(function(){
             $(this).removeClass("tabletrcontent");
             $(this).addClass("hover");
        },function(){
             $(this).removeClass("hover");
             $(this).addClass("tabletrcontent");
         });   
 
 
        $("#dataWindow tr").hover(function(){
             $(this).removeClass("tabletrcontent");
             $(this).addClass("hover");
        },function(){
             $(this).removeClass("hover");
             $(this).addClass("tabletrcontent");
         });          
    }

function areaClick(index){
	
  $("#areaId").val(index);	
	
 $("#dataWindow").empty();
 $.ajax({
        type:"POST",
        url : "buildingData.action",
        cache: false,
        data : "areaId="+index,
        dataType : "json" ,
        async : false ,
        success : function(data){ 
               if(data["buildings"]){
                   $.each(data["buildings"],function(i,n){
                     addbuilding(n.id,n.dormitoryarea.company.companyName,n.dormitoryarea.dormitoryareaName,n.dormitoryName,n.deleted,n.dormitoryId,n.memo);
 	                 });
 	                bindColor();
	               }
	               }             
     }); 
}


function addbuilding(id,companyName,dormitoryareaName,dormitoryName,deleted,dormitoryId,memo){
      $("#dataWindow").append("<tr class='tabletrcontent'>"+
               "<td height='30'>"+companyName+"</td>"+
               "<td >"+dormitoryareaName+"</td>"+
               "<td >"+dormitoryId+"</td>"+			   
               "<td >"+dormitoryName+"</td>"+
               "<td >"+memo+"</td>"+
               "<td >"+(deleted?"不可用":"可用")+"</td>"+
               "<td ><s:if test='isUpdate'><a href='#' onClick='editbuilding("+id+")'><img src='../img/edit.gif' width='15' height='15'></a></s:if></td>"+
               "</tr>");
}

function newbuilding(index){
	 window.open("addbuilding.action?areaId="+index,"","width=400,height=400");
}

function editbuilding(index){
	window.open("editbuilding.action?id="+index,"","width=400,height=400");	
}