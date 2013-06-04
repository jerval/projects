$(function() {
			$("#back").click(function() {
						location.assign("exam_key_list.html");
					});
			getData();// 获取数据
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
					addData(examinationKey.id, examinationKey.version,
							examinationKey.strDateCreated, examinationKey.strDateUpdate,
							examinationKey.question.id,
							examinationKey.content,
							examinationKey.correct,
							examinationKey.state);
				}
			});
}
function addData(id, version, dateCreated, dateUpdate, question_id, content, correct, state) {
	$("#id").val(id);
	$("#version").val(version);
	$("#dateCreated").val(dateCreated);
	$("#dateUpdate").val(dateUpdate==null?"未修改":dateUpdate);
	$("#question_id").val(question_id);
	$("#correct").val(correct);
	$("#state").val(state);
	$("#content").html(content);
}
