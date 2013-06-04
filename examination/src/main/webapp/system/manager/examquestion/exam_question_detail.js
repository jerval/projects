$(function() {
			$("#back").click(function() {
						location.assign("exam_question_list.html");
					});
			getData();// 获取数据
		});
function getData() {
	$.ajax({
				type : "GET",
				url : "examinationQuestionEditAction!update" + location.search,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var examinationQuestion = data["examinationQuestion"];
					addData(examinationQuestion.id, examinationQuestion.version,
							examinationQuestion.strDateCreated, examinationQuestion.strDateUpdate,
							examinationQuestion.question_id, examinationQuestion.questionType,
							examinationQuestion.state, examinationQuestion.paper.paper_name,
							examinationQuestion.score, examinationQuestion.content);
				}
			});
}
function addData(id, version, dateCreated, dateUpdate, question_id, questionType,
		state, paper_name, score, content) {
	$("#id").val(id);
	$("#version").val(version);
	$("#dateCreated").val(dateCreated);
	$("#dateUpdate").val(dateUpdate==null?"未修改":dateUpdate);
	$("#question_id").val(question_id);
	$("#questionType").val(questionType);
	$("#state").val(state);
	$("#paper").val(paper_name);
	$("#score").val(score);
	$("#content").html(content);
}
