<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.prod_pic.model.*"%>

<%
Prod_pic_VO prod_picVO = (Prod_pic_VO) request.getAttribute("prod_picVO");
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
<script>
	let path = window.location.pathname.substring(0, window.location.pathname
			.lastIndexOf("/"));
	path = path.substring(0, path.lastIndexOf("/"));
</script>
</head>

<style>

	input[disabled]{
        background-color: #eee;
        cursor: not-allowed;
      }

	#preview{
        border: 3px solid grey;
        display: inline-block;
        width: 150px;
        min-height: 100px;
        position: relative;
      }
      #preview span.text{
        position: absolute;
        display: inline-block;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        z-index: -1;
        color: lightgray;
      }
      #preview img.preview_img{
        width: 100%;
      }
      
</style>

<script>
window.addEventListener("load", function(e){
	var preview_el = document.getElementById("preview");
    var p_file_el = document.getElementById("p_file");
	var preview_img = function(file){
        var reader = new FileReader(); // 用來讀取檔案
        reader.readAsDataURL(file); // 讀取檔案
        reader.addEventListener("load", function () {
        	var img_str = '<img src="' + reader.result + '" class="preview_img">';
            preview_el.innerHTML = img_str;

        });
	};
	p_file_el.addEventListener("change", function(e){
        if(this.files.length > 0){
          preview_img(this.files[0]);
        }else{
          preview_el.innerHTML = '<span class="text">預覽圖</span>';
        }
      });
});

</script>

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
											<a href="listAllProd_pic.jsp"><img
												src="./images/home.png" width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a href='addProd_pic.jsp'><img src="./images/plus.png"
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
									<%-- 錯誤表列 --%>
									<c:if test="${not empty errorMsgs}">
										<font style="color: red">請修正以下錯誤:</font>
										<ul>
											<c:forEach var="message" items="${errorMsgs}">
												<li style="color: red">${message}</li>
											</c:forEach>
										</ul>
									</c:if>
									<jsp:useBean id="prod_picSvc" scope="page" class="com.prod_pic.model.Prod_pic_Service" />
									<jsp:useBean id="prodSvc" scope="page" class="com.prod.model.Prod_Service" />
									<h4 class="card-title">新增商品圖片</h4>
									<table id="dataTables" class="stripe table-hover"
										style="width: 100%">
										<FORM METHOD="post" ACTION="prod_pic.do" name="form1" enctype="multipart/form-data">
											<table>
												<tr>
													<td>選擇商品名稱:</td> 
													<td>
													<select size="1" name="prod_no">
														<c:forEach var="prodVO" items="${prodSvc.all}">
															<option value="${prodVO.prod_no}">${prodVO.prod_name}
														</c:forEach>
													</select>
												</td> 
												</tr>
												<tr>
													<td>商品照片:</td>
													<td><input type="file" name="prod_pic" size="45" id="p_file"/></td>
													<td>預覽圖:</td>
													<td>
														<div id="preview">
															<span class="text">預覽圖</span>
														</div>
													</td>
												</tr>
												<tr>
													<td>商品照片名稱:</td>
													<td><input type="TEXT" name="prod_pic_name" size="25"
														value="<%=(prod_picVO == null) ? "" : prod_picVO.getProd_pic_name()%>" /></td>
												</tr>
											</table>
											<br> <input type="hidden" name="action" value="insert">
											<input type="submit" value="送出新增">
										</FORM>
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
						$(".footer").load(window.location.pathname.substring(0, window.location.pathname.indexOf('/', 2))
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

	<script>
							function getContextPath() {
								return window.location.pathname.substring(0,
										window.location.pathname
												.indexOf('/', 2));
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