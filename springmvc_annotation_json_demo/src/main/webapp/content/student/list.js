$(function() {

			getData();

		});

function getData() {
	jQuery.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : 'list.do',
				// data : jsonuserinfo,
				dataType : 'json',
				success : function(data) {
					if (data) {
						$("#dataArea").empty();
						$.each(data, function(i, n) {
									addData(n.stu_no, n.stu_name);
								});
					}
				},
				error : function() {
					alert("ajax error");
				}
			});
}
function addData(stu_no, stu_name) {
	$("#dataArea").append("<tr><td>" + stu_no + "</td><td>" + stu_name
			+ "</td></tr>");
}