<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>LonelyBar Act_pic: Home</title>

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
   <tr><td><h3>LonelyBar Act_pic: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for LonelyBar Act_pic: Home</p>

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
  <li><a href='listAllAct_pic.jsp'>List</a> all Act_pics.  <br><br></li>
  
  
  <li>
  
    <FORM METHOD="post" ACTION="act_pic.do" >
        <b>輸入活動照片編號:</b>
        <input type="text" name="act_pic_no">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="act_picSvc" scope="page" class="com.act_pic.model.Act_pic_Service" />
   
  <li>
     <FORM METHOD="post" ACTION="act_pic.do" >
       <b>選擇活動照片編號:</b>
       <select size="1" name="act_pic_no">
         <c:forEach var="act_picVO" items="${act_picSvc.all}" > 
          <option value="${act_picVO.act_pic_no}">${act_picVO.act_pic_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="act_pic.do" >
       <b>選擇活動照片名稱:</b>
       <select size="1" name="act_pic_no">
         <c:forEach var="act_picVO" items="${act_picSvc.all}" > 
          <option value="${act_picVO.act_pic_no}">${act_picVO.act_pic_name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>活動照片管理</h3>

<ul>
  <li><a href='addAct_pic.jsp'>Add</a> a new ActProd_pic.</li>
</ul>

</body>
</html>