<%@page import="java.util.List"%>
<%@page import="com.manager_authfunc.model.Manager_authfunc_Service"%>
<%@page import="com.manager_authfunc.model.Manager_authfunc_VO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <%
// 取得所有資料
Manager_authfunc_Service manager_authfuncSvc = new Manager_authfunc_Service();
List<Manager_authfunc_VO> list = manager_authfuncSvc.getAllManager_authfunc();
pageContext.setAttribute("list", list);


%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改管理員權限</title>
</head>
<body>
<section id="main-content">
	<section class="wrapper">


	<div id="bid-content">

		<table id="table-1">
			<tr>
				<td>
			 		<h3>修改管理員權限</h3>
				</td>
			</tr>
		</table>

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>
		
<!-- 		主要修改資訊區 -->

		<form method="post"
			action="<%=request.getContextPath()%>/mngAuthFuncUpdate"
			name="form1" enctype="multipart/form-data">
			<table>
				<tr>
				
					
					<td>原管理員權限</td>
					<td><select name="mng_authfunc_no" size="1">   <!-- -->
						<c:forEach var="manager_authfunc_VO" items="${list}">
						<option value="${manager_authfunc_VO.mng_authfunc_no}">
						${manager_authfunc_VO.mng_authfunc_name}
						</c:forEach>
						</select>
					</td>
						
					<td>新管理員權限</td>
					<td><input type="text" name="mng_authfunc_name" size="20"
						value="${manager_authfunc_VO.mng_authfunc_name}" /></td>	
						
				</tr>
				<tr>
					<td>

			<input type="submit" value="修改">
			<input type="reset" value="重設">
					</td>
				</tr>
<!-- 	上傳圖片區 
				<tr>
					<td>
	        		<input type="file" name="upfile1" onclick="previewImage()" multiple id="upfile"
	        		style="position: relative; left:480px ;bottom: 530px;">
					</td>
				</tr> -->
			</table>
		</form>
		<div id="picPreview" style="display: flex; width: 400px ;flex-wrap:wrap;
		position: relative; left:480px ;bottom: 530px"></div>

	</div>

	</section>

	<!--main content end-->

</section>

<script type="text/javascript">

		var filereader_support = typeof FileReader != 'undefined';

		if (!filereader_support) {
			alert("No FileReader support");
		}

		acceptedTypes = {
				'image/png' : true,
				'image/jpeg' : true,
				'image/gif' : true
		};
		
		
		function previewImage() {
			var upfile = document.getElementById("upfile");
			upfile.addEventListener("change", function(event) {
				var files = event.target.files || event.dataTransfer.files;
				for (var i = 0; i < files.length; i++) {
					previewfile(files[i])
				}
			}, false);
		}
		
		function previewfile(file) {
			if (filereader_support === true && acceptedTypes[file.type] === true) {
				var reader = new FileReader();
				reader.onload = function(event) {
					var image = new Image();
					image.src = event.target.result;
					image.width = 128;
					picPreview.appendChild(image);
				};
				reader.readAsDataURL(file);
			} else {
				picPreview.innerHTML += "<p>" + "filename: <strong>" + file.name
						+ "</strong><br>" + "ContentTyp: <strong>" + file.type
						+ "</strong><br>" + "size: <strong>" + file.size
						+ "</strong> bytes</p>";
			}
		}
		// 當upload重新選擇 清空舊有資料
		$("#upload").change(function(){
		    $("#picPreview").empty() // 清空當下預覽
		    previewfile(this.files) // this即為<input>元素
		})
	</script>
</body>
</html>