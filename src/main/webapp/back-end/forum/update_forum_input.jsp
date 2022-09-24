<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.forum.model.*"%>

<%
Forum_VO forum_VO = (Forum_VO) request.getAttribute("forum_VO");
%>

<html lang="zh">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar【後端】</title>
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
<style>
.button {
    text-decoration: none;           /* 去除下底線 */
    display: inline-block;           /* 變成行內區塊 */
    font-size: 10px;                 /* 文字大小 */
    color: white;                    /* 文字顏色 */
    background: gray;                /* 按鈕背景顏色 */
    padding: 5px 10px 5px 10px;      /* 文字到邊框的間距 */
    border: 1px solid black;         /* 邊框設定 */
    border-radius: 5px;              /* 邊框圓角設定 */
}
</style>
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
							<h3 class="mb-0 font-weight-bold">討論區管理員</h3>
						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
<!-- 										<button style="margin-right: 10px;"> -->
<!-- 											<a href="listAllForum.jsp"><img -->
<!-- 												src="./images/home.png" width="30px" height="30px"></a> -->
<!-- 										</button> -->
										<button style="margin-right: 10px;">
											<a href='addForum.jsp'><img src="./images/plus.png"
												width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a href="select_page.jsp"><img src="./images/search2.png"
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
									<h4 class="card-title">討論區修改</h4>
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

										<FORM METHOD="post" ACTION="forum1.do" name="form1">
											<table class="table table-striped">
												<tr>
													<td>討論區名稱 :</td>
													<td><input type="TEXT" name="frm_name_no" size="45"
														value="<%=(forum_VO == null) ? "" : forum_VO.getFrm_name_no()%>" /></td>
												</tr>
<!-- 												<tr> -->
<!-- 													<td>討論區狀態 :</td> -->
<!-- 													<td><input type="TEXT" name="frm_status" size="45" -->
<%-- 														value="<%=(forum_VO == null) ? "1" : forum_VO.getFrm_status()%>" /></td> --%>
<!-- 												</tr> -->
												<tr>
													<td>討論區狀態 :</td>
													<td>
														<select size="1" name="frm_status" value="<%=(forum_VO == null) ? "" : forum_VO.getFrm_status()%>">
          														<option>0</option>
          														<option>1</option>
       													</select>	
       												</td>
       											</tr>
											</table>

											<br> <input type="hidden" name="action" value="update">
											<input type="hidden" name="frm_no"
												value="<%=forum_VO.getFrm_no()%>"> <input
												type="submit" value="修改" class="button">
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