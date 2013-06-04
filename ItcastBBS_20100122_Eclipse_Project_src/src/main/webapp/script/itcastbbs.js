
function confirmDel( message ){
	if( message == null ){ 
		message = "您确定要删除一条记录吗？";
	}
	return window.confirm( message );
}