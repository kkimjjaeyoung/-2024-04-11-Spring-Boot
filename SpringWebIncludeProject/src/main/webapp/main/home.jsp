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
   <h3 class="text-center">�� <span style="color: green;font-size: 40px">
     <fmt:formatNumber value="${count }" pattern="#,###,###,###"/>
   </span>���� ���ִ� �����ǰ� �ֽ��ϴ�.</h3>
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
       <ul class="pagination">
        <c:if test="${startPage>1 }">
         <li><a href="../main/main.do?page=${startPage-1 }">&lt;</a></li>
        </c:if>
        
        <c:forEach var="i" begin="${startPage }" end="${endPage }">
          <li ${i==curpage?"class=active":"" }><a href="../main/main.do?page=${i }">${i }</a></li>
        </c:forEach>
        
        <c:if test="${endPage<totalpage }">
         <li><a href="../main/main.do?page=${endPage+1}">&gt;</a></li>
        </c:if>
       </ul>
     </div>
   </div>
   <h3>�湮�� ������</h3>
   <a href="../recipe/cookie_all.do" class="btn btn-xs btn-primary">������</a>
   <hr>
   <div class="row">
    <c:if test="${size==0 }">
      <h3 class="text-center">�湮�� �����ǰ� �����ϴ�</h3>
    </c:if>
    <c:if test="${size>0 }">
      <c:forEach var="vo" items="${cList }" varStatus="s">
         <c:if test="${s.index<9 }">
          <a href="../recipe/detail.do?no=${vo.no }">
           <img src="${vo.poster}" style="width: 100px;height: 100px"
             title="${vo.title }">
          </a>
         </c:if>
      </c:forEach>
    </c:if>
   </div>
</body>
</html>