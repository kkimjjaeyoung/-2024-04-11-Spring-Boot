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
   <div class="container">
     <h3 class="text-center">�۾���</h3>
     <div class="row">
     <form method="post" action="../board/insert_ok.do">
      <table class="table">
        <tr>
         <th class="text-right" width=20%>�̸�</th>
         <td width=80%>
           <input type=text name=name size=20 class="input-sm">
         </td>
        </tr>
        <tr>
         <th class="text-right" width=20%>����</th>
         <td width=80%>
           <input type=text name=subject size=50 class="input-sm">
         </td>
        </tr>
        <tr>
         <th class="text-right" width=20%>����</th>
         <td width=80%>
           <textarea rows="10" cols="50" name="content"></textarea>
         </td>
        </tr>
        <tr>
         <th class="text-right" width=20%>��й�ȣ</th>
         <td width=80%>
           <input type=password name=pwd size=10 class="input-sm">
         </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <button class="btn-sm btn-info">�۾���</button>
            <input type=button class="btn-sm btn-warning"
              value="���" onclick="javascript:history.go(-1)">
          </td>
        </tr>
      </table>
      </form>
     </div>
   </div>
</body>
</html>