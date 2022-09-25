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
<script
	src="<%=request.getContextPath()%>/front-end/pages/pub/js/open.js"></script>
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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<style>
	
@media (min-width: 600px)
  {
	 .main_div{
	display: flex;
	}
  }
#booking {
	display: block;
	width: 100px;
	padding: 20px;
	border-radius: 30px;
}

#open {
}

.img {
	height: 120px;
}

div.content-wrapper {
	display: flex;
	justify-content: center;
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

div.col-sm-12>button.btn-warning {
	background-color: #ffc107;
}

div.col-sm-12>button.btn-warning:hover {
	background-color: #e0a800;
}

.main-top {
	height: 53.5px;
}

.align-self-center, h1, .img, p, #open {
	text-align: left !important;
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
						<h1>${pub.pub_name}</h1>
						<div class="main_div">
							<div>
								<c:forEach var="pic" items="${pub.pub_pics }">
									<img class="img" src="${pic.pub_pic }">
								</c:forEach>

							</div>
							<div style="padding:10px">
								<p>可接受預約人數:${pub.pub_nop}</p>
								<p>${pub.pub_detail}</p>
								<p>評分:${pub.pub_rate_sum} &#9;&#9;評價人數:${pub.pub_ratetotal}</p>
								<p>
									地址:<a
										href="https://www.google.com/maps/place/${pub.pub_address}">${pub.pub_address}</a>
								</p>
							</div>
							<div style="padding:10px">
								<p>營業時間</p>
								<div id="open">${pub.pub_open}</div>
							</div>
							<div style="padding:10px">
								<a id="booking" href="<%=request.getContextPath()%>/PubBooking?pub_no=${pub.pub_no}" class="btn-secondary">前往預約</a>
							</div>
						</div>
						<script>setDivData(document.querySelector(`#open`))</script>
					</div>
				</div>
			</div>
		</div>
		<!-- 主內容 -->

	</div>
	<!-- End Gallery  -->

	<!-- Start Instagram Feed  -->


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