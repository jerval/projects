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
			getPapers();// 从数据库中获取数据
			$("#refresh").click(function() {
						getPapers();
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

function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "examinationQuestionSaveAction!addSave",
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
								.append("<option value=''>请选择部门</option>");
						$.each(data["examinationPapers"], function(i, n) {
									$("#paper_id").append("<option value='"
											+ n[0] + "'>" + n[1] + "</option>");
								});
					}
				}
			});
}