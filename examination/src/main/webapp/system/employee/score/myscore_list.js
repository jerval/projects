$(function() {
			listPage(1); // 从数据库中获取数据
			// 给组件加事件
		});
function getData() {
	var formToArray = $("#queryForm").serializeArray();
	$.ajax({
		type : "POST",
		url : "myScoreAction",
		cache : false,
		data : formToArray,
		dataType : "json",
		async : false,
		success : function(data) {
			var pagination = data["pagination"];
			$("#dataArea").empty();
			if (pagination["list"]) {
				$.each(pagination["list"], function(i, n) {
							addData(n.id, n.employee.emp_id, n.employee.emp_name, n.paper.paper_id,
									n.paper.paper_name, n.strDate,
									n.answerTime, n.score);
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

function addData(id, emp_id, emp_name, paper_id,
									paper_name, date,
									answerTime, score) {
	$("#dataArea")
			.append("<tr class='tr_s' onMouseOver='this.className=\"tr_o\"' onMouseOut='this.className=\"tr_s\"'>"
					+ "<td align='center'>"
					+ id
					+ "</td><td>"
					+ emp_id
					+ "</td><td >"
					+ emp_name
					+ "</td><td >"
					+ paper_id
					+ "</td><td >"
					+ paper_name
					+ "</td><td >"
					+ date
					+ "</td><td >"
					+ answerTime
					+ "</td><td >"
					+ score
					+ "</td></tr>");
}

function listPage(pageNo) {
	$("#pageNo").val(pageNo);// 设置表单中保存当前页码信息组件的值
	getData();
}
