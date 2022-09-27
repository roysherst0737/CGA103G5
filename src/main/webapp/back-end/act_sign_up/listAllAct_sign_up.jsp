<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.act_sign_up.model.*"%>
<%@ page import="com.mem.model.*"%>

<%
Act_sign_up_Service act_sign_upSvc = new Act_sign_up_Service();
List<Act_sign_up_VO> list = act_sign_upSvc.getAll();
pageContext.setAttribute("list", list);
int i = 1;
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

</head>


<style>
.wrap {
  text-align: center;
  padding-top: 5%;
}
.btn {
  background-color: #FFB80C;
  text-decoration: none;
  color: #1e1e1e;
  padding: 5px;
  border-radius: 5px;
}

.popup-wrap {
  width: 100%;
  height: 100%;
  display: none;
  position: fixed;
  top: 0px;
  left: 0px;
  content: '';
  background: rgba(0, 0, 0, 0.85);
}

.popup-box {
  width: 95%;
  padding: 100px 175px;
  transform: translate(-50%, -50%) scale(0.5);
  position: absolute;
  top: 50%;
  left: 50%;
  box-shadow: 0px 2px 16px rgba(0, 0, 0, 0.5);
  border-radius: 3px;
  background: #fff;
  text-align: center;
}
h2 {
  font-size: 45px;
  color: #1a1a1a;
}

.close-btn {
  width: 50px;
  height: 50px;
  display: inline-block;
  position: absolute;
  top: 10px;
  right: 10px;
  border-radius: 100%;
  background: #d75f70;
  font-weight: bold;
  text-decoration: none;
  color: #fff;
  line-height: 40px;
  font-size: 32px;
}

.transform-in, .transform-out {
  display: block;
  -webkit-transition: all ease 0.5s;
  transition: all ease 0.5s;
}

.transform-in {
  -webkit-transform: translate(-50%, -50%) scale(1);
  transform: translate(-50%, -50%) scale(1);
}

.transform-out {
  -webkit-transform: translate(-50%, -50%) scale(0.5);
  transform: translate(-50%, -50%) scale(0.5);
}
</style>


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

					<table id="dataTables" class="stripe" style="width: 100%">
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right: 10px;">
											<a href="listAllAct_sign_up.jsp"><img
												src="./images/home.png" width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a href='addAct_sign_up.jsp'><img src="./images/plus.png"
												width="30px" height="30px"></a>
										</button>


									</div>
								</div>
							</div>
						</div>
						<thead>
							<tr>
								<th>報名編號</th>
								<th>活動名稱</th>
								<th>會員暱稱</th>
								<th>會員信箱</th>
								<th>報名時間</th>
								<th>攜伴人數</th>
								<th>寄送通知</th>
<!-- 								<th>修改</th> -->
<!-- 								<th>刪除</th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="act_sign_upVO" items="${list}">
								<tr>
									<td>${act_sign_upVO.sign_up_no}</td>
									<td>${act_sign_upVO.actVO.act_name}</td>
									<td>${act_sign_upVO.memVO.mem_nickname}</td>
									<td>${act_sign_upVO.memVO.mem_email}</td>
									<td>${act_sign_upVO.sign_up_time}</td>
									<td>${act_sign_upVO.accompany_count}</td>
									<td><div class="wrap">
											<a class="btn popup-btn" href="#letmeopen<%=i%>">寄送email</a>
										</div>
										<div class="popup-wrap" id="letmeopen<%=i++%>">
											<div class="popup-box transform-out">
<!-- 												<h2>請輸入要寄送的內容</h2> -->
												<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/mem/MailServlet"
													style="margin-bottom: 0px;">
													<textarea name="email_content" rows="8" cols="50" placeholder="請輸入要寄送的內容" style="font-size:30px;width:950px;left:100px;"></textarea>
													<input type="hidden" name="mem_email"
														value="${act_sign_upVO.memVO.mem_email}"> 
													<input type="hidden" name="action" value="sign_up_email">
														<input type="submit" value="寄送" style="width:150px;height:75px;font-size:30px;">
												</FORM>
												<a class="close-btn popup-close" href="#">x</a>
											</div>
										</div></td>
<!-- 									<td> -->
<!-- 										<FORM METHOD="post" -->
<%-- 											ACTION="<%=request.getContextPath()%>/back-end/act_sign_up/act_sign_up.do" --%>
<!-- 											style="margin-bottom: 0px;"> -->
<!-- 											<input type="submit" value="修改"> <input type="hidden" -->
<%-- 												name="sign_up_no" value="${act_sign_upVO.sign_up_no}"> --%>
<!-- 											<input type="hidden" name="action" value="getOne_For_Update"> -->
<!-- 										</FORM> -->
<!-- 									</td> -->
<!-- 									<td> -->
<!-- 										<FORM METHOD="post" -->
<%-- 											ACTION="<%=request.getContextPath()%>/back-end/act_sign_up/act_sign_up.do" --%>
<!-- 											style="margin-bottom: 0px;"> -->
<!-- 											<input type="submit" value="刪除"> <input type="hidden" -->
<%-- 												name="sign_up_no" value="${act_sign_upVO.sign_up_no}"> --%>
<!-- 											<input type="hidden" name="action" value="delete"> -->
<!-- 										</FORM> -->
<!-- 									</td> -->
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>報名編號</th>
								<th>活動名稱</th>
								<th>會員暱稱</th>
								<th>會員信箱</th>
								<th>報名時間</th>
								<th>攜伴人數</th>
								<th>寄送通知</th>
<!-- 								<th>修改</th> -->
<!-- 								<th>刪除</th> -->
							</tr>
						</tfoot>
					</table>


					<script>
						$(document).ready(function() {
							$('#dataTables').DataTable();
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
	<!-- End custom js for this page-->
</body>
<script>
	let path = window.location.pathname.substring(0, window.location.pathname
			.lastIndexOf("/"));
	path = path.substring(0, path.lastIndexOf("/"));
	
	$(".popup-btn").click(function() {
		  var href = $(this).attr("href")
		  $(href).fadeIn(250);
		  $(href).children$("popup-box").removeClass("transform-out").addClass("transform-in");
		  e.preventDefault();
		});

		$(".popup-close").click(function() {
		  closeWindow();
		});
// 		$(".popup-wrap").click(function(){
// 		  closeWindow();
// 		})
		function closeWindow(){
		  $(".popup-wrap").fadeOut(200);
		  $(".popup-box").removeClass("transform-in").addClass("transform-out");
		  event.preventDefault();
		}
</script>
</html>