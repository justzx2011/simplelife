<?xml version="1.0" encoding="UTF-8" ?>
<!-- 
 $LastChangedBy$
 $LastChangedDate$
 $Rev$
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@page import="user.UserException"%>
    
<%
	String exceptionType="服务器内部错误";
	String exceptionMessage="无";
	
	if (exception instanceof UserException){
		exceptionType="用户管理异常";
		exceptionMessage=exception.getMessage();
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户管理::错误报告</title>
</head>
<body>
<jsp:include  page="header.jsp" />

<table width="600" border="0" align="center">
  <tr>
    <td colspan="2" bgcolor="#FF99CC"><div align="center"><strong>错误</strong></div></td>
  </tr>
  <tr>
    <td width="120"><div align="center">错误类型</div></td>
    <td width="470"><%=exceptionType %></td>
  </tr>
  <tr>
    <td><div align="center">错误提示</div></td>
    <td><%=exceptionMessage %></td>
  </tr>
</table>

<%@include file="footer.jsp"%>
</body>
</html>