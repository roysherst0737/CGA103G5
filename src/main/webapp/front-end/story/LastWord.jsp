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
						<li class="breadcrumb-item active">Last Word</li>
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
									src="<%=request.getContextPath()%>/front-end/images/LastWord.jpg"
									width=500px height=600px alt="First slide">
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2>Last Word</h2>
						<p>這款調酒有個很雅致的中文名稱「臨別一語」，Brandon笑說，當然也可以想成是因為它從基酒到其他附材料酒精度都很高，喝完就要說再見了。這個名字據說由美國一位Stand-up喜劇表演者（就是龍龍或是博恩那種一個人講一個段子那樣）Frank
							Fogarty而來，他的表演形式大多是以音樂開場，接著講段子，最後以朗誦結束。有次受訪，他自陳自己的演出重點就是簡潔有力，如果有任何贅字（Unnecessary
							Word）就會毀了一切。後來就從Unnecessary Word延伸為Last Word，好比最後一根稻草，而Last
							Word這款調酒由四種強烈風味的酒款調製，只要比例稍微不對，就會破壞了那完美的平衡。</p>

						<p>「我很喜歡這杯酒的原因是因為，臨別一語給人的感覺就好像要say good
							bye了，你還有什麼事情沒有完成，這是最後一個moment，接下來再也沒有能夠後悔的機會了。」這杯也是Brandon用來激勵我自己的一款調酒，或是想要鼓勵某個好像已經經歷了最糟糕一天的客人，又或者是那些對自己不了解的人。「因為已經到了最後關頭，你才會真正跟自己對話，去問自己還有什麼事情沒有做，還有什麼是自己想要做，但因為種種現實考量，而沒有去做因此產生悔恨？假如這一杯就是我的最後一杯酒，還有什麼事情這個當下非做不可的，不能再拖延的？這杯調酒可用來誠實地面對自己，跟自己最深處的對話。」</p>
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