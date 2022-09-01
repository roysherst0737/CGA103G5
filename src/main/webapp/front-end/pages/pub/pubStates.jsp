<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
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
<link rel="shortcut icon" href="./images/favicon.ico"
	type="image/x-icon">
<link rel="lonelybar-icon" href="./images/Logo2.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front-end/css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front-end/css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front-end/css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front-end/css/custom.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front-end/css/pub.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<style>
a.booking {
	background: #f5c242;
	position: absolute;
	bottom: 0;
	left: 0px;
	padding: 10px 20px;
	font-weight: 700;
	color: #ffffff;
}

a.booking:hover {
	background: #000000;
	color: #ffffff;
}
</style>
</head>

<body>

	<!-- !!!!!! 可修改部分：從第142行開始到footer !!!!!!-->
	<div id=top_nav_banner>
		<%@ include file="/front-end/partials/_mainTop.jsp"%>
	</div>
	<!-- !!!!!! 從以下開始修改到footer !!!!!!-->

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>酒吧狀態查詢</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item active">酒吧狀態查詢 /</li>
						<li></li>
						<li class="breadcrumb-item"><a
							href="<%=request.getContextPath()%>/front-end">首頁</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start Gallery  -->
	<div class="products-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="title-all text-center">
						<h1>適度飲酒</h1>
						<p>一、飲酒勿開車。</p>
						<p>二、未滿十八歲者，禁止飲酒。</p>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="special-menu text-center">
						<div class="button-group filter-button-group">
							<button class="active" data-filter="*">All</button>
							<c:forEach var="pubAddress" items="${pubAddress}">
								<button data-filter=".${pubAddress}">${pubAddress}</button>
							</c:forEach>
							<!-- 							<button data-filter=".bulbs">Bulbs</button> -->
							<!-- 							<button data-filter=".fruits">Fruits</button> -->
							<!-- 							<button data-filter=".podded-vegetables">Podded	vegetables</button> -->
							<!-- 							<button data-filter=".root-and-tuberous">Root and tuberous</button> -->
						</div>
					</div>
				</div>
			</div>

			<div class="row special-list">
				<c:forEach var="pubVO" items="${pubList}">
					<div
						class="col-lg-3 col-md-6 special-grid ${pubVO.pub_address.substring(0, 3)}">
						<div class="products-single fix">
							<div class="box-img-hover">
								<div class="type-lb">
									<p class="openType">營業中</p>
								</div>
								<img
									src="<%=request.getContextPath()%>/back-end/images/noPic.png"
									class="img-fluid" alt="Image">
								<div class="mask-icon">
									<ul>
										<li><a href="#" data-toggle="tooltip"
											data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
										<li><a href="#" data-toggle="tooltip"
											data-placement="right" title="Compare"><i
												class="fas fa-sync-alt"></i></a></li>
										<li><a href="#" data-toggle="tooltip"
											data-placement="right" title="Add to Wishlist"><i
												class="far fa-heart"></i></a></li>
									</ul>
									<a class="cart" href="#">預約訂位</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				<div class="col-lg-3 col-md-6 special-grid bulbs">
					<div class="products-single fix">
						<div class="box-img-hover">
							<div class="type-lb">
								<p class="sale">Sale</p>
							</div>
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-01.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
								<a class="cart" href="#">Add to Cart</a>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid fruits">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-02.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid bulbs">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-03.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid fruits">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-04.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 special-grid bulbs">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-05.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid fruits">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-06.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid podded-vegetables">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-07.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid root-and-tuberous">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-08.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid root-and-tuberous">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-09.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid podded-vegetables">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-10.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid root-and-tuberous">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-11.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="col-lg-3 col-md-6 special-grid podded-vegetables">
					<div class="products-single fix">
						<div class="box-img-hover">
							<img
								src="<%=request.getContextPath()%>/front-end/images/gallery-img-12.jpg"
								class="img-fluid" alt="Image">
							<div class="mask-icon">
								<ul>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="View"><i class="fas fa-eye"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Compare"><i
											class="fas fa-sync-alt"></i></a></li>
									<li><a href="#" data-toggle="tooltip"
										data-placement="right" title="Add to Wishlist"><i
											class="far fa-heart"></i></a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Gallery  -->

	<!-- Start Instagram Feed  -->
	<div class="instagram-box">
		<div class="main-instagram owl-carousel owl-theme">
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-01.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-02.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-03.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-04.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-05.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-06.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-07.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-08.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-09.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/front-end/images/instagram-img-05.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Instagram Feed  -->

	<!-- !!!!!!此行以下都不要修改!!!!!!-->
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
		src="<%=request.getContextPath()%>/front-end/js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script
		src="<%=request.getContextPath()%>/front-end/js/jquery.superslides.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/bootstrap-select.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/inewsticker.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/bootsnav.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/images-loded.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/isotope.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/baguetteBox.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/form-validator.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/contact-form-script.js"></script>
	<script id="customjs"
		src="<%=request.getContextPath()%>/front-end/js/custom.js"></script>
</body>

</html>