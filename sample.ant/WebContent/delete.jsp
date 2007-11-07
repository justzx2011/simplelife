<!-- 
 $LastChangedBy$
 $LastChangedDate$
 $Rev$
 -->
<%@page import="java.util.Arrays"%>
<%@page import="user.UserInfos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");

	String[] userNames=request.getParameterValues("userNames");

	if (userNames!=null){
		UserInfos.delete(Arrays.asList(userNames));
	}
	
	response.sendRedirect("choose.jsp");
%>