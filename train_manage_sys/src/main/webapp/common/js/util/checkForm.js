// JavaScript Document

	var text_name=/^[\u4E00-\u9FA5\uF900-\uFA2D]+$/;
	var text_date=/^[12]\d{3}-(0[1-9]|[1-9]|1[0-2])-(0[1-9]|[1-9]|[1-2][0-9]|3[01])$/;
	var text_cardID=/^([1-9]\d{14}|[1-9]\d{17}|[1-9]\d{16}[Xx])$/;
	var text_phone=/^\d{11}$/;
	var text_email=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	var text_qq=/^[1-9]\d{4,10}$/;
	var text_password=/^\w{3,12}$/;
	var text_notNull=/^([\u4E00-\u9FA5\uF900-\uFA2D]|\w)+(.|\.)*$/;
	var text_number=/^[1-9]\d*$/;
		
   	function initTextCheck(inputId,message,regexp){
   		$("#"+inputId+"Tip").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message.def);
   		$("#"+inputId).blur(function(){
   			if($(this).val()==""){
   				$("#"+inputId+"Tip").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message.def).removeClass().addClass("show");
   			}else{
					if(!regexp.test($(this).val())){
	  					$("#"+inputId+"Tip").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message.err).removeClass().addClass("error");
	  				}else{
	   					$("#"+inputId+"Tip").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message.suc).removeClass().addClass("success");
	   				}
	   			}
   			});
   		$("#"+inputId).focus(function(){
   			$("#"+inputId+"Tip").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message.foc).removeClass().addClass("focus");
   		});
   	}

