<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.manager.model.*"%>

<%
  Manager_VO manager_VO = (Manager_VO) request.getAttribute("manager_VO");
%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>朧醴 LonelyBar【後端登入頁面】</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/manager_login/mngStyle.css">

</head>
<body>
<!-- partial:index.partial.html -->
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">

<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
<body>
  <div class="cotn_principal">
<div class="cont_centrar">

  <div class="cont_login">
<div class="cont_info_log_sign_up">
  <!-- LOGIN -->
      <div class="col_md_login">
<div class="cont_ba_opcitiy">
        
        <h2>LOGIN</h2>  
  <p>朧醴 LonelyBar【管理員登入】</p> 
  <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
  </div>
  </div>
    <!-- SIGNUP -->
<div class="col_md_sign_up">
<div class="cont_ba_opcitiy">
  <h2>SIGN UP</h2>

  
  <p>朧醴 LonelyBar【管理員註冊】</p>

  <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
</div>
  </div>
       </div>

    
    <div class="cont_back_info">
       <div class="cont_img_back_grey">
       <img src="https://images.pexels.com/photos/1554654/pexels-photo-1554654.jpeg?cs=srgb&dl=pexels-wendy-wei-1554654.jpg&fm=jpg"" alt="" />
       </div>
       
    </div>

    
<div class="cont_forms" >
    <div class="cont_img_back_">
       <img src="https://images.pexels.com/photos/1554654/pexels-photo-1554654.jpeg?cs=srgb&dl=pexels-wendy-wei-1554654.jpg&fm=jpg" alt="" />
       </div>
 <div class="cont_form_login">
<a href="#" onclick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
   <h2>LOGIN</h2>
   <form method='post' action="<%=request.getContextPath()%>/mng_login">
<input type="text" name="mng_account" value="<%= (manager_VO==null)? "" : manager_VO.getMng_account()%>" placeholder="Account" />
<input type="password" value="<%= (manager_VO==null)? "" : manager_VO.getMng_password()%>" name="mng_password" placeholder="Password" />
<input type="hidden" name="action" value="mngLogin">
<button class="btn_login" onclick="cambiar_login()">LOGIN</button>
</form>
  </div>
  
   <div class="cont_form_sign_up">
<a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
     <h2>SIGN UP</h2>
     <FORM METHOD='post' ACTION="<%=request.getContextPath()%>/back-end/manager_login/mngRegister.do" name="form1" enctype="multipart/form-data">
<input type="text" name="mng_account" value="<%= (manager_VO==null)? "" : manager_VO.getMng_account()%>" placeholder="Account" /><br>
<input type="password" id="mng_password" name="mng_password" value="<%= (manager_VO==null)? "" : manager_VO.getMng_password()%>" placeholder="Password" />
<input type="password" id="mng_cnf_password" name="mng_cnf_password" placeholder="Confirm Password" value=''/><br>
<input type="text" id="mng_name" name="mng_name" value="<%= (manager_VO==null)? "" : manager_VO.getMng_name()%>" placeholder="Username" /><br>
<input type="text" name="mng_phone" value="<%= (manager_VO==null)? "" : manager_VO.getMng_phone()%>" placeholder="Phone"/><br>
<input type="file" name="mng_pic" placeholder="Picture" /><br>
<label for="mng_status" style="margin: auto;">啟用管理員狀態: </label><input type="checkbox" id="mng_status" name="mng_status" value=1 /><br>
<input type="hidden" id="mng_status" name="mng_status" value=0>
<input type="hidden" name="action" value="mngRegister">
<button class="btn_sign_up1" onclick="cambiar_sign_up()">SIGN UP</button>
</FORM>
  </div>

    </div>
    
  </div>
 </div>
</div>
  

</body>
<!-- partial -->
  <script  src="<%=request.getContextPath()%>/back-end/manager_login/mngScript.js"></script>

</body>
</html>
