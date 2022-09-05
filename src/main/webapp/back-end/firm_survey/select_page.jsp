<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>LonelyBar Firm_survey: Home</title>

<style>
table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
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

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td><h3>LonelyBar Firm_survey: Home</h3>
				<h4>( MVC )</h4></td>
		</tr>
	</table>

	<p>This is the Home page for LonelyBar Firm_survey: Home</p>

	<h3>資料查詢:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul>
		<li><a href='listAllFirm_survey.jsp'>List</a> all Firm_surveys. <br>
		<br></li>


		<li>
			<FORM METHOD="post" ACTION="firm_survey.do">
				<b>輸入廠商問卷編號:</b> <input type="text" name="firm_survey_no"> <input
					type="hidden" name="action" value="getOne_For_Display"> <input
					type="submit" value="送出">
			</FORM>
		</li>

		<jsp:useBean id="firm_surveySvc" scope="page"
			class="com.firm_survey.model.Firm_survey_Service" />

		<li>
			<FORM METHOD="post" ACTION="firm_survey.do">
				<b>選擇廠商問卷編號:</b> <select size="1" name="firm_survey_no">
					<c:forEach var="firm_surveyVO" items="${firm_surveySvc.all}">
						<option value="${firm_surveyVO.firm_survey_no}">${firm_surveyVO.firm_survey_no}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>


	<h3>廠商問卷管理</h3>

	<ul>
		<li><a href='addFirm_survey.jsp'>Add</a> a new Firm_survey.</li>
	</ul>

</body>
</html>