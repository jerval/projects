$(document).ready(function() {
	// $.formValidator.initConfig({onerror:function(){alert("校验没有通过，具体错误请看错误提示")}});
	$.formValidator.initConfig({
				formid : "form1",
				onerror : function(msg) {
					alert(msg)
				},
				onsuccess : function() {
					alert('ddd');
					return false;
				}
			});
	$("#test1").formValidator({
				onshow : "请输入用户名,只有输入\"maodong\"才是对的",
				onfocus : "用户名至少6个字符,最多10个字符",
				oncorrect : "该用户名可以注册"
			}).inputValidator({
				min : 6,
				max : 10,
				onerror : "你输入的用户名非法,请确认"
			}).regexValidator({
				regexp : "username",
				datatype : "enum",
				onerror : "用户名格式不正确"
			}).ajaxValidator({
				type : "get",
				url : "Default.aspx",
				datatype : "json",
				success : function(data) {
					if (data == "1") {
						return true;
					} else {
						return false;
					}
				},
				buttons : $("#button"),
				error : function() {
					alert("服务器没有返回数据，可能服务器忙，请重试");
				},
				onerror : "该用户名不可用，请更换用户名",
				onwait : "正在对用户名进行合法性校验，请稍候..."
			});
	$("#password1").formValidator({
				onshow : "请输入密码",
				onfocus : "密码不能为空",
				oncorrect : "密码合法"
			}).inputValidator({
				min : 1,
				empty : {
					leftempty : false,
					rightempty : false,
					emptyerror : "密码两边不能有空符号"
				},
				onerror : "密码不能为空,请确认"
			});
	$("#password2").formValidator({
				onshow : "请输入重复密码",
				onfocus : "两次密码必须一致哦",
				oncorrect : "密码一致"
			}).inputValidator({
				min : 1,
				empty : {
					leftempty : false,
					rightempty : false,
					emptyerror : "重复密码两边不能有空符号"
				},
				onerror : "重复密码不能为空,请确认"
			}).compareValidator({
				desid : "password1",
				operateor : "=",
				onerror : "2次密码不一致,请确认"
			});
	$(":radio[name='sex']").formValidator({
				tipid : "sexTip",
				onshow : "请选择你的性别",
				onfocus : "没有第三种性别了，你选一个吧",
				oncorrect : "输入正确",
				defaultvalue : ["1"]
			}).inputValidator({
				min : 1,
				max : 1,
				onerror : "性别忘记选了,请确认"
			});// .defaultPassed();
	$("#nl").formValidator({
				onshow : "请输入的年龄（1-99岁之间）",
				onfocus : "只能输入1-99之间的数字哦",
				oncorrect : "恭喜你,你输对了"
			}).inputValidator({
				min : 1,
				max : 99,
				type : "value",
				onerrormin : "你输入的值必须大于等于1",
				onerror : "年龄必须在1-99之间，请确认(输入正确后才能离开焦点)"
			});// .defaultPassed();
	$("#csny").focus(function() {
				WdatePicker({
							skin : 'whyGreen',
							oncleared : function() {
								$(this).blur();
							},
							onpicked : function() {
								$(this).blur();
							}
						})
			}).formValidator({
				onshow : "请输入的出生日期",
				onfocus : "请输入的出生日期，不能全部是0哦",
				oncorrect : "你输入的日期合法"
			}).inputValidator({
				min : "1900-01-01",
				max : "2000-01-01",
				type : "date",
				onerror : "日期必须在\"1900-01-01\"和\"2000-01-01\"之间"
			});// .defaultPassed();
	$("#sfzh").formValidator({
				onshow : "请输入15或18位的身份证",
				onfocus : "输入15或18位的身份证",
				oncorrect : "输入正确"
			}).functionValidator({
				fun : isCardID
			});
	$("#email").formValidator({
				onshow : "请输入邮箱",
				onfocus : "邮箱6-100个字符,输入正确了才能离开焦点",
				oncorrect : "恭喜你,你输对了",
				defaultvalue : "@",
				forcevalid : true
			}).inputValidator({
				min : 6,
				max : 100,
				onerror : "你输入的邮箱长度非法,请确认"
			}).regexValidator({
		regexp : "^([\\w-.]+)@(([[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.)|(([\\w-]+.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$",
		onerror : "你输入的邮箱格式不正确"
	});
	$("#xueli").formValidator({
				onshow : "请选择你的学历",
				onfocus : "学历必须选择",
				oncorrect : "谢谢你的配合",
				defaultvalue : "a"
			}).inputValidator({
				min : 1,
				onerror : "你是不是忘记选择学历了!"
			}).defaultPassed();
	$("#ewjy").formValidator({
				onshow : "无论你输入什么都会提示你额外校验出错",
				onfocus : "如果你输入\"猫冬\"，额外校验就会成功",
				oncorrect : "额外校验成功"
			}).inputValidator({
				min : 1,
				onerror : "这里至少要一个字符,请确认"
			}).functionValidator({
				fun : function(val, elem) {
					if (val == "猫冬") {
						return true;
					} else {
						return "额外校验失败,想额外校验通过，请输入\"猫冬\""
					}
				}
			});
	$("#Tel_country").formValidator({
				tipid : "teltip",
				onshow : "请输入国家区号",
				onfocus : "国家区号2位数字",
				oncorrect : "恭喜你,你输对了",
				defaultvalue : "86"
			}).regexValidator({
				regexp : "^\\d{2}$",
				onerror : "国家区号不正确"
			});
	$("#Tel_area").formValidator({
				tipid : "teltip",
				onshow : "请输入地区区号",
				onfocus : "地区区号3位或4位数字",
				oncorrect : "恭喜你,你输对了"
			}).regexValidator({
				regexp : "^\\d{3,4}$",
				onerror : "地区区号不正确"
			});
	$("#Tel_number").formValidator({
				tipid : "teltip",
				onshow : "请输入电话号码",
				onfocus : "电话号码7到8位数字",
				oncorrect : "恭喜你,你输对了"
			}).regexValidator({
				regexp : "^\\d{7,8}$",
				onerror : "电话号码不正确"
			});
	$("#Tel_ext").formValidator({
				tipid : "teltip",
				onshow : "请输入分机号码",
				onfocus : "分机号码1到5位数字",
				oncorrect : "恭喜你,你输对了"
			}).regexValidator({
				regexp : "^\\d{1,5}$",
				onerror : "分机号码不正确"
			});
	$(":checkbox[name='checkbox1']").formValidator({
				tipid : "test3Tip",
				onshow : "请选择你的兴趣爱好（至少选一个）",
				onfocus : "你至少选择1个",
				oncorrect : "恭喜你,你选对了"
			}).inputValidator({
				min : 1,
				onerror : "你选的个数不对"
			});
	$(":checkbox[name='checkbox8']").formValidator({
				tipid : "test2Tip",
				onshow : "请选择你的兴趣爱好(至少选择2个,最多选择3个)",
				onfocus : "你至少选择2个,最多选择3个",
				oncorrect : "恭喜你,你选对了",
				defaultvalue : ["7", "8"]
			}).inputValidator({
				min : 2,
				max : 3,
				onerror : "你选的个数不对(至少选择2个,最多选择3个)"
			});
	$(":radio[name='radio']").formValidator({
				tipid : "aiguoTip",
				onshow : "爱国的人一定要选哦",
				onfocus : "你得认真思考哦",
				oncorrect : "不知道你爱不爱，反正你是选了",
				defaultvalue : ["4"]
			}).inputValidator({
				min : 1,
				max : 1,
				onerror : "难道你不爱国？你给我选！！！！"
			}).defaultPassed();
	$("#shouji").formValidator({
				empty : true,
				onshow : "请输入你的手机号码，可以为空哦",
				onfocus : "你要是输入了，必须输入正确",
				oncorrect : "谢谢你的合作",
				onempty : "你真的不想留手机号码啊？"
			}).inputValidator({
				min : 11,
				max : 11,
				onerror : "手机号码必须是11位的,请确认"
			}).regexValidator({
				regexp : "mobile",
				datatype : "enum",
				onerror : "你输入的手机号码格式不正确"
			});;
	$("#lxdh").formValidator({
				empty : true,
				onshow : "请输入你的联系电话，可以为空哦",
				onfocus : "格式例如：0577-88888888",
				oncorrect : "谢谢你的合作",
				onempty : "你真的不想留联系电话了吗？"
			}).regexValidator({
				regexp : "^[[0-9]{3}-|\[0-9]{4}-]?([0-9]{8}|[0-9]{7})?$",
				onerror : "你输入的联系电话格式不正确"
			});
	$("#selectmore").formValidator({
				onshow : "按住CTRL可以多选",
				onfocus : "按住CTRL可以多选,至少选择2个",
				oncorrect : "谢谢你的合作",
				defaultvalue : ["0", "1", "2"]
			}).inputValidator({
				min : 2,
				onerror : "至少选择2个"
			});
	$("#ms").formValidator({
				onshow : "请输入你的描述",
				onfocus : "描述至少要输入10个汉字或20个字符",
				oncorrect : "恭喜你,你输对了",
				defaultvalue : "这家伙很懒，什么都没有留下。"
			}).inputValidator({
				min : 20,
				onerror : "你输入的描述长度不正确,请确认"
			});
});
function test(obj) {
	if (obj.value == "不校验身份证") {
		$("#sfzh").attr("disabled", true).unFormValidator(true);
		obj.value = "校验身份证";
	} else {
		$("#sfzh").attr("disabled", false).unFormValidator(false);
		obj.value = "不校验身份证";
	}
}
function test1(obj) {
	if (obj.value == "全角字符当做1个长度") {
		$.formValidator.getInitConfig("1").wideword = false;
		obj.value = "全角字符当做2个长度";
	} else {
		$.formValidator.getInitConfig("1").wideword = true;
		obj.value = "全角字符当做1个长度";
	}

}