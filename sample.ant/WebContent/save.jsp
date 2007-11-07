<!-- 
 $LastChangedBy$
 $LastChangedDate$
 $Rev$
 -->
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.*" errorPage="error.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");

	String action=request.getParameter("action");
	//boolean create=false;
	boolean returnInput=false;
	List<String> messages=new ArrayList<String>();

	
	
	String userName=request.getParameter("userName");
	String password=request.getParameter("password");
	String passwordAgain=request.getParameter("passwordAgain");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String birthdayString=request.getParameter("birthday");
	
	if (userName==null || userName.trim().length()==0){
		returnInput=true;
		messages.add("必须填写用户名");
	}
	
	if (action.equals("create") && UserInfos.find(userName)!=null){
		returnInput=true;
		messages.add("用户名已经存在");
	}
	
	if (!password.equals(passwordAgain)){
		returnInput=true;
		messages.add("两次输入的密码不一致");
	}
	
	boolean sex=false;
	
	try{
		sex=Boolean.parseBoolean(request.getParameter("sex"));
	}catch(Exception e){
		returnInput=true;
		messages.add("性别输入错误");
	}
	
	Date birthday=null;

	if (birthdayString!=null &&birthdayString.trim().length()>0){
		try{
			birthday=new SimpleDateFormat("yyyy-MM-dd").parse(birthdayString);
		}catch(Exception e){
			returnInput=true;
			messages.add("生日输入不符合格式(yyyy-MM-dd)");
		}
	}
	
	UserInfo user=new UserInfo();
	user.setUserName(userName);
	user.setPassword(password);
	user.setName(name);
	user.setMale(sex);
	user.setEmail(email);
	user.setBirthday(birthday);
	
	request.setAttribute("user",user);
	request.setAttribute("action",action);
	
	if (returnInput){
		request.setAttribute("messages",messages);
		request.getRequestDispatcher("input.jsp").forward(request,response);
		return;
	}
	
	UserInfos.save(user);
	
	response.sendRedirect("choose.jsp");

%>

