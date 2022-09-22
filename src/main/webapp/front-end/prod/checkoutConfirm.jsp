<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
}

#attention {
	color: red;
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
		<FORM name="detailCreate" action="detailFinal.do" method="post">
			<input type="hidden" name="action" value="createDetail">
			<div class="container">
				<!-- 信用卡資料開始 -->
				<div>
					<div class="order-box">
						<div class="title-left" id="order">
							<br>
							<h3 style="font-size: 20px;">再次確認訂單 (訂單編號：<span>"${orderVO.order_no}"</span>)</h3>
						</div>
						<div class="d-flex">
							<div class="font-weight-bold" id="attention">僅供確認，訂單資料已無法修改</div>
						</div>
						<hr>
							<div class="title-left" id="order">
								<br>
								<h3 style="font-size: 20px;">
									信用卡結帳 <span style="color: red; font-size: 12px;">(若選擇貨到付款，不必填寫)
										*非真實信用卡結帳，可隨意填寫資料</span>
								</h3>
							</div>

							<h2 style="display: inline-block;">付款資訊</h2>
							<br>
							<p style="display: inline-block;">持卡人姓名</p>
							<input type="text" class="inputbox" name="name" />
							<p style="display: inline-block;">信用卡卡號</p>
							<input type="number" class="inputbox" name="card_number"
								id="card_number" />

							<p style="display: inline-block;">信用卡種類</p>
							<select class="inputbox" name="card_type" id="card_type">
								<option value="">--選擇信用卡種類--</option>
								<option value="Visa">Visa</option>
								<option value="MasterCard">MasterCard</option>
								<option value="Maestro">Maestro</option>
								<option value="Cirrus">Cirrus</option>
								<option value="Skrill">Skrill</option>
							</select>
							<hr>
							<div class="expcvv">

								<p style="display: inline-block;"
									expcvv_text" style="font-size: 16px;">到期日</p>
								<input type="month" class="inputbox" name="exp_date"
									id="exp_date"/>

								<p style="display: inline-block;"
									expcvv_text2" style="font-size: 10px;">CVV(卡片背面末三碼)</p>
								<input type="password" class="inputbox" name="cvv" id="cvv"
									/>
							</div>
						<hr>
					</div>
				</div>
				<!-- 信用卡資料結束 -->

				<!-- 購物車開始 -->
				<div>
					<div class="odr-box">
						<div class="title-left" id="order">
							<h3>購物車內容</h3>
						</div>
						<c:forEach var="cartVO" items="${cartlist}">
							<c:if test="${cartVO.mem_no == user.mem_no}">
								<div class="rounded p-2 bg-light">
									<div class="media mb-2 border-bottom">
										<div class="media-body">
											<input name="prod_name"
												value="${cartVO.getProd_VO().prod_name}" id="detail"></input>
												<input type="hidden" name="prod_no"
												value="${cartVO.prod_no}" id="detail"></input>

											<div class="small text-muted" id="cartContent">
												<span>單價: $</span> <input name="prod_price"
													value="${cartVO.getProd_VO().prod_price}" id="detail"></input>
												<span class="mx-2">|</span> <span>數量: </span> <input
													name="prod_qty" value="${cartVO.prod_qty}" id="detail"></input>
												<span class="mx-2">|</span> <span>總價: $</span> <span
													class="totalPrice">${cartVO.getProd_VO().prod_price * cartVO.prod_qty}</span>
												<input type="hidden" name="prod_price_total"
													value="${cartVO.getProd_VO().prod_price * cartVO.prod_qty}"
													id="detail"></input>
												<script>
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
											</div>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>

						<script>
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
					</div>
				</div>
				<!-- 購物車結束 -->

				<!-- 訂單總金額開始 -->
				<div>
					<div class="order-box">
						<div class="title-left" id="order">
							<br>
							<h3 style="font-size: 20px;">您的訂單</h3>
						</div>
						<div class="d-flex">
							<div class="font-weight-bold">本次消費</div>
							<div class="ml-auto font-weight-bold">金額</div>
						</div>
						<input type="hidden" name="order_price_total" value="" id="amount"
							style="border-style: none; text-align: right; width: 65px"
							readonly>
						<hr>
						<div class="d-flex gr-total">
							<h5>訂單總金額</h5>
							<div class="ml-auto h5">
								$<input name="dis_price_total" value="" id="amountFinal"
									style="border-style: none; text-align: right; width: 65px"
									readonly>
							</div>
						</div>
						<hr>
					</div>
				</div>
				<!-- 訂單總金額結束 -->

				<!-- 結帳按鈕開始 -->
				<div>

					<input type="hidden" name="mem_no" value="${user.mem_no}">
					<input class="btn btn-warning" id="checkout" type="submit"
						value="確認訂單">
				</div>
				<!-- 結帳按鈕結束 -->
			</div>
		</FORM>
	</div>

	<!-- End Checkout -->

	<!-- !!!!!!此行以下都不要修改!!!!!!-->
	<!-- Start Instagram Feed  -->
	<div class="instagram-box">
		<%@ include file="/front-end/partials/_InstagramBox.jsp"%>
	</div>
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