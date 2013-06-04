$(function() {
			$("#back").click(function() {
						location.assign("exam_paper_list.html");
					});
			getData();// 获取数据
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
							examinationPaper.strDateCreated, examinationPaper.strDateUpdate,
							examinationPaper.paper_id, examinationPaper.paper_name,
							examinationPaper.department.depart_name,
							examinationPaper.answerTime, examinationPaper.state, examinationPaper.info);
				}
			});
}
function addData(id, version, dateCreated, dateUpdate, paper_id, paper_name,
		depart_name, answerTime, state, info) {
	$("#id").val(id);
	$("#version").val(version);
	$("#dateCreated").val(dateCreated);
	$("#dateUpdate").val(dateUpdate==null?"未修改":dateUpdate);
	$("#paper_id").val(paper_id);
	$("#paper_name").val(paper_name);
	$("#depart_name").val(depart_name);
	$("#answerTime").val(answerTime);
	$("#state").val(state);
	$("#memo").html(info);
}
