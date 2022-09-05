<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.question.model.*"%>

<%
Question_VO questionVO = (Question_VO) request.getAttribute("questionVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>題目修改 - update_question_input.jsp</title>

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
				<h3>題目修改 - update_question_input.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>題目修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="question.do" name="form1">
		<table>
			<tr>
				<td>題目編號:<font color=red><b>*</b></font></td>
				<td><%=questionVO.getQuestion_no()%></td>
			</tr>
			<tr>
				<td>問題:</td>
				<td><input type="TEXT" name="que" size="45"
					value="<%=(questionVO == null) ? "" : questionVO.getQue()%>" /></td>
			</tr>
		</table>

		<br> 
		<input type="hidden" name="action" value="update"> 
		<input type="hidden" name="question_no" value="<%=questionVO.getQuestion_no()%>"> 
		<input type="submit" value="送出修改">
	</FORM>
</body>

</html>