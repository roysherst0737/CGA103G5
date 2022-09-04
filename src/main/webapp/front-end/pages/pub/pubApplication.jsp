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
						<li class="breadcrumb-item active">酒吧註冊申請 /</li>
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
						<h1>酒吧申請</h1>
						<p>一、請確實填寫資料。</p>
						<p>二、經審核後即可上架。</p>
					</div>
				</div>
			</div>
		</div>
		<!-- 主內容 -->
		<div class="main-panel">
			<div class="content-wrapper">
				<%-- 				<form class="forms-sample"  action="<%=request.getContextPath()%>/PubRegister" method="post"> --%>
				<form class="forms-sample">
					<div class="row">
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">廠商申請表單</h4>
									<p class="card-description">酒吧基本資料</p>
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="fpub_name"
											value="1" placeholder="pub_name"> <label
											for="fpub_name">酒吧名稱</label>
									</div>
									<div class="form-floating mb-3">
										<input type="number" class="form-control" id="fpub_nop"
											value="1" placeholder="pub_nop"> <label
											for="fpub_nop">酒吧可接受預約人數</label>

									</div>
									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="fpub_address"
											value="台北市" placeholder="pub_address"> <label
											for="fpub_address">酒吧地址</label>
									</div>

									<div class="container px-4">
										<div class="row gx-5">
											<div class="col">
												<div class="form-floating mb-3">
													<input type="text" class="form-control" id="fpub_lng"
														value="1" placeholder="pub_lng"> <label
														for="fpub_lng">經度</label>
												</div>
											</div>
											<div class="col">
												<div class="form-floating mb-3">
													<input type="text" class="form-control" id="fpub_lat"
														value="2" placeholder="pub_lat"> <label
														for="fpub_lat">緯度</label>
												</div>
											</div>
										</div>
									</div>

									<div class="form-floating mb-3">
										<input type="text" class="form-control" id="fpub_open"
											value="111" placeholder="pub_open"> <label
											for="fpub_open">營業時間</label>
									</div>
									<div class="form-group">
										<label>酒吧圖片</label> <input id="pub_img" type="file"
											name="img[]" class="file-upload-default" accept="image/gif, image/jpeg, image/png">
										<div class="input-group col-xs-12">
											<input type="text" class="form-control file-upload-info"
												disabled placeholder="Upload Image"> <span
												class="input-group-append">
												<button class="file-upload-browse btn btn-primary"
													type="button">上傳</button>
											</span>
										</div>
									</div>
									<div class="form-floating">
										<textarea class="form-control" placeholder="pub_detail"
											id="fpub_detail" style="height: 100px">detail</textarea>
										<label for="fpub_detail">酒吧描述</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title"></h4>
									<p class="card-description">廠商基本資料</p>

									<div class="form-group row">
										<label for="firm_name" class="col-sm-3 col-form-label">廠商名稱</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" value="酒吧"
												id="firm_name" placeholder="廠商名稱">
										</div>
									</div>
									<div class="form-group row">
										<label for="firm_addr" class="col-sm-3 col-form-label">廠商地址</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" value="台北111"
												id="firm_addr" placeholder="廠商地址">
										</div>
									</div>
									<div class="form-group row">
										<label for="firm_tel_no" class="col-sm-3 col-form-label">廠商電話</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" value="0111111111"
												id="firm_tel_no" placeholder="廠商電話">
										</div>
									</div>
									<div class="form-group row">
										<label for="firm_email" class="col-sm-3 col-form-label">廠商電子郵件</label>
										<div class="col-sm-9">
											<input type="email" class="form-control" value="0@a.a"
												id="firm_email" placeholder="廠商電子郵件">
										</div>
									</div>
									<div class="form-group row">
										<label for="firm_tax_id" class="col-sm-3 col-form-label">廠商統一編號</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" value="23225229"
												id="firm_tax_id" placeholder="廠商統一編號">
										</div>
									</div>
									<!-- 									<div class="form-check form-check-flat form-check-primary"> -->
									<!-- 										<label class="form-check-label"> <input -->
									<!-- 											type="checkbox" class="form-check-input"> Remember me -->
									<!-- 										</label> -->
									<!-- 									</div> -->
									<button id="btn" type="button" class="btn btn-primary mr-2" >確認送出</button>
									<button type="reset" class="btn btn-light" >重填</button>
								</div>
							</div>
						</div>
					</div>
				</form>


				<!-- Modal -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Lonely Bar</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">...</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">取消</button>
								<a style=" width: auto;height: auto;"
								 class="btn btn-primary"href="<%=request.getContextPath()%>/PubStates">確認</a>
							</div>
						</div>
					</div>
				</div>
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
	<script src="<%=request.getContextPath()%>/back-end/js/file-upload.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/pages/pub/js/register.js"></script>
</body>

</html>