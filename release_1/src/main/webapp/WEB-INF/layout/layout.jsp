<?xml version="1.0" encoding="UTF-8" ?>
<!--
	$LastChangedBy$
	$LastChangedDate$
	$Revision$
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:getAsString name="title" /></title>
<s:head />
<link href="${pageContext.request.contextPath}/css/style.css"
	type="text/css" rel="stylesheet" />
</head>
<body>
<div id="content">
<div id="header"><tiles:insertAttribute name="header" /></div>
<div id="body"><tiles:insertAttribute name="body" /></div>
<div id="footer"><tiles:insertAttribute name="footer" /></div>
</div>
</body>
</html>