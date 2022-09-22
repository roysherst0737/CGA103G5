<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.manager.model.*"%>

<%
  Manager_VO manager_VO = (Manager_VO) request.getAttribute("manager_VO");
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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/manager_login/mngStyle.css">
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">

<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
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
<div class="cont_centrar">
			 <div class="t" style="margin: 0px auto;  padding: 0px;  text-align: center;font-family: 'Lato', sans-serif;">
          <table class="table table-striped">

  <div class="cont_login" >
<div class="cont_info_log_sign_up" >
  <!-- LOGIN -->
      <div class="col_md_login" class="t" style="margin: 0px auto;  padding: 0px;  text-align: center;font-family: 'Lato', sans-serif;">
<div class="cont_ba_opcitiy" class="t" style="margin-left: 30px;  text-align: center;font-family: 'Lato', sans-serif;">
        
        <h2>LOGIN</h2>  
  <p>朧醴 LonelyBar【管理員登入】</p> 
  <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
  </div>
  </div>
    <!-- SIGNUP -->
<div class="col_md_sign_up" class="t" style="margin: 0px auto;  padding: 0px;  text-align: center;font-family: 'Lato', sans-serif;">
<div class="cont_ba_opcitiy" style="margin-left: 30px;  text-align: center;font-family: 'Lato', sans-serif;">
  <h2>SIGN UP</h2>

  
  <p>朧醴 LonelyBar【管理員註冊】</p>

  <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
</div>
  </div>
       </div>
       

    
    <div class="cont_back_info">
       <div class="cont_img_back_grey">
       <img src="https://images.pexels.com/photos/1554654/pexels-photo-1554654.jpeg?cs=srgb&dl=pexels-wendy-wei-1554654.jpg&fm=jpg" alt="" />
       </div>
       
    </div>

    
<div class="cont_forms" >
    <div class="cont_img_back_">
       <img src="https://images.pexels.com/photos/1554654/pexels-photo-1554654.jpeg?cs=srgb&dl=pexels-wendy-wei-1554654.jpg&fm=jpg" alt="" />
       </div>
 <div class="cont_form_login">
<a href="#" onclick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
   <h2>LOGIN</h2>
   <form method='post' action="<%=request.getContextPath()%>/back-end/manager_login/mngLogin.do">
<input type="text" name="mng_account" value="<%= (manager_VO==null)? "" : manager_VO.getMng_account()%>" placeholder="Account" />
<input type="password" value="<%= (manager_VO==null)? "" : manager_VO.getMng_password()%>" name="mng_password" placeholder="Password" />
<input type="hidden" name="action" value="mngLogin">
<button class="btn_login" onclick="cambiar_login()">LOGIN</button>
</form>
  </div>
  
   <div class="cont_form_sign_up">
<a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
     <h2>SIGN UP</h2>
     <FORM METHOD='post' ACTION="<%=request.getContextPath()%>/back-end/manager_login/mngRegister.do" name="form1" enctype="multipart/form-data">
<input type="text" name="mng_account" value="<%= (manager_VO==null)? "" : manager_VO.getMng_account()%>" placeholder="Account" /><br>
<input type="password" id="mng_password" name="mng_password" value="<%= (manager_VO==null)? "" : manager_VO.getMng_password()%>" placeholder="Password" />
<input type="password" id="mng_cnf_password" name="mng_cnf_password" placeholder="Confirm Password" value=""/><br>
<input type="text" id="mng_name" name="mng_name" value="<%= (manager_VO==null)? "" : manager_VO.getMng_name()%>" placeholder="Username" /><br>
<input type="text" name="mng_phone" value="<%= (manager_VO==null)? "" : manager_VO.getMng_phone()%>" placeholder="Phone"/><br>
<input type="file" name="mng_pic" placeholder="Picture" /><br>
<label for="mng_status" style="margin: auto;">啟用管理員狀態: <input type="checkbox" id="mng_status" name="mng_status" value=1 /><br>
<input type="hidden" id="mng_status" name="mng_status" value=0></label><br>
<input type="hidden" name="action" value="mngRegister">
<button class="btn_sign_up1" onclick="cambiar_sign_up()">SIGN UP</button>
</FORM>
  </div>

    </div>
    
</table>

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
						$(".footer").load("./partials/_footer.html");
					});
				</script>
				<!-- partial -->


	</div>
	<!-- container-scroller -->
	<!-- base:js -->
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
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
<!-- partial -->
  <script  src="<%=request.getContextPath()%>/back-end/manager_login/mngScript.js"></script>

</body>
</html>
