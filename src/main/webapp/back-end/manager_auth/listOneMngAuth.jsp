<%@page import="com.manager_auth.model.Manager_auth_VO"%>
<%@page import="java.util.List"%>
<%@page import="com.manager_auth.model.Manager_auth_Service"%>
<%@page import="com.manager.model.Manager_VO"%>
<%@page import="com.manager.model.Manager_Service"%>
<%@page import="com.manager_authfunc.model.Manager_authfunc_VO"%>
<%@page import="com.manager_authfunc.model.Manager_authfunc_Service"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
  Manager_VO manager_VO = (Manager_VO) request.getAttribute("manager_VO"); //Manager_Servlet.java (Concroller) 存入req的manager_VO物件 (包括幫忙取出的manager_VO, 也包括輸入資料錯誤時的manager_VO物件)
  Manager_auth_VO manager_auth_VO = (Manager_auth_VO) request.getAttribute("manager_auth_VO");
  Manager_authfunc_VO manager_authfunc_VO = (Manager_authfunc_VO) request.getAttribute("manager_authfunc_VO");
  
  Manager_Service managerSvc = new Manager_Service();
  List<Manager_VO> list = managerSvc.getAllManager();
  pageContext.setAttribute("list", list);

  Manager_auth_Service manager_authSvc = new Manager_auth_Service();
  List<Manager_auth_VO> list1 = manager_authSvc.getAllManager_auth();
  pageContext.setAttribute("list1", list1);
  
  Manager_authfunc_Service manager_authfuncSvc = new Manager_authfunc_Service();
  List<Manager_authfunc_VO> list2 = manager_authfuncSvc.getAllManager_authfunc();
  pageContext.setAttribute("list2", list2);
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
           <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
  <div class="col-lg-12 grid-margin stretch-card">
    <div class="card">
      <div class="card-body">
        <h4 class="card-title" style="text-align:center;">朧醴 LonelyBar【管理員列表】</h4>
        <h5 style="text-align:center;"><a href="selectPage.jsp">回首頁</a></h5>
        <p class="card-description">
          <code></code>
        </p>
        <div class="table-responsive">
          <table class="table table-striped" style="text-align:center;">
            <thead>
       <tr>
        <th>管理員<br>編號</th>
		<th>管理員<br>姓名</th>
		<th>管理員<br>權限</th>

       </tr>
            </thead>
            <tbody>
            
            <%@ include file="page1.file" %> 
	<c:forEach var="manager_VO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>" >
              <tr>
                <td><%=manager_VO.getMng_no()%></td>
               	<td><%=manager_VO.getMng_name()%></td>
				<td><c:forEach var="manager_auth_VO" items="${list1}">
			    <c:if test="${manager_VO.mng_no == manager_auth_VO.mng_no}">
			    <c:forEach var="manager_authfunc_VO" items="${list2}">
			    <c:if test="${manager_auth_VO.mng_authfunc_no == manager_authfunc_VO.mng_authfunc_no}">
			       ${manager_authfunc_VO.mng_authfunc_name}
			    <input type="checkbox" checked class="form-control" id="mng_authfunc_name" name="mng_authfunc_name"
			    value="${manager_auth_VO.mng_authfunc_no}">
			    <input type="hidden" checked class="form-control" id="mng_no" name="mng_no"
			    value="${manager_VO.mng_no}">
			    </c:if>
			    </c:forEach>
			    </c:if>
		
			    </c:forEach></td>

			<td>
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/Manager_authServlet" style="margin-bottom: 0px;">
				<input class="" type="submit" value="修改" > 
				<input type="hidden" name="mng_no" value="${manager_VO.mng_no}">
				<input type="hidden" name="action" value="getOne_For_Display">
			</FORM>
			</td>
                <td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/manager/manager.do" style="margin-bottom: 0px;">
			     <input type="submit" value="新增">
			     <input type="hidden" name="mng_no"  value="${manager_VO.mng_no}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
              </tr>
              </c:forEach>
                      </tbody>
                    </table>
                    <%@ include file="page2.file" %>
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