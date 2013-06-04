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
			var user = data["user"];
			addData(user.id, user.version, user.username,
					user.type);
		}
	});
}
function addData(id, version, username, type) {
	$("#id").val(id);
	$("#version").val(version);
	$("#username").val(username);
	$("#type").val(type);
	$("option[name='lev']").each(function() {
				if ($(this).val() == level) {
					$(this).attr("selected", "selected");
				};
			});
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
