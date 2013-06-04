$(function() {
			$.formValidator.initConfig({
						formid : "form1",
						onerror : function(msg) {
							giveMsg(false, "数据验证出错", msg);
							return false;
						},
						onsuccess : function() {
							return true;
						}
					});
			$("#oldPassword").formValidator({
						onshow : "请输入旧密码",
						onfocus : "旧密码不能为空,且4-20位",
						oncorrect : "密码合法"
					}).inputValidator({
						min : 4,
						max : 20,
						empty : {
							leftempty : false,
							rightempty : false,
							emptyerror : "密码两边不能有空符号"
						},
						onerror : "密码不能为空,请确认"
					});
			$("#password").formValidator({
						onshow : "请输入新密码",
						onfocus : "新密码不能为空,且4-20位",
						oncorrect : "密码合法"
					}).inputValidator({
						min : 4,
						max : 20,
						empty : {
							leftempty : false,
							rightempty : false,
							emptyerror : "密码两边不能有空符号"
						},
						onerror : "密码不能为空,请确认"
					});
			$("#repassword").formValidator({
						onshow : "请输入重复密码",
						onfocus : "两次密码必须一致哦",
						oncorrect : "密码一致"
					}).inputValidator({
						min : 4,
						max : 20,
						empty : {
							leftempty : false,
							rightempty : false,
							emptyerror : "重复密码两边不能有空符号"
						},
						onerror : "重复密码不正确,请确认"
					}).compareValidator({
						desid : "password",
						operateor : "=",
						onerror : "2次密码不一致,请确认"
					});

			$("#save").click(function() {
						if ($.formValidator.pageIsValid('1')) {
							submitData();
						}
					});
			$("#reset").click(function() {
						document.getElementById("form1").reset();
					});
		});

function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "sysModifyPasswordAction",
				cache : false,
				data : formToArray,
				dataType : "json",
				async : false,
				success : function(data) {
					var message = data["message"];
					if (message.state) {
						giveMsg(message.state, "操作成功", message.msg);
						$('#dialog').dialog({
									close : function(event, ui) {
										$("#gotologin").submit();
									}
								});
					} else {
						giveMsg(message.state, "操作失败", message.msg);
					}
				}
			});
}
