<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.manager.model.*"%>

<%
  Manager_VO manager_VO = (Manager_VO) request.getAttribute("manager_VO");
%>
--%= manager_VO==null %--${managerVO.mng_no}--${managerVO.mng_account}--
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Employee Login Form</h1>
		
		<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
		
		<form method='post' action="<%=request.getContextPath()%>/login">
			<table style="with: 100%">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="mng_account" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="mng_password" /></td>
				</tr>

			</table>
			<input type="hidden" name="action" value="login">
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>