<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.prod.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.order.model.*"%>
<%@ page import="com.cart.model.*"%>

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
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
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
	
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	<script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
	<script>
		function confirmTest() {
			Swal.fire({
				title : "請先登入會員",		
				showCancelButton : true
			}).then(function(result) {
				if (result.value) {	
					location.href='<%=request.getContextPath()%>/front-end/mem/login.jsp'
					}
				});
		}
		function confirmTest0() {
			Swal.fire({
				title : "您已登入會員，可直接進行結帳",
				showCancelButton : false
			});
		}
		function confirmTest1() {
			Swal.fire({
				title : "訂單已成立，謝謝您的購買！",
				showCancelButton : false
			});
		}
		function confirmTest2() {
			location.href='<%=request.getContextPath()%>/front-end/prod/PayWithCredit.jsp'
		}
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
                        <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/front-end/prod/shop.jsp">回商城</a></li>
                        <li class="breadcrumb-item active">結帳</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <div class="row new-account-login">
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="title-left">
                        <h3>會員登入</h3>
                    </div>
                    <h5>
                    	<c:choose>
							<c:when test="${empty sessionScope.user}">
								<a href="<%=request.getContextPath()%>/front-end/mem/login.jsp" style="color:#f5c242; font-size: 18px">您尚未登入，請點擊登入會員後方可結帳</a>
							</c:when>
							<c:otherwise>
								<a style="color:#f5c242; font-size: 18px">您已登入，可直接進行結帳</a>
							</c:otherwise>
						</c:choose> 
                    </h5>
                </div>
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="title-left">
                        <h3>註冊新會員</h3>
                    </div>
                    <h5>
                    	<c:choose>
							<c:when test="${empty sessionScope.user}">
								<a href="<%=request.getContextPath()%>/front-end/mem/register.jsp" style="color:#f5c242; font-size: 18px">若您尚未註冊，請點擊加入我們！</a>
							</c:when>
							<c:otherwise>
								<a style="color:#f5c242; font-size: 18px">已註冊會員，謝謝您的支持！</a>
							</c:otherwise>
						</c:choose> 
                    </h5>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="checkout-address">
                        <div class="title-left">
                            <h3>收貨人資訊</h3>
                        </div>
                        <form class="needs-validation" novalidate>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="firstName">收貨人姓名 *</label>
                                    <input type="text" name="receiver_name" class="form-control" id="firstName" placeholder="" value="" required>
                                    <div class="invalid-feedback"> 請輸入收貨人姓名 </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="username">收貨人電話 *</label>
                                <div class="input-group">
                                    <input type="text" name="receiver_phone" class="form-control" id="username" placeholder="" required>
                                    <div class="invalid-feedback" style="width: 100%;"> 請輸入收貨人電話 </div>
                                </div>
                            </div>
<!--                             <div class="mb-3"> -->
<!--                                 <label for="email">收貨人email</label> -->
<!--                                 <input type="email" class="form-control" id="email" placeholder=""> -->
<!--                                 <div class="invalid-feedback"> 請輸入電子郵件，以追蹤最新資訊 </div> -->
<!--                             </div> -->
                            <div class="mb-3">
                                <label for="address">收貨方式 *</label>
                                <br>                                
                                <div class="custom-control custom-radio" style="display: inline-block;">
                                    <input id="delivery" value="0" name="pickup_method" type="radio" class="custom-control-input" checked required>
                                    <label class="custom-control-label" for="delivery">宅配到府</label>
                                </div>
                                <div class="custom-control custom-radio" style="display: inline-block;">
                                    <input id="7-11" value="1" name="pickup_method" type="radio" class="custom-control-input" required>
                                    <label class="custom-control-label" for="7-11">7-11 便利商店</label>
                                </div>
                                <div class="custom-control custom-radio" style="display: inline-block;">
                                    <input id="famMart" value="2" name="pickup_method" type="radio" class="custom-control-input" required>
                                    <label class="custom-control-label" for="famMart">全家 便利商店</label>
                                </div>
                                <p> (運費：宅配100元 / 便利商店60元)</p>
                                <p> (折抵前訂單總金額達$1,000即享免運費)</p>
                            </div>
                            <div class="mb-3">
                                <label for="address2">宅配地址/便利商店地址 *</label>
                                <input type="text" name="receiver_address" class="form-control" id="address" placeholder="" required>
                                <div class="invalid-feedback" style="width: 100%;"> 地址必填 </div>
                            </div>
                                
                                
<!--                             <hr class="mb-4"> -->
<!--                             <div class="custom-control custom-checkbox"> -->
<!--                                 <input type="checkbox" class="custom-control-input" id="same-address"> -->
<!--                                 <label class="custom-control-label" for="same-address">收貨地址與帳單地址相同</label> -->
<!--                             </div> -->
<!--                             <div class="custom-control custom-checkbox"> -->
<!--                                 <input type="checkbox" class="custom-control-input" id="save-info"> -->
<!--                                 <label class="custom-control-label" for="save-info">儲存本次資訊</label> -->
<!--                             </div> -->

                            <hr class="mb-4">
                            <div class="title"> <span>付款方式</span> </div>
                            <div class="d-block my-3">
                                <div class="custom-control custom-radio" style="display: inline-block;">
                                    <input id="cash" value="0" name="payment_method" type="radio" class="custom-control-input" checked required>
                                    <label class="custom-control-label" for="cash">貨到付款</label>
                                </div>
                                <div class="custom-control custom-radio" style="display: inline-block;">
                                    <input id="credit" value="1" name="payment_method" type="radio" class="custom-control-input" required>
                                    <label class="custom-control-label" for="credit">信用卡</label>
                                </div>
                                <div class="custom-control custom-radio" style="display: inline-block;">
                                    <input id="linepay" value="2" name="payment_method" type="radio" class="custom-control-input" required>
                                    <label class="custom-control-label" for="linepay">LinePay</label>
                                </div>
                            </div>
                                <div class="col-md-6 mb-3">
                                    <div class="payment-icon">
                                        <ul>
                                            <li><img class="img-fluid" src="images/payment-icon/1.png" width=150%;></li>
                                            <li><img class="img-fluid" src="images/payment-icon/2.png"></li>
                                            <li style="margin-top: 0.5px;"><img class="img-fluid" src="images/payment-icon/9.png"></li>

                                        </ul>
                                    </div>
                                </div>
                            <hr class="mb-1"> </form>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="row">
                        <div class="col-md-12 col-lg-12">

                        </div>
                        <div class="col-md-12 col-lg-12">
                            <div class="odr-box">
                                <div class="title-left">
                                    <h3>購物車內容</h3>
                                </div>
                                <c:forEach var="cartVO" items="${cartlist}">
                            	<c:if test="${cartVO.mem_no == user.mem_no}">
                                <div class="rounded p-2 bg-light">
                                    <div class="media mb-2 border-bottom">
                                        <div class="media-body"> <a href="detail.html"> ${cartVO.getProd_VO().prod_name}</a>
                                            <div class="small text-muted">單價: $${cartVO.getProd_VO().prod_price} <span class="mx-2">|</span> 數量: ${cartVO.prod_qty} <span class="mx-2">|</span> 總價: $${cartVO.getProd_VO().prod_price * cartVO.prod_qty}</div>
                                        </div>
                                    </div>
                                </div>
                                </c:if>
                            	</c:forEach>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-12">
                            <div class="order-box">
                                <div class="title-left" id="order">
                                    <br><h3 style="font-size: 20px;">你的訂單</h3>
                                </div>
                                <div class="d-flex">
                                    <div class="font-weight-bold">本次消費</div>
                                    <div class="ml-auto font-weight-bold">金額</div>
                                </div>
                                <hr class="my-1">
                                <div class="d-flex">
                                    <h4>消費金額</h4>
                                    <div class="ml-auto font-weight-bold"> $ 440 </div>
                                </div>
                                <hr class="my-1">
                                <div class="d-flex">
                                    <h4>優惠碼折抵</h4>
                                    <div class="ml-auto font-weight-bold"> $ 10 </div>
                                </div>
                                <div class="d-flex">
                                    <h4>運費</h4>
                                    <div class="ml-auto font-weight-bold"> Free </div>
                                </div>
                                <hr>
                                <div class="d-flex gr-total">
                                    <h5>訂單總金額</h5>
                                    <div class="ml-auto h5"> $ 388 </div>
                                </div>
                                <hr> </div>
                        </div>
                        <div class="col-12 d-flex shopping-box">
                        <c:choose>
							<c:when test="${empty sessionScope.user}">
								<input class="btn btn-warning" id="checkout" type="button" value="結帳" onclick="confirmTest()" />
							</c:when>
							<c:otherwise>
								<c:choose>
									<c:when test="${orderVO.payment_method == 0}">
										<input class="btn btn-warning" id="checkout" type="submit" value="結帳" onclick="confirmTest1()">
									</c:when>
							<c:otherwise>
<%-- 								<c:when test="${orderVO.payment_method == 1}"> --%>
									<input class="btn btn-warning" id="checkout" type="submit" value="結帳" onclick="confirmTest2()">
<%-- 								</c:when> --%>
							</c:otherwise>
								</c:choose>
							</c:otherwise>
						</c:choose>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!-- End Cart -->

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