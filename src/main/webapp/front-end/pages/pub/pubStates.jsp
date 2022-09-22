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
					style="max-width: 100%; max-height: 400px">
					<div class="row g-0">
						<div class="col-md-4" style="display: flex">
							<div class="div_card ul${loop.index}"
								style="align-items: center;">
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
						<div class="col-md-8 container">
							<div class="card-body row container" style="height: 100%;">
								<div class="col" style="display: grid;">
									<div class="card-title row">${pubList.pub_name}</div>
									<div class="row">狀態： ${pubList.pub_status?"上架":"下架"}</div>
									<div class="row">審核狀態：${pubList.pub_application==0?"待審核":pubList.pub_application==1?"審核通過":"審核失敗"}</div>
									<div class="row card-text ">酒吧地址:${pubList.pub_address}</div>
									<div class="row card-text align-items-end">
										<small class="text-muted ">總評價:${pubList.pub_rate_sum}
											/ ${pubList.pub_ratetotal}人</small>
									</div>
								</div>
								<div class="col" style="display: grid;">
									<div class="row" style="grid-row-start: 1; grid-row-end: 2;">
										營業時間:</div>
									<div id="open${loop.index}" class="row"
										style="grid-row-start: 2; grid-row-end: 8; display: grid; float: right">${pubList.pub_open}</div>
									<script>setDivData(document.querySelector(`#open${loop.index}`))</script>
									<div class="row" style="grid-row-start: 9; grid-row-end: 10;">
										<button onclick="getdate(${pubList.pub_no})" type="button"
											class="btn" data-toggle="modal" data-target="#staticBackdrop">修改資料</button>
											<a href="<%=request.getContextPath()%>/lookbooking?pub_no=${pubList.pub_no}" class="btn">查看訂位</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<!-- Modal -->
			<div class="modal fade " id="staticBackdrop" data-backdrop="static"
				data-keyboard="false" tabindex="-1"
				aria-labelledby="staticBackdropLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="staticBackdropLabel">設定</h5>
							<button type="button" class="btn-close" data-dismiss="modal"
								aria-label="Close"
								style="border: 0px; background-color: aliceblue;">X</button>
						</div>
						<div class="modal-body">
							<div class=" grid-margin stretch-card">
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">酒吧基本資料</h4>
										<div style="display: flex; justify-content: space-around;">
											<p class="card-description">
												會員編號 : <span id="span_id"></span>
											</p>
											<p class="card-description">
												酒吧編號 : <span id="span_pub_no"></span>
											</p>
											<p class="card-description">
												酒吧狀態: <span id="span_pub_status"></span><span><button
														id="status_b" class="btn btn-danger b1"
														style="display: none">上架</button></span>
											</p>
										</div>
										<div class="form-floating mb-3">
											<input type="text" class="form-control" id="fpub_name"
												value="" placeholder="請填寫酒吧名稱"> <label
												for="fpub_name">酒吧名稱</label>
										</div>
										<div class="form-floating mb-3">
											<input type="number" class="form-control" id="fpub_nop"
												value="" placeholder="請填寫可接受預約人數"> <label
												for="fpub_nop">酒吧可接受預約人數</label>

										</div>
										<div class="form-floating mb-3">
											<input type="text" class="form-control" id="fpub_address"
												value="" placeholder="請填寫酒吧地址"> <label
												for="fpub_address">酒吧地址</label>
										</div>

										<div class="container px-4">
											<div class="row gx-5">
												<div class="col">
													<div class="form-floating mb-3">
														<input type="text" class="form-control" id="fpub_lng"
															value="" placeholder="經度"> <label for="fpub_lng">經度</label>
													</div>
												</div>
												<div class="col">
													<div class="form-floating mb-3">
														<input type="text" class="form-control" id="fpub_lat"
															value="" placeholder="緯度"> <label for="fpub_lat">緯度</label>
													</div>
												</div>
											</div>
										</div>

										<div class="form-floating mb-3">
											<input type="text" class="form-control" id="fpub_open"
												placeholder="營業時間" style="display: none">
											<div class="open_div">
												<label>營業時間 </label>
												<div style="border: 1px solid #e8eff9; padding: 10px;">
													<div id="div1" class="d1 o1">
														<div>星期一:</div>
														<button id="b1" type="button" class="btn btn-danger b1"
															>未設定</button>
													</div>
													<div id="div2" class="d1 o1">
														<div>星期二:</div>
														<button id="b2" type="button" class="btn btn-danger b1"
															 >未設定</button>
													</div>
													<div id="div3" class="d1 o1">
														<div>星期三:</div>
														<button id="b3" type="button" class="btn btn-danger b1"
															>未設定</button>
													</div>
													<div id="div4" class="d1 o1">
														<div>星期四:</div>
														<button id="b4" type="button" class="btn btn-danger b1"
															>未設定</button>
													</div>
													<div id="div5" class="d1 o1">
														<div>星期五:</div>
														<button id="b5" type="button" class="btn btn-danger b1"
															>未設定</button>
													</div>
													<div id="div6" class="d1 o1">
														<div>星期六:</div>
														<button id="b6" type="button" class="btn btn-danger b1"
															>未設定</button>
													</div>
													<div id="div7" class="d1 o1">
														<div>星期日:</div>
														<button id="b7" type="button" class="btn btn-danger b1"
															>未設定</button>
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div
												style="height: 240px; width: 100%; position: relative; margin: 10px;">
												<label>酒吧圖片</label> <img id="img_set"
													style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); height: 240px; max-width: 300px;"
													src="<%=request.getContextPath()%>/back-end/images/noPic.png"></img>
											</div>
											<input id="pub_img" type="file" name="img[]"
												class="file-upload-default"
												accept="image/gif, image/jpeg, image/png">
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
											<label for="fpub_detail">酒吧描述</label>
											<textarea class="form-control" placeholder="請填寫酒吧描述"
												id="fpub_detail" style="height: 100px"></textarea>
										</div>
									</div>
								</div>
							</div>
							<div class=" grid-margin stretch-card">
								<div class="card">
									<div class="card-body">
										<h4 class="card-title"></h4>
										<p class="card-description">廠商基本資料</p>

										<div class="form-group row">
											<label for="firm_name" class="col-sm-3 col-form-label">廠商名稱</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" value=""
													id="firm_name" placeholder="廠商名稱">
											</div>
										</div>
										<div class="form-group row">
											<label for="firm_addr" class="col-sm-3 col-form-label">廠商地址</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" value=""
													id="firm_addr" placeholder="廠商地址">
											</div>
										</div>
										<div class="form-group row">
											<label for="firm_tel_no" class="col-sm-3 col-form-label">廠商電話</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" value=""
													id="firm_tel_no" placeholder="廠商電話">
											</div>
										</div>
										<div class="form-group row">
											<label for="firm_email" class="col-sm-3 col-form-label">廠商電子郵件</label>
											<div class="col-sm-9">
												<input type="email" class="form-control" value=""
													id="firm_email" placeholder="廠商電子郵件">
											</div>
										</div>
										<div class="form-group row">
											<label for="firm_tax_id" class="col-sm-3 col-form-label">廠商統一編號</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" value=""
													id="firm_tax_id" placeholder="廠商統一編號">
											</div>
										</div>
										<div style="display:none">
											<p class="card-description" >
												審核狀態:<span style="display: none" id="span_pub_application"></span>
											</p>
											<div>
												<div style="margin: 20px">
													<input id="check_0" type="radio"
														class="form-check-input input" name="check_i" value="0"
														onclick="setCheckBox()"> <label for="check_0"
														style="width: 100%">待審核</label>

												</div>
												<div style="margin: 20px">
													<input id="check_1" type="radio"
														class="form-check-input input" name="check_i" value="1"
														onclick="setCheckBox()"> <label for="check_1"
														style="width: 100%">審核成功</label>
												</div>
												<div style="margin: 20px">
													<input id="check_2" type="radio"
														class="form-check-input input" name="check_i" value="2"
														onclick="setCheckBox()"> <label for="check_2"
														style="width: 100%">審核失敗</label>
												</div>
												<div id="pub_application_M_div" class="form-floating"
													style="display: none">
													<label for="pub_application_M">失敗原因</label>
													<textarea class="form-control" placeholder="請填寫失敗原因"
														id="pub_application_M" style="height: 100px"></textarea>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">

							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">取消</button>
							<button id="btn" type="button" class="btn btn-primary">修改</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 				彈跳視窗結束 -->

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
		src="<%=request.getContextPath()%>/back-end/js/getModel_noReadonly.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/file-upload.js"></script>


</body>

</html>