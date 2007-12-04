<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>商品表单</title>
</head>
<body>
<form action="save.action" method="post">
<fieldset><legend>商品信息</legend>
<p><label>名称<input name="product.name" type="text" /></label></p>
<p><label>价格<input name="product.price" type="text" /></label></p>
<p><label>厂商<input name="product.vendor" type="text" /></label></p>
<hr />
<p><input type="submit" value="保存" /></p>
</fieldset>
<input type="hidden" name="product.id" value="" /></form>
</body>
</html>