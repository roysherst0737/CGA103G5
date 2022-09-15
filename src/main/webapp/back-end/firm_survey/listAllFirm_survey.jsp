<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.firm_survey.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
Firm_survey_Service firm_surveySvc = new Firm_survey_Service();
List<Firm_survey_VO> list = firm_surveySvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有廠商問卷 - listAllFirm_survey.jsp</title>

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
	width: 800px;
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
				<h3>所有廠商問卷 - listAllFirm_survey.jsp</h3>
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
		<%@ include file="page1.file"%>
		<c:forEach var="firm_surveyVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${firm_surveyVO.firm_survey_no}</td>
				<td>${firm_surveyVO.act_no}</td>
				<td>${firm_surveyVO.survey_build_time}</td>
				<td>${firm_surveyVO.survey_revise_time}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/firm_survey/firm_survey.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="firm_survey_no" value="${firm_surveyVO.firm_survey_no}">
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/firm_survey/firm_survey.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="firm_survey_no" value="${firm_surveyVO.firm_survey_no}">
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>