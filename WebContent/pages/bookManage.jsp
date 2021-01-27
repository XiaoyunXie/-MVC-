<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@include file="/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		$(".delBtn").click(function(){
			//alert("删除");
			//this代表当前被点击的a
			var td = $(this).parent().parent().children().first();
			/* if(!confirm("确认删除【" + td.text() +"】?")){
				//用户点击取消
				return false;
			} */
			return confirm("确认删除【" + td.text() +"】?");
			
			
		});
	});
	
</script>
</head>
<body>
	
	<div id="header">
			<span class="wel_word">图书管理系统</span>
			<%@include file="/include/book-manager.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>出版社</td>
				<td colspan="2">操作</td>
			</tr>	
			
			<c:forEach items="${requestScope.page.pageData }" var="book">
				<tr>
					<td>${book.title}</td>
					<td>${book.price }</td>
					<td>${book.author }</td>
					<td>${book.publisher }</td>
					<td><a href="manager/BookManagerServlet?method=getBook&id=${book.id }&pn=${page.pageNo}">修改</a></td>
					<td><a class="delBtn" href="manager/BookManagerServlet?method=delete&id=${book.id }&pn=${page.pageNo}">删除</a></td>
				</tr>
			</c:forEach>	
			
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/bookInsert.jsp">添加图书</a></td>
			</tr>	
		</table>
		
		<%@include file="/include/page.jsp" %>
	</div>
	
	
		
	<div id="bottom">
		<span>
			xxy.Copyright &copy;2020
		</span>
	</div>
</body>
</html>