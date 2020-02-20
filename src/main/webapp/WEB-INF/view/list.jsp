<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript">

function  order(flag){
	location="list?flag="+flag;
}

</script>
</head>
<body>
	<form action="list" method="post" >
	时间区间:<input type="date" name="start" value="${vo.start}">--<input type="date" name="end" value="${vo.end}">
	<input type="submit" value="搜索">
	<select name="way" onchange="way(this.value)">
          <option>--请选择--</option>
          <option value="created">评论量</option>
          <option value="hit">发布时间</option>
    </select> 
	<select name="flag" onchange="order(this.value)">
          <option value="asc">--请选择--</option>
          <option value="asc">升序</option>
          <option value="desc">降序</option>
    </select> 

	</form>
	<h1>列表</h1>
		
		<div>
					<c:forEach items="${info.list}" var="a">
						<div class="media">
							<a href="/article?id=${a.id}" target="_blank"><img src="/pic/${a.picture }" class="mr-3" alt="..."
								style="width: 156px; height: 101.8px"></a>
							<div class="media-body">
								<h5 class="mt-0"><a href="/article?id=${a.id}" target="_blank">${a.title }</a></h5>
								<h5 style="margin-top: 5px">${a.user.username}
										<fmt:formatDate value="${a.created}"
										pattern="yyyy-MM-dd HH:mm:ss" />
								</h5>
							</div>
						</div>
						<hr />
					</c:forEach>
	  </div>

	<div>
			<c:if test="${info.pages>0}">
				<c:if test="${info.pageNum>0}">
					<a href="list?pageNum=1">首页</a>
					<a href="list?pageNum=${info.pageNum-1}&start=${vo.start}&end=${vo.end}">上一页</a>
				</c:if>
				
				<c:forEach begin="1" end="${info.pages}" step="1" var="pageNo">
					<a href="list?pageNum=${pageNo}&start=${vo.start}&end=${vo.end}">${pageNo}</a>
				</c:forEach>
				
				<c:if test="${info.pageNum<=info.pages}">
					<a href="list?pageNum=${info.pageNum+1 }&start=${vo.start}&end=${vo.end}">下一页</a>
					<a href="list?pageNum=${info.pages }&start=${vo.start}&end=${vo.end}">尾页</a>
				</c:if>
			</c:if>
	</div>
</body>
</html>