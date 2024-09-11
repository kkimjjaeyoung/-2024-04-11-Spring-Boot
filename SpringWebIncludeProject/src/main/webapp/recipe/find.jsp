<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
.a{
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
</style>
</head>
<body>
	<div class="row">
	<form method="post" action="../recipe/find.do">
		<input type=text name=fd size=20 class="input-sm" value="#">
		<button class="btn-sm btn-primary">검색</button>
	</form>
	</div>
   <div class="row">
    <c:forEach var="vo" items="${list }">
      <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="../recipe/detail_before.do?no=${vo.no }">
		        <img src="${vo.poster }" title="${vo.title}" style="width:230px;height: 150px">
		        <div class="caption">
		          <p>${vo.chef }</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </c:forEach>
   </div>
   <div style="height: 10px"></div>
   <div class="row">
   	<div class="text-center">
   		<a href="../recipe/find.do=${fd}&page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-warning">이전</a>
   			${curpage } page / ${totalpage } pages
   		<a href="../recipe/find.do=${fd}&page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-warning">다음</a>
   	</div>
   </div>
</body>
</html>