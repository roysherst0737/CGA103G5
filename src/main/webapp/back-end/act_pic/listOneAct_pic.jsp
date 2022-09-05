<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.act_pic.model.*"%>

<%
Act_pic_VO act_picVO = (Act_pic_VO) request.getAttribute("act_picVO");
%>

<html>
<head>
<title>活動照片 - listOneAct_pic.jsp</title>

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
				<h3>活動照片 - ListOneAct_pic.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>活動照片編號</th>
			<th>活動編號</th>
			<th>活動照片</th>
			<th>活動照片名稱</th>
		</tr>
		<tr>
			<td><%=act_picVO.getAct_pic_no()%></td>
			<td><%=act_picVO.getAct_no()%></td>
			<td><img
				src="<%=request.getContextPath()%>/Show_Act_pic_Servlet?act_pic_no=${act_picVO.act_pic_no}"
				width=300px height=200px></td>
			<td><%=act_picVO.getAct_pic_name()%></td>
		</tr>
	</table>

</body>
</html>