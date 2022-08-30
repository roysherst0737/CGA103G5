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
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
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

<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/css/vertical-layout-light/style.css">
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
					<h2>酒吧註冊申請</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item active">酒吧註冊申請</li>
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
		</div>
		<!-- 主內容 -->
		<div class="main-panel">
			<div class="content-wrapper">
				<form class="forms-sample">
					<div class="row">
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">廠商申請表單</h4>
									<p class="card-description">酒吧基本資料</p>
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="fpub_nop"
											placeholder="pub_nop"> <label for="fpub_nop">酒吧可接受預約人數</label>
									</div>
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="fpub_address"
											placeholder="pub_address"> <label for="fpub_address">pub_address</label>
									</div>
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="fpub_open"
											placeholder="pub_open"> <label for="fpub_open">pub_open</label>
									</div>
									<div class="form-floating">
										<textarea class="form-control" placeholder="pub_detail"
											id="fpub_detail" style="height: 100px"></textarea>
										<label for="fpub_detail">pub_detail</label>
									</div>
									<div class="form-check form-check-flat form-check-primary">
										<label class="form-check-label"> <input
											type="checkbox" class="form-check-input"> Remember me
										</label>
									</div>
									<button type="submit" class="btn btn-primary mr-2">Submit</button>
									<button class="btn btn-light">Cancel</button>
								</div>
							</div>
						</div>
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Horizontal Form</h4>
									<p class="card-description">Horizontal form layout</p>

									<div class="form-group row">
										<label for="exampleInputUsername2"
											class="col-sm-3 col-form-label">Email</label>
										<div class="col-sm-9">
											<input type="text" class="form-control"
												id="exampleInputUsername2" placeholder="Username">
										</div>
									</div>
									<div class="form-group row">
										<label for="exampleInputEmail2"
											class="col-sm-3 col-form-label">Email</label>
										<div class="col-sm-9">
											<input type="email" class="form-control"
												id="exampleInputEmail2" placeholder="Email">
										</div>
									</div>
									<div class="form-group row">
										<label for="exampleInputMobile"
											class="col-sm-3 col-form-label">Mobile</label>
										<div class="col-sm-9">
											<input type="text" class="form-control"
												id="exampleInputMobile" placeholder="Mobile number">
										</div>
									</div>
									<div class="form-group row">
										<label for="exampleInputPassword2"
											class="col-sm-3 col-form-label">Password</label>
										<div class="col-sm-9">
											<input type="password" class="form-control"
												id="exampleInputPassword2" placeholder="Password">
										</div>
									</div>
									<div class="form-group row">
										<label for="exampleInputConfirmPassword2"
											class="col-sm-3 col-form-label">Re Password</label>
										<div class="col-sm-9">
											<input type="password" class="form-control"
												id="exampleInputConfirmPassword2" placeholder="Password">
										</div>
									</div>
									<div class="form-check form-check-flat form-check-primary">
										<label class="form-check-label"> <input
											type="checkbox" class="form-check-input"> Remember me
										</label>
									</div>
									<button type="submit" class="btn btn-primary mr-2">Submit</button>
									<button class="btn btn-light">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<!-- content-wrapper ends -->
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
	<script src="<%=request.getContextPath()%>/back-end/js/template.js"></script>
</body>

</html>