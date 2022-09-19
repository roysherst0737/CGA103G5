<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
      <div class="main-panel">

  <div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h4 class="card-title" style="text-align:center;">朧醴 LonelyBar【管理員列表】</h4>
        <p class="card-description">
          <code></code>
        </p>
        <div class="table-responsive" style="margin-left:30%;">
          <table class="table table-striped" style="text-align:center;">

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>


  <li><a href='<%=request.getContextPath()%>/back-end/manager/listAllMng.jsp'>List</a> all Managers.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/manager/manager.do" >
        <b>輸入管理員編號 (如1):</b>
        <input type="text" name="mng_no">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="manager_Svc" scope="page" class="com.manager.model.Manager_Service" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/manager/manager.do" >
       <b>選擇管理員編號:</b>
       <select size="1" name="mng_no">
         <c:forEach var="manager_VO" items="${manager_Svc.allManager}" > 
          <option value="${manager_VO.mng_no}">${manager_VO.mng_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/manager/manager.do" >
       <b>選擇管理員姓名:</b>
       <select size="1" name="mng_no">
         <c:forEach var="manager_VO" items="${manager_Svc.allManager}" > 
          <option value="${manager_VO.mng_no}">${manager_VO.mng_name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>



<h3>管理員管理</h3>


  <li><a href='<%=request.getContextPath()%>/back-end/manager_login/mngLogin.jsp'>Add</a> a new Manager.</li>


 </table>
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