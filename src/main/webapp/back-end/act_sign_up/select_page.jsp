<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>LonelyBar Act_sign_up: Home</title>

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
   <tr><td><h3>LonelyBar Act_sign_up: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for LonelyBar Act_sign_up: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllAct_sign_up.jsp'>List</a> all Act_sign_ups.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="act_sign_up.do" >
        <b>輸入活動報名編號:</b>
        <input type="text" name="sign_up_no">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="act_sign_upSvc" scope="page" class="com.act_sign_up.model.Act_sign_up_Service" />
   
  <li>
     <FORM METHOD="post" ACTION="act_sign_up.do" >
       <b>選擇活動報名編號:</b>
       <select size="1" name="sign_up_no">
         <c:forEach var="act_sign_upVO" items="${act_sign_upSvc.all}" > 
          <option value="${act_sign_upVO.sign_up_no}">${act_sign_upVO.sign_up_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
</ul>


<h3>活動報名管理</h3>

<ul>
  <li><a href='addAct_sign_up.jsp'>Add</a> a new Act_sign_up.</li>
</ul>

</body>
</html>