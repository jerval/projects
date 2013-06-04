$(function() {
	getDepartments();// 从数据库中获取数据
	getData();// 获取数据
	$("#refresh").click(function() {
				getDepartments();
			});
	$.formValidator.initConfig({
				formid : "form1",
				onerror : function(msg) {
					giveMsg(false, "数据验证出错", msg);
					return false;
				},
				onsuccess : function() {
					return true;
				}
			});
	$("#paper_id").formValidator({
				onshow : "请输入试卷编号",
				onfocus : "试卷编号由4-20数字，字母，下划线组成",
				oncorrect : "试卷编号输入合法"
			}).inputValidator({
				min : 4,
				max : 20,
				onerror : "输入的试卷编号长度不正确"
			}).regexValidator({
				regexp : "username",
				datatype : "enum",
				onerror : "试卷编号格式不正确"
			});
	$("#paper_name").formValidator({
				onshow : "请输入试卷名称",
				onfocus : "试卷名称由4-20字符组成",
				oncorrect : "试卷名称输入合法"
			}).inputValidator({
				min : 4,
				max : 20,
				onerror : "输入的试卷名称长度不正确"
			});
	$("#depart_id").formValidator({
				onshow : "请选择所属部门",
				onfocus : "别选错哦！",
				oncorrect : "选择正确了"
			}).inputValidator({
				min : 1,
				onerror : "所属部门未选择!"
			});

	$("#answerTime").formValidator({
				onshow : "请输入作答时间",
				onfocus : "作答时间为整数，分钟为单位",
				oncorrect : "输入正确"
			}).inputValidator({
				min : 1,
				max : 10,
				onerror : "好像太长了,请确认"
			}).regexValidator({
				regexp : "intege1",
				datatype : "enum",
				onerror : "输入的格式不正确"
			});;


	$("#save").click(function() {
				if ($.formValidator.pageIsValid('1')) {
					submitData();
				}
			});
	$("#reset").click(function() {
				document.getElementById("form1").reset();
			});
});

function getData() {
	$.ajax({
				type : "GET",
				url : "examinationPaperEditAction!update" + location.search,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var examinationPaper = data["examinationPaper"];
					addData(examinationPaper.id, examinationPaper.version,
							examinationPaper.paper_id, examinationPaper.paper_name,
							examinationPaper.department.id,
							examinationPaper.answerTime, examinationPaper.state, examinationPaper.info);
				}
			});
}
function addData(id, version, paper_id, paper_name,
		depart_id, answerTime, state, info) {
	$("#id").val(id);
	$("#version").val(version);
	$("#paper_id").val(paper_id);
	$("#paper_name").val(paper_name);
	$("option[name='d_id']").each(function() {
				if ($(this).val() == depart_id) {
					$(this).attr("selected", "selected");
				};
			});
	$("#answerTime").val(answerTime);
	$("input[name='state']").each(function() {
				if ($(this).val() == state) {
					$(this).attr("checked", "checked");
				};
			});
	$("#memo").html(info);
}
function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "examinationPaperSaveAction!editSave",
				cache : false,
				data : formToArray,
				dataType : "json",
				async : false,
				success : function(data) {
					var message = data["message"];
					if (message.state) {
						giveMsg(message.state, "操作成功", message.msg);
						$('#dialog').dialog({
									close : function(event, ui) {
										location.assign(message.toURL);
									}
								});
					} else {
						giveMsg(message.state, "操作失败", message.msg);
					}
				}
			});
}
function getDepartments() {
	$.ajax({
		type : "POST",
		url : "examinationPaperListAction!getDeparts",
		cache : false,
		dataType : "json",
		async : false,
		success : function(data) {
			if (data["departments"]) {
				$("#depart_id").empty();
				$("#depart_id")
						.append("<option name='d_id' value=''>不限</option>");
				$.each(data["departments"], function(i, n) {
							$("#depart_id")
									.append("<option name='d_id' value='"
											+ n[0] + "'>" + n[1] + "</option>");
						});
			}
		}
	});
}