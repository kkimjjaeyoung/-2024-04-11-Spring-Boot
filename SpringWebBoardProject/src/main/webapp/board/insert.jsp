<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
	<h3 class="text-center">글쓰기</h3>
		<div class="row">
		<form method="post" action="insert_ok.do"></form>
		<table class="table">
		<tr>
			<th class="text-right" width="20%">제목</th>
			<td width=80%>
				<input type=text name=subject size=5
			</td>
		</tr>
		<tr>
			<th class="text-right" width="20%"></th>
			<td width=80%>
				<input type=text name=subject size=5>
			</td>
		</tr>
		<tr>
			<th class="text-right" width="20%">비밀번호</th>
			<td width=80%>
				<input type=password name=pwd size=10 slass="input-sm">
			</td>
		</tr>
		<tr>
			<td colspan="2" class="text-center"
				<button
		</tr>
		</table>
		</div>
	</div>
</body>
</html>