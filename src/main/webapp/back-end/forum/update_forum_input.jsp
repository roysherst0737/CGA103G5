<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.forum.model.*"%>

<%
Forum_VO forum_VO = (Forum_VO) request.getAttribute("forum_VO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>討論區資料修改 - update_forum_input.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>討論區資料修改 - update_forum_input.jsp</h3>
				<h4>
					<a href="select_page.jsp"><img src="images/back1.gif"
						width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="forum.do" name="form1">
		<table>
<!-- 			<tr> -->
<!-- 				<td>討論區編號:</td> -->
<!-- 				<td><input type="TEXT" name="frm_no" size="45" -->
<%-- 					value="<%=(forum_VO == null) ? "1" : forum_VO.getFrm_no()%>" /></td> --%>
<!-- 			</tr> -->
			<tr>
				<td>討論區名稱:</td>
				<td><input type="TEXT" name="frm_name_no" size="45"
					value="<%=(forum_VO == null) ? "" : forum_VO.getFrm_name_no()%>" /></td>
			</tr>
			<!-- 	<tr> -->
			<!-- 		<td>雇用日期:</td> -->
			<!-- 		<td><input name="hiredate" id="f_date1" type="text"></td> -->
			<!-- 	</tr> -->
			<tr>
				<td>討論區狀態:</td>
				<td><input type="TEXT" name="frm_status" size="45"
					value="<%=(forum_VO == null) ? "1" : forum_VO.getFrm_status()%>" /></td>
			</tr>

		</table>
		<br> 
		<input type="hidden" name="action" value="update"> 
		<input type="hidden" name="frm_no" value="<%=forum_VO.getFrm_no()%>">
		<input type="submit" value="送出修改">
	</FORM>
</body>
</html>