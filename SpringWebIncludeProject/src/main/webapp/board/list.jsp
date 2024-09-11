<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
      �� : ������ ���� 
           �帧 
            ��û / ���� 
             |     | ó�� ����� => ȭ�鿡 ��� (JSP)
            ����ڰ� ���� 
            ========== ����� ������ �����ͺ��̽����� ã�� 
      ������ 
        DI => Ŭ���� ��� 
              �ʿ�ÿ� ��������� �ʱ�ȭ : DI => setXxx() , ������ 
                                           p:         c:
               AI => ��������ó�� => �м� => ��� => ���� 
                                               ==== after���� �ַ� ����  
                     ========= ������ ���� : before 
        AOP => �������� ����Ǵ� ����� ���� => �ڵ����� ó�� => ���ͼ��� (�ڵ� �α���)
               = log���� / Ʈ����� / ���� 
               = � �޼ҵ忡 ���� (PointCut) 
               = �޼ҵ� ������ġ Ȯ�� (JoinPoint)
                 before / after / after-returning / after-throwing
                 public void dsiplay()
                 {
                    = ���� : Before
                    try
                    {
                    }catch(Exception ex)
                    {
                       => ���� : after-throwing
                    }
                    finally
                    {
                       after
                    }
                    return  after-returning
                 } 
               = ============================ Advice 
         MVC : 
            ��û ==> DispatcherServlet = HandlerMapping = Model = ViewResolver = View(JSP)
            ===                                          =====                  =========
            JSP = Model = JSP
                  =====
                    |
                    DB
          => ���̺귯�� : ���� (����) 
 --%>
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
     <h3 class="text-center">�亯�� �Խ���</h3>
     <div class="row">
      <table class="table">
       <tr>
        <td>
         <a href="../board/insert.do" class="btn btn-sm btn-primary">����</a>
        </td>
       </tr>
      </table>
      <table class="table table-hover">
       <tr>
        <th width=10% class="text-center">��ȣ</th>
        <th width=45% class="text-center">����</th>
        <th width=15% class="text-center">�̸�</th>
        <th width=20% class="text-center">�ۼ���</th>
        <th width=10% class="text-center">��ȸ��</th>
       </tr>
       <c:set var="count" value="${count }"/>
       <c:forEach var="vo" items="${list }">
         <tr>
            <td width=10% class="text-center">${count }</td>
	        <td width=45%>
	          <a href="../board/detail.do?no=${vo.no }">${vo.subject }</a>
	          &nbsp;
	          <c:if test="${today==vo.dbday }">
	            <sup><img src="../board/images/new.gif"></sup>
	          </c:if>
	        </td>
	        <td width=15% class="text-center">${vo.name}</td>
	        <td width=20% class="text-center">${vo.dbday }</td>
	        <td width=10% class="text-center">${vo.hit }</td>
         </tr>
         <c:set var="count" value="${count-1 }"/>
       </c:forEach>
      </table>
      <table class="table">
        <tr>
          <td class="text-center">
           <a href="#" class="btn btn-sm btn-danger">����</a>
             ${curpage } page / ${totalpage } pages
           <a href="#" class="btn btn-sm btn-danger">����</a>
          </td>
        </tr>
      </table>
     </div>
   </div>
</body>
</html>