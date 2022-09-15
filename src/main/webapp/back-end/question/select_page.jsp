<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>LonelyBar Question: Home</title>

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
   <tr><td><h3>LonelyBar Question: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for LonelyBar Question: Home</p>

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
  <li><a href='listAllQuestion.jsp'>List</a> all Questions.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="question.do" >
        <b>輸入題目編號:</b>
        <input type="text" name="question_no">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="questionSvc" scope="page" class="com.question.model.Question_Service" />
   
  <li>
     <FORM METHOD="post" ACTION="question.do" >
       <b>選擇題目編號:</b>
       <select size="1" name="question_no">
         <c:forEach var="questionVO" items="${questionSvc.all}" > 
          <option value="${questionVO.question_no}">${questionVO.question_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
</ul>


<h3>題目管理</h3>

<ul>
  <li><a href='addQuestion.jsp'>Add</a> a new Question.</li>
</ul>

</body>
</html>