<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/custom.css">
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
					<h2>經典調酒故事</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a
							href="<%=request.getContextPath()%>/front-end/story/storyIndex.jsp">回前頁</a></li>
						<li class="breadcrumb-item active">Boulevardier</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start Shop Detail  -->
	<div class="shop-detail-box-main">
		<div class="container">
			<div class="row">
				<div class="col-xl-5 col-lg-5 col-md-6">
					<div id="carousel-example-1"
						class="single-product-slider carousel slide" data-ride="carousel">
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<img class="d-block w-100"
									src="<%=request.getContextPath()%>/front-end/images/Boulevardier.jpg"
									width=500px height=600px alt="First slide">
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2>Boulevardier</h2>
						<p>Boulevardier得從美國禁酒令談起。1920年代，有一位調酒師Harry
							McElhone受禁酒令影響因此從美國移民到巴黎，開了一間叫做Harry’s New York
							Bar的店，裡頭有位自己的老鄉熟客叫Erskine
							Gwynne，據說因為基本上是高富帥，在當時的巴黎夜生活裡獵豔無數，儼然就是一位花花公子；而他創立了一本雜誌名為 《The
							Boulevardier》，Harry就以Negroni為基礎，將其中琴酒換為美國波本威士忌，並用這本雜誌名稱來命名。</p>

						<p>Brandon說其實酒吧最常遇到的就是為情所困的客人，他非常喜歡出這杯調酒給這些人，因為酒譜裡的材料是有意思的，包括波本或是Rye威士忌、意大利的Campari，透過柑橘浸泡會帶些苦味，回甘則有柑橘甜香，再來是Vermouth。「其實亞洲人不太能接受調酒裡頭有苦味，往往會帶來藥水之類的負面想像；但假如你願意嘗試苦味，就會發現苦其實有更多層次，更多的意境可以去闡述這個味道。」</p>

						<p>他說bartender會觀察客人，常看到有人一直為感情所苦，聽來聽去每次都是被同樣的人傷害，就像有SOP一樣；但是如果你跳脫原本的思維框架，比如每次都被渣男騙，但為何你不給一旁的好男人一個機會呢？「我也常遇到有客人來威士忌吧但不喝威士忌，那我就問他喝過哪些威士忌，往往都只喝過一兩款，但今天威士忌有多少酒廠、多少風格，為什麼要因為一兩次不喜歡的威士忌經驗，就再也不喝了？或許你只是還沒找到你愛的那款威士忌，不是嗎？」</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Cart -->

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