$(function() {
	if (location.hash.toString() == "#update") {
		getData();// 获取数据
	}

	$("#save").click(function() {
		submitData();
	});
	$("#reset").click(function() {
		document.getElementById("form1").reset();
	});
});
function getData() {
	$.ajax( {
		type : "GET",
		url : "update" + location.search,
		cache : false,
		dataType : "json",
		async : false,
		success : function(data) {
			var department = data["department"];
			addData(department.id, department.version, department.depart_id,
					department.depart_name, department.depart_info);
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
	$.ajax( {
		type : "POST",
		url : "save",
		cache : false,
		data : formToArray,
		dataType : "json",
		async : false,
		success : function(data) {
			var message = data["message"];
			if (message.state) {
				giveMsg(message.state, message.title, message.msg);
				$('#dialog').dialog( {
					close : function(event, ui) {
						location.assign(message.toURL);
					}
				});
			} else {
				giveMsg(message.state, message.title, message.msg);
			}
		}
	});
}
