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
<!-- ****** Breadcumb Area Start ****** -->
    <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>레시피 목록</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home" aria-hidden="true"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Archive Page</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ****** Breadcumb Area End ****** -->

    <!-- ****** Archive Area Start ****** -->
    <section class="archive-area section_padding_80">
        <div class="container">
            <div class="row">

               
                <!-- Single Post -->
                <c:forEach var="vo" item="${list }">
                <div class="col-12 col-md-6 col-lg-4">
                    <div class="single-post wow fadeInUp" data-wow-delay="1.2s">
                        <!-- Post Thumb -->
                        <div class="post-thumb">
                            <img src="${vo.poster }">
                        </div>
                        <!-- Post Content -->
                        <div class="post-content">
                            <div class="post-meta d-flex">
                                <div class="post-author-date-area d-flex">
                                    <!-- Post Author -->
                                    <div class="post-author">
                                        <a href="${vo.chef }">By Marian</a>
                                    </div>
                                    <!-- Post Date -->
                                    <div class="post-date">
                                        <a href="#">May 19, 2017</a>
                                    </div>
                                </div>
                                <!-- Post Comment & Share Area -->
                                <div class="post-comment-share-area d-flex">
                                    <!-- Post Favourite -->
                                    <div class="post-favourite">
                                        <a href="#"><i class="fa fa-heart-o" aria-hidden="true"></i> 0</a>
                                    </div>
                                    <!-- Post Comments -->
                                    <div class="post-comments">
                                        <a href="#"><i class="fa fa-comment-o" aria-hidden="true"></i> 0</a>
                                    </div>
                                    <!-- Post Share -->
                                    <div class="post-share">
                                        <a href="#"><i class="fa fa-share-alt" aria-hidden="true"></i></a>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <h4 class="post-headline">${vo.title }</h4>
                            </a>
                        </div>
                    </div>
                </div>
                </c:forEach>

                <div class="col-12">
                    <div class="pagination-area d-sm-flex mt-15">
                        <nav aria-label="#">
                            <ul class="pagination">
                            <c:if test="${startPage>1 }">
                            <c:forEach>
                                <li class="page-item active" >
                                    <a class="page-link" href="../recipe/list.do?page=${startPage-1 }">1 <span class="sr-only">(current)</span></a>
                                </li>
                            </c:if>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                            </c:forEach>
                                <c:if test="${endPage<totalpage }">
                                <li class="page-item">
                                    <a class="page-link" href="../recipe/list.do?page=${endPage+1 }">Next <i class="fa fa-angle-double-right" aria-hidden="true"></i></a>
                                </li>
                                </c:if>
                            </ul>
                        </nav>
                        <div class="page-status">
                            <p>Page ${curpage } page / ${totalpage } pages</p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- ****** Archive Area End ****** -->
</body>
</html>