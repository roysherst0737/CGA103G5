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
						<li class="breadcrumb-item active">Aviation</li>
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
									src="<%=request.getContextPath()%>/front-end/images/Aviation.jpg"
									width=500px height=600px alt="First slide">
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2>Aviation</h2>
						<p>這款調酒聽名字就知道和飛行有關，現在大家大多認為飛機之父是萊特兄弟，但事實上1901年，德國的Gustave
							Whitehead早駕著美國自製禿鷹號飛機飛上天際。1911年當飛行這件事不再是異想天開後，Aviation這款調酒開始在酒吧裡風行，不過得等到1916年Hugo
							Ensslin的《Recipes for Mixed Drinks》，這款酒才有了正式的酒譜記載。</p>

						<p>Brandon說這是一款非常經典的調酒，材料非常奇特，其中包含花香氣息非常重的紫羅蘭。加入少量紫羅蘭香甜酒後，除了顏色變化，整體都充滿了花香香氣，要調出一杯均衡好喝又經典的Aviation並不是件容易的事。「還有一個說法是當初紫羅蘭香甜酒Crème
							de
							Violette及黑櫻桃蒸餾酒Maraschino銷售狀況非常差，基於想要推銷的緣由，就把這幾款利口酒組合起來，創造出這款調酒。」他認為這款調酒呈現的花香、黑櫻桃香氣還有酸感都非常鮮明，很多人會因為怕甜，比如說非常甜的Maraschino就常被改成只加一點，但原始酒譜的比例才是讓這款酒達到平衡而鮮明的原因。</p>

						<p>「我有一位客人是個藝術家，以立可白作為媒材創作，曾經在韓國唸書，當時過得很苦，但偶爾也會去酒吧喝上一杯，最喜歡的就是Aviation，因為飛行者就是沒有框架不受拘束，他自己的作品也希望是這樣不被侷限的大膽創作。」後來這位藝術家回台灣後住內湖，所以來到大直的小後苑，隨口點了一杯Aviation，結果喝了之後感動落淚。「因為我會依循原始酒譜的比例來做酒，但他說從在韓國喝到這樣的味道後，去過很多酒吧都沒有找到原始的風味，可能多少都有一些調整，讓他很感動，彷彿回到在韓國辛苦磨練的那段時光，也找回了初心。」</p>
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