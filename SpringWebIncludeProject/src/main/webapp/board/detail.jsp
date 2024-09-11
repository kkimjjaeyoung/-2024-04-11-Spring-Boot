<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
    margin: 0px auto;
    width: 800px;
}
</style>
</head>
<body>
	<div class="row">
		<div>
			<table class="table">
			<tr>
				<th width="20%" class="text-center">��ȣ</th>
				<td width="30%" class="text-center">${vo.no }</td>
				<th width="20%" class="text-center">�ۼ���</th>
				<td width="30%" class="text-center">${vo.dbday }</td>
			</tr>
			<tr>
				<th width="20%" class="text-center">�̸�</th>
				<td width="30%" class="text-center">${vo.name }</td>
				<th width="20%" class="text-center">��ȸ��</th>
				<td width="30%" class="text-center">${vo.hit }</td>
			</tr>
			<tr>
				<th width="20%" class="text-center">����</th>
				<td colspan="3">${vo.subject }</td>
			</tr>
			<tr>
				<td colspan="4" class="text-left" valign="top" height="200">
					<pre style="white-space: pre-warp">${vo.content }></pre>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="text-left" valign="top" height="200">
					<a href="..board/reply.do?no=${vo.no }" class="btn btn-xs btb-danger">�亯</a>
					<a href="..board/update.do?no=${vo.no }" class="btn btn-xs btb-info">����</a>
					<a href="..board/delete.do?no=${vo.no }" class="btn btn-xs btb-success">����</a>
					<a href="../board/list.do" class="btn btn-xs btb-primary">���</a>
				</td>
			</tr>
			</table>
		</div>
	</div>
</body>
</html>