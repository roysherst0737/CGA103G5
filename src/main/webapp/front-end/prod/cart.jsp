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


Object Objuser = session.getAttribute("user");
Mem_VO user = (Mem_VO) Objuser;

String url = request.getRequestURL().toString() + "?" + request.getQueryString();
session.setAttribute("url", url);

int i = 0;
// System.out.println(i);

List<Cart_VO> cartlist2 = cartSvc.getByMem_no(user.getMem_no());
Iterator<Cart_VO> iter = cartlist2.iterator();

// int [] prod_no_int = new int[cartlist2.size()]; 
// int [] prod_qty_int = new int[cartlist2.size()];
// int [] prod_stock_int = new int[cartlist2.size()]; 
String prod_no_int = "";
String prod_qty_int = "";
String prod_stock_int = ""; 

for (int j =0; j<cartlist2.size() ; j++) {	
	prod_no_int += cartlist2.get(j).getProd_no().toString()+ ","; 
	prod_qty_int += cartlist2.get(j).getProd_qty().toString()+ ","; 
	prod_stock_int += cartlist2.get(j).getProd_VO().getProd_stock().toString()+ ","; 
// 	System.out.println(list.get(j).getProd_no());
//        Cart_VO cartVO = (Cart_VO) iter.next();
//        System.out.println(cartVO.getProd_no());
//        System.out.println(cartVO.getProd_qty());
//        System.out.println(cartVO.getProd_VO().getProd_stock());
}
// System.out.println(prod_no_int);
// System.out.println(prod_qty_int);
// System.out.println(prod_stock_int);

pageContext.setAttribute("cartlist2", cartlist2);

pageContext.setAttribute("prod_no_int", prod_no_int);
pageContext.setAttribute("prod_qty_int", prod_qty_int);
pageContext.setAttribute("prod_stock_int", prod_stock_int);
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
		#deleteCart {
			font-size: 18px;
			color: red;
			}		
		#deleteAll {
			font-size: 18px;
			color: red;
			margin-right: 14px;
			float:left;
			}			
		#minus {
			width: 20px;
			text-align: auto;
			font-size: 20px;
			padding: 0px;
			}
		#minus:hover {
			color: red;
			}			
		#qty {
			width: 16px;
			text-align: center;
			}			
		#plus {
			width: 20px;
			text-align: auto;
			font-size: 20px;
			padding: 0px;
			}
		#plus:hover {
			color: green;
			}	
		#total-price {
			text-align: center;
			}
		#remove-cart {
			width: 16px;
			text-align: center;
			}
		#pic {
			width: 250px;
			}
		#name {
			width: 200px;
			}
		#price {
			width: 200px;
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
                                    <th id="pic">商品圖片</th>
                                    <th id="name">商品名稱</th>
                                    <th id="price">商品單價</th>
                                    <th id="minus"></th>
                                    <th id="qty">購買數量</th>
                                    <th id="plus"></th>
                                    <th id="total-price">總價</th>
                                    <th id="remove-cart"></th>
                                </tr>
                            </thead>
                            <c:forEach var="cartVO" items="${cartlist2}">
<%--                             <c:if test="${cartVO.mem_no == user.mem_no}"> --%>
                            <%i++;%>
                            <tbody>
                                <tr>
                                    <td id="pic">
                                    	<img src="<%=request.getContextPath()%>/ShowProd_picForProd?prod_no=${cartVO.getProd_pic_VO().prod_pic_no}"
											 width=150px height=100px>
                                    </td>
                                    <td id="name">
                                        ${cartVO.getProd_VO().prod_name}
                                    </td>
                                    <td id="price">
                                        <p>$${cartVO.getProd_VO().prod_price}</p>
                                    </td>
                                    <FORM action="cart.do" method="post">
                                    <td id="minus">
                                    	
                                        	<input class="btn" id="minus" type="submit" value="-">
                                        	<input type="hidden" name="prod_no" value="${cartVO.prod_no}">
                                        	<input type="hidden" name="prod_qty" value="${cartVO.prod_qty}">
                                        	<input type="hidden" name="prod_stock" value="${cartVO.getProd_VO().prod_stock}">
                                        	<input type="hidden" name="mem_no" value="${user.mem_no}">
                                        	<input type="hidden" name="action" value="cartMinus">

                                    </td>
                                    </FORM>
                                    <td id="qty"> 
                                    	<p>${cartVO.prod_qty}</p>                                   	
<%--                                     	<input name="prod_qty" value="${cartVO.prod_qty}" style="text-align: center; border-style:none;" readonly>                                   	 --%>
<%--                                     <input type="number" size="4" value="${cartVO.prod_qty}" min="0" max="${cartVO.getProd_VO().prod_stock}" class="c-input-text qty text"> --%>
                                    </td>
                                    <FORM action="cart.do" method="post">
                                    <td id="plus">
										<c:if test="${cartVO.getProd_VO().prod_status == 1 && cartVO.getProd_VO().prod_stock>=1}">
                                        	<input class="btn" id="plus" type="submit" value="+">
                                        	<input type="hidden" name="prod_no" value="${cartVO.prod_no}">
                                        	<input type="hidden" name="prod_qty" value="${cartVO.prod_qty}">
                                        	<input type="hidden" name="prod_stock" value="${cartVO.getProd_VO().prod_stock}">
                                        	<input type="hidden" name="mem_no" value="${user.mem_no}">    	
                                        	<input type="hidden" name="action" value="cartPlus">
                                        </c:if>                                        
                                    </td>
                                    </FORM>
                                    
                                    <td id="total-price">
                                        <p>$${cartVO.getProd_VO().prod_price * cartVO.prod_qty}</p>
                                    </td>
                                    
                                    <td id="remove-cart">
                                    	<FORM action="cart.do" method="post">
                                        	<input class="btn btn-warning" id="deleteCart" type="submit" value="X">
                                        	<input type="hidden" name="prod_no" value="${cartVO.prod_no}">
                                        	<input type="hidden" name="prod_qty" value="${cartVO.prod_qty}">
                                        	<input type="hidden" name="prod_stock" value="${cartVO.getProd_VO().prod_stock}">
                                        	<input type="hidden" name="mem_no" value="${user.mem_no}">
                                        	<input type="hidden" name="action" value="deleteOne">
                                        </FORM>
                                    </td>
                                    
                                </tr>                                                                
                            </tbody>
<%--                             </c:if> --%>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <FORM action="cart.do" method="post">
    								<input type="hidden" name="action" value="deleteAll">
                <div class="col-12 d-flex shopping-box" id="GoToCheckout">
                <%pageContext.setAttribute("i", i);%>
                	
                	<c:choose>
						<c:when test="${empty sessionScope.user}">
							<a href="<%=request.getContextPath()%>/front-end/mem/login.jsp" id="remind">【請點擊登入會員，以查看購物車】</a>								
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${i < 1}">
									<a href="<%=request.getContextPath()%>/front-end/prod/shop.jsp" id="remind">【前往選購商品】</a>
								</c:when>
								<c:otherwise>
								<div id="deleteAll">
									   								
    								<input class="btn btn-warning" id="deleteAll" type="submit" value="清空購物車">                        		
                    				<input type="hidden" name="prod_no_int" value="${prod_no_int}">
                                   	<input type="hidden" name="prod_qty_int" value="${prod_qty_int}">
                                   	<input type="hidden" name="prod_stock_int" value="${prod_stock_int}">
                                   	<input type="hidden" name="mem_no" value="${user.mem_no}">
              					</div> 
                        		<a href="checkout.jsp" class="ml-auto btn hvr-hover" style="font-size: 20px; float:right;">前往結帳</a>                        		
                        		</c:otherwise>
                        	</c:choose> 
                        </c:otherwise>
                    </c:choose>                                                    	
                </div>
                </FORM>
        </div>
        						
                 					
                					
    </div>
    <!-- End Cart -->

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