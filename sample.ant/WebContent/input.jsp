<?xml version="1.0" encoding="UTF-8" ?>
<!-- 
 $LastChangedBy$
 $LastChangedDate$
 $Rev$
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@page import="user.UserInfo"%>
<%@page import="java.util.List"%>
    
<%
	String action=(String)request.getAttribute("action");
	UserInfo user=(UserInfo)request.getAttribute("user");
	List<String> messages=(List<String>)request.getAttribute("messages");
	
	String userName=user.getUserName()!=null?user.getUserName():"";
	String password=user.getPassword()!=null?user.getPassword():"";
	String passwordAgain=request.getParameter("passwordAgain");
	
	if (passwordAgain==null){
		passwordAgain=password;
	}
	
	String sexMale=user.isMale()?"checked=\"checked\"":"";
	String sexFemale=user.isMale()?"":"checked=\"checked\"";
	String name=user.getName()!=null?user.getName():"";
	String email=user.getEmail()!=null?user.getEmail():"";
	
	String birthday="";
	
	if (user.getBirthday()!=null){
		birthday=new SimpleDateFormat("yyyy-MM-dd").format(user.getBirthday());
	}else if (request.getParameter("birthday")!=null){
		birthday=request.getParameter("birthday");
	}
	
	String userNameDisable="";
	
	if (action!=null && action.equals("update")){
		userNameDisable="readonly=\"readonly\"";
	}
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="java.text.SimpleDateFormat"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户管理::编辑</title>
</head>
<body>
<jsp:include flush="true" page="header.jsp">
	<jsp:param name="current" value="<%=action %>"/>
</jsp:include>
<form action="save.jsp" method="post">

<table width="500" border="0" align="center">
  <tr>
    <td colspan="4" bgcolor="#CCCCFF"><div align="center"><strong>用户录入</strong></div></td>
  </tr>
  <%
  	if (messages.size()>0){
  %>
  <tr>
    <td width="85"><div align="center">错误提示</div></td>
    <td colspan="3">
    <ul>
    
    <%
		for(String message:messages){
	%>
		<li><%=message %></li>
	<%
		}
	%>
    </ul>
    </td>
  </tr>
  
  <%
  	}
  %>
  <tr>
    <td width="85"><div align="center">用户名</div></td>
    <td colspan="3">      <label>
      <div align="left">
        <input type="text" name="userName" value="<%=userName%>" <%=userNameDisable %>/>
      </div>
      </label></td>
    </tr>
  <tr>
    <td><div align="center">密码</div></td>
    <td width="156"><div align="left">
      <label>
      <input type="password" name="password" value="<%=password%>"/>
      </label>
    </div></td>
    <td width="85"><div align="center">重输密码</div></td>
    <td width="156"><label>
      <input type="password" name="passwordAgain" value="<%=passwordAgain%>"/>
    </label></td>
  </tr>
  <tr>
    <td><div align="center">姓名</div></td>
    <td><label>
      <input type="text" name="name" value="<%=name%>"/>
    </label></td>
    <td><div align="center">性别</div></td>
    <td><label>
      <input type="radio" name="sex" value="true" <%=sexMale %>/>
      男
      <input type="radio" name="sex" value="false" <%=sexFemale %>/>
    女</label></td>
  </tr>
  <tr>
    <td><div align="center">邮箱</div></td>
    <td colspan="3"><label>
      <input type="text" name="email" value="<%=email %>"/>
    </label></td>
    </tr>
  <tr>
    <td><div align="center">生日</div></td>
    <td colspan="3"><label>
      <input type="text" name="birthday" value="<%=birthday %>"/>
    </label></td>
  </tr>
  <tr>
    <td><div align="center"></div></td>
    <td colspan="3"><div align="center">
      <label>
      <input type="hidden" name="action" value="<%=action %>"/>
      <input type="submit" name="Submit" value="提交" />
      </label>
    </div></td>
    </tr>
</table>
</form>
<%@include file="footer.jsp"%>
</body>
</html>