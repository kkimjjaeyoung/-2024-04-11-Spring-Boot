<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="row" style="width: 350px;">
		<table class="table">
		<caption>��� �󼼺���</caption>
		<tr>
			<th width="30%" class="text-center">���</th>
			<td width="70%" class="text-center">${vo.empno }</td>
		</tr>
		<tr>
			<th width="30%" class="text-center">�̸�</th>
			<td width="70%" class="text-center">${vo.ename }</td>
		</tr>
		<tr>
			<th width="30%" class="text-center">����</th>
			<td width="70%" class="text-center">${vo.job }</td>
		</tr>
		<tr>
			<th width="30%" class="text-center">�Ի���</th>
			<td width="70%" class="text-center">${vo.dbday }</td>
		</tr>
		<tr>
			<th width="30%" class="text-center">�޿�</th>
			<td width="70%" class="text-center">${vo.sal }</td>
		</tr>
		<tr>
			<th width="30%" class="text-center">�μ���</th>
			<td width="70%" class="text-center">${vo.dvo.dname }</td>
		</tr>
		<tr>
			<th width="30%" class="text-center">�ٹ���</th>
			<td width="70%" class="text-center">${vo.dvo.loc }</td>
		</tr>
		<tr>
			<th width="30%" class="text-center">�޿����</th>
			<td width="70%" class="text-center">${vo.svo.grade }</td>
		</tr>
		<tr>
			<td colspan="2" class="text-center">
				<a href="javascript.:history.back()" class="btn btn-sm btn-danger">���</a>
			</td>
		</tr>
		</table>
	</div>
</body>
</html>