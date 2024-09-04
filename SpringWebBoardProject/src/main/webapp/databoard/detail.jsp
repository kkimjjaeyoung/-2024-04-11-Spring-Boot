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
		<h3 class="text-center">내용보기</h3>
			<div class="row">
				<table class="table">
					<tr>
						<th width=30% class=text-center>벊</th>
						<td width="20%" class=text-center>$</td>
						<th width=30% class=text-center>작성일</th>
						<td width="20%" class=text-center></td>
					</tr>
					<tr>
						<th width=30% class=text-center>이름</th>
						<td width="20%" class=text-center></td>
						<th width=30% class=text-center>조회수</th>
						<td width="20%" class=text-center></td>
					</tr>
					<tr>
						<th width=30% class=text-center>제목</th>
						<td colspan="3"></td>
					</tr>
					<tr>
					<c:if test="${vo.filecount!=0 }">
	        <tr>
	          <th width=20% class="text-center">첨부파일</th>
	          <td colspan="3">
	            <ul>
	              <c:forEach var="fname" items="${nList }" varStatus="s">
	                <li>${fname }(${cList[s.index]}Bytes)</li>
	              </c:forEach>
	            </ul>
	          </td>
	        </tr>
        </c:if>
        <tr>
          <td colspan="4" class="text-left" valign="top" height="200">
            <pre style="white-space: pre-wrap;background-color: white;border:none">${vo.content}</pre>
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
           <a href="#" class="btn btn-xs btn-danger">수정</a>
           <a href="#" class="btn btn-xs btn-success">삭제</a>
           <a href="list.do" class="btn btn-xs btn-primary">목록</a>
          </td>
        </tr>
      </table>
			</div>
	</div>
</body>
</html>