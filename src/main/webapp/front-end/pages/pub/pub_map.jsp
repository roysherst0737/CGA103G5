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
.modal{
padding-right: 17px;}
.img_rate {
	width: 30px;
	vertical-align: middle;
}

.ipt_rate {
	position: absolute;
	width: 30px;
	height: 30px;
	opacity: 0;
}

.modal-content {
	background-color: azure;
}

#myimg {
	width: auto;
	height: 120px;
}

.myimg_div {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

#mydetail {
	width: 100%;
	height: auto;
	margin: 15px;
}

.datamsg {
	display: none;
}

.my_a {
	position: relative;
}

.mybtn, .mybtn1 {
	position: absolute;
	width: 100%;
	height: 100%;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: transparent;
	border: none;
}

#rate_li {
	text-align: center;
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
					<h2>酒吧地圖</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item active">酒吧地圖 /</li>
						<li>
						<li>
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
						</div>
					</div>
				</div>
			</div>

			<div class="row special-list">
				<c:forEach var="pubVO" items="${pubList}" varStatus="loop">
					<div
						class="col-lg-3 col-md-6 special-grid ${pubVO.pub_address.substring(0, 3)}">
						<div class="products-single fix">
							<div class="box-img-hover">
								<div class="type-lb">
									<p class="openType">${pubVO.pub_name}</p>
								</div>
								<c:forEach var="imgList" items="${pubVO.pub_pics}">
									<img src="${imgList.pub_pic}" class="img-fluid" alt="Image">
								</c:forEach>
								<div class="datamsg">
									<span class="pub_name">${pubVO.pub_name}</span> <span
										class="pub_no">${pubVO.pub_no}</span> <span class="pub_detail">${pubVO.pub_detail}</span>
									<span class="pub_name">${pubVO.pub_name}</span> <span
										class="pub_name">${pubVO.pub_name}</span> <span
										class="pub_name">${pubVO.pub_name}</span> <span
										class="pub_name">${pubVO.pub_name}</span> <span
										class="pub_name">${pubVO.pub_name}</span> <span
										class="pub_name">${pubVO.pub_name}</span> <span
										class="pub_name">${pubVO.pub_name}</span>
								</div>
								<div class="mask-icon">
									<ul>
										<li><a
											href="<%=request.getContextPath()%>/PubDetail?pub_no=${pubVO.pub_no}"
											data-toggle="tooltip" data-placement="right" title="詳細"><i
												class="fas fa-eye"></i>
												<button type="button" class="mybtn1"></button></a></li>
										<li id="rate_li"><a data-toggle="tooltip"
											data-placement="right" title="評分數">${pubVO.pub_rate_sum==null?"NA":pubVO.pub_rate_sum}<i
												class=""></i></a></li>
										<li><a class="my_a" id="i${loop.index}"
											data-toggle="tooltip" data-placement="right" title="一起來評分"><i
												class="far fa-heart"></i>
												<button type="button" class="mybtn" data-toggle="modal"
													data-target="#exampleModalCenter"></button></a></li>
									</ul>
									<a class="cart" href="<%=request.getContextPath()%>/PubBooking?pub_no=${pubVO.pub_no}">預約訂位</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
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

	<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="pub_no" style="display: none"></h5>
					<h5 class="modal-title" id="exampleModalLongTitle"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="myimg_div">
						<img id="myimg"></img> <span id="mydetail"></span>
					</div>
					<div style="text-align: center;">點擊留下評分</div>
					<div
						style="display: flex; justify-content: space-around; padding: 0px 100px 20px 100px;">
						<div style="position: relative;">
							<input type="radio" name="rate" value="1" class="ipt_rate">
							<img class="img_rate"
								src="<%=request.getContextPath()%>/front-end/images/str_yes.svg"></img>
						</div>
						<div style="position: relative;">
							<input type="radio" name="rate" value="2" class="ipt_rate">
							<img class="img_rate"
								src="<%=request.getContextPath()%>/front-end/images/str_yes.svg"></img>
						</div>
						<div style="position: relative;">
							<input type="radio" name="rate" value="3" class="ipt_rate">
							<img class="img_rate"
								src="<%=request.getContextPath()%>/front-end/images/str_yes.svg"></img>
						</div>
						<div style="position: relative;">
							<input type="radio" name="rate" value="4" class="ipt_rate">
							<img class="img_rate"
								src="<%=request.getContextPath()%>/front-end/images/str_yes.svg"></img>
						</div>
						<div style="position: relative;">
							<input type="radio" name="rate" value="5" class="ipt_rate"
								checked> <img class="img_rate"
								src="<%=request.getContextPath()%>/front-end/images/str_yes.svg"></img>
						</div>
					</div>
					<div>
						<textarea class="form-control" id="mem_rate" placeholder="請留下感想"></textarea>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">取消</button>
					<button id="rate_submit" type="button" class="btn btn-primary">提交評價</button>
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
	<script src="<%=request.getContextPath()%>/front-end/js/custom.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/pages/pub/js/pubmap.js"></script>
</body>

</html>