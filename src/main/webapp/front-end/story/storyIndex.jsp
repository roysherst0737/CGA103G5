<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

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
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
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
					<h2>調酒故事</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/front-end/index.jsp">回首頁</a></li>
						<li class="breadcrumb-item active">調酒故事</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->


	<!-- !!!!!! 從以下開始修改到footer !!!!!!-->

	<div class="categories-shop">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="../images/OldFashioned.jpg" width="300px" height="200px" alt="" />
						<a class="btn hvr-hover" href="<%=request.getContextPath()%>/front-end/story/OldFashioned.jsp">Old Fashioned</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="../images/Martini.jpg" width="300px" height="200px" alt="" />
						<a class="btn hvr-hover" href="<%=request.getContextPath()%>/front-end/story/Martini.jsp">Martini</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="../images/GinTonic.jpg" width="300px" height="200px" alt="" />
						<a class="btn hvr-hover" href="<%=request.getContextPath()%>/front-end/story/GinTonic.jsp">Gin Tonic</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="../images/EspressoMartini.jpg" width="300px" height="200px" alt="" />
						<a class="btn hvr-hover" href="<%=request.getContextPath()%>/front-end/story/EspressoMartini.jsp">Espresso Martini</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="../images/Aviation.jpg" width="100px" height="100px" alt="" />
						<a class="btn hvr-hover" href="<%=request.getContextPath()%>/front-end/story/Aviation.jsp">Aviation</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="../images/Boulevardier.jpg" width="100px" height="100px" alt="" />
						<a class="btn hvr-hover" href="<%=request.getContextPath()%>/front-end/story/Boulevardier.jsp">Boulevardier</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="../images/HemingwayDaiquiri.jpg" width="100px" height="100px" alt="" />
						<a class="btn hvr-hover" href="<%=request.getContextPath()%>/front-end/story/HemingwayDaiquiri.jsp">Hemingway Daiquiri</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
					<div class="shop-cat-box">
						<img class="img-fluid" src="../images/LastWord.jpg" width="100px" height="100px" alt="" />
						<a class="btn hvr-hover" href="<%=request.getContextPath()%>/front-end/story/LastWord.jsp">Last Word</a>
					</div>
				</div>
			</div>
		</div>
	</div>

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