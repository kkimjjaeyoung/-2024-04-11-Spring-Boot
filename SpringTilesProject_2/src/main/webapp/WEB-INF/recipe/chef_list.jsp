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
		<table class="table">
		<tr>
			<td>
				<c:forEach var="vo" items="${list }">
					<table class="table">
					<tr>
						<td class="text-center" rowspan="2">
							<a href="../recipe/chef_make.do">
								<img src="${vo.poster }" style="width: 100px; height: 100px;" class="img-circle">
							</a>
						</td>
						<td colspan="4">
							<h3 style="color:orange;">
								<a href="../recipe/chef_make.do">
								${vo.chef }
								</a>
							</h3>
						</td>
					</tr>
					<tr>
						<td class="text-center"><img src="../images/m1.png">&nbsp;${vo.mem_cont1 }</td>
						<td class="text-center"><img src="../images/m2.png">&nbsp;${vo.mem_cont2 }</td>
						<td class="text-center"><img src="../images/m3.png">&nbsp;${vo.mem_cont7 }</td>
						<td class="text-center"><img src="../images/m4.png">&nbsp;${vo.mem_cont3 }</td>
					</tr>
					</table>
				</c:forEach>
			</td>
		</tr>
		</table>
	</div>
  <div style="height: 10px"></div>
  <div class="row">
    <div class="text-center">
      <ul class="pagination">
       <c:if test="${startPage>1 }">
        <li><a href="../recipe/chef_list.do?page=${startPage-1 }">&lt;</a></li>
       </c:if>
       
       <c:forEach var="i" begin="${startPage }" end="${endPage }">
        <li ${i==curpage?"class=active":""}><a href="../recipe/chef_list.do?page=${i }">${i }</a></li>
       </c:forEach>
       
       <c:if test="${endPage<totalpage }">
        <li><a href="../recipe/chef_list.do?page=${endPage+1 }">&gt;</a></li>
       </c:if>
      </ul>
    </div>
  </div>
</body>
</html>