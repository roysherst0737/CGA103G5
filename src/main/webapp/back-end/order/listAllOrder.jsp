<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.order.model.*"%>

<%
    Order_Service orderSvc = new Order_Service();
    List<Order_VO> list = orderSvc.getAll();
    pageContext.setAttribute("list",list);
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
							<p>上次登入：21小時前</p>
						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right:10px;">
										<a href="listAllOrder.jsp"><img src="./images/home.png" width="30px" height="30px"></a>
										</button>
										<button style="margin-right:10px;">
										<a href="selectOrder.jsp"><img src="./images/search2.png" width="30px" height="30px"></a>
										</button>
										<button
											class="btn bg-white btn-sm dropdown-toggle btn-icon-text border mr-2"
											type="button" id="dropdownMenu3" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">
											<i class="typcn typcn-calendar-outline mr-2"></i>Last 7 days
										</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuSizeButton3"
											data-x-placement="top-start">
											<h6 class="dropdown-header">Last 14 days</h6>
											<a class="dropdown-item" href="#">Last 21 days</a> <a
												class="dropdown-item" href="#">Last 28 days</a>
										</div>
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
									<h4 class="card-title">訂單管理</h4>
										<table id="dataTables" class="stripe table-hover" style="width: 100%; font-size: 12px">
										<div>
										<%@ include file="page1.file"%>
										</div>
										<br>
											<thead>
												<tr>
													<th>訂單編號</th>
													<th>會員編號</th>
													<th>訂單建立時間</th>
													<th>訂單總金額</th>
													<th>優惠後金額</th>
													<th>訂單狀態</th>
													<th>付款方式</th>
													<th>取貨方式</th>
													<th>運費</th>
													<th>取貨人姓名</th>
													<th>取貨人地址</th>
													<th>取貨人電話</th>
													<th>訂單明細</th>
													<th>出貨狀態更改</th>
												</tr>
											</thead>
											<c:forEach var="orderVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
												<tr>
													<td>${orderVO.order_no}</td>
													<td>${orderVO.mem_no}</td>
													<td>${orderVO.order_time}</td>
													<td>${orderVO.order_price_total}</td>
													<td>${orderVO.dis_price_total}</td>
													<td>
														<c:if test="${orderVO.order_status == 0}">
															<div style="color: blue;">未出貨</div>
														</c:if>
														<c:if test="${orderVO.order_status == 1}">
															<div style="color: yellow;">已出貨</div>
														</c:if>
														<c:if test="${orderVO.order_status == 2}">
															<div style="color: green;">已完成</div>
														</c:if>
														<c:if test="${orderVO.order_status == 3}">
															<div style="color: red;">取消</div>
														</c:if>
													</td>
													<td>
														<c:if test="${orderVO.payment_method == 0}">
															<div>貨到付款</div>
														</c:if>
														<c:if test="${orderVO.payment_method == 1}">
															<div>信用卡</div>
														</c:if>
													</td>
													<td>
														<c:if test="${orderVO.pickup_method == 0}">
															<div>宅配</div>
														</c:if>
														<c:if test="${orderVO.pickup_method == 1}">
															<div>7-11</div>
														</c:if>
														<c:if test="${orderVO.pickup_method == 2}">
															<div>全家</div>
														</c:if>
													</td>
													<td>
														<c:if test="${orderVO.shipping_fee == 0}">
															<div>免運</div>
														</c:if>
														<c:if test="${orderVO.shipping_fee == 1}">
															<div>超商60元</div>
														</c:if>
														<c:if test="${orderVO.shipping_fee == 2}">
															<div>宅配100元</div>
														</c:if>
													</td>
													<td>${orderVO.receiver_name}</td>
													<td>${orderVO.receiver_address}</td>
													<td>${orderVO.receiver_phone}</td>
													<td>
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/back-end/order/order.do"
															style="margin-bottom: 0px;">
															<input type="submit" value="查詢"> <input
																type="hidden" name="order_no"
																value="${orderVO.order_no}"> <input
																type="hidden" name="action" value="listOrder_details_ByOrder">
														</FORM>
													</td>
													<td>
														<FORM METHOD="post"
															ACTION="<%=request.getContextPath()%>/back-end/order/order.do"
															style="margin-bottom: 0px;">
															<input type="submit" value="更改狀態"> <input
																type="hidden" name="order_no"
																value="${orderVO.order_no}"> <input
																type="hidden" name="action" value="getOne_For_Update">
														</FORM>
													</td>
												</tr>
											</c:forEach>
										</table>
										<%@ include file="page2.file"%>
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