<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.act.model.*"%>
<%@ page import="com.act_sign_up.model.*"%>

<%
Act_VO actVO = (Act_VO) request.getAttribute("actVO");

%>

<html>
<head>
<title>活動 - listOneAct.jsp</title>

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
				<h3>活動 - ListOneAct.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>活動編號</th>
			<th>酒吧編號</th>
			<th>活動名稱</th>
			<th>活動描述</th>
			<th>活動地址</th>
			<th>上架時間</th>
			<th>下架時間</th>
			<th>當前報名人數</th>
			<th>容納人數上限</th>
			<th>容納人數下限</th>
			<th>報名開始時間</th>
			<th>報名結束時間</th>
			<th>活動開始時間</th>
			<th>活動結束時間</th>
			<th>活動狀態</th>
			<th>修改時間</th>
		</tr>
		<tr>
			<td><%=actVO.getAct_no()%></td>
			<td><%=actVO.getPub_no()%></td>
			<td><%=actVO.getAct_name()%></td>
			<td><%=actVO.getAct_detail()%></td>
			<td><%=actVO.getAct_loc()%></td>
			<td><%=actVO.getAct_launch_time()%></td>
			<td><%=actVO.getAct_off_time()%></td>
			<td><%=actVO.getCurrent_count()%></td>
			<td><%=actVO.getMax_count()%></td>
			<td><%=actVO.getMin_count()%></td>
			<td><%=actVO.getSign_up_begin_time()%></td>
			<td><%=actVO.getSign_up_end_time()%></td>
			<td><%=actVO.getAct_start_time()%></td>
			<td><%=actVO.getAct_end_time()%></td>
			<td><%=actVO.getAct_status()%></td>
			<td><%=actVO.getRevise_time()%></td>
		</tr>
	</table>

</body>
</html>