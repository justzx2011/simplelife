<!-- 
 $LastChangedBy$
 $LastChangedDate$
 $Rev$
 -->
<%@page import="user.UserException"%>
<%@page import="user.UserNotFoundException"%>
<%@page import="java.util.Collections"%>
<%@page import="user.UserInfo"%>
<%@page import="user.UserInfos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>

<% 
	String userName=request.getParameter("userName");

	if (userName==null){
		throw new UserException("必须输入用户名方可修改");
	}
	
	UserInfo user=UserInfos.find(userName);
	
	if (user==null){
		throw new UserNotFoundException("未找到需要修改的用户记录:"+userName);
	}
	
	request.setAttribute("user",user);
	request.setAttribute("action","update");
	request.setAttribute("messages",Collections.EMPTY_LIST);
	
	request.getRequestDispatcher("input.jsp").forward(request,response);
%>