<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width: 960px;
}
img:hover{
  opacity: 0.3
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">자유게시판</h3>
			<div class="row">
				<table class="table">
				<tr>
					<td>
						<a href="insert.do" class="btn btn-sm btn-primary">새글</a>
					</td>
				</tr>
				</table>
				<table class="table table-hover">
				<tr>
					<th width=10% class="text-center">번호</th>
					<th width=45% class="text-center">제목</th>
					<th width=15% class="text-center">이름</th>
					<th width=20% class="text-center">작성일</th>
					<th width=10% class="text-center">조회수</th>
				</tr>
				<c:set var="count" value="${count }"/>
				<c:forEach var="vo" items="${list }">
				<tr>
					<th width=10% class="text-center">${count }</th>
					<th width=45% >${vo.subject }</th>
					<th width=15% class="text-center">${vo.name }</th>
					<th width=20% class="text-center">${vo.dbday }</th>
					<th width=10% class="text-center">${vo.hit }</th>
				</tr>
				<c:set var="count" value="${count-1 }"/>
				</c:forEach>
				</table>
				<table class="table">
				<tr>
					<td class="text-center">
						<a href="#" class="btn btn-sm btn-danger">이전</a>
							${curpage } page / ${totalpage } pages
						<a href="#" class="btn btn-sm btn-danger">이전</a>
					</td>	
				</tr>
				</table>
			</div>
	</div>
</body>
</html>