<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mem.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
Mem_Service memSvc = new Mem_Service();
List<Mem_VO> list = memSvc.getAll();
pageContext.setAttribute("list", list);
%>

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
<link rel="stylesheet" type="text/css"
	href="css/style.css" />
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
							<h3 class="mb-0 font-weight-bold">會員資料管理</h3>

						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right:10px;">
										<a href="<%=request.getContextPath()%>/back-end/index_back.html"><img src="./images/home.png" width="30px" height="30px"></a>
										</button>										
									</div>
								</div>
							</div>
						</div>
					</div>					
						<h4 class="card-title">會員資料</h4>

						<div class="horizontal_style">
							<table id="dataTables" class="table table-striped">
								<thead>
									<tr>
										<th>編號</th>
										<th>帳號</th>
										<th>密碼</th>
										<th>性別</th>
										<th>姓氏</th>
										<th>名字</th>
										<th>暱稱</th>
										<th>連絡電話</th>
										<th>手機號碼</th>
										<th>電子郵件</th>
										<th>身分證字號</th>
										<th>生日</th>
										<th>地址</th>
										<th>權限</th>
										<th>狀態</th>
										<th>創建日期</th>
<!-- 										<th>認證狀態</th> -->
										<th>啟用</th>
										<th>停用</th>															
									</tr>
								</thead>	
								<tbody>											
									<c:forEach var="memVO" items="${list}">
										
										<tr>
											<td>${memVO.mem_no}號</td>
											<td>${memVO.mem_account}</td>
											<td>${memVO.mem_password}</td>			
											<c:choose>
									   			<c:when test="${memVO.mem_gender==1}">
									   				<td>男性</td>
									  			 </c:when>
									  			 
									   			<c:when test="${memVO.mem_gender==0}">
									   				<td>女性</td>
									   			</c:when>
									   			
									  			<c:otherwise>
									   				<td>多元性別</td>
									  			</c:otherwise>
											</c:choose>
											<td>${memVO.mem_last_name}</td>
											<td>${memVO.mem_first_name}</td> 
											<td>${memVO.mem_nickname}</td>
											<td>${memVO.mem_tel_no}</td>
											<td>${memVO.mem_cel_no}</td>
											<td>${memVO.mem_email}</td>
											<td>${memVO.mem_id}</td> 
											<td>${memVO.mem_birth}</td>
											<td>${memVO.mem_addr}</td>
											<c:choose>
									   			<c:when test="${memVO.mem_permission==0}">
									   				<td>一般會員</td>
									  			 </c:when>
									  			<c:otherwise>
									   				<td>廠商會員</td>
									  			</c:otherwise>
											</c:choose>
											<c:choose>
									   			<c:when test="${memVO.status==0}">
									   				<td>啟用</td>
									  			 </c:when>
									  			<c:otherwise>
									   				<td>停用</td>
									  			</c:otherwise>
											</c:choose>
											<td>${memVO.mem_build_time}</td> 
<%-- 											<c:choose> --%>
<%-- 									   			<c:when test="${memVO.mem_cert_status==0}"> --%>
<!-- 									   				<td>待認證</td> -->
<%-- 									  			 </c:when>	   			 --%>
<%-- 									  			<c:otherwise> --%>
<!-- 									   				<td>認證通過</td> -->
<%-- 									  			</c:otherwise> --%>
<%-- 											</c:choose> --%>
											<td>
											  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/mem/changeMemStatus" style="margin-bottom: 0px;">
											     <input type="submit" class="btn btn-outline-secondary btn-sm" value="啟用">
											     <input type="hidden" name="mem_no"  value="${memVO.mem_no}">
											     <input type="hidden" name="action"	value="enable_status"></FORM>
											</td>
											<td>
											  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/mem/changeMemStatus" style="margin-bottom: 0px;">				     
									   			 <input type="submit" class="btn btn-outline-primary btn-sm" value="停用">													  			
											     <input type="hidden" name="mem_no"  value="${memVO.mem_no}">
											     <input type="hidden" name="action" value="unable_status">
											   </FORM>
											</td>
										</tr>
									</c:forEach>
									</tbody>
									<tfoot>
									<tr>
										<th>編號</th>
										<th>帳號</th>
										<th>密碼</th>
										<th>性別</th>
										<th>姓氏</th>
										<th>名字</th>
										<th>暱稱</th>
										<th>連絡電話</th>
										<th>手機號碼</th>
										<th>電子郵件</th>
										<th>身分證字號</th>
										<th>生日</th>
										<th>地址</th>
										<th>權限</th>
										<th>狀態</th>
										<th>創建日期</th>
<!-- 										<th>認證狀態</th> -->
										<th>啟用</th>
										<th>停用</th>
									</tr>
								</tfoot>
								</table>
								<script>
								$(document).ready(function () {
								    $('#dataTables').DataTable({
								        scrollY: 300,
								        scrollX: true,
								    });
								});
								</script>
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
	<script
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<!-- End custom js for this page-->
</body>

</html>