<?xml version="1.0" encoding="UTF-8" ?>
<!--
	$LastChangedBy$
	$LastChangedDate$
	$Revision$
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h1 id="page_title">编辑商品</h1>

<s:form method="POST" id="product_form" action="save.action"
	enctype="multipart/form-data">
	<s:textfield name="product.name" label="名称" />
	<s:textfield name="product.price" label="价格" />
	<s:textfield name="product.vendor" label="厂商" />
	<s:datetimepicker name="product.createDate" label="创建日期"
		weekStartsOn="1" />
	<s:file label="商品照片" name="file" />
	<s:hidden name="product.id" value="${product.id}" />
	<s:submit value="保存" />
</s:form>
