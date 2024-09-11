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
   <h3 class="text-center">총 <span style="color: green;font-size: 40px">
     <fmt:formatNumber value="${count }" pattern="#,###,###,###"/>
   </span>개의 맛있는 레시피가 있습니다.</h3>
   <div class="row">
    <c:forEach var="vo" items="${list }">
      <div class="col-md-3">
		    <div class="thumbnail">
		      <a href="../food/detail_before.do?fno=${vo.fno }">
		        <img src="https://www.menupan.com${vo.poster }" title="${vo.name}" style="width:230px;height: 150px">
		        <div class="caption">
		          <p>${vo.theme }</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </c:forEach>
   </div>
   <div style="height: 10px"></div>
   <div class="row">
     <div class="text-center">
       <ul class="pagination">
        <c:if test="${startPage>1 }">
         <li><a href="../food/list.do?page=${startPage-1 }">&lt;</a></li>
        </c:if>
        
        <c:forEach var="i" begin="${startPage }" end="${endPage }">
          <li ${i==curpage?"class=active":"" }><a href="../food/list.do?page=${i }">${i }</a></li>
        </c:forEach>
        
        <c:if test="${endPage<totalpage }">
         <li><a href="../food/list.do?page=${endPage+1}">&gt;</a></li>
        </c:if>
       </ul>
     </div>
   </div>
   <h3>방문한 레시피</h3>
   <a href="../food/cookie_all.do" class="btn btn-xs btn-primary">더보기</a>
   <hr>
   
</body>
</html>