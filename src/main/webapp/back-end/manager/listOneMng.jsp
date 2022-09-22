<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.manager.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  Manager_VO manager_VO = (Manager_VO) request.getAttribute("manager_VO"); //Manager_Servlet.java(Concroller), 存入req的manager_VO物件
  
  Manager_Service manager_Svc = new Manager_Service();
%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar【後端】</title>
<!-- base:css -->

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


  <!-- base:css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/vendors/typicons.font/font/typicons.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- inject:css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/css/vertical-layout-light/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="<%=request.getContextPath()%>/back-end/images/favicon.png" />
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
      <<div class="main-panel">
        <div class="content-wrapper">
          <div class="row">

  <div class="col-lg-12 grid-margin stretch-card">
    <div class="card" style="border-radius: 15px">
      <div class="card-body">
        <h4 class="card-title" style="text-align:center;">朧醴 LonelyBar【管理員】</h4>
        <p class="card-description">
          <code></code>
        </p>
        <div class="table-responsive">
          <table class="table table-striped" style="text-align:center;">
	<tr>
		<th>管理員編號</th>
		<th>管理員帳號</th>
		<th>管理員密碼</th>
		<th>管理員姓名</th>
		<th>管理員手機</th>
		<th>管理員照片</th>
		<th>管理員狀態</th>
	</tr>
	<tr>
		<td><%=manager_VO.getMng_no()%></td>
		<td><%=manager_VO.getMng_account()%></td>
		<td><%=manager_VO.getMng_password()%></td>
		<td><%=manager_VO.getMng_name()%></td>
		<td><%=manager_VO.getMng_phone()%></td>
		<td><img src="<%=request.getContextPath()%>/ManagerImage?mng_no=${manager_VO.mng_no}" width=60px height=60px></td>
		<td><%=manager_VO.getMng_status()%></td>
	</tr>
</table>
</div>
</div>
</div>
</div>
</div>
</div>

<!-- container-scroller -->
    <!-- base:js -->
    <script src="<%=request.getContextPath()%>/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page-->
    <!-- End plugin js for this page-->
    <!-- inject:js -->
    <script src="<%=request.getContextPath()%>/js/off-canvas.js"></script>
    <script src="<%=request.getContextPath()%>/js/hoverable-collapse.js"></script>
    <script src="<%=request.getContextPath()%>/js/template.js"></script>
    <script src="<%=request.getContextPath()%>/js/settings.js"></script>
    <script src="<%=request.getContextPath()%>/js/todolist.js"></script>
    <script>

    </script>
    <!-- endinject -->
    <!-- plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- Custom js for this page-->
    <!-- End custom js for this page-->
    
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
        let path = "http://";
      	let hostname = window.location.host;
    	let pathname = window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2));
    	 
		return path+hostname+pathname;
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