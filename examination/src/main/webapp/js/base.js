$(function() {
			$('#dialog').dialog({
						autoOpen : false,
						width : 400,
						height : 300,
						position : 'center',
						title : '系统提示',
						modal : true,
						buttons : {
							"关 闭" : function() {
								$(this).dialog("close");
							},
							"我知道了" : function() {
								$(this).dialog("close");
							}

						}
					});
			$("#info").hide();
			$("#info").ajaxStart(function() {
						$(this).show();
					});
			$("#info").ajaxStop(function() {
						$(this).hide();
					});
			$("#info").ajaxError(function(event, request, settings) {
						$(this).hide();
						giveMsg(false, "获取数据失败", "请检查数据库连接是否正常，如有问题请联系网络管理员！");
					});
		});
function giveMsg(state, title, msg) {
	if (state) {
		$('#subtitle').css("color", "blue");
		$('#subtitle').html(title);
	} else {
		$('#subtitle').css("color", "red");
		$('#subtitle').html(title);
	}
	$('#msg').html(msg);
	$('#dialog').dialog('open');
}