<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入介面</title>
</head>
<body>
	<div align="center">
		<font size="10px" color="#00008b">使用者登入</font>
		
		<form action="MemLoginServlet" method="post">

			<table border="2">
				<tr>
					<th>帳號</th>
					<td><input type="text" name="mem_account" /></td>
				</tr>
				<tr>
					<th>密碼</th>
					<td><input type="password" name="mem_password" /></td>
				</tr>
				<tr>
				
					<td colspan="2" align="center"><input type="submit" value="登入" />
						<input type="reset" /></td>

				</tr>
			</table>
			<input type="hidden" name="Login" value="Mem_Login">
		</form>
		<div>
			<a href="/jsp/register.jsp" style="text-align: left">立即註冊</a>
		</div>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>


	</div>
</body>
</html>