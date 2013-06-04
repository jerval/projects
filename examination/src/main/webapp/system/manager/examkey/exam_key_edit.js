$(function() {
			getExamQuestions();// 从数据库中获取数据
			getData();// 获取数据
			$("#refresh").click(function() {
						getExamQuestions();
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

			$("#question_id").formValidator({
						onshow : "请选择所属试题",
						onfocus : "别选错哦！",
						oncorrect : "选择正确了"
					}).inputValidator({
						min : 1,
						onerror : "所属试题未选择!"
					});

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
				url : "examinationKeyEditAction!update" + location.search,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var examinationKey = data["examinationKey"];
					addData(examinationKey.id,
							examinationKey.version,
							examinationKey.question.id,
							examinationKey.content,
							examinationKey.correct,
							examinationKey.state);
				}
			});
}
function addData(id, version, question_id, content, correct, state) {
	$("#id").val(id);
	$("#version").val(version);
	$("option[name='d_id']").each(function() {
				if ($(this).val() == question_id) {
					$(this).attr("selected", "selected");
				};
			});
	$("input[name='correct']").each(function() {
				if ($(this).val() == correct) {
					$(this).attr("checked", "checked");
				};
			});
	$("input[name='state']").each(function() {
				if ($(this).val() == state) {
					$(this).attr("checked", "checked");
				};
			});
	$("#content").html(content);
}
function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "examinationKeySaveAction!editSave",
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
function getExamQuestions() {
	$.ajax({
		type : "POST",
		url : "examinationKeyListAction!getExamQuestions",
		cache : false,
		dataType : "json",
		async : false,
		success : function(data) {
			if (data["examinationQuestions"]) {
				$("#question_id").empty();
				$("#question_id")
						.append("<option name='d_id' value=''>不限</option>");
				$.each(data["examinationQuestions"], function(i, n) {
							$("#question_id")
									.append("<option name='d_id' value='"
											+ n[0] + "'>" + n[1] + "</option>");
						});
			}
		}
	});
}