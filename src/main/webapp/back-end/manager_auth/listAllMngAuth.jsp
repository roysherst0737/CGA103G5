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
<html>
<head>
<meta charset="UTF-8">
<title>管理員權限</title>

<style type="text/css">
th {
	border-bottom-style: solid;
	background-color: #b2cdcc;
}

td {
	border-bottom-style: solid;
}

h3 {
	font-weight: bold;
	color: #547492;
}
</style>

</head>
<body>
	<!--main content start-->
	<section id="main-content">
		<section class="wrapper">

			<div id="bid-content">

				<table id="table-1">
					<tr>

						<h3>管理員權限</h3>

					</tr>
				</table>
				<%-- 錯誤表列 --%>
				<c:if test="${not empty errorMsgs}">
					<font style="color: red">請修正以下錯誤:</font>
					<ul>
						<c:forEach var="message" items="${errorMsgs}">
							<li style="color: red">${message}</li>
						</c:forEach>
					</ul>
				</c:if>
				<%-- 成功表列 --%>
				<p style="color: red;">${successMsg}</p>
				<div class="content-panel">
					<table class="table table-striped table-advance table-hover">
						<h4>
							<i class="fa fa-angle-right"></i>管理員權限
						</h4>
						</div>
						</h4>

						<hr>
						<thead>
							<tr>
								<th class=" hidden-phone"><i class="fa fa-barcode"></i> 編號</th>
								<th><i class="fa fa-bookmark"></i> 姓名</th>
								<th><i class=" fa fa-edit"></i>權限</th>
								<th></th>
							</tr>
						</thead>
						<%@ include file="page1.file"%>
						<c:forEach var="manager_VO" items="${list}" begin="<%=pageIndex%>"
							end="<%=pageIndex+rowsPerPage-1%>">
						<c:forEach var="manager_authfunc_VO" items="${list2}" begin="<%=pageIndex%>"
							end="<%=pageIndex+rowsPerPage-1%>">
							<tbody>
								<tr>
									<td>${manager_VO.mng_no}</td>
									<td>${manager_VO.mng_name}</td>
									<td>${manager_authfunc_VO.mng_authfunc_no}</td>
							<!--  		<span class="label label-primary"
										style="margin: 1.5px; padding: 10px; font-size: 15px;">
										${managerAuthVO.managerAuthrizationFunctionNo}</span> -->
							</tbody>
							</c:forEach>
						</c:forEach>
						<td sytle="">
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/back-end/manager_auth/addmanagerAuth.jsp"
								style="margin-bottom: 0px;">
								<input type="submit" value="新增"> <input type="hidden"
									name="mng_authfunc_no"
									value="${manager_auth_VO.mng_authfunc_no}">
							</FORM>
						</td>
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/back-end/manager_auth/editmanagerAuth.jsp"
								style="margin-bottom: 0px;">
								<input type="submit" value="修改"> <input type="hidden"
									name="mng_authfunc_no"
									value="${manager_auth_VO.mng_authfunc_no}">
							</FORM>
						</td>
				</div>
				<%@ include file="page2.file"%>
			</div>
		</section>
		<!--/wrapper -->
	</section>
	<!-- /MAIN CONTENT -->

	<!--main content end-->
	</section>
</body>
</html>