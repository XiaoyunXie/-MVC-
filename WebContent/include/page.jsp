<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <script type="text/javascript">
	$(function(){
		$("#gotopage").click(function(){
			//用户输入了去第几页
			//获取用户输入的值
			var pn = $("#pn_input").val();
			//发送新的分页请求
			//location对象
			window.location.href = "${page.url}&pn="+pn;
		});
	});
	
</script>

<div id="page_nav">
		<a href="${page.url }&pn=1">首页</a>
		<c:if test="${page.hasPrev }">
			<a href="${page.url }&pn=${requestScope.page.pageNo-1}">上一页</a>
		</c:if>
		
		
		<!-- 总页码在5页以内 -->
		<c:if test="${page.totalPage<=5 }">
			<!-- 给begin和end动态赋值 -->
			<c:set var="begin" value="1" scope="page"></c:set>
			<c:set var="end" value="${page.totalPage }" scope="page"></c:set>
		</c:if>

		<!-- 总页码在5页以上 -->
		<c:if test="${page.totalPage>5 }">
			<!-- 当前页码在3页以内 -->
			<c:if test="${page.pageNo<= 3 }">
				<c:set var="begin" value="1" scope="page"></c:set>
				<c:set var="end" value="5" scope="page"></c:set>
			</c:if>
			
			<!-- 当前页码大于3 -->
			<c:if test="${page.pageNo> 3 }">
				<c:set var="begin" value="${page.pageNo-2 }" scope="page"></c:set>
				<c:set var="end" value="${page.pageNo+2 }" scope="page"></c:set>
			</c:if>
			<!-- 当前页码加2大于总页码时 end到总页码结束 begin 总页码减4 -->
			<c:if test="${page.pageNo+2>=page.totalPage }">
				<c:set var="begin" value="${page.totalPage-4 }" scope="page"></c:set>
				<c:set var="end" value="${page.totalPage }" scope="page"></c:set>
			</c:if>
		</c:if>
		<!-- 显示所有页码，总页码totalpage -->
		<c:forEach begin="${begin }" end="${end}" var="pnum">
			
			<!-- 判断当前遍历的页码号是否为当前页码，是--不加链接 -->
			<c:if test="${pnum == page.pageNo }">
				<span style="color:blue;">【${page.pageNo }】</span>
			</c:if>
			<c:if test="${pnum != page.pageNo }">
				<a href="${page.url }&pn=${pnum }">${pnum }</a>
			</c:if>
		</c:forEach>
		
		
		
		
		<c:if test="${page.hasNext }">
			<a href="${page.url }&pn=${requestScope.page.pageNo+1}">下一页</a>
		</c:if>
		<a href="${page.url }&pn=${requestScope.page.totalPage}">末页</a>
		共${ requestScope.page.totalPage}页，${ requestScope.page.totalCount}条记录
		</div>