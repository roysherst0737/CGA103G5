<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.firm_survey.model.*"%>

<%
Firm_survey_VO firm_surveyVO = (Firm_survey_VO) request.getAttribute("firm_surveyVO");
%>

<html>
<head>
<title>廠商問卷 - listOneFirm_survey.jsp</title>

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
				<h3>廠商問卷 - ListOneFirm_survey.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>廠商問卷編號</th>
			<th>活動編號</th>
			<th>廠商問卷建立時間</th>
			<th>廠商問卷修改時間</th>
		</tr>
		<tr>
			<td><%=firm_surveyVO.getFirm_survey_no()%></td>
			<td><%=firm_surveyVO.getAct_no()%></td>
			<td><%=firm_surveyVO.getSurvey_build_time()%></td>
			<td><%=firm_surveyVO.getSurvey_revise_time()%></td>
		</tr>
	</table>

</body>
</html>