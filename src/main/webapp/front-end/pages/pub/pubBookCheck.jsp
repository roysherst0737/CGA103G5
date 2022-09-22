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
<script
	src="<%=request.getContextPath()%>/front-end/pages/pub/js/open.js"></script>
<script src="<%=request.getContextPath()%>/front-end/js/inewsticker.js"></script>
<script>
		function setDivData(opendiv){
			            str="";
			           const week= aa(opendiv.textContent);
			           week.forEach(e=>{
			        	   str+="<div class='col align-self-center '>"+e+"</div>"
			           });
			        	   opendiv.innerHTML=str;
		}
		</script>
<style>
.container-fluid{
	padding:0px;
}
.col-lg-6{
	padding:0px;
}
.main-top {
	padding:0.1px;
}
.modal1{
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    z-index: 1050;
    display: none;
    overflow: hidden;
    outline: 0;
}
button.b1 {
	height: auto;
	padding: 5px;
}

div.o1 {
	padding: 7px;
	display: flex;
	align-items: center;
	margin: 5px;
}

div.inside {
	padding-left: 30px;
	margin: 0px;
}

div.d1 {
	border: 3px solid #e8eff9;
	border-radius: 3px;
}

div.d1:hover {
	border: 3px solid #d2b36b;
}

div.row {
	margin: 11px;
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

.modal-content {
	background-color: aliceblue;
}

.modal-body {
	display: flex;
	justify-content: space-evenly;
}

.btn-c {
	border-radius: 50%;
	border: 2px solid #e8eff9;
}

.btn-c:hover {
	border: 2px solid #266ed4;
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

img.img_card {
	max-height: 240px;
	min-height: 240px;
	max-width: 380px;
	margin: auto;
	padding: 10px;
}

div.div_card {
	height: 240px;
	min-height: 240px;
	min-width: 380px;
	min-width: 380px;
	margin: auto;
	display: flex;
	align-items: center;
	justify-content: center;
}

div.main_card {
	background-color: whitesmoke;
}

div.main_card:hover {
	background-color: antiquewhite;
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
					<h2>訂位查看</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item active">訂位查看 /</li>
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
<!-- 						<h1>適度飲酒</h1> -->
<!-- 						<p>一、飲酒勿開車。</p> -->
<!-- 						<p>二、未滿十八歲者，禁止飲酒。</p> -->
					</div>
				</div>
			</div>
			<c:forEach var="bookList" items="${bookList}" varStatus="loop">
				<div class="card mb-3 main_card"
					style="max-width: 100%; max-height: 400px">
						<div class="col-md-8 container">
							<div class="card-body row container" style="height: 100%;">
								<c:set var="Key" value="${bookList.pub_no}"/>
									<div class="card-title row">${namemap[Key]}</div>
									<div class="row">${bookList.pub_booking_date}</div>
									<div class="row">訂位時間：<span id="time">${bookList.pub_booking_time}</span></div>
						</div>
					</div>
				</div>
			</c:forEach>
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
	<script src="<%=request.getContextPath()%>/front-end/pages/pub/js/getTime.js"></script>
</body>

</html>