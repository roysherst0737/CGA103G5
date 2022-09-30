<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.forum.model.*"%>
<%@ page import="com.forum_article.model.*"%>

<%@ page import="com.prod.model.*"%>
<%@ page import="com.forum_article_report.model.*"%>
<%

Forum_Service forum_Svc = new Forum_Service();
List<Forum_VO> list1 = forum_Svc.getAll();
pageContext.setAttribute("list1", list1);

Forum_VO forum_VO = forum_Svc.getOneForum(Integer.parseInt(request.getQueryString()));
request.setAttribute("forum_VO", forum_VO);

Set<Forum_article_VO> set = forum_Svc.getForum_articleByForum(forum_VO.getFrm_no());
pageContext.setAttribute("set", set);


%>


<!DOCTYPE html>
<html lang="zh-Hant">
<!-- Basic(head都不用動) -->

<head>
<meta charset="utf-8">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>朧醴 LonelyBar</title>
<meta name="keywords" content="LonelyBar Index">
<meta name="description" content="This is template from Theme Wagon.">
<meta name="author" content="Theme Wagon">

<!-- Site Icons -->
<link rel="shortcut icon" href="../images/favicon.ico"
	type="image/x-icon">
<link rel="lonelybar-icon" href="../images/Logo2.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="../css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="../css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="../css/custom.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<style>
.btn {
	width: auto;
	height: auto;
}

#view {
	float: left;
}

#type {
	padding: 2px;
	font-size: 20px;
}
		h2 {
       	text-align: center;
		display: -webkit-box;
    	display: -ms-flexbox;
    	display: flex;
    	margin: 5% 20% 10px 15%;
    	text-shadow: 0 0 48px #000000;
    	font-family: 微軟正黑體;
    	font-size: 3vw;
    	font-weight: bolder;
    	font-stretch: normal;
    	font-style: normal;
    	line-height: 1.32;
    	letter-spacing: -2.72px;
     	color: #ffffff; 
    	width: 70%;
     	text-align: justify; 
    	}
</style>

</head>

<body>

	<div id=top_nav_mainTop>
		<%@ include file="/front-end/partials/_mainTop.jsp"%>
	</div>

	<!-- !!!!!! 從以下開始修改到Start Instagram Feed" !!!!!!-->

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
<!-- 					<h2>購物商城</h2> -->
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a
							href="<%=request.getContextPath()%>/front-end/forum/forum.jsp">討掄區</a></li>
						<li class="breadcrumb-item active">總覽</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<form id="table-style" class="frm" action="index.html" method="post">
		<table class="table table-bordered table-hover"
			style="border: 3px #cccccc solid; border-width: 3px 6px; padding: 5px;"
			cellpadding="50" border='10'>
			<div class="container">
				<div class="">
					<div class="card-body">
						<h2>${forum_VO.frm_name_no}</h2>
						<thead id="btn-style">
							<div class="" style="position: relative;" id="btn-style">
								<div class="btn btn-warning btn:hover"
								style="margin-bottom: 10px height:100%; position: absolute; bottom: 10px; right: 10px;">
								<a href="<%=request.getContextPath()%>/front-end/forum_article/new_frm_art.jsp">新增文章</a>
								</div>
							</div>
						</thead>
						<tbody class="tby" >
							<tr>
								<th width="300px">標題</th>
								<th>文章內容</th>
								<th width="300px">發布日期</th>
							</tr>
							<c:forEach var="forum_article_VO" items="${set}">
							<c:choose>
									<c:when test="${forum_article_VO.art_status==1}">
<%-- 									${forum_article_VO.forum_article_report_VO.rpt_result==1} --%>
										<tr>
											<td><a href="<%=request.getContextPath()%>/front-end/forum_article/show_frm_art.jsp?${forum_article_VO.frm_art_no}">${forum_article_VO.art_title}</td>
											<td><a href="<%=request.getContextPath()%>/front-end/forum_article/show_frm_art.jsp?${forum_article_VO.frm_art_no}">${forum_article_VO.art_content}</td>
											<td><a href="<%=request.getContextPath()%>/front-end/forum_article/show_frm_art.jsp?${forum_article_VO.frm_art_no}">${forum_article_VO.art_time}</td>
										</tr>
					
									</c:when>

							<c:otherwise><!-- 否則下架 -->

							</c:otherwise>
				
							</c:choose>
							</c:forEach>
						</tbody>				
					</div>
				</div>
		</table>
		<tfoot>
			<nav aria-label="Page navigation example"
				style="width: 15%; margin: 0 auto;">
				<ul class=" pagination" id="page-select">
					<li class="page-item"><a class="page-link" href="#!"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#!">1</a></li>
					<li class="page-item"><a class="page-link" href="#!">2</a></li>
					<li class="page-item"><a class="page-link" href="#!">3</a></li>
					<li class="page-item"><a class="page-link" href="#!"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</tfoot>

	</form>


	<!-- !!!!!!此行以下都不要修改!!!!!!-->
	<!-- Start Instagram Feed  -->
<!-- 	<div class="instagram-box"> -->
<%-- 		<%@ include file="/front-end/partials/_InstagramBox.jsp"%> --%>
<!-- 	</div> -->
	<!-- End Instagram Feed  -->
	<!-- Start Footer  -->
	<footer>
		<%@ include file="/front-end/partials/_footer.jsp"%>
	</footer>
	<!-- End Footer  -->

	<!-- Start copyright  -->
	<div class="footer-copyright">
		<p class="footer-company">
			All Rights Reserved. &copy; 2022 <a href="#">LonelyBar</a> Design By
			: <a href="https://html.design/">CGA103G5</a>
		</p>
	</div>
	<!-- End copyright  -->

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

	<!-- ALL JS FILES -->
	<script src="<%=request.getContextPath()%>/front-end/js/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script
		src="<%=request.getContextPath()%>/front-end/js/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/form-validator.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/bootsnav.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/baguetteBox.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/inewsticker.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/isotope.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/jquery.superslides.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/bootstrap-select.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/images-loded.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/contact-form-script.js"></script>
	<!-- 該文件需部屬較慢 -->
	<script id="customjs"
		src="<%=request.getContextPath()%>/front-end/js/custom.js"></script>
</body>

</html>