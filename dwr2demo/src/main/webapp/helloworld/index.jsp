<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>DWR2's Hello world</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script src='${contextPath}/dwr/util.js'></script>
<script src='${contextPath}/dwr/engine.js'></script>
<script src='${contextPath}/dwr/interface/helloworld.js'></script>
<script type="text/javascript">
function sayHello(){
	var userName=$('userName').value;
	helloworld.sayHello(userName,callBackHello);
}

function callBackHello(data){
	alert(data);
}
</script>
</head>
<body>
<lable for="userName" value="用户名"/><input id="userName" type="text"/>
<input  type="button"  name="button"  value="提交"  onclick="sayHello()" />
</body>
</html>