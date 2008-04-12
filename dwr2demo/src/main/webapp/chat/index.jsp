<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>聊天室原型</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script src='${contextPath}/dwr/util.js'></script>
<script src='${contextPath}/dwr/engine.js'></script>
<script src='${contextPath}/dwr/interface/chatService.js'> </script>
<script src='chat.js'></script>
</head>
<body onload="init()">
<p>发送的信息： <input id="text"
	onkeypress="dwr.util.onReturn(event, sendMessage)" /> <input
	type="button" value="Send" onclick="sendMessage()" /></p>
<hr />
<div id="chatlog"></div>
<script type="text/javascript"></script>
</body>
</html>