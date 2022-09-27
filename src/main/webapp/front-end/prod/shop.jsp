<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.prod.model.*"%>
<%@ page import="com.prod_type.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.cart.model.*"%>

<%
Prod_Service prodSvc = new Prod_Service();
List<Prod_VO> list = prodSvc.getAll();
pageContext.setAttribute("list", list);

Prod_type_Service prod_typeSvc = new Prod_type_Service();
List<Prod_type_VO> list2 = prod_typeSvc.getAll();
pageContext.setAttribute("list2", list2);

Object Objuser = session.getAttribute("user");
Mem_VO user = (Mem_VO) Objuser;

if (user != null) {
	Cart_Service cartSvc = new Cart_Service();
	Set<Integer> cartSet = cartSvc.getAdd_to_Cart((Integer) user.getMem_no());
	pageContext.setAttribute("cartSet", cartSet);
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

	<style>
		.btn {
    		width: auto;
    		height: auto;
			}
			
		#view {
			float:left;
			}
		
		#type {
			padding:2px;
			font-size:20px;
			}
		#type:hover {
			color:#f5c242;
			font-weight: bold
			}
		
		#cart {
			background-color: #f5c242;
			color: white;
			font-weight: bold;
			font-size: 16px;
			margin-top: 122px;
			cursor: pointer;
			border: none;
			height: 38px;
			}
		#cart:hover {
			color: black;
			}
			
		#cart2 {
			font-size: 18px;
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
                    <h2>購物商城</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/front-end/prod/shop.jsp">回商城</a></li>
                        <li class="breadcrumb-item active">總覽</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Shop Page  -->
    <div class="shop-box-inner">
        <div class="container">
            <div class="row">
                <div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
                    <div class="right-product-box">
                        <div class="product-item-filter row">
                            <div class="col-12 col-sm-4 text-center text-sm-right">
                                <ul class="nav nav-tabs ml-auto" id="view">
                                    <li>
                                        <a class="nav-link active" href="#grid-view" data-toggle="tab"> <i class="fa fa-th"></i> </a>
                                    </li>
                                    <li>
                                        <a class="nav-link" href="#list-view" data-toggle="tab"> <i class="fa fa-list-ul"></i> </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
						
                        <div class="product-categorie-box">
                            <div class="tab-content">	
                                <div role="tabpanel" class="tab-pane fade show active" id="grid-view">                                                                                               
                                    <div class="row">
                                    <c:forEach var="prodVO" items="${list}">
                                    <!-- 暴力式判斷庫存 -->
                                    <c:if test="${prodVO.prod_status == 1}">
                                        <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                            <div class="products-single fix">
                                                <div class="box-img-hover">
                                                    <img src="<%=request.getContextPath()%>/ShowProd_picForProd?prod_no=${prodVO.getProd_pic_VO().prod_pic_no}"
														width=250px height=160px>
                                                    <div class="mask-icon">
                                                        <ul>
                                                            <li><a href="<%=request.getContextPath()%>/front-end/prod/shop-detail.jsp?${prodVO.prod_no}"
                                                            	data-toggle="tooltip" data-placement="right" title="查看詳情"><i class="fas fa-eye"></i></a></li>
                                                        </ul>
                                                        
                                                        <c:choose>
                                                        <c:when  test="${prodVO.prod_status == 1 && prodVO.prod_stock>=1}">
                                            			<FORM name="cart" action="cart.do" method="post">             
                                                        <c:choose>
															<c:when test="${empty sessionScope.user}">
																<input id="cart" type="button" value="加入購物車" onclick="confirmTest6()" />
															</c:when>
															<c:otherwise>
																<input id="cart" type="submit" value="加入購物車" onclick="confirmTest7()">
															</c:otherwise>
														</c:choose>
														<input type="hidden" name="prod_no" value="${prodVO.prod_no}">
														<input type="hidden" name="prod_stock" value="${prodVO.prod_stock}">
                                                        <input type="hidden" name="mem_no" value="${user.mem_no}">
														<input type="hidden" name="action" value="insert">	
														</FORM>
														</c:when>
															<c:otherwise>
																<input disabled id="cart" type="submit" value="目前無庫存">
															</c:otherwise>
														</c:choose>
														 																
                                                    </div>
                                                </div>
                                                <div class="why-text">
                                                    <h4>${prodVO.prod_name}</h4>
                                                    <h5>$${prodVO.prod_price}</h5>
                                                    <p style="display: inline-block; float:right; color:#f5c242; font-weight:bold;">${prodVO.prod_stock}</p><p style="display: inline-block; float:right;"> 庫存：</p>
                                                </div>
                                            </div>
                                        </div>
                                        </c:if>
                                        </c:forEach>
                                    </div> 
                                    
                                                                  	
                                </div>
                                <div role="tabpanel" class="tab-pane fade" id="list-view">
                                <c:forEach var="prodVO" items="${list}">
                                <c:if test="${prodVO.prod_status == 1}">
                                    <div class="list-view-box">                                    
                                        <div class="row">
                                            <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                                <div class="products-single fix">
                                                    <div class="box-img-hover">
                                                        <img src="<%=request.getContextPath()%>/ShowProd_picForProd?prod_no=${prodVO.getProd_pic_VO().prod_pic_no}"
														width=280px height=180px>
                                                        <div class="mask-icon">
                                                            <ul>
                                                                <li><a href="<%=request.getContextPath()%>/front-end/prod/shop-detail.jsp?${prodVO.prod_no}"
                                                                	data-toggle="tooltip" data-placement="right" title="查看詳情"><i class="fas fa-eye"></i></a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
                                                <div class="why-text full-width">
                                                    <h4>${prodVO.prod_name}</h4>
                                                    <h5>$${prodVO.prod_price}</h5>
                                                    <span style="line-height:3px;"> 庫存：</span><span style="color:#f5c242; display: inline-block; font-weight:bold;">${prodVO.prod_stock}</span>
                                                    <p>${prodVO.prod_detail}</p>
                                                    
                                                    <c:choose> 
                                                    <c:when  test="${prodVO.prod_status == 1 && prodVO.prod_stock>=1}">                                                  
                                                    <FORM name="cart" action="cart.do" method="post">
                                                    <c:choose>
														<c:when test="${empty sessionScope.user}">
															<input class="btn btn-warning" id="cart2" type="button" value="加入購物車" onclick="confirmTest6()" />
														</c:when>
														<c:otherwise>
															<input class="btn btn-warning" id="cart2" type="submit" value="加入購物車" onclick="confirmTest7()">
														</c:otherwise>
													</c:choose>
													<input type="hidden" name="prod_no" value="${prodVO.prod_no}">
													<input type="hidden" name="prod_stock" value="${prodVO.prod_stock}">
                                                    <input type="hidden" name="mem_no" value="${user.mem_no}">
													<input type="hidden" name="action" value="insert">	
													</FORM>
													</c:when>
														<c:otherwise>
															<input disabled class="btn btn-warning" id="cart2" type="submit" value="目前無庫存">
														</c:otherwise>
													</c:choose>
													
                                                </div>
                                            </div>
                                        </div>                                      
                                    </div>
                                    </c:if>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				<div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
                    <div class="product-categori">
                        <div class="filter-sidebar-left">
                            <div class="title-left">
                                <h2 style="font-size:28px; font-weight: bold;">商品類別</h2>
                            </div>
                            <div class="list-group list-group-collapse list-group-sm list-group-tree" id="list-group-men" data-children=".sub-men">
                            	<a href="<%=request.getContextPath()%>/front-end/prod/shop.jsp"
                            		class="list-group-item list-group-item-action" id="type" style="font-size:22px; font-weight: bold;">所有商品總覽</a>
                            	<c:forEach var="prod_typeVO" items="${list2}">
                            		<a href="<%=request.getContextPath()%>/front-end/prod/shopByType.jsp?${prod_typeVO.prod_type_no}"
                            			class="list-group-item list-group-item-action" id="type">● ${prod_typeVO.prod_type_name}</a>
                            	</c:forEach>
                            	
<!--                                 <div class="list-group-collapse sub-men"> -->
<!--                                     <a class="list-group-item list-group-item-action" href="#sub-men1" data-toggle="collapse" aria-expanded="true" aria-controls="sub-men1">各式基酒 -->
<!-- 								</a> -->
<!--                                     <div class="collapse show" id="sub-men1" data-parent="#list-group-men"> -->
<!--                                         <div class="list-group"> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">威士忌 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">伏特加 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">琴酒 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">紅酒 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">龍舌蘭 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">蘭姆酒 <small class="text-muted"></small></a> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                                 <div class="list-group-collapse sub-men"> -->
<!--                                     <a class="list-group-item list-group-item-action" href="#sub-men2" data-toggle="collapse" aria-expanded="false" aria-controls="sub-men2">調酒器材 -->
<!-- 								</a> -->
<!--                                     <div class="collapse" id="sub-men2" data-parent="#list-group-men"> -->
<!--                                         <div class="list-group"> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">量酒器 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">雪克杯 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">隔冰器 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">吧叉匙 <small class="text-muted"></small></a> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                                 <div class="list-group-collapse sub-men"> -->
<!--                                     <a class="list-group-item list-group-item-action" href="#sub-men3" data-toggle="collapse" aria-expanded="false" aria-controls="sub-men3">調酒懶人包 -->
<!-- 								</a> -->
<!--                                     <div class="collapse" id="sub-men3" data-parent="#list-group-men"> -->
<!--                                         <div class="list-group"> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">經典調酒懶人包 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">便利商店調酒懶人包 <small class="text-muted"></small></a> -->
<!--                                             <a href="#" class="list-group-item list-group-item-action">微醺調酒懶人包 <small class="text-muted"></small></a> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Shop Page -->

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