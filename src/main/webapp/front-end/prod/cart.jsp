<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.prod.model.*"%>
<%@ page import="com.cart.model.*"%>
<%@ page import="com.mem.model.*"%>

<%
Prod_Service prodSvc = new Prod_Service();
List<Prod_VO> list = prodSvc.getAll();
pageContext.setAttribute("list", list);

Cart_Service cartSvc = new Cart_Service();
List<Cart_VO> cartlist = cartSvc.getAll();
pageContext.setAttribute("cartlist", cartlist);

// int amount = 0;
// for (int i = 0; i < cartlist.size(); i++) {
// 	Cart_VO order = cartlist.get(i);
// 	Integer price = order.getProd_VO().getProd_price();
// 	Integer quantity = order.getProd_qty();
// 	amount += (price * quantity);
// }

Object Objuser = session.getAttribute("user");
Mem_VO user = (Mem_VO) Objuser;

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

	<style>
		.btn {
    		width: auto;
    		height: auto;
			}
		
		#remind {
			color:#f5c242; 
			font-size: 28px; 
			font-weight:bold;
			}
		#remind:hover {	
			color:black;
			}
	
	</style>
	
</head>

<body>

	<div id=top_nav_mainTop>
		<%@ include file="/front-end/partials/_mainTop.jsp"%>
	</div>

	<!-- !!!!!! 從以下開始修改到Start Instagram Feed" !!!!!!-->

    <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>您的購物車</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/front-end/prod/shop.jsp">回商城</a></li>
                        <li class="breadcrumb-item active">購物車</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-main table-responsive">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>圖片</th>
                                    <th>名稱</th>
                                    <th>單價</th>
                                    <th>數量</th>
                                    <th>總價</th>
                                    <th>移除</th>
                                </tr>
                            </thead>
                            <c:forEach var="cartVO" items="${cartlist}">
                            <c:if test="${cartVO.mem_no == user.mem_no}">
                            <tbody>
                                <tr>
                                    <td class="thumbnail-img">
                                    	<img src="<%=request.getContextPath()%>/ShowProd_picForProd?prod_no=${cartVO.getProd_pic_VO().prod_pic_no}"
											 width=150px height=100px>
                                    </td>
                                    <td class="name-pr">
                                        ${cartVO.getProd_VO().prod_name}
                                    </td>
                                    <td class="price-pr">
                                        <p>$${cartVO.getProd_VO().prod_price}</p>
                                    </td>
                                    <td class="quantity-box">
                                    	<p>${cartVO.prod_qty}</p>
<!--                                     <input type="number" size="4" value="1" min="0" step="1" class="c-input-text qty text"> -->
                                    </td>
                                    <td class="total-pr">
                                        <p>$${cartVO.getProd_VO().prod_price * cartVO.prod_qty}</p>
                                    </td>
                                    <td class="remove-pr">
                                        <a href="#">
									<i class="fas fa-times"></i>
								</a>
                                    </td>
                                </tr>                                                                
                            </tbody>
                            </c:if>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row my-5">
                <div class="col-lg-6 col-sm-6">
                    <div class="coupon-box">
                        <div class="input-group input-group-sm">
                        	<c:choose>
							<c:when test="${empty sessionScope.user}">
								<a href="<%=request.getContextPath()%>/front-end/mem/login.jsp" id="remind">【請點擊登入會員，以查看購物車】</a>
							</c:when>
							<c:otherwise>
                            	<input class="form-control" placeholder="輸入優惠碼" aria-label="Coupon code" type="text">
                            </c:otherwise>
                            </c:choose> 
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-sm-6">
                    <div class="update-box">
                    	<c:choose>
							<c:when test="${empty sessionScope.user}">								
							</c:when>
							<c:otherwise>
                        		<input value="確定" type="submit">
                        	</c:otherwise>
                    	</c:choose> 
                    </div>
                </div>
            </div>
			
<%-- 			<c:forEach var="cartVO" items="${cartlist}"> --%>
<%--             <c:if test="${cartVO.mem_no == user.mem_no}"> --%>
<!--             <div class="row my-5"> -->
<!--                 <div class="col-lg-8 col-sm-12"></div> -->
<!--                 <div class="col-lg-4 col-sm-12"> -->
<!--                     <div class="order-box"> -->
<!--                         <h3>購物車內容</h3> -->
<!--                         <div class="d-flex"> -->
<!--                             <h4>消費金額</h4> -->
<!--                             <div class="ml-auto font-weight-bold"> $${cartVO.getProd_VO().prod_price * cartVO.prod_qty} </div> -->
<!--                         </div> -->
<!--                         <hr class="my-1"> -->
<!--                         <div class="d-flex"> -->
<!--                             <h4>優惠碼折抵</h4> -->
<!--                             <div class="ml-auto font-weight-bold"> $ 10 </div> -->
<!--                         </div> -->
<!--                         <div class="d-flex"> -->
<!--                             <h4>運費</h4> -->
<!--                             <div class="ml-auto font-weight-bold"> Free </div> -->
<!--                         </div> -->
<!--                         <hr> -->
<!--                         <div class="d-flex gr-total"> -->
<!--                             <h5>訂單總金額</h5> -->
<!--                             <div class="ml-auto h5"> $${cartVO.getProd_VO().prod_price * cartVO.prod_qty} </div> -->
<!--                         </div> -->
<!--                         <hr> </div> -->
<!--                 </div> -->
                <div class="col-12 d-flex shopping-box">
                	<c:choose>
						<c:when test="${empty sessionScope.user}">								
						</c:when>
						<c:otherwise>
                        	<a href="checkout.jsp" class="ml-auto btn hvr-hover">結帳</a>
                        </c:otherwise>
                    </c:choose>                 	
                </div>
<!--             </div> -->
<%--             </c:if> --%>
<%--             </c:forEach> --%>

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