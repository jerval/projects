$(function() {
			$("#back").click(function() {
				location.assign("user_list");
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
					var user = data["user"];
					addData(user.id, user.version,
							user.dateCreated, user.dateUpdate,
							department.username, department.type);
				}
			});
}
function addData(id, version, dateCreated, dateUpdate, depart_id, depart_name,
		depart_info) {
	$("#id").val(id);
	$("#version").val(version);
	$("#dateCreated").val(dateCreated);
	$("#dateUpdate").val(dateUpdate==null?"未修改":dateUpdate);
	$("#username").val(username);
	$("#type").val(type);
}

