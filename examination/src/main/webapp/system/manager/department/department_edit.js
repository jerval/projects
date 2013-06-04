$(function() {
			getData();// 获取数据
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
						onfocus : "部门名称由4-20字符组成",
						oncorrect : "部门名称输入合法"
					}).inputValidator({
						min : 4,
						max : 20,
						onerror : "部门名称长度不正确,请检查"
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
function getData() {
	$.ajax({
				type : "GET",
				url : "departmentEditAction!update" + location.search,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var department = data["department"];
					addData(department.id, department.version,
							department.depart_id, department.depart_name,
							department.depart_info);
				}
			});
}
function addData(id, version, depart_id, depart_name, depart_info) {
	$("#id").val(id);
	$("#version").val(version);
	$("#depart_id").val(depart_id);
	$("#depart_name").val(depart_name);
	$("#depart_info").html(depart_info);
}
function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "departmentSaveAction!editSave",
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
