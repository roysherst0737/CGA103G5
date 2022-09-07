<%@ page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%@ page import="com.act.model.*"%>

<%

Act_Service actSvc = new Act_Service();
Act_VO actVO = actSvc.getOneAct(Integer.parseInt(request.getQueryString()));

request.setAttribute("actVO", actVO);
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
					<h2>Shop Detail</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Shop</a></li>
						<li class="breadcrumb-item active">Shop Detail</li>
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
								<img
									src="<%=request.getContextPath()%>/Show_Act_pic_Servlet?act_pic_no=${actVO.act_picVO.act_pic_no}"
									width=300px height=200px>
							</div>

						</div>

						<ol class="carousel-indicators">
							<li data-target="#carousel-example-1" data-slide-to="0"
								class="active"><img class="d-block w-100 img-fluid"
								src="images/smp-img-01.jpg" alt="" /></li>
							<li data-target="#carousel-example-1" data-slide-to="1"><img
								class="d-block w-100 img-fluid" src="images/smp-img-02.jpg"
								alt="" /></li>
							<li data-target="#carousel-example-1" data-slide-to="2"><img
								class="d-block w-100 img-fluid" src="images/smp-img-03.jpg"
								alt="" /></li>
						</ol>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2><%=actVO.getAct_name()%></h2>
						<h5>
							<del>$ 60.00</del>
							$40.79
						</h5>
						<p class="available-stock">
							<span> More than 20 available / <a href="#">8 sold </a></span>
						<p>
						<h4>活動內容:</h4>
						<p><%=actVO.getAct_detail()%></p>
						<ul>
							<li>
								<div class="form-group quantity-box">
									<label class="control-label">Quantity</label> <input
										class="form-control" value="0" min="0" max="20" type="number">
								</div>
							</li>
						</ul>

						<div class="price-box-bar">
							<div class="cart-and-bay-btn">
								<a class="btn hvr-hover" data-fancybox-close="" href="#">Buy
									New</a> <a class="btn hvr-hover" data-fancybox-close="" href="#">Add
									to cart</a>
							</div>
						</div>

						<div class="add-to-btn">
							<div class="add-comp">
								<a class="btn hvr-hover" href="#"><i class="fas fa-heart"></i>
									Add to wishlist</a> <a class="btn hvr-hover" href="#"><i
									class="fas fa-sync-alt"></i> Add to Compare</a>
							</div>
							<div class="share-bar">
								<a class="btn hvr-hover" href="#"><i class="fab fa-facebook"
									aria-hidden="true"></i></a> <a class="btn hvr-hover" href="#"><i
									class="fab fa-google-plus" aria-hidden="true"></i></a> <a
									class="btn hvr-hover" href="#"><i class="fab fa-twitter"
									aria-hidden="true"></i></a> <a class="btn hvr-hover" href="#"><i
									class="fab fa-pinterest-p" aria-hidden="true"></i></a> <a
									class="btn hvr-hover" href="#"><i class="fab fa-whatsapp"
									aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>



			<div class="row my-5">
				<div class="col-lg-12">
					<div class="title-all text-center">
						<h1>Featured Products</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Sed sit amet lacus enim.</p>
					</div>
					<div class="featured-products-box owl-carousel owl-theme">
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="images/img-pro-01.jpg" class="img-fluid" alt="Image">
									<div class="mask-icon">
										<ul>
											<li><a href="#" data-toggle="tooltip"
												data-placement="right" title="View"><i
													class="fas fa-eye"></i></a></li>
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
								<div class="why-text">
									<h4>Lorem ipsum dolor sit amet</h4>
									<h5>$9.79</h5>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="images/img-pro-02.jpg" class="img-fluid" alt="Image">
									<div class="mask-icon">
										<ul>
											<li><a href="#" data-toggle="tooltip"
												data-placement="right" title="View"><i
													class="fas fa-eye"></i></a></li>
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
								<div class="why-text">
									<h4>Lorem ipsum dolor sit amet</h4>
									<h5>$9.79</h5>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="images/img-pro-03.jpg" class="img-fluid" alt="Image">
									<div class="mask-icon">
										<ul>
											<li><a href="#" data-toggle="tooltip"
												data-placement="right" title="View"><i
													class="fas fa-eye"></i></a></li>
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
								<div class="why-text">
									<h4>Lorem ipsum dolor sit amet</h4>
									<h5>$9.79</h5>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="images/img-pro-04.jpg" class="img-fluid" alt="Image">
									<div class="mask-icon">
										<ul>
											<li><a href="#" data-toggle="tooltip"
												data-placement="right" title="View"><i
													class="fas fa-eye"></i></a></li>
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
								<div class="why-text">
									<h4>Lorem ipsum dolor sit amet</h4>
									<h5>$9.79</h5>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="images/img-pro-01.jpg" class="img-fluid" alt="Image">
									<div class="mask-icon">
										<ul>
											<li><a href="#" data-toggle="tooltip"
												data-placement="right" title="View"><i
													class="fas fa-eye"></i></a></li>
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
								<div class="why-text">
									<h4>Lorem ipsum dolor sit amet</h4>
									<h5>$9.79</h5>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="images/img-pro-02.jpg" class="img-fluid" alt="Image">
									<div class="mask-icon">
										<ul>
											<li><a href="#" data-toggle="tooltip"
												data-placement="right" title="View"><i
													class="fas fa-eye"></i></a></li>
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
								<div class="why-text">
									<h4>Lorem ipsum dolor sit amet</h4>
									<h5>$9.79</h5>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="images/img-pro-03.jpg" class="img-fluid" alt="Image">
									<div class="mask-icon">
										<ul>
											<li><a href="#" data-toggle="tooltip"
												data-placement="right" title="View"><i
													class="fas fa-eye"></i></a></li>
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
								<div class="why-text">
									<h4>Lorem ipsum dolor sit amet</h4>
									<h5>$9.79</h5>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="products-single fix">
								<div class="box-img-hover">
									<img src="images/img-pro-04.jpg" class="img-fluid" alt="Image">
									<div class="mask-icon">
										<ul>
											<li><a href="#" data-toggle="tooltip"
												data-placement="right" title="View"><i
													class="fas fa-eye"></i></a></li>
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
								<div class="why-text">
									<h4>Lorem ipsum dolor sit amet</h4>
									<h5>$9.79</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- End Cart -->

	<!-- Start Instagram Feed  -->
	<div class="instagram-box">
		<div class="main-instagram owl-carousel owl-theme">
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-01.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-02.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-03.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-04.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-05.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-06.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-07.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-08.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-09.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-05.jpg" alt="" />
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