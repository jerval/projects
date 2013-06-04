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
			$("#username").formValidator({
						onshow : "请输入用户名",
						onfocus : "用户名由4-20数字，字母，下划线组成",
						oncorrect : "用户名输入合法"
					}).inputValidator({
						min : 4,
						max : 20,
						onerror : "用户名长度不正确,请检查"
					}).regexValidator({
						regexp : "username",
						datatype : "enum",
						onerror : "用户名格式不正确"
					});
			$("#password").formValidator({
						onshow : "请输入密码",
						onfocus : "密码不能为空,且4-20位",
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
				url : "userSaveAction!addSave",
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
										location.assign(message.toURL);
									}
								});
					} else {
						giveMsg(message.state, "操作失败", message.msg);
					}
				}
			});
}
