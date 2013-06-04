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
		url : "update.do" + location.search,
		contentType : 'application/json',
		cache : false,
		dataType : "json",
		async : false,
		success : function(data) {
			var department = data;
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
	var formToJson = JSON.stringify($('#form1').serializeObject());
	$.ajax( {
		type : "POST",
		url : "save.do",
		contentType : 'application/json',
		cache : false,
		data : formToJson,
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.state) {
				giveMsg(data.state, data.title, data.msg);
				$('#dialog').dialog( {
					close : function(event, ui) {
						location.assign(data.toURL);
					}
				});
			} else {
				giveMsg(data.state, data.title, data.msg);
			}
		}
	});
}
