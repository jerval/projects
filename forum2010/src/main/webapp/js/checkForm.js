// JavaScript Document
// ������ʽ

	var reg_name=/^[\u4E00-\u9FA5\uF900-\uFA2D]+$/;
	var reg_email=/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	var reg_phone=/^\d{11}$/;
	var reg_cardID=/^([1-9]\d{14}|[1-9]\d{17}|[1-9]\d{16}[Xx])$/;
	var reg_date=/^\d{4}-(0[1-9]|[1-9]|1[0-2])-(0[1-9]|[1-9]|[1-2][0-9]|3[01])$/;
	var reg_address=/^(\w|[\u4E00-\u9FA5\uF900-\uFA2D])+$/;
	var reg_qq=/^[1-9]\d{4,10}$/;
	var reg_num=/^\d{1,20}$/;
	//Ч����
	function initTextFieldCheck(path,inputid,message,regexp){
		$("#"+inputid+"Tip").html("<img align='middle' src='"+path+"onShow.gif'/>"+message.def);
		$("#"+inputid).blur(function(){
			if(!regexp.test($(this).val())){
				$("#"+inputid+"Tip").html("<img align='middle' src='"+path+"onError.gif'/>"+message.err).removeClass("success").addClass("error");
			}else{
				$("#"+inputid+"Tip").html("<img align='middle' src='"+path+"onCorrect.gif'/>"+message.suc).removeClass("error").addClass("success");
			}
		});
	}
	
	function checkTextField(path,inputid,message,regexp){
		if(!regexp.test($("#"+inputid).val())){
			$("#"+inputid+"Tip").html("<img align='middle' src='"+path+"onError.gif'/>"+message.err).removeClass("success").addClass("error");
		    return false;
		}
		return true;
	}

