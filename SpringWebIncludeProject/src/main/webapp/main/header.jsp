<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SpringMVC</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">������
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../recipe/chef_list.do">����</a></li>
          <%--
          	����
          	1. do ��ũ
          	2. @Controller(.doó��)
          	3. ó��(mapper-dao-service)
          	4. @Controller(dao����-�����-jsp����)
          	5. jsp���� ȭ�� ���
          	
          	1. ���۹��(���� ���� Ȯ��)
          	2. �ڵ�����
          	3. �˻�
           --%>
          <li><a href="../recipe/find.do">������ ã��</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">����
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../food/list.do">��ü ����</a></li>
          <li><a href="../food/find.do">���� ã��</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">�����
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">��ü ��ǰ</a></li>
          <li><a href="#">��ǰ ã��</a></li>
        </ul>
      </li>
      <li><a href="#">�亯�� �Խ���</a></li>
    </ul>
  </div>
</nav>
</body>
</html>