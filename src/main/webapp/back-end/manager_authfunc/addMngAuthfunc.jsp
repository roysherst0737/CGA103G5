<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.manager_authfunc.model.Manager_authfunc_Service"%>
<%@page import="com.manager_authfunc.model.Manager_authfunc_VO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>

<%
// 取得所有資料
Manager_authfunc_Service manager_authfuncSvc = new Manager_authfunc_Service();
List<Manager_authfunc_VO> list = manager_authfuncSvc.getAllManager_authfunc();
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
            <div class="col-md-6 grid-margin stretch-card" style="margin: auto;">
              <div class="card" style="margin: auto; border-radius: 15px">
                <div class="card-body">
                  <h4 class="card-title" style="text-align:center;">朧醴 LonelyBar【權限新增&修改】</h4>
                  <p class="card-description">
                    
                  </p>
						<div class="form-group">
                   <%-- 錯誤表列 --%>
                   
						<c:if test="${not empty errorMsgs}">
							<font style="color:red">請修正以下錯誤:</font>
							<ul>
								<c:forEach var="message" items="${errorMsgs}">
									<li style="color:red">${message}</li>
								</c:forEach>
							</ul>
						</c:if>
						</div>
                   <div class="table-responsive">

                  <FORM method="post" action="<%=request.getContextPath()%>/mngAuthFuncServlet"
                  	name="form1" enctype="multipart/form-data">
                  <div class="form-group">
                  <label for="exampleInputEmail1">新增管理員權限: </label>
       			  <input type="text" name="mng_authfunc_name" value="${manager_authfunc_VO.mng_authfunc_name}"/>
        		  <input type="hidden" name="action" value="insert">
       		      <input type="submit" value="新增">
       		      <input type="reset" value="重設">
                    </div>
    			</FORM>
    			<p></p>
    			<hr Color="black">
    			<p></p>
  			 <FORM method="post" action="<%=request.getContextPath()%>/mngAuthFuncUpdate" 
  			 name="form1" enctype="multipart/form-data">
  			 	  <div class="form-group">
  			 	  <label for="exampleInputEmail1">原管理員權限名稱: </label>
						<select name="mng_authfunc_no" size="1" style="text-align:center;">
						<c:forEach var="manager_authfunc_VO" items="${list}">
						<option value="${manager_authfunc_VO.mng_authfunc_no}">
						${manager_authfunc_VO.mng_authfunc_name}
						</c:forEach>
						</select><br>

					<label for="exampleInputEmail1">新管理員權限名稱: </label>
					<input type="text" name="mng_authfunc_name" value="${manager_authfunc_VO.mng_authfunc_name}">
					<input type="submit" value="修改" >
					<input type="reset" value="重設">
  			 		</div>
  			 </FORM>
  			 
                </div>
              </div>
            </div>
            <script type="text/javascript">
		// 當upload重新選擇 清空舊有資料
		$("#upload").change(function(){
		    $("#picPreview").empty() // 清空當下預覽
		    previewfile(this.files) // this即為<input>元素
		})
	</script>
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