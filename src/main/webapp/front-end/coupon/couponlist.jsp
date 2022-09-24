<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.coupon.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.mem_coupon.model.*"%>
<%@ page import="java.util.ArrayList"%>


<%
Object Objuser = session.getAttribute("user");
Mem_VO user = (Mem_VO) Objuser;

Coupon_Service couponSvc = new Coupon_Service();
List<Coupon_VO> couponlist = couponSvc.getAll();
pageContext.setAttribute("couponlist",couponlist);

Mem_Coupon_Service mcouponSvc = new Mem_Coupon_Service();

ArrayList<Mem_Coupon_VO> haveCoupon = new ArrayList<Mem_Coupon_VO>();

for(int number = 1; number<=couponlist.size(); number++){
	haveCoupon.add(mcouponSvc.getOneCoupon(number,user.getMem_no()));
}
pageContext.setAttribute("haveCoupon",haveCoupon);
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
                    <h2>領取優惠券</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/front-end/mem/my-account.jsp">會員專區</a></li>
                        <li class="breadcrumb-item active">領取優惠券</li>
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
						<table id="dataTables" class="stripe table-hover" style="width: 100%; font-size: 12px">
							<thead>
								<tr style="font-size:16px">
									<th>優惠券名稱</th>
									<th>優惠券內容</th>
									<th>有效期間開始日期</th>
									<th>有效期間結束日期</th>				
									<th>優惠券領取</th>				
								</tr>
							</thead>
							<c:forEach var="couponVO" items="${couponlist}" varStatus="status">
							<c:if test="${couponVO.status == 0}">
								<tr>
									<td>${couponVO.coupon_name}</td>
									<td>${couponVO.coupon_content}</td>
									<td>${couponVO.launch_time}</td>
									<td>${couponVO.off_time}</td>
									<td>
										<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/memcoupon/MemCouponServlet"
											style="margin-bottom: 0px;">
											<c:choose>
											
												<c:when test="${empty haveCoupon.get(status.index)}">
												<input type="submit" value="領取">
												<input type="hidden" name="coupon_no" value="${couponVO.coupon_no}">
												<input type="hidden" name="action" value="getcoupon">
												</c:when>
												
												<c:otherwise>
												<input type="submit"  value="領取" disabled="disabled">
												<input type="hidden" name="order_no" value="${orderVO.order_no}" >
												<input type="hidden" name="action" value="listFrontOrder_details">
												
												</c:otherwise>
											
											</c:choose>
											
										</FORM>
									</td>									
								</tr>
								</c:if>
							</c:forEach>
						</table>
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