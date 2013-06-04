$(function() {
			listPage(1); // 从数据库中获取数据
			getPeperInfo();
			$("#getresult").click(function() {
						if (confirm("您确定要交卷吗？交卷后将不能对试卷进行修改！")) {
							$("#form1").submit();
						}
					});
		});

function getData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
		type : "POST",
		url : "getExamAction",
		cache : false,
		data : formToArray,
		dataType : "json",
		async : false,
		success : function(data) {
			var pagination = data["pagination"];
			$("#dataArea").empty();
			if (pagination["list"]) {
				$.each(pagination["list"], function(i, n) {
							addData(n.question_id, n.content, n.questionType,
									n.score, n.keys);
						});
			} else {
				$("#dataArea")
						.append("<tr height='40px'><td align='center' colspan='2'>暂无数据</td></tr>");
			}
			if (data["selectKeys"]) {
				addKey(data["selectKeys"]);
			}
			pageBar("pageBar", pagination["pageNo"], pagination["maxPages"],
					pagination["maxElements"]);
			pageOperateBar("pageOperateBar", pagination["pageNo"],
					pagination["maxPages"]);
		}
	});
}

function addData(question_id, content, questionType, score, keys) {
	$("#dataArea")
			.append("<tr><td colspan='2' class='title-td'><input type='hidden' name='question_id' value='"
					+ +question_id
					+ "'/>"
					+ content
					+ "("
					+ questionType
					+ ")[" + score + "分]</td>");
	if (keys) {
		$.each(keys, function(i, n) {
			$("#dataArea")
					.append("<tr><td width='35' class='thin'><input type='checkbox' name='keys' value='"
							+ n.id
							+ "'></td>"
							+ " <td width='540' class='thin'>"
							+ n.content
							+ "</td></tr>");
		});
	}
	$("#dataArea").append("</tr>");
}
function addKey(keys) {
	$.each(keys, function(i, n) {
				$("input[name='keys']").each(function() {
							if ($(this).val() == n) {
								$(this).attr("checked", "checked");
							}
						});
			});
}
function pageBar(componentId, pageNo, maxPages, maxElements) {
	$("#" + componentId).empty();
	$("#" + componentId).append("第" + pageNo + "题&nbsp;共" + maxPages
			+ "题&nbsp;总记录数：" + maxElements + "题");
}

function pageOperateBar(componentId, pageNo, maxPages) {
	$("#" + componentId).empty();
	if (pageNo > 1) {
		$("#" + componentId)
				.append("<a href='#' onClick='listPage(1)'>首题</a>&nbsp;<a href='#' onclick='listPage("
						+ (pageNo - 1) + ");'>上一题</a>&nbsp;");
	} else {
		$("#" + componentId).append("首题&nbsp;上一题&nbsp;");
	}
	if (pageNo < maxPages && pageNo > 0) {
		$("#" + componentId).append("<a href='#' onclick='listPage("
				+ (pageNo + 1)
				+ ");'>下一题</a>&nbsp;<a href='#' onclick='listPage(" + maxPages
				+ ")'>尾题</a>");
	} else {
		$("#" + componentId).append("下一题&nbsp;尾题");
	}
}
function getPeperInfo() {
	$.ajax({
				type : "POST",
				url : "myExamAction!examInfo",
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var examPaper = data["examPaper"];
					if (examPaper) {
						$("#answerTime").html(examPaper.answerTime);
						timeBack(examPaper.answerTime);
					}
				}
			});
}

function timeBack(minute) {
	var m = minute;
	var s = 0;
	if (m < 10) {
		$("#minute").html("0" + m);
	} else {
		$("#minute").html(m);
	}
	if (s < 10) {
		$("#scond").html("0" + s);
	} else {
		$("#scond").html(s);
	}
	setInterval(function() {
				if (s == 0) {
					m--;
					s = 60;
				}
				s--;
				if (m < 10) {
					$("#minute").html("0" + m);
				} else {
					$("#minute").html(m);
				}
				if (s < 10) {
					$("#scond").html("0" + s);
				} else {
					$("#scond").html(s);
				}
				if (m == 0 && s == 0) {
					giveMsg(false, "答题时间到！", "对不起，答题时间已经到了，系统将自动提交您的试卷！");
					$('#dialog').dialog({
								close : function(event, ui) {
									$("#form1").submit();
								}
							});
				}
			}, 1000);
}
function listPage(pageNo) {
	$("#pageNo").val(pageNo);// 设置表单中保存当前页码信息组件的值
	getData();
}