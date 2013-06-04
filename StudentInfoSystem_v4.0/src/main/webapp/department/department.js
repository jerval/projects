function add() {
	window.open("departmentAction!add", "aaaa", "width=400,height=400");
}

function update(id) {
	window.open("departmentAction!update?departmentId=" + id, "bbb", "width=400,height=400");
}

function del(id) {
	$.ajax( {
		type : "POST",
		url : "departmentAction!delete",
		cache : false,
		data : "departmentId=" + id,
		success : function(data) {
		alert("ok");
		}
	});
}