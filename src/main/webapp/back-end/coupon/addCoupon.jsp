<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.coupon.model.*"%>

<%
Coupon_VO couponVO = (Coupon_VO) request.getAttribute("couponVO");
%>

<html lang="zh">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar【後台】</title>
<!-- base:css -->
<script type="text/javascript">
	let path = window.location.pathname.substring(0, window.location.pathname
			.lastIndexOf("/"));
	path = path.substring(0, path.lastIndexOf("/"));
</script>

<link rel="stylesheet" href="../vendors/typicons.font/font/typicons.css">
<link rel="stylesheet" href="../vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="../css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="../images/favicon.png" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>

<body>
	<!-- 主頁面 -->
	<div class="container-scroller">
		<!-- 引入nav(頂部含廣告) -->
		<script src="../js/nav.js"></script>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<!-- 引入浮動視窗 -->
			<script src="../js/floating_window.js"></script>
			<!-- partial -->
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar"></nav>
			<!-- 引入sidebar 用JQ方式 -->
			<script>
				$(function() {
					$("#sidebar").load("../partials/_sidebar.html");
				});
			</script>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-sm-6">
							<h3 class="mb-0 font-weight-bold">商品管理員</h3>

						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right:10px;">
										<a href="listAllProd_pic.jsp"><img src="./images/home.png" width="30px" height="30px"></a>
										</button>
									</div>
								</div>
								<div class="pr-1 mb-3 mr-2 mb-xl-0">
									<button type="button"
										class="btn btn-sm bg-white btn-icon-text border">
										<i class="typcn typcn-arrow-forward-outline mr-2"></i>Export
									</button>
								</div>
								<div class="pr-1 mb-3 mb-xl-0">
									<button type="button"
										class="btn btn-sm bg-white btn-icon-text border">
										<i class="typcn typcn-info-large-outline mr-2"></i>info
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row  mt-3">
						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">商品圖片修改</h4>
									<div class="table-responsive">
										<%-- 錯誤表列 --%>
										<c:if test="${not empty errorMsgs}">
											<font style="color: red">請修正以下錯誤:</font>
											<ul>
												<c:forEach var="message" items="${errorMsgs}">
													<li style="color: red">${message}</li>
												</c:forEach>
											</ul>
										</c:if>
										
										<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/coupon/coupon.do" name="coupon_form"
											>
											<table class="table table-striped">
												<tr>
													<td>優惠券名稱:</td> 
													<td><input type="TEXT" name="coupon_name" size="25"
													value="<%=(couponVO == null) ? "" : couponVO.getCoupon_name()%>"/></td> 
												</tr>
												<tr>
													<td>優惠券代碼:</td> 
													<td><input type="TEXT" name="coupon_code" size="25" 
													value="<%=(couponVO == null) ? "" : couponVO.getCoupon_code()%>"/></td> 
												</tr>
												<tr>
													<td>優惠券內容:</td> 
													<td><textarea name="coupon_content" rows="6" cols="26"
													><%=(couponVO == null) ? "" : couponVO.getCoupon_content()%></textarea></td> 
												</tr>
												<tr>
													<td>優惠券折扣:</td> 
													<td><input type="TEXT" name="coupon_discount" size="25"
														value="<%=(couponVO == null) ? "" : couponVO.getCoupon_discount()%>" /></td> 
												</tr>								
												<tr>
													<td>優惠券有效期間開始日期:</td> 
													<td><input type="datetime-local" name="launch_time" size="25"
														value="<%=(couponVO == null) ? "2018-06-12T19:30" : couponVO.getLaunch_time()%>" /></td> 
												</tr>
												<tr>
													<td>優惠券有效期間結束日期:</td> 
													<td><input type="datetime-local" name="off_time" size="25"
														value="<%=(couponVO == null) ? "2018-06-12T19:30" : couponVO.getOff_time()%>" /></td> 
												</tr>
												<tr>
													<td>優惠券狀態:</td> 
													<td>
													<div class="form-group row">
				                           			  <div class="col-sm-5">
				                           				 <div class="form-check">
				                           				   <label class="form-check-label">
				                              				  <input type="radio" class="form-check-input" name="status" id="couponRadios1" value="0" >
				                                				啟用
				                             					 <i class="input-helper"></i><i class="input-helper"></i></label>
				                            			</div>
				                          			 </div>
				                          			 <div class="col-sm-5">
				                           				 <div class="form-check">
				                           				   <label class="form-check-label">
				                            				   <input type="radio" class="form-check-input" name="status" id="couponRadios2" value="1" checked>
				                              					  停用
				                              						<i class="input-helper"></i><i class="input-helper"></i></label>
				                          				  </div>
				                       				   </div>	                     		
				                          			 </div>
				                         		   </td>
												</tr>

											</table>
											
											<input type="hidden" name="action" value="insert">
											<input type="submit" value="新增" >
										</FORM>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<!-- 引入footer 用JQ方式 -->
				<footer class="footer"></footer>
				<script>
					$(function() {
						$(".footer").load("../partials/_footer.html");
					});
				</script>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- base:js -->

	<script>
		function getContextPath() {
			return window.location.pathname.substring(0,
					window.location.pathname.indexOf('/', 2));
		}
	</script>
	<script src="../vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="../js/off-canvas.js"></script>
	<script src="../js/hoverable-collapse.js"></script>
	<script src="../js/template.js"></script>
	<script src="../js/settings.js"></script>
	<script src="../js/todolist.js"></script>
	<!-- endinject -->
	<!-- plugin js for this page -->
	<script src="../vendors/progressbar.js/progressbar.min.js"></script>
	<script src="../vendors/chart.js/Chart.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- Custom js for this page-->

	<script src="../js/dashboard.js"></script>
	<!-- End custom js for this page-->
</body>

</html>