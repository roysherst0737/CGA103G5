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
<jsp:useBean id="mng_authfunc" scope="page"
	class="com.manager_authfunc.model.Manager_authfunc_Service" />


<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar【後端】</title>
<!-- base:css -->

<link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/vendors/typicons.font/font/typicons.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/back-end/images/favicon.png" />
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
		<script src="<%=request.getContextPath()%>/back-end/js/nav.js"></script>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<!-- 引入浮動視窗 -->
			<script src="<%=request.getContextPath()%>/back-end/js/floating_window.js"></script>
			<!-- partial -->
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar"></nav>
			<!-- 引入sidebar 用JQ方式 -->
			<script>
				$(function() {
					$("#sidebar").load("<%=request.getContextPath()%>/back-end/partials/_sidebar.html");
				});
			</script>
			 <!-- partial -->
           <div class="main-panel">
        <div class="content-wrapper">
          <div class="row">
  <div class="col-lg-12 grid-margin stretch-card">
    <div class="card" style="border-radius: 15px">
      <div class="card-body">
        <h4 class="card-title" style="text-align:center;">朧醴 LonelyBar【管理員權限列表】</h4>
        <h5 style="text-align:center;"><a href="<%=request.getContextPath()%>/back-end/manager_authfunc/addMngAuthfunc.jsp">新增&修改管理員權限</a></h5>
        <p class="card-description">
          <code></code>
        </p>
        <div class="table-responsive">
          <table class="table table-striped" style="text-align:center;">
            <thead>
       <tr>
        <th nowrap="nowrap" style="padding: 8px">管理員編號</th>
		<th nowrap="nowrap" style="padding: 8px">管理員姓名</th>
		<th nowrap="nowrap" style="padding: 8px">權限名稱</th>
		<th nowrap="nowrap" style="padding: 8px">增加權限</th>
       </tr>
            </thead>
            <tbody>
            
            <%@ include file="page1.file" %> 
	<c:forEach var="manager_VO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>" >
              <tr>
                <td>${manager_VO.mng_no}</td>
				<td>${manager_VO.mng_name}</td>
				<td>
				<c:forEach var="manager_auth_VO" items="${list1}">
			    <c:if test="${manager_VO.mng_no == manager_auth_VO.mng_no}">
			    <c:forEach var="manager_authfunc_VO" items="${list2}">
			    <c:if test="${manager_auth_VO.mng_authfunc_no == manager_authfunc_VO.mng_authfunc_no}">
				<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/Manager_authServlet" style="margin-bottom: 0px;" enctype="multipart/form-data">
			    ${manager_authfunc_VO.mng_authfunc_name}
			    <input type="hidden" name="action"	value="delete">
			    <input type="hidden" name="mng_no"	value="${manager_VO.mng_no}">
			    <input type="hidden" name="mng_authfunc_no"  value="${manager_authfunc_VO.mng_authfunc_no}">
			    <input type="submit" class="" value="刪除" style="margin-left: 10px;margin-top: 0px"><br>
				</FORM>

			    </c:if>
			    </c:forEach>
			    </c:if>
			    </c:forEach>
			    </td>
			   <td> 
			  <FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/Manager_authServlet" style="margin-bottom: 0px; margin-left: 55px;" >
				<select name="mng_authfunc_no" size="1">
						<c:forEach var="manager_authfunc_VO" items="${list2}">
						<option value="${manager_authfunc_VO.mng_authfunc_no}" style="text-align:center;">
						${manager_authfunc_VO.mng_authfunc_name}
						</c:forEach>
						</select>
			     <input type="submit" value="增加">
			     <input type="hidden" name="mng_no"  value="${manager_VO.mng_no}">
			     <input type="hidden" name="action"	value="insert">
					</FORM>
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
    <script type="text/javascript">

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
						$(".footer").load("<%=request.getContextPath()%>/back-end/partials/_footer.html");
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
		
	
	
	<script src="<%=request.getContextPath()%>/back-end/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/back-end/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/todolist.js"></script>
	<!-- endinject -->
	<!-- plugin js for this page -->
	<script src="<%=request.getContextPath()%>/back-end/vendors/progressbar.js/progressbar.min.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/vendors/chart.js/Chart.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- Custom js for this page-->

	<script src="<%=request.getContextPath()%>/back-end/js/dashboard.js"></script>
	<!-- End custom js for this page-->
</body>

</html>