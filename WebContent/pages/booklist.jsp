<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<%@include file="/include/base.jsp" %>
</head>
<body>
	<div id="header">
			<span class="wel_word">图书管理系统</span>
			<!-- 这里是操作菜单 -->
			<%@include file="/include/user-info.jsp" %>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/BookClientServlet" method="get">
					价格：<input id="min" type="text" name="min" value="${param.min }"> 元 - 
						<input id="max" type="text" name="max" value="${param.max }"> 元 
						<input type="hidden" name="method" value="pageByPrice">
						<input type="submit" value="查询" />
				</form>
				
				<form action="client/BookClientServlet" method="get">
					图书标题：<input id="title" type="text" name="title">
						<input type="hidden" name="method" value="pageByTitle">
						<input type="submit" value="查询" />
				</form>
			</div>
			
			
			<c:forEach items="${page.pageData }" var="book">
				<div class="b_list">
				<div class="img_div">
					<img class="book_img" alt="" src="${book.imgPath }" />
				</div>
				<div class="book_info">
					<div class="book_name">
						<span class="sp1">书名:</span>
						<span class="sp2">${book.title }</span>
					</div>
					<div class="book_author">
						<span class="sp1">作者:</span>
						<span class="sp2">${book.author }</span>
					</div>
					<div class="book_publisher">
						<span class="sp1">出版社:</span>
						<span class="sp2">${book.publisher }</span>
					</div>
					<div class="book_price">
						<span class="sp1">价格:</span>
						<span class="sp2">￥${book.price }</span>
					</div>
				</div>
			</div>
			</c:forEach>
	</div>
	
	<%@include file="/include/page.jsp" %>
</div>	
	
		
	<div id="bottom">
		<span>
			xxy.Copyright &copy;2020
		</span>
	</div>
</body>
</html>