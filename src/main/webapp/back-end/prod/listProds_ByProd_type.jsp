<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.prod.model.*"%>

<jsp:useBean id="prod_typeSvc" scope="page" class="com.prod_type.model.Prod_type_Service" />

<!DOCTYPE html>
<html lang="zh">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar【後台】</title>
<!-- base:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/typicons.font/font/typicons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" />
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
							<h3 class="mb-0 font-weight-bold">商品管理員</h3>
							
						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right: 10px;">
											<a href="listAllProd.jsp"><img
												src="./images/home.png" width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a href='addProd.jsp'><img src="./images/plus.png"
												width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a href="selectProd.jsp"><img src="./images/search2.png"
												width="30px" height="30px"></a>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row  mt-3">
						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">商品清單管理</h4>
									<table id="dataTables" class="stripe table-hover" style="width: 100%">
										<thead>
											<tr>
												<th>商品編號</th>
												<th>商品種類</th>
												<th>商品名稱</th>
												<th>商品照片</th>
												<th>商品單價</th>
												<th>庫存數量</th>
												<th>商品狀態</th>
												<th>上架時間</th>
<!-- 												<th>下架時間</th> -->
												<th>商品敘述</th>
												<th>商品管理</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="prodVO" items="${listProds_ByProd_type}">
												<tr>
													<td>${prodVO.prod_no}</td>
													<td>${prodVO.getProd_type_VO().prod_type_name}</td>
													<td>${prodVO.prod_name}</td>
													<td><img
														src="<%=request.getContextPath()%>/ShowProd_picForProd?prod_no=${prodVO.getProd_pic_VO().prod_pic_no}"
														width=110px height=75px></td>
													<td>${prodVO.prod_price}</td>
													<td style="text-align:left;">${prodVO.prod_stock}</td>
													<td>
														<c:if test="${prodVO.prod_status == 1}">
															<div>已上架</div>
														</c:if>
														<c:if test="${prodVO.prod_status == 0}">
															<div>已下架</div>
														</c:if>
													</td>
													<td>${prodVO.launch_time}</td>
<!-- 													<td> -->
<%-- 														<c:if test="${empty prodVO.off_time}"> --%>
<!-- 															<div>暫無下架時間</div> -->
<%-- 														</c:if> --%>
<%-- 														<c:if test="${not empty prodVO.off_time}"> --%>
<%-- 															<div>${prodVO.off_time}</div> --%>
<%-- 														</c:if> --%>
<!-- 													</td> -->
													<td style="max-width: 300px">${prodVO.prod_detail}</td>
													<td>
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/back-end/prod/prod.do"
															style="margin-bottom: 0px;">
															<input type="submit" value="管理"> <input
																type="hidden" name="prod_no" value="${prodVO.prod_no}">
															<input type="hidden" name="action"
																value="getOne_For_Update">
														</FORM>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
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