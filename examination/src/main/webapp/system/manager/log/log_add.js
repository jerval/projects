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
			$("#depart_id").formValidator({
						onshow : "请输入部门编号",
						onfocus : "部门编号由4-20数字，字母，下划线组成",
						oncorrect : "部门编号输入合法"
					}).inputValidator({
						min : 4,
						max : 20,
						onerror : "部门编号长度不正确,请检查"
					}).regexValidator({
						regexp : "username",
						datatype : "enum",
						onerror : "部门编号格式不正确"
					});
			$("#depart_name").formValidator({
						onshow : "请输入部门名称",
						onfocus : "部门名称由2-10中文组成",
						oncorrect : "部门名称输入合法"
					}).inputValidator({
						min : 4,
						max : 20,
						onerror : "部门名称长度不正确,请检查"
					}).regexValidator({
						regexp : "chinese",
						datatype : "enum",
						onerror : "部门名称格式不正确"
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
				url : "departmentSaveAction!addSave",
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
