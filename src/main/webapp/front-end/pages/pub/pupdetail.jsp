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
button.b1{
	height: auto;
    padding: 5px;
}
div.o1{
padding:7px;
	display: flex;
    align-items: center;
    margin: 5px;
}
div.inside {
	padding-left:30px; 
	margin:0px;
	
}
div.d1{
border: 3px solid #e8eff9;  
border-radius:3px;
}
div.d1:hover{
border: 3px solid #d2b36b; 
}
div.row {
	margin:11px;
}
.open_div>div {
	padding-left: 30px;
}

.open_div>button {
	float: right;
}

div.col-sm-12>button.btn {
	width: 50px;
	height: 30px;
	padding: 0px;
	margin: 0px;
	font-weight: bolder;
}

div.col-sm-12>button.btn-warning {
	background-color: #ffc107;
}

div.col-sm-12>button.btn-warning:hover {
	background-color: #e0a800;
}

.main-top {
	height: 53.5px;
}

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
					<h2>酒吧詳情</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item active">酒吧詳情 /</li>
						<li></li>
						<li class="breadcrumb-item"><a
							href="<%=request.getContextPath()%>/PubMap">酒吧地圖</a></li>
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


				<!-- Modal1確認視窗 -->
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
								<a style="width: auto; height: auto;" class="btn btn-primary"
									href="<%=request.getContextPath()%>/PubStates">確認</a>
							</div>
						</div>
					</div>
				</div>

				<!-- Modal2確認視窗 -->
<!-- 				<div class="modal fade" id="exampleModal2" tabindex="-1" -->
<!-- 					role="dialog" aria-labelledby="exampleModalLabel" -->
<!-- 					aria-hidden="true"> -->
<!-- 					<div class="modal-dialog" role="document"> -->
<!-- 						<div class="modal-content"> -->
<!-- 							<div class="modal-header"> -->
<!-- 								<h5 class="modal-title" id="exampleModalLabel2">編輯營業時間</h5> -->
<!-- 								<button type="button" class="close" data-dismiss="modal" -->
<!-- 									aria-label="Close"> -->
<!-- 									<span aria-hidden="true">&times;</span> -->
<!-- 								</button> -->
<!-- 							</div> -->
<!-- 							<div class="modal-body1 container"> -->
<!-- 								<div class="row d1"> -->
<!-- 									<div class="col-6" style="display:flex;"> -->
<!-- 										<div style="display: flex; justify-content:center;align-items: center; "> -->
<!-- 											<label>星期一</label> -->
<!-- 										</div> -->
<!-- 										<div > -->
<!-- 											<div class="row inside"> -->
<!-- 												<input class="form-check-input" type="radio" name="m1" -->
<!-- 													id="M1all"> <label class="" for="M1all">24小時營業 -->
<!-- 												</label> -->
<!-- 											</div> -->
<!-- 											<div class="row inside"> -->
<!-- 												<input class="form-check-input" type="radio" name="m1" -->
<!-- 													id="m1off" checked> <label class="" for="m1off">休息</label> -->
<!-- 											</div> -->
<!-- 											<div class="row inside"> -->
<!-- 												<input class="form-check-input" type="radio" name="m1" -->
<!-- 													id="m1self"> <label class="" for="m1self">自選</label> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 									<div class="col-6" style="display:flex"> -->
<!-- 										<select class="form-select form-select-sm mb-0" aria-label=".form-select-lg example" style="height:30px; font-size: smaller;"> -->
<!-- 										  <option value="0">00:00</option> -->
<!-- 										  <option value="1">01:00</option> -->
<!-- 										  <option value="2">02:00</option> -->
<!-- 										  <option value="3">03:00</option> -->
<!-- 										  <option value="4">04:00</option> -->
<!-- 										  <option value="5">05:00</option> -->
<!-- 										  <option value="6">06:00</option> -->
<!-- 										  <option value="7">07:00</option> -->
<!-- 										  <option value="8">08:00</option> -->
<!-- 										  <option value="9">09:00</option> -->
<!-- 										  <option value="10">10:00</option> -->
<!-- 										  <option value="11">11:00</option> -->
<!-- 										  <option value="12">12:00</option> -->
<!-- 										  <option value="13">13:00</option> -->
<!-- 										  <option value="14">14:00</option> -->
<!-- 										  <option value="15">15:00</option> -->
<!-- 										  <option value="16">16:00</option> -->
<!-- 										  <option value="17">17:00</option> -->
<!-- 										  <option value="18">18:00</option> -->
<!-- 										  <option value="19">19:00</option> -->
<!-- 										  <option value="20">20:00</option> -->
<!-- 										  <option value="21">21:00</option> -->
<!-- 										  <option value="22">22:00</option> -->
<!-- 										  <option value="23">23:00</option> -->
<!-- 										  <option value="24">24:00</option> -->
<!-- 										</select> -->
<!-- 											<select class="form-select form-select-sm mb-0" aria-label=".form-select-lg example" style="height:30px;font-size: smaller;"> -->
<!-- 										  <option value="0">00:00</option> -->
<!-- 										  <option value="1">01:00</option> -->
<!-- 										  <option value="2">02:00</option> -->
<!-- 										  <option value="3">03:00</option> -->
<!-- 										  <option value="4">04:00</option> -->
<!-- 										  <option value="5">05:00</option> -->
<!-- 										  <option value="6">06:00</option> -->
<!-- 										  <option value="7">07:00</option> -->
<!-- 										  <option value="8">08:00</option> -->
<!-- 										  <option value="9">09:00</option> -->
<!-- 										  <option value="10">10:00</option> -->
<!-- 										  <option value="11">11:00</option> -->
<!-- 										  <option value="12">12:00</option> -->
<!-- 										  <option value="13">13:00</option> -->
<!-- 										  <option value="14">14:00</option> -->
<!-- 										  <option value="15">15:00</option> -->
<!-- 										  <option value="16">16:00</option> -->
<!-- 										  <option value="17">17:00</option> -->
<!-- 										  <option value="18">18:00</option> -->
<!-- 										  <option value="19">19:00</option> -->
<!-- 										  <option value="20">20:00</option> -->
<!-- 										  <option value="21">21:00</option> -->
<!-- 										  <option value="22">22:00</option> -->
<!-- 										  <option value="23">23:00</option> -->
<!-- 										  <option value="24">24:00</option> -->
<!-- 										</select> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
<!-- 							</div> -->
<!-- 							<div class="modal-footer"> -->
<!-- 								<button type="button" class="btn btn-secondary" -->
<!-- 									data-dismiss="modal">取消</button> -->
<!-- 								<button type="button" style="width: auto; height: auto;" -->
<!-- 									class="btn btn-primary" onclick="getOpenTime()">確認</button> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
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