<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.prod.model.*"%>
<%@ page import="com.prod_pic.model.*"%>

<%
Prod_Service prodSvc = new Prod_Service();
List<Prod_VO> list = prodSvc.getAll();
pageContext.setAttribute("list", list);

Prod_VO prodVO = prodSvc.getOneProd(Integer.parseInt(request.getQueryString()));
request.setAttribute("prodVO", prodVO);
Set<Prod_pic_VO> set = prodSvc.getProd_picsByProd(prodVO.getProd_no());
pageContext.setAttribute("set", set);
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
    <link rel="stylesheet" href="css/custom.css">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

	<style>
		.btn {
    		width: auto;
    		height: auto;
			}
		#subPic {
			width: auto;
    		height: auto;
    		padding: 0;
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
                    <h2>商品詳情</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/front-end/prod/shop.jsp">回商城</a></li>
                        <li class="breadcrumb-item active">詳情 </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Shop Detail  -->
    <div class="shop-detail-box-main">
        <div class="container">
            <div class="row">
                <div class="col-xl-5 col-lg-5 col-md-6">
                    <div id="carousel-example-1" class="single-product-slider carousel slide" data-ride="carousel">
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                            <c:forEach var="prod_picVO" items="${set}" begin="0" end="0"> 
                            <img class="d-block w-100" 
                            	src="<%=request.getContextPath()%>/Show_Prod_pic_Servlet?prod_pic_no=${prod_picVO.prod_pic_no}"
								width=450px height=320px alt="First slide">
							</c:forEach>
							</div>
                            <div class="carousel-item">
                            <c:forEach var="prod_picVO" items="${set}" begin="1" end="1"> 
                            <img class="d-block w-100" 
                            	src="<%=request.getContextPath()%>/Show_Prod_pic_Servlet?prod_pic_no=${prod_picVO.prod_pic_no}"
								width=450px height=320px alt="First slide">
							</c:forEach>
							</div>
                            <div class="carousel-item">
                            <c:forEach var="prod_picVO" items="${set}" begin="2" end="2"> 
                            <img class="d-block w-100" 
                            	src="<%=request.getContextPath()%>/Show_Prod_pic_Servlet?prod_pic_no=${prod_picVO.prod_pic_no}"
								width=450px height=320px alt="First slide">
							</c:forEach>
							</div>
                        </div>
                        <a class="carousel-control-prev" href="#carousel-example-1" role="button" data-slide="prev"> 
						<i class="fa fa-angle-left" aria-hidden="true"></i>
						<span class="sr-only">Previous</span> 
					</a>
                        <a class="carousel-control-next" href="#carousel-example-1" role="button" data-slide="next"> 
						<i class="fa fa-angle-right" aria-hidden="true"></i> 
						<span class="sr-only">Next</span> 
					</a>
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-1" data-slide-to="0" class="active">
                                <c:forEach var="prod_picVO" items="${set}" begin="0" end="0"> 
                            		<img class="d-block w-100" id="subPic" 
                            			src="<%=request.getContextPath()%>/Show_Prod_pic_Servlet?prod_pic_no=${prod_picVO.prod_pic_no}"
										width=200px height=180px alt="First slide">
								</c:forEach>
                            </li>
                            <li data-target="#carousel-example-1" data-slide-to="1">
                                <c:forEach var="prod_picVO" items="${set}" begin="1" end="1"> 
                            		<img class="d-block w-100" id="subPic"
                            			src="<%=request.getContextPath()%>/Show_Prod_pic_Servlet?prod_pic_no=${prod_picVO.prod_pic_no}"
										width=200px height=180px alt="First slide">
								</c:forEach>
                            </li>
                            <li data-target="#carousel-example-1" data-slide-to="2">
                                <c:forEach var="prod_picVO" items="${set}" begin="2" end="2"> 
                            		<img class="d-block w-100" id="subPic"
                            			src="<%=request.getContextPath()%>/Show_Prod_pic_Servlet?prod_pic_no=${prod_picVO.prod_pic_no}"
										width=200px height=180px alt="First slide">
								</c:forEach>
                            </li>
                        </ol>
                    </div>
                </div>
                <div class="col-xl-7 col-lg-7 col-md-6">
                    <div class="single-product-details">
                        <h2>${prodVO.prod_name}</h2>
                        <h5>$${prodVO.prod_price}</h5>
                        <p class="available-stock"><span> 現有庫存： <a href="#">${prodVO.prod_stock}</a></span><p>
						<h4>商品詳情：</h4>
						<p>${prodVO.prod_detail}</p>
						<ul>
							<li>
								<div class="form-group quantity-box">
									<label class="control-label">購買數量</label>
									<input class="form-control" value="0" min="0" max="20" type="number">
								</div>
							</li>
						</ul>

						<div class="price-box-bar">
							<div class="cart-and-bay-btn">
								<a class="btn hvr-hover" data-fancybox-close="" href="#">加入購物車</a>
							</div>
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