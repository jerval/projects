$(function() {
			$("#info").hide();
			$("#info").ajaxStart(function() {
						$(this).show();
					});
			$("#info").ajaxStop(function() {
						$(this).hide();
					});
			$("#info").ajaxError(function(event, request, settings) {
						$(this).hide();
						giveMsg(false, "获取数据失败", "请检查数据库连接是否正常，如有问题请联系网络管理员！");
					});
			listPage(1); // 从数据库中获取数据
		});

function getData() {
	var formToArray = $("#queryForm").serializeArray();
	$.ajax({
		type : "POST",
		url : "myExamAction",
		cache : false,
		data : formToArray,
		dataType : "json",
		async : false,
		success : function(data) {
			var pagination = data["pagination"];
			$("#dataArea").empty();
			if (pagination["list"]) {
				$.each(pagination["list"], function(i, n) {
							addData(n.paper_id, n.paper_name, n.answerTime,
									n.info);
						});
			} else {
				$("#dataArea")
						.append("<tr height='40px'><td align='center' colspan='5'>暂无数据</td></tr>");
			}
			pageBar("pageBar1", pagination["pageNo"], pagination["maxPages"],
					pagination["maxElements"]);
			pageBar("pageBar2", pagination["pageNo"], pagination["maxPages"],
					pagination["maxElements"]);
			pageOperateBar("pageOperateBar1", pagination["pageNo"],
					pagination["maxPages"]);
			pageOperateBar("pageOperateBar2", pagination["pageNo"],
					pagination["maxPages"]);
		}
	});
}

function addData(paper_id, paper_name, answerTime, info) {
	$("#dataArea")
			.append("<tr class='tr_s' onMouseOver='this.className=\"tr_o\"' onMouseOut='this.className=\"tr_s\"'>"
					+ "<td align='center'>"
					+ paper_id
					+ "</td><td>"
					+ paper_name
					+ "</td><td >"
					+ answerTime
					+ "</td><td >"
					+ info
					+ "</td>"
					+ "<td align='center'><a href='#' style='font-size:12px;' width='80'height='20' onClick='getpaper("
					+ paper_id
					+ ")'><img src='../../../images/btn_edit.gif' alt='开始考试' width='20'height='20'>开始考试</a></tr>");
}
function getpaper(paper_id) {
	$("#paper_id").val(paper_id);
	$("#form1").submit();
}
function listPage(pageNo) {
	$("#pageNo").val(pageNo);// 设置表单中保存当前页码信息组件的值
	getData();
}
