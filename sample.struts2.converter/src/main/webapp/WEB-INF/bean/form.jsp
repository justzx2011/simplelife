<?xml version="1.0" encoding="UTF-8" ?>
<!--
	$LastChangedBy: Marshal.Wu@gmail.com $
	$LastChangedDate: 2007-12-04 13:43:57 +0800 (星期二, 04 十二月 2007) $
	$Rev: 96 $
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>商品表单</title>
<s:head />
</head>
<body>
<s:form method="POST" id="product_form" action="save.action" >
        <s:textfield name="product.name" label="名称" />
        <s:textfield name="product.price" label="价格" />
        <s:textfield name="product.vendor" label="厂商" />
        <s:datetimepicker name="product.createDate" label="创建日期" weekStartsOn="1"/>
        <s:submit value="保存"/>
</s:form>
</body>
</html>