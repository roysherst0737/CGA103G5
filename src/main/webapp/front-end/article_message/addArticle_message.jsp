<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.article_message.model.*"%>

<%
Article_message_VO article_message_VO = (Article_message_VO) request.getAttribute("article_message_VO");
%>
--<%=article_message_VO == null%>--${article_message_VO.mem_no}-- --${article_message_VO.frm_art_no}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>留言編號資料新增 - addArticle_message.jsp</title>

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
				<h3>留言編號資料新增 - addArticle_message.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp"><img src="images/tomcat.png"
						width="100" height="100" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="article_message.do" name="form1">
		<table>
			<tr>
				<td>留言編號:</td>
				<td><input type="TEXT" name="art_msg_no" size="45"
					value="<%=article_message_VO.getArt_msg_no()%>" /></td>
			</tr>
			<!-- 			<tr> -->
			<!-- 				<td>會員編號:</td> -->
			<!-- 				<td><input type="TEXT" name="mem_no" size="45" -->
			<%-- 					value="<%=article_message_VO.getMem_no()%>" /></td> --%>
			<!-- 			</tr> -->
			<!-- 			<tr> -->
			<!-- 				<td>文章編號:</td> -->
			<!-- 				<td><input type="TEXT" name="frm_art_no" size="45" -->
			<%-- 					value="<%=article_message_VO.getFrm_art_no()%>" /></td> --%>
			<!-- 			</tr> -->
			<tr>
				<td>留言發布時間:</td>
				<td><input name="msg_time" id="f_date1" type="text"></td>
			</tr>
			<tr>
				<td>留言內容:</td>
				<td><input type="TEXT" name="msg_content" size="45"
					value="<%=article_message_VO.getFrm_art_no()%>" /></td>
			</tr>


			<jsp:useBean id="mem_Svc" scope="page" class="com.mem.model.Mem_Service" />
			<tr>
				<td>會員編號:<font color=red><b>*</b></font></td>
				<td><select size="1" name="mem_no">
						<c:forEach var="mem_VO" items="${memSvc.all}">
							<option value="${mem_VO.mem_no}"
								${(article_message_VO.mem_no==mem_VO.mem_no)?'selected':'' }>${mem_VO.mem_account}
						</c:forEach>
				</select></td>
			<jsp:useBean id="forum_Svc" scope="page" class="com.forum.model.Forum_Service" />
				<td>文章編號:<font color=red><b>*</b></font></td>
				<td><select size="1" name="frm_art_no">
						<c:forEach var="forum_article_VO" items="${forum_article_Svc.all}">
							<option value="${forum_article_VO.frm_art_no}"
								${(article_message_VO.frm_art_no==forum_article_VO.frm_art_no)?'selected':'' }>${forum_article_VO.frm_no}
						</c:forEach>
				</select></td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%
java.sql.Timestamp msg_time = null;
try {
	msg_time = article_message_VO.getMsg_time();
} catch (Exception e) {
	msg_time = new java.sql.Timestamp(System.currentTimeMillis());
}
%>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script
	src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:false,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
		   value: '<%=msg_time%>
	', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});

	// ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

	//      1.以下為某一天之前的日期無法選擇
	//      var somedate1 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});

	//      2.以下為某一天之後的日期無法選擇
	//      var somedate2 = new Date('2017-06-15');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {e
	//      }});

	//      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
	//      var somedate1 = new Date('2017-06-15');
	//      var somedate2 = new Date('2017-06-25');
	//      $('#f_date1').datetimepicker({
	//          beforeShowDay: function(date) {
	//        	  if (  date.getYear() <  somedate1.getYear() || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
	//		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
	//		             ||
	//		            date.getYear() >  somedate2.getYear() || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
	//		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
	//              ) {
	//                   return [false, ""]
	//              }
	//              return [true, ""];
	//      }});
</script>
</html>