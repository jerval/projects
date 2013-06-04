$().ready(function() {
	$("#loginForm").validate( {
		rules : {
			username : {
				required : true,
			},
			password : {
				required : true,
			}
		},
		messages : {
			username : {
				required : "必填",
			},
			password : {
				required : "必填",
			}
		}
	});
	$("#login").click(function() {
		var e = $("#loginForm").valid();
		if (!e){
			return;
		}else{
			$("#loginForm").submit();
		}
	});
	$("#username").keydown(function(event) {
		if (event.keyCode == 13)
			$("#password").focus();
	});
	$("#password").keydown(function(event) {
		if (event.keyCode == 13)
			$("#login").click();
	});
	$("#username").focus();
});

function goResize() {
	moveTo(0, 0);
	resizeTo(screen.availWidth, screen.availHeight);
}