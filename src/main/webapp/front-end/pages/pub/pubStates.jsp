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
		function bb(opendiv){
				  		open = "000000000000001111111111";
			            open += "111000000001100000001101";
			            open += "000000001111001111111111";
			            open += "000110001111001111111100";
			            open += "000000000000000000000000";
			            open += "111111111111111111111111";
			            open += "110110001111001111111100";
			            let div = document.createElement('div');
			            str="";
			           const week= aa(open);
			           week.forEach(e=>{
			        	   str+="<div class='col align-self-center	' style>"+e+"</div>"
			           });
			        	   opendiv.innerHTML=str;
		}
		</script>
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
div.main_card{
	background-color: whitesmoke;
}
div.main_card:hover{
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
			<script>let count = 0</script>
			<c:forEach var="pubList" items="${pubList}" varStatus="loop">
				<div class="card mb-3 main_card"
					style="max-width: 100%; max-height:400px">
					<div class="row g-0">
						<div class="col-md-4" style="display: flex">
							<div class="div_card ul${loop.index}"style="align-items: center;">
								<script>count = 0</script>
								<c:forEach var="imgList" items="${pubList.pub_pics}"
									varStatus="listCount">
									<img class="img_card fab fa-opencart" src="${imgList.pub_pic}"
										alt="酒吧照片">
									<script>count = ${listCount.index}</script>
								</c:forEach>
								<script>
									if (count > 1) {
										$(`.ul${loop.index}`).inewsticker({
															speed : 3000,
															effect : 'fade',
															dir : 'ltr',
															font_size : 13,
															color : '#ffffff',
															font_family : 'Montserrat, sans-serif',
															delay_after : 1000
														});}
								</script>
							</div>
						</div>
						<div class="col-md-8 container" >
							<div class="card-body row container" style="height:100%;">
							<div class="col" style="display: grid;">
								<div class="card-title row">${pubList.pub_name}</div>
								<div class="row">狀態： ${pubList.pub_status?"上架":"下架"}</div>
								<div class="row">審核狀態：${pubList.pub_application==0?"待審核":pubList.pub_application==1?"審核通過":"審核失敗"}</div>
								<div class="row card-text ">酒吧地址:${pubList.pub_address}</div>
								<div class="row card-text align-items-end">
									<small class="text-muted ">總評價:${pubList.pub_rate_sum} /
										${pubList.pub_ratetotal}人</small>
								</div>
							</div>
							<div class="col" style="display: grid;">
								<div class="row" style="grid-row-start: 1;grid-row-end: 2;"> 營業時間:</div>
								<div id="open${loop.index}" class="row" style="grid-row-start: 2;grid-row-end: 8; display: grid;float:right"></div>
								<script>console.log(document.querySelector(`#open${loop.index}`))</script>
								<script>bb(document.querySelector(`#open${loop.index}`))</script>
								<div class="row" style="grid-row-start:9;grid-row-end: 10;"><button type="button" class="btn" data-toggle="modal" data-target="#exampleModal${loop.index}">查看詳情</button></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
<!-- 				彈跳視窗 -->
	<div class="modal fade" id="exampleModal${loop.index}" tabindex="-1" aria-labelledby="exampleModalLabel${loop.index}" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title${loop.index}</h5>
        <button type="button" class="close" data-dismiss="modal"aria-label="Close">X</button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<!-- 				彈跳視窗結束 -->
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
	<script 
		src="<%=request.getContextPath()%>/front-end/js/custom.js"></script>


</body>

</html>