$(function() {
			getDepartments();// 从数据库中获取数据
			if (location.hash.toString() == "#update") {
				getData();// 获取数据
			}
			$("#refresh").click(function() {
						getDepartments();
					});

			$("#save").click(function() {
						submitData();
					});
			$("#reset").click(function() {
						document.getElementById("form1").reset();
					});
		});


function getData() {
	$.ajax({
				type : "GET",
				url : "update" + location.search,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var employee = data["employee"];
					addData(employee.id, employee.version, employee.emp_id,
							employee.emp_name, employee.gender,
							employee.department.id, employee.level,
							employee.strBirthday, employee.phone,
							employee.email, employee.address, employee.contact,
							employee.memo, employee.dep_manager);
				}
			});
}
function addData(id, version, emp_id, emp_name, gender, depart_id, level,
		birthday, phone, email, address, contact, memo, dep_manager) {
	$("#id").val(id);
	$("#version").val(version);
	$("#emp_id").val(emp_id);
	$("#emp_name").val(emp_name);
	$("input[name='gender']").each(function() {
				if ($(this).val() == gender) {
					$(this).attr("checked", "checked");
				};
			});
	$("option[name='d_id']").each(function() {
				if ($(this).val() == depart_id) {
					$(this).attr("selected", "selected");
				};
			});
	$("option[name='lev']").each(function() {
				if ($(this).val() == level) {
					$(this).attr("selected", "selected");
				};
			});
	$("#birthday").val(birthday);
	$("#phone").val(phone);
	$("#email").val(email);
	$("#address").val(address);
	$("#contact").val(contact);
	$("input[name='dep_manager']").each(function() {
				if ($(this).val() == dep_manager) {
					$(this).attr("checked", "checked");
				}
			});
	$("#memo").html(memo);
}
function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "save",
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
function getDepartments() {
	$.ajax({
		type : "POST",
		url : "findDeparts",
		cache : false,
		dataType : "json",
		async : false,
		success : function(data) {
			if (data["departments"]) {
				$("#depart_id").empty();
				$("#depart_id")
						.append("<option name='d_id' value=''>不限</option>");
				$.each(data["departments"], function(i, n) {
							$("#depart_id")
									.append("<option name='d_id' value='"
											+ n.id + "'>" + n.depart_name + "</option>");
						});
			}
		}
	});
}