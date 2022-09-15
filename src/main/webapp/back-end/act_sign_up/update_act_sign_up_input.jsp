<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.act_sign_up.model.*"%>

<%
Act_sign_up_VO act_sign_upVO = (Act_sign_up_VO) request.getAttribute("act_sign_upVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>活動報名修改 - update_act_sign_up_input.jsp</title>

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
				<h3>活動報名修改 - update_act_sign_up_input.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>活動報名修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="act_sign_up.do" name="form1">
		<table>
			<tr>
				<td>報名編號:</td>
				<td><input type="TEXT" name="sign_up_no" size="45"
					value="<%=(act_sign_upVO == null) ? "" : act_sign_upVO.getSign_up_no()%>" /></td>
			</tr>
			<tr>
				<td>活動編號:</td>
				<td><input type="TEXT" name="act_no" size="45"
					value="<%=(act_sign_upVO == null) ? "" : act_sign_upVO.getAct_no()%>" /></td>
			</tr>
			<tr>
				<td>會員編號:</td>
				<td><input type="TEXT" name="mem_no" size="45"
					value="<%=(act_sign_upVO == null) ? "" : act_sign_upVO.getMem_no()%>" /></td>
			</tr>
			<tr>
				<td>報名時間:</td>
				<td><input name="sign_up_time" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>攜伴人數:</td>
				<td><input type="TEXT" name="accompany_count" size="45"
					value="<%=(act_sign_upVO == null) ? "" : act_sign_upVO.getAccompany_count()%>" /></td>
			</tr>
		</table>

		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="sign_up_no" value="<%=act_sign_upVO.getSign_up_no()%>">
		<input type="submit" value="送出修改">
	</FORM>
</body>

<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<!-- 參考網站: https://xdsoft.net/jqplugins/datetimepicker/ -->

<link rel="stylesheet" type="text/css"
	href="datetimepicker/jquery.datetimepicker.css" />
<script src="datetimepicker/jquery.js"></script>
<script src="datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
	$.datetimepicker.setLocale('zh'); // kr ko ja en
	$(function() {
		$('#f_date1').datetimepicker({
			format : 'Y-m-d H:i:s',
			timepicker : false
		});
	});
</script>

</html>