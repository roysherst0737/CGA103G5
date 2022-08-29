<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.prod_pic.model.*"%>

<html>
<head>
<title>LonelyBar Prod_pic: Home</title>

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
   <tr><td><h3>LonelyBar Prod_pic: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for LonelyBar Prod_pic: Home</p>

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
  <li><a href='listAllProd_pic.jsp'>List</a> all Prod_pics.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="prod_pic.do" >
        <b>輸入商品照片編號:</b>
        <input type="text" name="prod_pic_no">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="prod_picSvc" scope="page" class="com.prod_pic.model.Prod_pic_Service" />
   
  <li>
     <FORM METHOD="post" ACTION="prod_pic.do" >
       <b>選擇商品照片編號:</b>
       <select size="1" name="prod_pic_no">
         <c:forEach var="prod_picVO" items="${prod_picSvc.all}" > 
          <option value="${prod_picVO.prod_pic_no}">${prod_picVO.prod_pic_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="prod_pic.do" >
       <b>選擇商品照片名稱:</b>
       <select size="1" name="prod_pic_no">
         <c:forEach var="prod_picVO" items="${prod_picSvc.all}" > 
          <option value="${prod_picVO.prod_pic_no}">${prod_picVO.prod_pic_name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>商品照片管理</h3>

<ul>
  <li><a href='addProd_pic.jsp'>Add</a> a new Prod_pic.</li>
</ul>

</body>
</html>