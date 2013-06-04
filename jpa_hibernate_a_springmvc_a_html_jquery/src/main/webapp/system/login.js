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
			$("#username").focus();
			$("#username").formValidator({
						onshow : "请输入用户名",
						onfocus : "正在输入用户名",
						oncorrect : "用户名输入合法"
					}).inputValidator({
						min : 4,
						max : 20,
						onerror : "用户名长度不正确"
					}).regexValidator({
						regexp : "username",
						datatype : "enum",
						onerror : "用户名格式不正确"
					});
			$("#password").formValidator({
						onshow : "请输入密码",
						onfocus : "正在输入密码",
						oncorrect : "密码输入合法"
					}).inputValidator({
						min : 4,
						max : 20,
						onerror : "密码长度不正确"
					}).regexValidator({
						regexp : "username",
						datatype : "enum",
						onerror : "密码格式不正确"
					});

			$("#login").click(function() {
						if ($.formValidator.pageIsValid('1')) {
							submitData();
						}
					});
		});

function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "loginAction",
				cache : false,
				data : formToArray,
				dataType : "json",
				async : false,
				success : function(data) {
					var message = data["message"];
					if (message.state) {
						location.assign(message.toURL);
					} else {
						giveMsg(message.state, "登录失败", message.msg);
					}
				}
			});
}
