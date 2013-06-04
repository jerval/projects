$(function() {
			$("#show1").click(function() {
						var pagesize1 = $("#pagesize1").val()
						if (!checkIsNum("pagesize1")) {
							$("#pagesize1").val("");
							return;
						}
						$("#pageSize").val(pagesize1);
						listPage(1);
						$("#pagesize1").val("");
					});
			$("#go1").click(function() {
						var page1 = $("#page1").val();
						if (!checkIsNum("page1")) {
							$("#page1").val("");
							return;
						}
						listPage(page1);
						$("#page1").val("");
					});
			$("#show2").click(function() {
						var pagesize2 = $("#pagesize2").val()
						if (!checkIsNum("pagesize2")) {
							$("#pagesize2").val("");
							return;
						}
						$("#pageSize").val(pagesize2);
						listPage(1)
						$("#pagesize2").val("");
					});
			$("#go2").click(function() {
						var page2 = $("#page2").val();
						if (!checkIsNum("page2")) {
							$("#page2").val("");
							return;
						}
						listPage(page2);
						$("#page2").val("");
					});
		});
function checkIsNum(inputid) {
	var reg_num = /^\d{1,10}$/;
	if (reg_num.test($("#" + inputid).val())) {
		return true;
	}
	return false;
}
function pageBar(componentId, pageNo, maxPages, maxElements) {
	$("#" + componentId).empty();
	$("#" + componentId).append("第" + pageNo + "页&nbsp;共" + maxPages
			+ "页&nbsp;总记录数：" + maxElements + "条");
}

function pageOperateBar(componentId, pageNo, maxPages) {
	$("#" + componentId).empty();
	if (pageNo > 1) {
		$("#" + componentId)
				.append("<a href='#' onClick='listPage(1)'>首页</a>&nbsp;<a href='#' onclick='listPage("
						+ (pageNo - 1) + ");'>上一页</a>&nbsp;");
	} else {
		$("#" + componentId).append("首页&nbsp;上一页&nbsp;");
	}
	if (pageNo < maxPages && pageNo > 0) {
		$("#" + componentId).append("<a href='#' onclick='listPage("
				+ (pageNo + 1)
				+ ");'>下一页</a>&nbsp;<a href='#' onclick='listPage(" + maxPages
				+ ")'>尾页</a>");
	} else {
		$("#" + componentId).append("下一页&nbsp;尾页");
	}
}
