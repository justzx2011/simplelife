<?xml version="1.0" encoding="UTF-8" ?>
<!--
	$LastChangedBy: Marshal.Wu@gmail.com $
	$LastChangedDate: 2007-12-04 13:16:03 +0800 (星期二, 04 十二月 2007) $
	$Rev: 95 $
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>保存提示</title>
</head>
<body>
<h2>商品保存成功.</h2>

<p>品名: ${product.name }</p>
<p>价格: ${product.price }</p>
<p>厂商: ${product.vendor.name }</p>
<p>联系人: ${product.contact }</p>
<p>创建日期: <fmt:formatDate pattern="yyyy年M月d日" value="${product.createDate}"/></p>
</body>
</html>