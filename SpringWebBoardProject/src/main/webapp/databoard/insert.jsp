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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let fileIndex=0
$(function(){
	$('#addBtn').on('click', function(){
		$('#file-tbody').append(
			'<tr id="f+fileIndex+'">'
			+'<td width="20%">File'+(fileIndex+1)+'</td>'
			+'<td width="80%"><input type="file" name="['+fileIndex+']" size="20"></td>'
			+'</tr>'
		)
	})
	$('#removeBtn').on('click',function(){
		if(fileIndex>0){
			$('#f'+(fileIndex-1)).remove()
			fileIndex--;
		}
	})
})
</script>
</head>
<body>
<div class="container">
     <h3 class="text-center">�۾���</h3>
     <div class="row">
     <form method="post" action="insert_ok.do">
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
          <th class="text-right" width=20%>÷������</th>
          <td width="80%">
           <table class="table">
             <tr>
              <td class="text-right">
               <input type=button class="btn-xs btn-danger" value="Add" id="addBtn">
               <input type=button class="btn-xs btn-primary" value="Remove" id="removeBtn">
              </td>
             </tr>
           </table>
           <table class="table" id="user-table">
             <tbody id="file-tbody">
              
             </tbody>
           </table>
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