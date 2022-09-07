<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style>
.btn-c{
border-radius:50%;
border: 2px solid #e8eff9;
}
.btn-c:hover{
border: 2px solid #266ed4;
}
</style>	
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
					<!--你要寫的頁面  -->
					<div class="btn-group" role="group" aria-label="Basic example"
						style="margin: 10px">
						<button type="button" value="審核通過"
							class="btn btn-inverse-success btn-fw btn-outline-secondary">審核成功</button>
						<button type="button" value="待審核"
							class="btn btn-inverse-secondary btn-fw btn-outline-secondary">等待審核</button>
						<button type="button" value="審核失敗"
							class="btn btn-inverse-danger btn-fw btn-outline-secondary">審核失敗</button>
						<button type="button" value=""
							class="btn btn-inverse-dark btn-fw btn-outline-secondary">全部</button>
					</div>
					<table id="dataTables" class="stripe table-hover" style="width: 100%">
						<thead>
							<tr>
								<th style="width:30px">酒吧編號</th>
								<th style="width:120px">酒吧名稱</th>
								<th style="width:60px">審核狀態</th>
								<th style="width:60px">容納人數</th>
								<th style="width:70px">建立時間</th>
								<th>酒吧地址</th>
								<th style="width:30px">設定</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pubVO" items="${pubList}" varStatus="loop">
								<tr>
									<td>${pubVO.pub_no}</td>
									<td>${pubVO.pub_name}</td>
									<td>${pubVO.pub_application==0?"待審核":pubVO.pub_application==1?"審核通過":"審核失敗"}</td>
									<td>${pubVO.pub_nop}</td>
									<td>${pubVO.pub_time}</td>
									<td>${pubVO.pub_address}</td>
									<td><button class="btn-c" type="button" id="btn${loop.index}" onclick="getdate(${pubVO.pub_no})"><img  src="<%=request.getContextPath()%>/back-end/images/brush.svg"></img></button></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>酒吧編號</th>
								<th>酒吧名稱</th>
								<th>審核狀態</th>
								<th>容納人數</th>
								<th>建立時間</th>
								<th>酒吧地址</th>
								<th>設定</th>
							</tr>
						</tfoot>
					</table>

					<script>
						$(document).ready(function() {
							$('#dataTables').DataTable();
						});
						
					    document.querySelectorAll(".btn-outline-secondary").forEach(e=>{e.addEventListener('click',()=>{
					        var table = $('#dataTables').DataTable();
		                    table.column(2).search(e.value).draw();
					    	});
    					});
					</script>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<!-- 引入footer 用JQ方式 -->
				<footer class="footer"></footer>
				<script>
					$(function() {
						$(".footer").load(
								window.location.pathname.substring(0,
										window.location.pathname
												.indexOf('/', 2))
										+ "/back-end/partials/_footer.html");
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
	<script>document</script>
	<script
		src="<%=request.getContextPath()%>/back-end/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/back-end/js/off-canvas.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/todolist.js"></script>
	<!-- endinject -->
	<!-- plugin js for this page -->
	<script
		src="<%=request.getContextPath()%>/back-end/vendors/progressbar.js/progressbar.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/vendors/chart.js/Chart.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- Custom js for this page-->

	<script src="<%=request.getContextPath()%>/back-end/js/dashboard.js"></script>
	<script
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/getModel.js"></script>
	<!-- End custom js for this page-->
	<script> function getId(i){
	}</script>
</body>

</html>