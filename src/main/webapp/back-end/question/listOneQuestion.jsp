<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.question.model.*"%>

<%
Question_VO questionVO = (Question_VO) request.getAttribute("questionVO");
%>

<html>
<head>
<title>題目 - listOneQuestion.jsp</title>

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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>題目 - ListOneQuestion.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>題目編號</th>
			<th>問題</th>
		</tr>
		<tr>
			<td><%=questionVO.getQuestion_no()%></td>
			<td><%=questionVO.getQue()%></td>
		</tr>
	</table>

</body>
</html>