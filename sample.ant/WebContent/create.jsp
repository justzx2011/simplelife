<!-- 
 $LastChangedBy$
 $LastChangedDate$
 $Rev$
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@page import="user.UserInfo"%>
<%@page import="java.util.Collections"%>

<%
	request.setAttribute("user",new UserInfo());
	request.setAttribute("messages",Collections.EMPTY_LIST);
	request.setAttribute("action","create");
	
	pageContext.forward("input.jsp");
%>