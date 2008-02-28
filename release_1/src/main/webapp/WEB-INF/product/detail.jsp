<?xml version="1.0" encoding="UTF-8" ?>
<!--
	$LastChangedBy$
	$LastChangedDate$
	$Revision$
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="product_detail">
<h1 id="page_title">商品详细信息</h1>
<p><span class="property_title">品名:</span> ${product.name }</p>
<p><span class="property_title">价格: </span>${product.price }</p>
<p><span class="property_title">厂商: </span>${product.vendor }</p>
<p><span class="property_title">创建日期: </span><fmt:formatDate
	pattern="yyyy年M月d日" value="${product.createDate}" /></p>

<p><span class="property_title">商品图片: </span></p>
<p><img src="photo.action?id=${product.id }" alt="商品" /></p>

<div class="product_context_menu">
<ul>
	<li><a href="update.action?id=${product.id }"> >>修改</a></li>
	<li><a href="delete.action?id=${product.id }"
		onclick="return confirm('确认删除么?');"> >>删除</a></li>
</ul>
</div>

</div>
