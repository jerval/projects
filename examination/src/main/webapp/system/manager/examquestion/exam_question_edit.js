$(function() {
			getPapers();// 从数据库中获取数据
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
			$("#question_id").formValidator({
						onshow : "请输入试题编号",
						onfocus : "试题编号由4-20数字，字母，下划线组成",
						oncorrect : "试题编号输入合法"
					}).inputValidator({
						min : 4,
						max : 20,
						onerror : "输入的试题编号长度不正确"
					}).regexValidator({
						regexp : "username",
						datatype : "enum",
						onerror : "试题编号格式不正确"
					});
			$("#paper_id").formValidator({
						onshow : "请选择所属试卷",
						onfocus : "别选错哦！",
						oncorrect : "选择正确了"
					}).inputValidator({
						min : 1,
						onerror : "所属试卷未选择!"
					});

			$("#score").formValidator({
						onshow : "请输入所占分数",
						onfocus : "所占分数为正整数",
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

function checkPassword() {
	$("#password").formValidator({
				onshow : "请输入密码",
				onfocus : "密码不能为空,且4-20位",
				oncorrect : "密码合法"
			}).inputValidator({
				min : 4,
				max : 20,
				empty : {
					leftempty : false,
					rightempty : false,
					emptyerror : "密码两边不能有空符号"
				},
				onerror : "密码不能为空,请确认"
			});
	$("#repassword").formValidator({
				onshow : "请输入重复密码",
				onfocus : "两次密码必须一致哦",
				oncorrect : "密码一致"
			}).inputValidator({
				min : 4,
				max : 20,
				empty : {
					leftempty : false,
					rightempty : false,
					emptyerror : "重复密码两边不能有空符号"
				},
				onerror : "重复密码不正确,请确认"
			}).compareValidator({
				desid : "password",
				operateor : "=",
				onerror : "2次密码不一致,请确认"
			});
}
function getData() {
	$.ajax({
				type : "GET",
				url : "examinationQuestionEditAction!update" + location.search,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var examinationQuestion = data["examinationQuestion"];
					addData(examinationQuestion.id,
							examinationQuestion.version,
							examinationQuestion.question_id,
							examinationQuestion.paper.id,
							examinationQuestion.state,
							examinationQuestion.questionType,
							examinationQuestion.score,
							examinationQuestion.content);
				}
			});
}
function addData(id, version, question_id, paper_id, state, questionType,
		score, content) {
	$("#id").val(id);
	$("#version").val(version);
	$("#question_id").val(question_id);
	$("input[name='state']").each(function() {
				if ($(this).val() == state) {
					$(this).attr("checked", "checked");
				};
			});
	$("input[name='questionType']").each(function() {
				if ($(this).val() == questionType) {
					$(this).attr("checked", "checked");
				};
			});
	$("option[name='d_id']").each(function() {
				if ($(this).val() == paper_id) {
					$(this).attr("selected", "selected");
				};
			});
	$("#score").val(score);
	$("#content").html(content);
}
function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "examinationQuestionSaveAction!editSave",
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
function getPapers() {
	$.ajax({
				type : "POST",
				url : "examinationQuestionListAction!getExamPapers",
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					if (data["examinationPapers"]) {
						$("#paper_id").empty();
						$("#paper_id")
								.append("<option name='d_id' value=''>不限</option>");
						$.each(data["examinationPapers"], function(i, n) {
									$("#paper_id")
											.append("<option name='d_id' value='"
													+ n[0]
													+ "'>"
													+ n[1]
													+ "</option>");
								});
					}
				}
			});
}