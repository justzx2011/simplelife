<?xml version="1.0" encoding="UTF-8" ?>
<!--
	$LastChangedBy$
	$LastChangedDate$
	$Rev$
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="products_info">
<h1 id="page_title">商品列表</h1>
<div id="products"><c:forEach var="product"
	items="${pagination.results}">
	<div class="product">
	<div class="product_name">${product.name}</div>

	<div class="product_price"><fmt:formatNumber type="currency"
		value="	${product.price }" /></div>
	<div class="product_vendor"><span class="product_title">厂商:</span>
	${product.vendor }</div>
	<div class="product_delete"><a
		href="detail.action?id=${product.id }">>>>详细</a></div>
	</div>
</c:forEach></div>
<div class="pagination">
<ul>
	<li>${pagination.size }条/页</li>
	<li>${pagination.pageSum }页</li>
	<li>${pagination.recordSum }条</li>
	<c:if test="${!pagination.first}">
		<li><a href="browse.action?pagination.no=1">首页</a></li>
	</c:if>
	<c:if test="${pagination.previous}">
		<li><a href="browse.action?pagination.no=${pagination.no-1 }">上页</a></li>
	</c:if>
	<c:if test="${pagination.next}">
		<li><a href="browse.action?pagination.no=${pagination.no+1 }">下页</a></li>
	</c:if>
	<c:if test="${!pagination.last&&pagination.no>0}">
		<li><a href="browse.action?pagination.no=${pagination.pageSum }">末页</a></li>
	</c:if>
</ul>
</div>
</div>
