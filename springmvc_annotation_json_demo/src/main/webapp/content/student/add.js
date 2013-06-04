
$(function() {
			
			$("#button").click(function() {
						save();
					});

		});

function save() {
	var elemUserinfo = $('#form1');
	var userinfo = elemUserinfo.serializeObject();
	var jsonuserinfo = JSON.stringify(userinfo);
	alert(jsonuserinfo);
	jQuery.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : 'save.do',
				data : jsonuserinfo,
				dataType : 'json',
				success : function(data) {
					alert(data);
				},
				error : function() {
					alert("ajax error");
				}
			});
}