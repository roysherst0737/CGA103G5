<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.firm_survey.model.*"%>

<%
Firm_survey_VO firm_surveyVO = (Firm_survey_VO) request.getAttribute("firm_surveyVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>廠商問卷修改 - update_firm_survey_input.jsp</title>

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
				<h3>廠商問卷修改 - update_firm_survey_input.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>廠商問卷修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="firm_survey.do" name="form1">
		<table>
			<tr>
				<td>廠商問卷編號:<font color=red><b>*</b></font></td>
				<td><%=firm_surveyVO.getFirm_survey_no()%></td>
			</tr>
			<tr>
				<td>活動編號:</td>
				<td><input type="TEXT" name="act_no" size="45"
					value="<%=(firm_surveyVO == null) ? "" : firm_surveyVO.getAct_no()%>" /></td>
			</tr>
			<tr>
				<td>廠商問卷建立時間:<font color=red><b>*</b></font></td>
				<td><%=firm_surveyVO.getSurvey_build_time()%></td>
			</tr>
			<tr>
				<td>廠商問卷修改時間:<font color=red><b>*</b></font></td>
				<td><%=firm_surveyVO.getSurvey_revise_time()%></td>
			</tr>
		</table>

		<br> 
		
		<input type="hidden" name="action" value="update"> 
		
		<input type="hidden" name="firm_survey_no" value="<%=firm_surveyVO.getFirm_survey_no()%>">
		<input type="hidden" name="survey_build_time" value="<%=firm_surveyVO.getSurvey_build_time()%>">
		<input type="submit" value="送出修改">
	</FORM>
</body>

</html>