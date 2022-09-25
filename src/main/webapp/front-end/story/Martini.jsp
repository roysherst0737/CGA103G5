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
						<li class="breadcrumb-item active">Martini</li>
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
									src="<%=request.getContextPath()%>/front-end/images/Martini.jpg"
									width=500px height=600px alt="First slide">
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2>Martini</h2>
						<p>這也是一款經典到已經不可考的調酒，有著許多故事，但你只需要知道它可是有「雞尾酒之王」的名號，江湖地位不言而喻。說到Martini為什麼會這麼紅，當然一定要提到007，在電影裡James
							Bond每次對bartender說出「shaken, not
							stirred.」時真是帥氣爆棚，。Brandon推薦這是一款適合資深或進階酒客的調酒，「真正的標準做法是用stirred，這樣帶來的酒體紮實，會放大酒本身的body跟風味，shaken能夠透過氣泡注入、融水量較多讓口感更滑順、清爽。所以007的這句台詞也真的能讓你學到一些東西，看當下你想要的是直接暖身完畢，還是要慢慢的輕鬆喝，可視需求和bartender溝通，調整手法。」</p>

						<p>Martini可以分為英系跟日系兩派，他說自己是比較日派的風格。英派為了要更紳士，通常會跟bartender強調要更「dry」，這在調酒裡的意思就是不甜，「我去英國時為了體驗，曾點了一杯天價Martini，bartender
							serving上來的方式，是推著一台推車，拿出一個非常冰的Martini杯，然後拿出一支凍過的Gin直接倒入，然後就結束了，非常有儀式感的出酒，但當下我真的是傻眼，想說我自己把琴酒丟到冷凍庫倒出來不也一樣嗎？」</p>

						<p>或者是調酒時改用Dry Vermouth入酒，但因為不甜的緣故，Dry
							Vermouth加進去後通常沒有太強烈的味道，甚至喝不太出來。至於日系調酒通常會有一個大原則，不管加什麼進去都要有原因，所以日系Martini不一定會問要不要Dry一點，而是用洗冰塊的手法，加入冰塊後再加Vermouth，攪拌後把Vermouth倒出來到另一個小杯中，才加入Gin；因為有甜度，在調酒裡會增加酒的厚度，這樣的Martini風味更加完整。</p>

						<p>至於Martini另一個不可或缺的元素橄欖，也有故事。以前的Gin大多都私釀，技術也不夠完備，雜味很多，所以早期的Martini大多都會把橄欖丟進去，壓掉那些雜味；但現在的琴酒味道都非常純粹細膩，如果把橄欖放進去反而是毀了一杯好的Martini，「現在我會把橄欖放在剛剛洗完冰塊後倒出來的Vermouth裡一起serving，還是可以吃到橄欖，但也不會破壞一杯Martini的平衡。」</p>
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