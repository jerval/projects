$(function() {
			listPage(1); // 从数据库中获取数据
			// 给组件加事件
			$("#refresh").click(function() {
						getDepartments();
					});
			$("#ids").click(function() {
						var value = $(this).attr("checked");
						$("input[name='id']").each(function() {
									$(this).attr("checked", value);
								});
					});

			$("#query").click(function() {
						listPage(1)
					});

			$("#showAll").click(function() {
						document.getElementById("queryForm").reset();
						listPage(1)
					});

			$("input[name='delete']").click(function() {
						var ids = new Array();
						$("input[name='id']").each(function() {
									if ($(this).attr("checked") == true) {
										ids[ids.length] = $(this).val();
									}
								});
						if (ids.length == 0) {
							giveMsg(false, "错误操作", "请选择您将要删除的数据！");
							return;
						}
						if (confirm("您确定要删除这" + ids.length + "条数据吗？")) {
							var url = "examinationKeyEditAction!delete?";
							for (i = 0; i < ids.length; i++) {
								if (i == 0) {
									url += "ids=" + ids[i];
								} else {
									url += "&ids=" + ids[i];
								}
							}
							deleteData(url);
						}
					});

		});
function deleteData(url) {
	$.ajax({
				type : "GET",
				url : url,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var message = data["message"];
					giveMsg(false, "恭喜，操作成功", message.msg);
					listPage(1);
				}
			});
}
function getData() {
	var formToArray = $("#queryForm").serializeArray();
	$.ajax({
		type : "POST",
		url : "examinationKeyListAction",
		cache : false,
		data : formToArray,
		dataType : "json",
		async : false,
		success : function(data) {
			var pagination = data["pagination"];
			$("#dataArea").empty();
			if (pagination["list"]) {
				$.each(pagination["list"], function(i, n) {
							addData(n.id, n.emp_id, n.emp_name, n.gender,
									n.department.depart_name, n.level,
									n.dep_manager, n.strBirthday, n.phone,
									n.email);
						});
			} else {
				$("#dataArea")
						.append("<tr height='40px'><td align='center' colspan='10'>暂无数据</td></tr>");
			}
			pageBar("pageBar1",pagination["pageNo"], pagination["maxPages"],
					pagination["maxElements"]);
			pageBar("pageBar2",pagination["pageNo"], pagination["maxPages"],
					pagination["maxElements"]);
			pageOperateBar("pageOperateBar1",pagination["pageNo"], pagination["maxPages"]);
			pageOperateBar("pageOperateBar2",pagination["pageNo"], pagination["maxPages"]);
		}
	});
}

function addData(id, emp_id, emp_name, gender, depart_name, level,
		dep_manager, strBirthday, phone, email) {
	$("#dataArea")
			.append("<tr class='tr_s' onMouseOver='this.className=\"tr_o\"' onMouseOut='this.className=\"tr_s\"'>"
					+ "<td align='center'><input type='checkbox' name='id' value='"
					+ id
					+ "'></td><td>"
					+ emp_id
					+ "</td><td >"
					+ emp_name
					+ "</td><td >"
					+ gender
					+ "</td><td >"
					+ depart_name
					+ "</td><td >"
					+ level
					+ "</td><td >"
					+ (dep_manager == true ? "是" : "否")
					+ "</td><td >"
					+ strBirthday
					+ "</td><td >"
					+ phone
					+ "</td><td >"
					+ email
					+ "</td></tr>");
}

function listPage(pageNo) {
	$("#pageNo").val(pageNo);// 设置表单中保存当前页码信息组件的值
	getData();
}
