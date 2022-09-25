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
						<li class="breadcrumb-item active">Espresso Martini</li>
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
									src="<%=request.getContextPath()%>/front-end/images/EspressoMartini.jpg"
									width=500px height=600px alt="First slide">
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2>Espresso Martini</h2>
						<p>Espresso Martini的起源眾說紛紜，但最多人知道的，是由一位調酒大師Dick
							Bradsell所創造出來。某天他遇到了一位剛party完的女模（傳聞是Kate Moss或是Naomi
							Campbell，但Dick本人只說這位女模後來變成一位超級模特兒，並沒有說出身份），希望他出一杯調酒「讓我清醒，再把我灌醉。」
							(Wake me up, then fuck me
							up)當時他就站在咖啡機旁的吧台，靈機一動，咖啡不就能提神嗎？再加上那個年代什麼都要加Vodka的風潮，就這樣將兩個元素混合。有趣的是一開始這杯調酒叫Vodka
							Espresso，還是用一般用來加冰塊的威杯出酒，後來Dick Bradsell
							對這款調酒做些改良後，改用馬丁尼杯，也正式成為今天大家聽到的 Espresso
							Martini。而在這款調酒上通常會放三顆咖啡豆作為裝飾，代表健康、財富與幸福這三個元素。</p>

						<p>以往都是用espresso入酒，現在則有可能換成手沖咖啡，只是在呈現的方式上就必須更注意，畢竟手沖咖啡較有水感，和espresso短小精悍的口感跟份量相比大不同；但手沖咖啡的香氣層次就會非常豐富。</p>

						<p>Brandon曾經遇過一個苦中作樂的國考生客人，希望出一杯符合他心境的調酒，「我就出了這杯Espresso
							Martini，因為我很愛從有故事性的經典調酒中找尋相似之處。我想給這個客人的感覺是，當然現在準備考試的過程是很艱苦的，但等到結束後，得到了美好的結果，這個時候你就能陶醉於其中。」</p>
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