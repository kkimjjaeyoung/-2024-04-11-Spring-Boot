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
   width: 300px;
}
img:hover{
  opacity: 0.3
}
</style>
</head>
<body>
	<div class="container">
	<h3 class="text-center">�����ϱ�</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-center">
						��й�ȣ:<input type="password" name=pwd size=15 class="input-sm">
						<input type="hidden" name=no value="${no }">
					</td>
				</tr>
				<tr>
					<td class="text-center">
						<button class="btn btn-sm btn-warning">����</button>
						<button class="btn btn-sm btn-warning">���</button>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>