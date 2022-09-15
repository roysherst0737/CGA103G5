<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.act.model.*"%>

<%
Act_VO actVO = (Act_VO) request.getAttribute("actVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>活動新增 - addAct.jsp</title>

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
				<h3>活動新增 - addAct.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>活動新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="act.do" name="form1">
		<table>
			<tr>
				<td>酒吧編號:</td>
				<td><input type="TEXT" name="pub_no" size="45"
					value="<%=(actVO == null) ? "" : actVO.getPub_no()%>" /></td>
			</tr>	
			<tr>
				<td>活動名稱:</td>
				<td><input type="TEXT" name="act_name" size="45"
					value="<%=(actVO == null) ? "" : actVO.getAct_name()%>" /></td>
			</tr>
			<tr>
				<td>活動描述:</td>
				<td><input type="TEXT" name="act_detail" size="45"
					value="<%=(actVO == null) ? "" : actVO.getAct_detail()%>" /></td>
			</tr>
			<tr>
				<td>活動地址:</td>
				<td><input type="TEXT" name="act_loc" size="45"
					value="<%=(actVO == null) ? "" : actVO.getAct_loc()%>" /></td>
			</tr>
			<tr>
				<td>上架時間:</td>
				<td><input name="act_launch_time" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>下架時間:</td>
				<td><input name="act_off_time" id="f_date2" type="text"></td>
			</tr>
			<tr>
				<td>當前報名人數:</td>
				<td><input type="TEXT" name="current_count" size="45"
					value="<%=(actVO == null) ? "" : actVO.getCurrent_count()%>" /></td>
			</tr>
			<tr>
				<td>容納人數上限:</td>
				<td><input type="TEXT" name="max_count" size="45"
					value="<%=(actVO == null) ? "" : actVO.getMax_count()%>" /></td>
			</tr>
			<tr>
				<td>容納人數下限:</td>
				<td><input type="TEXT" name="min_count" size="45"
					value="<%=(actVO == null) ? "" : actVO.getMin_count()%>" /></td>
			</tr>
			<tr>
				<td>報名開始時間:</td>
				<td><input name="sign_up_begin_time" id="f_date3" type="text"></td>
			</tr>
			<tr>
				<td>報名結束時間:</td>
				<td><input name="sign_up_end_time" id="f_date4" type="text"></td>
			</tr>
			<tr>
				<td>活動開始時間:</td>
				<td><input name="act_start_time" id="f_date5" type="text"></td>
			</tr>
			<tr>
				<td>活動結束時間:</td>
				<td><input name="act_end_time" id="f_date6" type="text"></td>
			</tr>
		</table>

		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
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
			onShow : function() {
				this.setOptions({
					maxDate : $('#f_date2').val() ? $('#f_date2').val() : false
				})
			},

		});

		$('#f_date2').datetimepicker({
			format : 'Y-m-d H:i:s',
			onShow : function() {
				this.setOptions({
					minDate : $('#f_date1').val() ? $('#f_date1').val() : false
				})
			},
			timepicker : false
		});

		$('#f_date3').datetimepicker(
				{
					format : 'Y-m-d H:i:s',
					onShow : function() {
						this.setOptions({
							maxDate : $('#f_date4').val() ? $('#f_date4').val()
									: false,
							minDate : $('#f_date1').val() ? $('#f_date1').val()
									: false
						})
					},
					timepicker : false
				});

		$('#f_date4').datetimepicker({
			format : 'Y-m-d H:i:s',
			onShow : function() {
				this.setOptions({
					minDate : $('#f_date3').val() ? $('#f_date3').val() : false
				})
			},
			timepicker : false
		});
		$('#f_date5').datetimepicker(
				{
					format : 'Y-m-d H:i:s',
					onShow : function() {
						this.setOptions({
							minDate : $('#f_date4').val() ? $('#f_date4').val()
									: false,
							maxDate : $('#f_date6').val() ? $('#f_date6').val()
									: false
						})
					},
					timepicker : false
				});
		$('#f_date6').datetimepicker({
			format : 'Y-m-d H:i:s',
			onShow : function() {
				this.setOptions({
					minDate : $('#f_date5').val() ? $('#f_date5').val() : false
				})
			},
			timepicker : false
		});
	});
</script>

</html>