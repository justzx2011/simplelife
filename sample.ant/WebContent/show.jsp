<?xml version="1.0" encoding="UTF-8" ?>
<!-- 
 $LastChangedBy$
 $LastChangedDate$
 $Rev$
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ page import="java.util.*" %>
<%@ page import="user.*" %>

<%
	Set<UserInfo> users = UserInfos.getUsers();
	int count = 1;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户管理::浏览用户</title>
</head>
<body>
<jsp:include flush="true" page="header.jsp">
	<jsp:param name="current" value="show"/>
</jsp:include>
<table width="600" border="0" align="center">
	<tr bgcolor="#99CCFF">
		<td width="47">
		<div align="center"><strong>序号</strong></div>
		</td>
		<td width="88">
		<div align="center"><strong>用户名</strong></div>
		</td>
		<td width="108">
		<div align="center"><strong>用户姓名</strong></div>
		</td>
		<td width="77">
		<div align="center"><strong>性别</strong></div>
		</td>
		<td width="140">
		<div align="center"><strong>邮箱</strong></div>
		</td>
		<td width="114">
		<div align="center"><strong>生日</strong></div>
		</td>
	</tr>
	<%
	for (UserInfo userInfo : users) {
	%>
	<tr>
		<td>
		<div align="center"><%=count++%></div>
		</td>
		<td>
		<div align="center"><%=userInfo.getUserName()%></div>
		</td>
		<td>
		<div align="center"><%=userInfo.getName() != null ? userInfo.getName()
						: ""%></div>
		</td>
		<td>
		<div align="center"><%=userInfo.isMale() ? "男" : "女"%></div>
		</td>
		<td>
		<div align="center"><%=userInfo.getEmail() != null ? userInfo
						.getEmail() : ""%></div>
		</td>
		<td>
		<div align="center"><%=userInfo.getBirthday() != null ? new SimpleDateFormat(
								"yyyy年MM月dd日").format(userInfo.getBirthday())
								: ""%></div>
		</td>
	</tr>
	<%
	}
	%>
</table>
<%@include file="footer.jsp"%>
</body>
</html>
