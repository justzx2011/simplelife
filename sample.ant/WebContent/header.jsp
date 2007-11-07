<%@ page language="java" pageEncoding="UTF-8"%>
<!-- 
 $LastChangedBy$
 $LastChangedDate$
 $Rev$
 -->
<%
	String browseUrl="<a href=\"show.jsp\">浏览</a>";
	String chooseUrl="<a href=\"choose.jsp\">选择</a>";
	String addUrl="<a href=\"create.jsp\">新增</a>";
	
	String current=request.getParameter("current");
	
	if(current==null){
		current="";
	}
	
	if(current.equals("show")){
		browseUrl="浏览";
	}
	
	if (current.equals("choose")){
		chooseUrl="选择";
	}
	
	if (current.equals("create")){
		addUrl="新增";
	}
%>

<table width="600" border="0" align="center">
  <tr>
    <td>■ <%=browseUrl %> ■ <%=chooseUrl %> ■ <%=addUrl %></td>
  </tr>
</table>
<hr width="600"/>
