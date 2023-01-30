<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.latest_news.model.*"%>


<%
Latest_news_Service latest_news_Svc = new Latest_news_Service();
List<Latest_news_VO> list1 = latest_news_Svc.getAll();
pageContext.setAttribute("list1", list1);
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

.btn {
	width: auto;
	height: auto;
}

tbody.tby {
	text-align: center;
	font-family: Verdana;
	font-weight: 400;
	color: #404040;
	width: 964px;
	font-size: 13px;
	border-collapse: collapse;
}

table.td {table-hover;
	
}

h2 {
	text-align: center;
	color: #FF1C1C;
	margin: 3%;
	margin: 1em auto;
	margin-left: 8%;
	font-family: 微軟正黑體;
	font-size: 3vw;
	width: 80%;
}

#page-select {
	padding: 20px;
}

#table-style {
	padding: 20px;
}

.tab-list li .wrap, .tab-list li a {
	padding: 10px;
}

.tab-list li .wrap, .tab-list li a {
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	padding: 10px;
	-webkit-box-align: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: justify;
	-ms-flex-pack: justify;
	justify-content: space-between;
	position: relative;
	cursor: pointer;
}

@media ( max-width : 992px) {
	.tab-list li .wrap, .tab-list li a {
		padding: 15px;
	}
}

.tab-list li .wrap, .tab-list li a {
	display: -webkit-box;
	display: -ms-flexbox;
	display: flex;
	padding: 10px;
	-webkit-box-align: center;
	-ms-flex-align: center;
	align-items: center;
	-webkit-box-pack: justify;
	-ms-flex-pack: justify;
	justify-content: space-between;
	position: relative;
	cursor: pointer;
}

*, ::after, ::before {
	box-sizing: border-box;
}

.tab-list li .wrap i.news-label-1, .tab-list li a i.news-label-1 {
	background-color: #8c101f;
}

.tab-list li .wrap i.news-label-1, .tab-list li a i.news-label-1 {
	background-color: #8c101f;
}

@media ( max-width : 992px) {
	.tab-list li .wrap i, .tab-list li a i {
		font-size: 12px;
		min-width: 35px;
		height: 20px;
	}
}

.tab-list li .wrap i, .tab-list li a i {
	display: flex;
	color: rgb(255, 255, 255);
	width: 60px;
	height: 30px;
	font-family: 微軟正黑體;
	font-size: 10px;
	font-weight: 600;
	font-style: normal;
	-webkit-box-align: center;
	align-items: center;
	-webkit-box-pack: center;
	justify-content: center;
	border-radius: 2px;
}

@media ( max-width : 992px) {
	.tab-list li .wrap i, .tab-list li a i {
		font-size: 12px;
		min-width: 35px;
		height: 20px;
	}
}

.tab-list li .wrap i, .tab-list li a i {
	display: flex;
	color: rgb(255, 255, 255);
	width: 40px;
	height: 20px;
	font-family: 微軟正黑體;
	font-size: 12px;
	font-weight: 600;
	font-style: normal;
	-webkit-box-align: center;
	align-items: center;
	-webkit-box-pack: center;
	justify-content: center;
	border-radius: 2px;
}

@media ( max-width : 992px) {
	.tab-list li .wrap:after, .tab-list li a:after {
		left: 10px;
		width: calc(100% - 20px)
	}
}

.tab-list li .wrap:after, .tab-list li a:after {
	content: '';
	position: absolute;
	bottom: 0;
	left: 20px;
	height: 1px;
	width: calc(100% - 40px);
	border-bottom: 1px solid rgba(255, 255, 255, 0.5);
	color: black;
}

*, ::after, ::before {
	box-sizing: border-box;
}

#bottom-line {
	border-bottom: 1px solid #dee2e6 !important;
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
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->
	
	<!-- 標題 -->
	<div class="title-left text-center" style="margin: 50px; width: 1200px; margin-left: 100px;">
		<h2>最新資訊</h2>
	</div>
	
	<!-- 最新消息欄位 -->
	<form class="" action="index.html" method="post">
		<div id="table-style" class="card" style="margin: 4%;">
			<section class="my-container list-group-numbered">
				<div class="news-info-list-wrap">
					<ul class="news-info-list tab-list">
						<li onclick="getBullentin(1784)" data-toggle="modal"
							data-target="#newsModal">
							<c:forEach var="latest_news_VO"
								items="${list1}">
								<c:choose>
									<c:when test="${latest_news_VO.news_status==1}">
										<div class="wrap" id="bottom-line">
											<i class="news-label-1" id="height">NEW</i> <span
												class="content">${latest_news_VO.news_content}</span> <span
												class="date">${latest_news_VO.news_time}</span>
										</div>
									</c:when>
								</c:choose>
							</c:forEach>
									
 <form class="" action="index.html" method="post">
    <h2 class="card-title" style="color:white; margin-left:30px;">最新消息</h2>
    <div id="table-style" class="card" style="margin:30px;">
      <section class="my-container list-group-numbered">
        <div class="news-info-list-wrap">
          <ul class="news-info-list tab-list">
            <li onclick="getBullentin(1784)" data-toggle="modal" data-target="#newsModal">
            	<c:forEach var="latest_news_VO" items="${list1}">
            		<c:choose>
            			<c:when test="${latest_news_VO.news_status==1}">
              				<div class="wrap" id="bottom-line"><i class="news-label-1" id="height">NEW</i>
                				<span class="content">${latest_news_VO.news_content}</span>
                				<span class="date">${latest_news_VO.news_time}</span>
              				</div>
						</c:when>
									<c:otherwise>
										<!-- 否則下架 -->

									</c:otherwise>

								</c:choose>
							</c:forEach></li>
				</div>
			</section>
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
		</div>
	</form>

	<!-- !!!!!!此行以下都不要修改!!!!!!-->
	<!-- Start Instagram Feed  -->
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