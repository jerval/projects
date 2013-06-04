$(function() {
			$("#back").click(function() {
						location.assign("employee_list.html");
					});
			getData();// 获取数据
		});
function getData() {
	$.ajax({
				type : "GET",
				url : "employeeEditAction!update" + location.search,
				cache : false,
				dataType : "json",
				async : false,
				success : function(data) {
					var employee = data["employee"];
					addData(employee.id, employee.version,
							employee.strDateCreated, employee.strDateUpdate,
							employee.emp_id, employee.emp_name,
							employee.gender, employee.department.depart_name,
							employee.level, employee.strBirthday, employee.phone,
							employee.email, employee.address, employee.contact,
							employee.memo, employee.dep_manager);
				}
			});
}
function addData(id, version, dateCreated, dateUpdate, emp_id, emp_name,
		gender, depart_name, level, birthday, phone, email, address, contact,
		memo, dep_manager) {
	$("#id").val(id);
	$("#version").val(version);
	$("#dateCreated").val(dateCreated);
	$("#dateUpdate").val(dateUpdate==null?"未修改":dateUpdate);
	$("#emp_id").val(emp_id);
	$("#emp_name").val(emp_name);
	$("#gender").val(gender);
	$("#depart_name").val(depart_name);
	$("#level").val(level);
	$("#birthday").val(birthday);
	$("#phone").val(phone);
	$("#email").val(email);
	$("#address").val(address);
	$("#contact").val(contact);
	$("#dep_manager").val(dep_manager);
	$("#memo").html(memo);
}
