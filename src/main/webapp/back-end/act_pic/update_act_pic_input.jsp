<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.act_pic.model.*"%>

<%
Act_pic_VO act_picVO = (Act_pic_VO) request.getAttribute("act_picVO");
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
<style>
input[disabled] {
	background-color: #eee;
	cursor: not-allowed;
}

#preview {
	border: 3px solid grey;
	display: inline-block;
	width: 150px;
	min-height: 100px;
	position: relative;
}

#preview span.text {
	position: absolute;
	display: inline-block;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	z-index: -1;
	color: lightgray;
}

#preview img.preview_img {
	width: 100%;
}
</style>
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
										<a href="listAllAct_pic.jsp"><img src="./images/home.png" width="30px" height="30px"></a>
										</button>
										<button style="margin-right:10px;">
										<a href='addAct_pic.jsp'><img src="./images/plus.png" width="30px" height="30px"></a>
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
									<h4 class="card-title">活動圖片修改</h4>
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
										
										
										<FORM METHOD="post" ACTION="act_pic.do" name="form1"
											enctype="multipart/form-data">
											<table >
												<tr>
													<td>活動名稱:</td> 
													<td>${act_picVO.getActVO().act_name}</td> 
												</tr>

												<tr>
													<td>活動照片:</td>
													<td><input type="file" name="act_pic" size="45"
														value=null id="file" /></td>
													<td>原圖:</td>
													<td><img
														src="<%=request.getContextPath()%>/Show_Act_pic_Servlet?act_pic_no=${act_picVO.act_pic_no}"
														width=150px height=100px></td>
													<td>更改為→→</td>
													<td>
														<div id="preview">
															<span class="text">預覽圖</span>
														</div>
													</td>
												</tr>
												<tr>
													<td>活動照片名稱:</td>
													<td><input type="TEXT" name="act_pic_name" size="25"
														value="<%=(act_picVO == null) ? "" : act_picVO.getAct_pic_name()%>" /></td>
												</tr>
											</table>

											<br> <input type="hidden" name="action" value="update">
											<input type="hidden" name="act_no"
												value="<%=act_picVO.getAct_no()%>">
											<input type="hidden" name="act_pic_no"
												value="<%=act_picVO.getAct_pic_no()%>"> <input
												type="submit" value="送出修改">
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
<script>
	window
			.addEventListener(
					"load",
					function(e) {
						var preview_el = document.getElementById("preview");
						var p_file_el = document.getElementById("file");
						var preview_img = function(file) {
							var reader = new FileReader(); // 用來讀取檔案
							reader.readAsDataURL(file); // 讀取檔案
							reader
									.addEventListener(
											"load",
											function() {
												var img_str = '<img src="' + reader.result + '" class="preview_img">';
												preview_el.innerHTML = img_str;

											});
						};
						p_file_el
								.addEventListener(
										"change",
										function(e) {
											if (this.files.length > 0) {
												preview_img(this.files[0]);
											} else {
												preview_el.innerHTML = '<span class="text">預覽圖</span>';
											}
										});
					});
</script>

</html>