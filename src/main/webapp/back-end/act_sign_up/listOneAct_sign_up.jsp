<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.act_sign_up.model.*"%>

<%
Act_sign_up_VO act_sign_upVO = (Act_sign_up_VO) request.getAttribute("act_sign_upVO");
%>

<html>
<head>
<title>活動報名 - listOneAct_sign_up.jsp</title>

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
				<h3>活動報名 - ListOneAct_sign_up.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>報名編號</th>
			<th>活動編號</th>
			<th>會員編號</th>
			<th>報名時間</th>
			<th>攜伴人數</th>
			<th>報名狀態</th>
		</tr>
		<tr>
			<td><%=act_sign_upVO.getSign_up_no()%></td>
			<td><%=act_sign_upVO.getAct_no()%></td>
			<td><%=act_sign_upVO.getMem_no()%></td>
			<td><%=act_sign_upVO.getSign_up_time()%></td>
			<td><%=act_sign_upVO.getAccompany_count()%></td>
			<td><%=act_sign_upVO.getSign_up_status()%></td>
		</tr>
	</table>

</body>
</html>