function User(){
	$('submit').onclick=submitUser;
}

function submitUser(){
	var user=DWRUtil.getValues($('userForm'));
	user=userService.save(user);
}

function receiveSavedUser(user){
	$('content').innerHTML="<p>保存成功。</p><p>用户ID："+user.id+
	"</p><p>用户名："+user.name+"</p><p>邮箱："+
	user.email+"</p>";
}