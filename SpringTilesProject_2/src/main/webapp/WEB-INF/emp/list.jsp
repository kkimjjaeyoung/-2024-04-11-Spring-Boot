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
			<th class="text-center">���</th>
			<th class="text-center">�̸�</th>
			<th class="text-center">����</th>
			<th class="text-center">�Ի���</th>
			<th class="text-center">�޿�</th>
			<th class="text-center">�μ���</th>
			<th class="text-center">�ٹ���</th>
		</tr>
		<c:forEach var="vo" items="${list }">
		<tr>
			<td class="text-center">${vo.empno }</td>
			<td class="text-center"><a href="../emp/detail.do?empno=${empno}">${vo.ename }</a></td>
			<td class="text-center">${vo.job }</td>
			<td class="text-center">${vo.dbday }</td>
			<td class="text-center">${vo.dvo.dname }</td>
			<td class="text-center">${vo.dvo.loc }</td>
			<td class="text-center">${vo.svo.grade } </td>
		</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>