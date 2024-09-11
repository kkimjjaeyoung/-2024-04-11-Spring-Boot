<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="row">
		<c:if test="${size==0 }">
			<h3 class="text-center">방문한 레시피가 없습니다</h3>
		</c:if>
		<c:if test="${size>0 }">
			<c:forEach var="vo" items="${cList }" varStatus="s">
   				<c:if test="${s.index<9 }">
   					<a href="../recipe/detail.do?no${vo.no }">
   					<img src="${vo.poster }" style="width: 100px; height: 100px;" title="${title }">
   					</a>
   				</c:if>
   			</c:forEach>
		</c:if>
	</div>
	<div style="height: 10px"></div>
	<div class="row">
		<div class="text-right">
			<a href="../recipe/cookie_delete.do" class="btn btn-sm btn-danger">삭제</a>
		</div>
	</div>
</body>
</html>