$(function() {
			$("#back").click(function() {
				location.assign("department_list");
					});
			getData();// 获取数据
		});
function getData() {
	$.ajax({
				type : "GET",
				url : "update" + location.search,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var department = data["department"];
					addData(department.id, department.version,
							department.strDateCreated, department.strDateUpdate,
							department.depart_id, department.depart_name,
							department.depart_info);
				}
			});
}
function addData(id, version, dateCreated, dateUpdate, depart_id, depart_name,
		depart_info) {
	$("#id").val(id);
	$("#version").val(version);
	$("#dateCreated").val(dateCreated);
	$("#dateUpdate").val(dateUpdate==null?"未修改":dateUpdate);
	$("#depart_id").val(depart_id);
	$("#depart_name").val(depart_name);
	$("#depart_info").html(depart_info);
}

