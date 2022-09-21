<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.coupon.model.*"%>
<%@ page import="com.prod_type.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
Coupon_Service couponSvc = new Coupon_Service();
List<Coupon_VO> list = couponSvc.getAll();
pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html lang="zh">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar【後端】</title>
<!-- base:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/typicons.font/font/typicons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/style.css" />
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/back-end/images/favicon.png" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	let path = window.location.pathname.substring(0, window.location.pathname
			.lastIndexOf("/"));
	path = path.substring(0, path.lastIndexOf("/"));
</script>
</head>

<body>
	<!-- 主頁面 -->
	<div class="container-scroller">
		<!-- 引入nav(頂部含廣告) -->
		<script src="<%=request.getContextPath()%>/back-end/js/nav.js"></script>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<!-- 引入浮動視窗 -->
			<script
				src="<%=request.getContextPath()%>/back-end/js/floating_window.js"></script>
			<!-- partial -->
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar"></nav>
			<!-- 引入sidebar 用JQ方式 -->
			<script>
				$(function() {
					$("#sidebar").load(
							window.location.pathname.substring(0,
									window.location.pathname.indexOf('/', 2))
									+ "/back-end/partials/_sidebar.html");
				});
			</script>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-sm-6">
							<h3 class="mb-0 font-weight-bold">優惠券資料管理</h3>

						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right: 10px;">
											<a href="listAllProd_type.jsp"><img
												src="./images/home.png" width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a href='addCoupon.jsp'><img src="./images/plus.png"
												width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a href="selectProd_type.jsp"><img
												src="./images/search2.png" width="30px" height="30px"></a>
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
											<h4 class="card-title">優惠券資料</h4>

											<div class="horizontal_style">
												<table class="table table-striped">
													<thead>
														<tr>
															<th>編號</th>
															<th>名稱</th>
															<th>代碼</th>
															<th>內容</th>
															<th>折扣</th>
															<th>使用數量</th>
															<th>有效期間開始日期</th>
															<th>有效期間結束日期</th>
															<th>建立時間</th>
															<th>狀態</th>															
														</tr>
													</thead>
													<%@ include file="page1.file" %> 
														<c:forEach var="couponVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
															
															<tr>
																<td>${couponVO.coupon_no}</td>
																<td>${couponVO.coupon_name}</td>
																<td>${couponVO.coupon_code}</td>																
																<td>${couponVO.coupon_content}</td>
																<td>${couponVO.coupon_discount}</td> 
																<td>${couponVO.coupon_amount}</td>
																<td>${couponVO.launch_time}</td>
																<td>${couponVO.off_time}</td>
																<td>${couponVO.coupon_build_time}</td>																													
																<c:choose>
														   			<c:when test="${couponVO.status==0}">
														   				<td>啟用</td>
														  			 </c:when>
														  			<c:otherwise>
														   				<td>停用</td>
														  			</c:otherwise>
																</c:choose>
																<td>
																  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/coupon/coupon.do" style="margin-bottom: 0px;">
																     <input type="submit" class="btn btn-outline-secondary btn-sm" value="修改">
																     <input type="hidden" name="coupon_no"  value="${couponVO.coupon_no}">
																     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
																</td>
																<td>
																  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/coupon/coupon.do" style="margin-bottom: 0px;">
																     <input type="submit" class="btn btn-outline-primary btn-sm" value="刪除">
																     <input type="hidden" name="coupon_no"  value="${couponVO.coupon_no}">
																     <input type="hidden" name="action" value="delete"></FORM>
																</td>
															</tr>
														</c:forEach>
													</table>
													<%@ include file="page2.file" %>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
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