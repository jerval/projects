$(function() {
			$.formValidator.initConfig({
						formid : "form1",
						onerror : function(msg) {
							giveMsg(false, "数据验证出错", msg)
							return false;
						},
						onsuccess : function() {
							return true;
						}
					});
			getExamQuestions();// 从数据库中获取数据
			$("#refresh").click(function() {
						getExamQuestions();
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

function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "examinationKeySaveAction!addSave",
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
								.append("<option value=''>请选择所属试题</option>");
						$.each(data["examinationQuestions"], function(i, n) {
									$("#question_id").append("<option value='"
											+ n[0] + "'>" + n[1] + "</option>");
								});
					}
				}
			});
}