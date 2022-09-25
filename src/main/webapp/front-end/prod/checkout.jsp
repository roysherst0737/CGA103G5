<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.prod.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.order.model.*"%>
<%@ page import="com.cart.model.*"%>

<%
Object Objuser2 = session.getAttribute("orderVO");
Order_VO orderVO = (Order_VO) Objuser2;
%>

<%
Prod_Service prodSvc = new Prod_Service();
List<Prod_VO> list = prodSvc.getAll();
pageContext.setAttribute("list", list);

Cart_Service cartSvc = new Cart_Service();
List<Cart_VO> cartlist = cartSvc.getAll();
pageContext.setAttribute("cartlist", cartlist);

Object Objuser = session.getAttribute("user");
Mem_VO user = (Mem_VO) Objuser;

if (user != null) {
	Order_Service orderSvc = new Order_Service();
	Set<Integer> orderSet = orderSvc.getCreateOrder((Integer) user.getMem_no());
	pageContext.setAttribute("orderSet", orderSet);
}

String url = request.getRequestURL().toString() + "?" + request.getQueryString();
session.setAttribute("url", url);

int i = 1;
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
<link rel="stylesheet" href="../css/custom.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script>
	// 商品總額加總
	(function($) {
    	$(window).on('load', function() {
        const total = document.querySelector("#amount");
        const totalFinal = document.querySelector("#amountFinal");
        let num = 0;
        document.querySelectorAll(".totalPrice").forEach(e =>{
        	num += parseInt(e.textContent);                                            				 
        });
        total.value = num;
        totalFinal.value = num;
    	});                                          
	}(jQuery));
</script>

<script>
	//使用優惠券
	(function () {
		$(window).on('load', function () {                    					
        	$('#useCoupon').on('click', function () {
            	let coupon_code=document.querySelector('#insertCoupon').value;
                let disAmount=document.querySelector('#disAmount');
                let amountFinal=document.querySelector('#amountFinal');                    						
                let json = JSON.stringify({
                	coupon_code: coupon_code,
                });  
                    					
                if(coupon_code === ""){
                	document.querySelector('#insertCoupon').classList.add('is-invalid');
                    alert("請輸入優惠碼");
                    return;
                } else {
                	document.querySelector('#insertCoupon').classList.remove('is-invalid');
                }
                fetch('Discount', {
                	method: 'POST',
                    headers: {
                    	'Content-Type': 'application/json',
                    },
                body: json,
                }).then(resp => resp.json())
                  .then(e => {
                  	if(e === null){
                    	alert("請輸入正確優惠碼");
                        	return;
                    	}
                    const { coupon_discount } = e;
                    if (coupon_discount < 1){
                    	disAmount.textContent = (coupon_discount*10) + "折";
                    	amountFinal.value = amountFinal.value * coupon_discount;
                    } else {
                    	disAmount.textContent = "折抵" + coupon_discount + "元";
                    	amountFinal.value = amountFinal.value - coupon_discount;
                    }                    								                   								
				});
			});
		});
	}(jQuery));
</script>

<style>
.btn {
	width: auto;
	height: auto;
}
#checkout {
	margin-left: auto;
	font-size: 20px;
	color: white;
}
#useCoupon {
	font-size: 16px;
}
#useCoupon:hover {
	color: red;
}
#deleteCart {
	font-size: 3px;
	color: red;
}
#detail:hover {
	color: red;
}
#detail:hover::after {
	margin-left: 12px;
	color: white;
	font-size: 12px;
	background: #f5c242;
	border-radius: 5px;
	content: '查看商品詳情';
}
#cartContent {
	font-size: 14px;
	font-weight: bold;
}
#insertCoupon.is-invalid {
	border-color: #dc3545;
	padding-right: calc(1.5em + 0.75rem);
	background-repeat: no-repeat;
	background-position: right calc(0.375em + 0.1875rem) center;
	background-size: calc(0.75em + 0.375rem) calc(0.75em + 0.375rem);
}
#boxCoupon {
	margin-top: 12px;
}
#detail {
	border-style: none;
	margin-bottom: 2px;
	font-weight: bold;
	width: 60px;
	background-color:transparent;
}
#detail1 {
	border-style: none;
	margin-bottom: 2px;
	font-weight: bold;
	width: 40px;
	background-color:transparent;
}
#detail2 {
	border-style: none;
	margin-bottom: 2px;
	font-weight: bold;
	width: 15px;
	background-color:transparent;
}
#goToCoupon {
	font-size: 14px;
	font-weight: bold;
	color: #f5c242;
}
#goToCoupon:hover {
	color:black;
}
</style>

</head>

<body>

	<div id=top_nav_banner>
		<%@ include file="/front-end/partials/_mainTop.jsp"%>
	</div>

	<!-- !!!!!! 從以下開始修改到Start Instagram Feed" !!!!!!-->

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>商品結帳</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a
							href="<%=request.getContextPath()%>/front-end/prod/shop.jsp">回商城</a></li>
						<li class="breadcrumb-item active">結帳</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start Checkout  -->
	<div class="cart-box-main">
	<FORM name="orderCreate" action="detail.do" method="post">
								<input type="hidden" name="action" value="createOrder">
		<div class="container">
			<!-- 會員登入欄位開始 -->
			<div class="row new-account-login">
				<div class="col-sm-6 col-lg-6 mb-3">
					<c:choose>
						<c:when test="${empty sessionScope.user}">
							<div class="title-left">
								<h3>會員登入</h3>
							</div>
							<h5>
								<a href="<%=request.getContextPath()%>/front-end/mem/login.jsp"
									style="color: #f5c242; font-size: 18px">您尚未登入，請點擊登入會員後方可結帳</a>
							</h5>
						</c:when>
						<c:otherwise>
							<div class="title-left">
								<h3>基本資訊填寫</h3>
							</div>
							<h5>
								<a style="color: #f5c242; font-size: 18px">為了提供完美的送貨服務，請填寫基本資料</a>
							</h5>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="col-sm-6 col-lg-6 mb-3">
					<c:choose>
						<c:when test="${empty sessionScope.user}">
							<div class="title-left">
								<h3>註冊新會員</h3>
							</div>
							<h5>
								<a
									href="<%=request.getContextPath()%>/front-end/mem/register.jsp"
									style="color: #f5c242; font-size: 18px">若您尚未註冊，請點擊加入我們！</a>
							</h5>
						</c:when>
						<c:otherwise>
							<div class="title-left">
								<h3>購買內容確認</h3>
							</div>
							<h5>
								<a style="color: #f5c242; font-size: 18px">確認購物車&消費金額，並輸入優惠券拿優惠！</a>
							</h5>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<!-- 會員登入欄位結束 -->
			
			
			<div class="row">

				<!-- 收貨資料開始 -->
				<div class="col-sm-6 col-lg-6 mb-3">
					<div class="checkout-address">
						<div class="title-left">
							<h3>收貨人資訊</h3>
						</div>
<!-- 						<FORM class="needs-validation" novalidate name="order" action="detail.do" method="post"> -->
							<div class="row">
								<div class="col-md-6 mb-3">
									<label for="firstName">收貨人姓名 *</label> <input type="text"
										name="receiver_name" class="form-control" id="firstName"
										placeholder="${user.mem_last_name}${user.mem_first_name}" onfocus="this.placeholder=''"
										value="<%=(orderVO == null) ? (user.getMem_last_name() + user.getMem_first_name()) : orderVO.getReceiver_name()%>">
									<div class="invalid-feedback">請輸入收貨人姓名</div>
								</div>
							</div>
							<div class="mb-3">
								<label for="username">收貨人電話 *</label>
								<div class="input-group">
									<input type="text" name="receiver_phone" class="form-control"
										id="username" placeholder="${user.mem_cel_no}" onfocus="this.placeholder=''"
										value="<%=(orderVO == null) ? (user.getMem_cel_no()) : orderVO.getReceiver_phone()%>"
										required>
									<div class="invalid-feedback" style="width: 100%;">
										請輸入收貨人電話</div>
								</div>
							</div>
							<!-- <div class="mb-3"> -->
							<!--   <label for="email">收貨人email</label> -->
							<!--   <input type="email" class="form-control" id="email" placeholder=""> -->
							<!--   <div class="invalid-feedback"> 請輸入電子郵件，以追蹤最新資訊 </div> -->
							<!-- </div> -->
							<div class="mb-3">
								<label for="address">收貨方式 *</label> <br>
								<div class="custom-control custom-radio"
									style="display: inline-block;">
									<input id="delivery" value=0 name="pickup_method" type="radio"
										class="custom-control-input" checked required> <label
										class="custom-control-label" for="delivery">宅配到府</label>
								</div>
								<div class="custom-control custom-radio"
									style="display: inline-block;">
									<input id="7-11" value=1 name="pickup_method" type="radio"
										class="custom-control-input" required> <label
										class="custom-control-label" for="7-11">7-11 便利商店</label>
								</div>
								<div class="custom-control custom-radio"
									style="display: inline-block;">
									<input id="famMart" value=2 name="pickup_method" type="radio"
										class="custom-control-input" required> <label
										class="custom-control-label" for="famMart">全家 便利商店</label>
								</div>
<!-- 								<p>(運費：宅配100元 / 便利商店60元)</p> -->
								<p>(大促銷！訂購任何商品皆享免運費)</p>
							</div>
							<div class="mb-3">
								<label for="address2">宅配地址/便利商店地址 *</label> <input type="text"
									name="receiver_address" class="form-control" id="address"
									placeholder="${user.mem_addr}" onfocus="this.placeholder=''"
									value="<%=(orderVO == null) ? (user.getMem_addr()) : orderVO.getReceiver_address()%>"
									required>
								<div class="invalid-feedback" style="width: 100%;">地址必填</div>
							</div>


							<!-- <hr class="mb-4"> -->
							<!--   <div class="custom-control custom-checkbox"> -->
							<!--     <input type="checkbox" class="custom-control-input" id="same-address"> -->
							<!--     <label class="custom-control-label" for="same-address">收貨地址與帳單地址相同</label> -->
							<!--  </div> -->
							<!--  <div class="custom-control custom-checkbox"> -->
							<!--     <input type="checkbox" class="custom-control-input" id="save-info"> -->
							<!--     <label class="custom-control-label" for="save-info">儲存本次資訊</label> -->
							<!--  </div> -->

							<hr class="mb-4">
							<div class="title">
								<span>付款方式</span>
							</div>
							<div class="d-block my-3">
								<div class="custom-control custom-radio"
									style="display: inline-block;">
									<input id="cash" value=0 name="payment_method" type="radio"
										class="custom-control-input" checked required> <label
										class="custom-control-label" for="cash">貨到付款</label>
								</div>
								<div class="custom-control custom-radio"
									style="display: inline-block;">
									<input id="credit" value=1 name="payment_method" type="radio"
										class="custom-control-input" required> <label
										class="custom-control-label" for="credit">信用卡</label>
								</div>
								<!-- <div class="custom-control custom-radio" style="display: inline-block;"> -->
								<!-- 	<input id="linepay" value="2" name="payment_method" type="radio" class="custom-control-input" required> -->
								<!--    <label class="custom-control-label" for="linepay">LinePay</label> -->
								<!-- </div> -->
							</div>
							<div class="col-md-6 mb-3">
								<div class="payment-icon">
									<ul>
										<li><img class="img-fluid" src="images/payment-icon/1.png" width=150%;></li>
										<li><img class="img-fluid" src="images/payment-icon/2.png"></li>
										<li><img class="img-fluid" src="images/payment-icon/3.png"></li>
										<li><img class="img-fluid" src="images/payment-icon/4.png"></li>
										<li><img class="img-fluid" src="images/payment-icon/6.png"></li>
										<!-- <li><img class="img-fluid" src="images/payment-icon/7.png"></li> -->
										<!-- <li style="margin-top: 0.5px;"><img class="img-fluid" src="images/payment-icon/9.png"></li> -->
									</ul>
								</div>
							</div>
							<hr class="mb-1">
<!-- 						</FORM> -->
					</div>
				</div>
				<!-- 收貨資料結束 -->
				
				
				<div class="col-sm-6 col-lg-6 mb-3">
					<div class="row">
						
						<!-- 購物車開始 -->
						<div class="col-md-12 col-lg-12">
							<div class="odr-box">
								<div class="title-left">
									<h3>購物車內容</h3>
								</div>
								<c:forEach var="cartVO" items="${cartlist}">
									<c:if test="${cartVO.mem_no == user.mem_no}">
										<div class="rounded p-2 bg-light">
											<div class="media mb-2 border-bottom">
												<div class="media-body">
													<a id="detail"
														href="<%=request.getContextPath()%>/front-end/prod/shop-detail.jsp?${cartVO.prod_no}">
														${cartVO.getProd_VO().prod_name}</a>

<!-- 													<div class="small text-muted" id="cartContent"> -->
<!-- 														單價: $${cartVO.getProd_VO().prod_price} <span class="mx-2">|</span> -->
<%-- 														數量: ${cartVO.prod_qty} <span class="mx-2">|</span> 總價: $ <span --%>
<%-- 															class="totalPrice" style="color: black;">${cartVO.getProd_VO().prod_price * cartVO.prod_qty}</span> --%>
													
													<div class="small text-muted" id="cartContent">
												<span>單價: $</span> <input name="prod_price"
													value="${cartVO.getProd_VO().prod_price}" id="detail1"></input>
													<input type="hidden" name="prod_no<%=i++%>" value="${cartVO.prod_no}" id="detail"></input>
												<span class="mx-2">|</span> <span>數量: </span> <input
													name="prod_qty" value="${cartVO.prod_qty}" id="detail2"></input>
												<span class="mx-2">|</span> <span>總價: $</span> <span
													class="totalPrice" style="color: black;">${cartVO.getProd_VO().prod_price * cartVO.prod_qty}</span>
												<input type="hidden" name="prod_price_total"
													value="${cartVO.getProd_VO().prod_price * cartVO.prod_qty}"
													id="detail"></input>
													
													<FORM action="cart.do" method="post" style="float: right; padding-bottom: 10px;">	
														<input class="btn" id="deleteCart" type="submit" value="X">
														<input type="hidden" name="prod_no" value="${cartVO.prod_no}">
														<input type="hidden" name="action" value="deleteOneWhenCheckout">
													</FORM>

													<FORM action="cart.do" method="post" style="float: right; padding-bottom: 10px;">
														<input class="btn" id="plus" type="submit" value="+">
														<input type="hidden" name="prod_no" value="${cartVO.prod_no}">
														<input type="hidden" name="prod_qty" value="${cartVO.prod_qty}">
														<input type="hidden" name="prod_stock" value="${cartVO.getProd_VO().prod_stock}">
														<input type="hidden" name="mem_no" value="${user.mem_no}">
														<input type="hidden" name="action" value="checkoutPlus">
													</FORM>

													<FORM action="cart.do" method="post" style="float: right; padding-bottom: 10px;">
														<input class="btn" id="minus" type="submit" value="-">
														<input type="hidden" name="prod_no" value="${cartVO.prod_no}">
														<input type="hidden" name="prod_qty" value="${cartVO.prod_qty}">
														<input type="hidden" name="prod_stock" value="${cartVO.getProd_VO().prod_stock}">
														<input type="hidden" name="mem_no" value="${user.mem_no}">
														<input type="hidden" name="action" value="checkoutMinus">
													</FORM>
													</div>
												</div>
											</div>
										</div>
									</c:if>
								</c:forEach>

								<div class="coupon-box">
								<br>
									<a href="<%=request.getContextPath()%>/front-end/memcoupon/memcouponlist.jsp" id="goToCoupon">前往查詢優惠碼</a>
									<div class="input-group input-group-sm" id="boxCoupon">										
										<input name="discount" id="insertCoupon" class="form-control"
											placeholder="輸入優惠碼" aria-label="Coupon code" type="text">
										<div class="input-group-append">
											<input class="btn" id="useCoupon" type="button" value="使用"></input>
										</div>
									</div>
								</div>
								
							</div>
						</div>
						<!-- 購物車結束 -->						
						
						<!-- 訂單總金額開始 -->
						<div class="col-md-12 col-lg-12">							
							<div class="order-box">							
								<div class="title-left" id="order">
									<br>
									<h3 style="font-size: 20px;">您的訂單</h3>
								</div>
								<div class="d-flex">
									<div class="font-weight-bold">本次消費</div>
									<div class="ml-auto font-weight-bold">金額</div>
								</div>
								<hr class="my-1">
								<div class="d-flex">
									<h4>消費金額</h4>
									<div class="ml-auto font-weight-bold">
										$<input name="order_price_total" value="" id="amount" style="border-style:none; text-align: right; width: 65px" readonly>
									</div>
								</div>
								<hr class="my-1">
								<div class="d-flex">
									<h4>優惠碼折抵</h4>
									<div class="ml-auto font-weight-bold">
										<span id="disAmount"></span>
									</div>
								</div>
								<div class="d-flex">
									<h4>運費</h4>
									<div class="ml-auto font-weight-bold">Free</div>
								</div>
								<hr>
								<div class="d-flex gr-total">
									<h5>訂單總金額</h5>
									<div class="ml-auto h5">
										$<input name="dis_price_total" value="" id="amountFinal" style="border-style:none; text-align: right; width: 65px" readonly>
									</div>
								</div>								
								<hr>
							</div>							
						</div>
						<!-- 訂單總金額結束 -->
						
						<!-- 結帳按鈕開始 -->
						<div class="col-12 d-flex shopping-box">
								<%-- 錯誤表列 --%>
								<c:if test="${not empty errorMsgs}">
									<font style="color: red">請修正以下錯誤:</font>
									<ul>
										<c:forEach var="message" items="${errorMsgs}">
											<li style="color: red">${message}</li>
										</c:forEach>
									</ul>
								</c:if>
								<input type="hidden" name="mem_no" value="${user.mem_no}">
								<input type="hidden" name="coupon_no" value="${couponVO.coupon_no}">	
								<input class="btn btn-warning" id="checkout" type="submit" value="下單" onclick="confirmTest9()">
								<input type="hidden" name="prodAmount" value="<%=i-1%>">						
						</div>
						<!-- 結帳按鈕結束 -->						
					</div>
				</div>
			</div>
		</div>
		</FORM>
	</div>
	
	<!-- End Checkout -->

	<!-- !!!!!!此行以下都不要修改!!!!!!-->
	<!-- Start Instagram Feed  -->
<!-- 	<div class="instagram-box"> -->
<%-- 		<%@ include file="/front-end/partials/_InstagramBox.jsp"%> --%>
<!-- 	</div> -->
	<!-- End Instagram Feed  -->
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