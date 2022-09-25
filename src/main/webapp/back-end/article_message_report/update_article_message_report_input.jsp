<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.article_message_report.model.*"%>

<%
Article_message_report_VO article_message_report_VO = (Article_message_report_VO) request
		.getAttribute("article_message_report_VO");
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
<style>
.button {
	text-decoration: none; /* 去除下底線 */
	display: inline-block; /* 變成行內區塊 */
	font-size: 10px; /* 文字大小 */
	color: white; /* 文字顏色 */
	background: gray; /* 按鈕背景顏色 */
	padding: 5px 10px 5px 10px; /* 文字到邊框的間距 */
	border: 1px solid black; /* 邊框設定 */
	border-radius: 5px; /* 邊框圓角設定 */
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
							<p>上次登入：21小時前</p>
						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right: 10px;">
											<a href="listAllArticle_message_report.jsp"><img
												src="./images/home.png" width="30px" height="30px"></a>
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
					</div>
					<div class="row  mt-3">
						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">文章留言檢舉修改</h4>
									<div class="tavble table-responsive">
										<%-- 錯誤表列 --%>
										<c:if test="${not empty errorMsgs}">
											<font style="color: red">請修正以下錯誤:</font>
											<ul>
												<c:forEach var="message" items="${errorMsgs}">
													<li style="color: red">${message}</li>
												</c:forEach>
											</ul>
										</c:if>

										<FORM METHOD="post" ACTION="article_message_report.do"
											name="form1">
											<table class="table table-striped">
<!-- 												<tr> -->
<!-- 													<td>檢舉留言編號:</td> -->
<!-- 													<td><input type="TEXT" name="art_msg_rpt" size="45" -->
<%-- 														value="<%=(article_message_report_VO == null) ? 1 : article_message_report_VO.getArt_msg_rpt()%>" /></td> --%>
<!-- 												</tr> -->
												<tr>
													<!-- 		<td>會員編號:</td> -->
													<!-- 		<td><input type="TEXT" name="mem_no" size="45" -->
													<%-- 			 value="<%= (article_message_report_VO==null)? 1 : article_message_report_VO.getMem_no()%>" /></td> --%>
													<!-- 	</tr> -->
													<!-- 	<tr> -->
													<!-- 		<td>留言編號:</td> -->
													<!-- 		<td><input type="TEXT" name="art_msg_no" size="45" -->
													<%-- 			 value="<%= (article_message_report_VO==null)? 1 : article_message_report_VO.getArt_msg_no()%>" /></td> --%>
													<!-- 	</tr> -->
												<tr>
													<td>檢舉時間:</td>
													<td><input name="rpt_time" id="f_date1" type="text"></td>
												</tr>
												<tr>
													<td>檢舉留言內容:</td>
													<td><input type="TEXT" name="rpt_msg_content"
														size="45"
														value="<%=(article_message_report_VO == null) ? "仇恨言論" : article_message_report_VO.getRpt_msg_content()%>" /></td>
												</tr>
												<!-- 	<tr> -->
												<!-- 		<td>管理員編號:</td> -->
												<!-- 		<td><input type="TEXT" name="mng_no" size="45" -->
												<%-- 			 value="<%= (article_message_report_VO==null)?1 : article_message_report_VO.getMng_no()%>" /></td> --%>
												<!-- 	</tr> -->
												<tr>
													<td>處理完成時間:</td>
													<td><input name="msg_done_time" id="f_date1"
														type="text"></td>
												</tr>
												<tr>
													<td>處理狀況:</td>
													<td><input type="TEXT" name="msg_status" size="45"
														value="<%=(article_message_report_VO == null) ? 0 : article_message_report_VO.getMsg_status()%>" /></td>
												</tr>
												<tr>
													<td>處理結果:</td>
													<td><input type="TEXT" name="msg_result" size="45"
														value="<%=(article_message_report_VO == null) ? 0 : article_message_report_VO.getMsg_result()%>" /></td>
												</tr>
												<tr>
													<td>處理註記:</td>
													<td><input type="TEXT" name="msg_note" size="45"
														value="<%=(article_message_report_VO == null) ? "" : article_message_report_VO.getMsg_note()%>" /></td>
												</tr>

												<jsp:useBean id="mem_Svc" scope="page"
													class="com.mem.model.Mem_Service" />
												<tr>
													<td>會員編號:<font color=red><b>*</b></font></td>
													<td><select size="1" name="mem_no">
															<c:forEach var="mem_VO" items="${mem_Svc.all}">
																<option value="${mem_VO.mem_no}"
																	${(article_message_report_VO.mem_no==mem_VO.mem_no)?'selected':'' }>${mem_VO.mem_account}
															</c:forEach>
													</select></td>
												</tr>
												<jsp:useBean id="article_message_Svc" scope="page"
													class="com.article_message.model.Article_message_Service" />
												<tr>
													<td>留言編號:<font color=red><b>*</b></font></td>
													<td><select size="1" name="art_msg_no">
															<c:forEach var="article_message_VO"
																items="${article_message_Svc.all}">
																<option value="${article_message_VO.art_msg_no}"
																	${(article_message_report_VO.art_msg_no==article_message_VO.art_msg_no)?'selected':'' }>${article_message_VO.mem_no}
															</c:forEach>
													</select></td>
												</tr>
												<jsp:useBean id="manager_Svc" scope="page"
													class="com.manager.model.Manager_Service" />
												<tr>
													<td>管理員編號:<font color=red><b>*</b></font></td>
													<td><select size="1" name="mng_no">
															<c:forEach var="manager_VO" items="${manager_Svc.allManager}">
																<option value="${manager_VO.mng_no}"
																	${(article_message_report_VO.mng_no==manager_VO.mng_no)?'selected':'' }>${manager_VO.mng_account}
															</c:forEach>
													</select></td>
												</tr>
											</table>

											<br> <input type="hidden" name="action" value="update">
											<input type="hidden" name="art_msg_rpt"
												value="<%=article_message_report_VO.getArt_msg_rpt()%>">
											<input type="submit" value="送出修改" class="button">
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