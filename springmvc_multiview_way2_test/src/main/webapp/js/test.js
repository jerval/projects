$(function() {
			$("#button").click(function() {
						save();
					});

		});

function save() {
	var elemUserinfo = $('#customerInfo');
	var userinfo = elemUserinfo.serializeObject();
	var jsonuserinfo = JSON.stringify(userinfo);
	alert(jsonuserinfo)
	jQuery.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : 'customerInfo/new/2/3.do',
				//url : 'customerInfo/new.do',
				data : jsonuserinfo,
				dataType : 'json',
				success : function(data) {
					alert("name:" + data.name + "  addr:" + data.addr);
				},
				error : function() {
					alert("ajax error");
				}
			});
}