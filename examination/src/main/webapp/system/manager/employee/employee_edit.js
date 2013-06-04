$(function() {
	getDepartments();// 从数据库中获取数据
	getData();// 获取数据
	$("#refresh").click(function() {
				getDepartments();
			});
	$.formValidator.initConfig({
				formid : "form1",
				onerror : function(msg) {
					giveMsg(false, "数据验证出错", msg);
					return false;
				},
				onsuccess : function() {
					return true;
				}
			});
	$("#emp_id").formValidator({
				onshow : "请输入编号",
				onfocus : "编号由4-20数字，字母，下划线组成",
				oncorrect : "编号输入合法"
			}).inputValidator({
				min : 4,
				max : 20,
				onerror : "输入的编号长度不正确,请检查"
			}).regexValidator({
				regexp : "username",
				datatype : "enum",
				onerror : "编号格式不正确"
			});
	$("#emp_name").formValidator({
				onshow : "请输入姓名",
				onfocus : "姓名由2-10中文组成",
				oncorrect : "姓名输入合法"
			}).inputValidator({
				min : 4,
				max : 20,
				onerror : "输入的姓名长度不正确,请检查"
			}).regexValidator({
				regexp : "chinese",
				datatype : "enum",
				onerror : "姓名格式不正确"
			});
	$("#depart_id").formValidator({
				onshow : "请选择所属部门",
				onfocus : "别选错哦！",
				oncorrect : "选择正确了"
			}).inputValidator({
				min : 1,
				onerror : "所属部门未选择!"
			});
	$("#birthday").DateTimeMask({
				"lawlessmessage" : "你输入的出生日期格式错误"
			}).formValidator({
				onshow : "请输入的出生日期",
				onfocus : "请输入的出生日期，不能全部是0哦",
				oncorrect : "你输入的日期合法"
			}).inputValidator({
				min : "1900-01-01",
				max : "2010-01-01",
				type : "value",
				onerror : "日期必须在\"1900-01-01\"和\"2010-01-01\"之间"
			})// .defaultPassed();

	$("#phone").formValidator({
				//empty : true,
				onshow : "请输入你的手机号码，可以为空哦",
				onfocus : "你要是输入了，必须输入正确",
				oncorrect : "谢谢你的合作"
				//onempty : "你真的不想留手机号码啊？"
			}).inputValidator({
				min : 11,
				max : 11,
				onerror : "手机号码必须是11位的,请确认"
			}).regexValidator({
				regexp : "mobile",
				datatype : "enum",
				onerror : "你输入的手机号码格式不正确"
			});;
	$("#email").formValidator({
				onshow : "请输入邮箱",
				onfocus : "邮箱6-100个字符,输入正确了才能离开焦点",
				oncorrect : "恭喜你,你输对了"
			}).inputValidator({
				min : 6,
				max : 100,
				onerror : "你输入的邮箱长度非法,请确认"
			}).regexValidator({
		regexp : "^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$",
		onerror : "你输入的邮箱格式不正确"
	});

	$(":password").focus(function() {
				checkPassword();
			});

	$("#save").click(function() {
				if ($.formValidator.pageIsValid('1')) {
					submitData();
				}
			});
	$("#reset").click(function() {
				document.getElementById("form1").reset();
			});
});

function checkPassword() {
	$("#password").formValidator({
				onshow : "请输入密码",
				onfocus : "密码不能为空,且4-20位",
				oncorrect : "密码合法"
			}).inputValidator({
				min : 4,
				max : 20,
				empty : {
					leftempty : false,
					rightempty : false,
					emptyerror : "密码两边不能有空符号"
				},
				onerror : "密码不能为空,请确认"
			});
	$("#repassword").formValidator({
				onshow : "请输入重复密码",
				onfocus : "两次密码必须一致哦",
				oncorrect : "密码一致"
			}).inputValidator({
				min : 4,
				max : 20,
				empty : {
					leftempty : false,
					rightempty : false,
					emptyerror : "重复密码两边不能有空符号"
				},
				onerror : "重复密码不正确,请确认"
			}).compareValidator({
				desid : "password",
				operateor : "=",
				onerror : "2次密码不一致,请确认"
			});
}
function getData() {
	$.ajax({
				type : "GET",
				url : "employeeEditAction!update" + location.search,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var employee = data["employee"];
					addData(employee.id, employee.version, employee.emp_id,
							employee.emp_name, employee.gender,
							employee.department.id, employee.level,
							employee.strBirthday, employee.phone,
							employee.email, employee.address, employee.contact,
							employee.memo, employee.dep_manager);
				}
			});
}
function addData(id, version, emp_id, emp_name, gender, depart_id, level,
		birthday, phone, email, address, contact, memo, dep_manager) {
	$("#id").val(id);
	$("#version").val(version);
	$("#emp_id").val(emp_id);
	$("#emp_name").val(emp_name);
	$("input[name='gender']").each(function() {
				if ($(this).val() == gender) {
					$(this).attr("checked", "checked");
				};
			});
	$("option[name='d_id']").each(function() {
				if ($(this).val() == depart_id) {
					$(this).attr("selected", "selected");
				};
			});
	$("option[name='lev']").each(function() {
				if ($(this).val() == level) {
					$(this).attr("selected", "selected");
				};
			});
	$("#birthday").val(birthday);
	$("#phone").val(phone);
	$("#email").val(email);
	$("#address").val(address);
	$("#contact").val(contact);
	$("input[name='dep_manager']").each(function() {
				if ($(this).val() == dep_manager) {
					$(this).attr("checked", "checked");
				}
			});
	$("#memo").html(memo);
}
function submitData() {
	var formToArray = $("#form1").serializeArray();
	$.ajax({
				type : "POST",
				url : "employeeSaveAction!editSave",
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
function getDepartments() {
	$.ajax({
		type : "POST",
		url : "employeeListAction!getDeparts",
		cache : false,
		dataType : "json",
		async : false,
		success : function(data) {
			if (data["departments"]) {
				$("#depart_id").empty();
				$("#depart_id")
						.append("<option name='d_id' value=''>不限</option>");
				$.each(data["departments"], function(i, n) {
							$("#depart_id")
									.append("<option name='d_id' value='"
											+ n[0] + "'>" + n[1] + "</option>");
						});
			}
		}
	});
}