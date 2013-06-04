$(function() {
			listPage(1); // 从数据库中获取数据
			// 给组件加事件
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

			$("input[name='add']").click(function() {
						location.assign("department_add.html");
					});

			$("input[name='update']").click(function() {
						var ids = new Array();
						$("input[name='id']").each(function() {
									if ($(this).attr("checked") == true) {
										ids[ids.length] = $(this).val();
									}
								});
						if (ids.length == 0) {
							giveMsg(false, "错误操作", "请选择一条您将要修改的数据！");
							return;
						}
						if (ids.length > 1) {
							giveMsg(false, "错误操作", "对不起，您选择了多条数据，每次只能修改一条数据！");
							return;
						}
						if (ids.length == 1) {
							location
									.assign("department_edit.html?id=" + ids[0]);
							return;
						}
					});
			$("input[name='detail']").click(function() {
						var ids = new Array();
						$("input[name='id']").each(function() {
									if ($(this).attr("checked") == true) {
										ids[ids.length] = $(this).val();
									}
								});
						if (ids.length == 0) {
							giveMsg(false, "错误操作", "请选择一条您将要查看的数据！");
							return;
						}
						if (ids.length > 1) {
							giveMsg(false, "错误操作", "对不起，您选择了多条数据，每次只能查看一条数据！");
							return;
						}
						if (ids.length == 1) {
							location.assign("department_detail.html?id="
									+ ids[0]);
							return;
						}
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
							var url = "departmentEditAction!delete?";
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
					$("#ids").removeAttr("checked");
					listPage(1);
					giveMsg(false, "恭喜，操作成功", message.msg);
				}
			});
}
function getData() {
	var formToArray = $("#queryForm").serializeArray();
	$.ajax({
		type : "POST",
		url : "departmentListAction",
		cache : false,
		data : formToArray,
		dataType : "json",
		async : false,
		success : function(data) {
			var pagination = data["pagination"];
			$("#dataArea").empty();
			if (pagination["list"]) {
				$.each(pagination["list"], function(i, n) {
							addData(n.id, n.depart_id, n.depart_name,
									n.depart_info);
						});
			} else {
				$("#dataArea")
						.append("<tr height='40px'><td align='center' colspan='4'>暂无数据</td></tr>");
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

function addData(id, depart_id, depart_name, depart_info) {
	$("#dataArea")
			.append("<tr class='tr_s' onMouseOver='this.className=\"tr_o\"' onMouseOut='this.className=\"tr_s\"'>"
					+ "<td align='center'><input type='checkbox' name='id' value='"
					+ id
					+ "'></td><td>"
					+ depart_id
					+ "</td><td >"
					+ depart_name + "</td><td >" + depart_info + "</td></tr>");
}

function listPage(pageNo) {
	$("#pageNo").val(pageNo);// 设置表单中保存当前页码信息组件的值
	getData();
}