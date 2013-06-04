// JavaScript Document
/**
 * sailor
 * 通过复选框实现多条记录同时删除操作
 * 注意事项：
 * 1.页面中全选复选框的ID必须是checkboxAll，每条记录对应的复选框的name属性必须是checkbox_no。
 * 2.页面中删除所选按钮的ID必须是deleteSelected
 * 3.页面中必须有两个隐藏域：第一个的ID是deleteUrl，value属性值是删除操作的路径
 * 		第二个的ID是noName，value属性值是删除时传递参数的名称
 */
$(function() {
	$("#checkboxAll").click(function() {
		$("input[name='ids']").each(function() {
			$(this).attr("checked", $("#checkboxAll").attr("checked"));
		});
	});
	$("#deleteSelected").click(function() {
		var nos = new Array();
		$("input[name='ids']").each(function() {
			if ($(this).attr("checked") == true) {
				nos[nos.length] = $(this).val();
			}
		});
		if (nos.length == 0) {
			alert("请选择要操作的数据。");
			return;
		}

		// 获取页面数据
			var url = $("#deleteUrl").val();
			var noName = $("#noName").val();
			url = url + "?" + noName + "=";
			for ( var i = 0; i < nos.length; i++) {
				if (i < nos.length - 1) {
					url = url + nos[i] + "&" + noName + "=";
				} else {
					url = url + nos[i];
				}
			}
			if (confirm("你确定要删除该  " + nos.length + "  条数据记录吗？")) {
				document.location.assign(url);
			}
		});
});