<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar【後端】</title>
<!-- base:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/typicons.font/font/typicons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" />
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/back-end/images/favicon.png" />
<style>

button.b1{
	height: auto;
    padding: 5px;
}
div.o1{
padding:7px;
	display: flex;
    align-items: center;
    margin: 5px;
}
div.inside {
	padding-left:30px; 
	margin:0px;
	
}
div.d1{
border: 3px solid #e8eff9;  
border-radius:3px;
}
div.d1:hover{
border: 3px solid #d2b36b; 
}
div.row {
	margin:11px;
}
.open_div>div {
	padding-left: 30px;
}

.open_div>button {
	float: right;
}

div.col-sm-12>button.btn {
	width: 50px;
	height: 30px;
	padding: 0px;
	margin: 0px;
	font-weight: bolder;
}

.modal-content{
background-color: aliceblue;
}
.modal-body{
display: flex;
justify-content: space-evenly;
}
.btn-c{
border-radius:50%;
border: 2px solid #e8eff9;
}
.btn-c:hover{
border: 2px solid #266ed4;
}
</style>	
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	let path = window.location.pathname.substring(0, window.location.pathname
			.lastIndexOf("/"));
	path = path.substring(0, path.lastIndexOf("/"));
</script>

</head>

<body>
	<!-- 主頁面 -->
	<div class="container-scroller">
		<!-- 引入nav(頂部含廣告) -->
		<script src="<%=request.getContextPath()%>/back-end/js/nav.js"></script>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<!-- 引入浮動視窗 -->
			<script
				src="<%=request.getContextPath()%>/back-end/js/floating_window.js"></script>
			<!-- partial -->
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar"></nav>
			<!-- 引入sidebar 用JQ方式 -->
			<script>
				$(function() {
					$("#sidebar").load(
							window.location.pathname.substring(0,
									window.location.pathname.indexOf('/', 2))
									+ "/back-end/partials/_sidebar.html");
				});
			</script>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<!--你要寫的頁面  -->
					<div class="btn-group" role="group" aria-label="Basic example"
						style="margin: 10px">
						<button type="button" value="審核通過"
							class="btn btn-inverse-success btn-fw btn-outline-secondary" >審核成功</button>
						<button type="button" value="待審核"
							class="btn btn-inverse-secondary btn-fw btn-outline-secondary"  >等待審核</button>
						<button type="button" value="審核失敗"
							class="btn btn-inverse-danger btn-fw btn-outline-secondary"  >審核失敗</button>
						<button type="button" value=""
							class="btn btn-inverse-dark btn-fw btn-outline-secondary"  >全部</button>
					</div>
					<table id="dataTables" class="stripe table-hover" style="width: 100%">
						<thead>
							<tr>
								<th style="width:30px">酒吧編號</th>
								<th style="width:120px">酒吧名稱</th>
								<th style="width:60px">審核狀態</th>
								<th style="width:60px">容納人數</th>
								<th style="width:70px">建立時間</th>
								<th>酒吧地址</th>
								<th style="width:30px">設定</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pubVO" items="${pubList}" varStatus="loop">
								<tr>
									<td>${pubVO.pub_no}</td>
									<td>${pubVO.pub_name}</td>
									<td>${pubVO.pub_application==0?"待審核":pubVO.pub_application==1?"審核通過":"審核失敗"}</td>
									<td>${pubVO.pub_nop}</td>
									<td>${pubVO.pub_time}</td>
									<td>${pubVO.pub_address}</td>
									<td><button class="btn-c" type="button" id="btn${loop.index}" data-toggle="modal" data-target="#staticBackdrop" onclick="getdate(${pubVO.pub_no})"><img  src="<%=request.getContextPath()%>/back-end/images/brush.svg"></img></button></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>酒吧編號</th>
								<th>酒吧名稱</th>
								<th>審核狀態</th>
								<th>容納人數</th>
								<th>建立時間</th>
								<th>酒吧地址</th>
								<th>設定</th>
							</tr>
						</tfoot>
					</table>

					<script>
						$(document).ready(function() {
							$('#dataTables').DataTable();
						});
						
					    document.querySelectorAll(".btn-outline-secondary").forEach(e=>{e.addEventListener('click',()=>{
					        var table = $('#dataTables').DataTable();
		                    table.column(2).search(e.value).draw();
					    	});
    					});
					</script>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<!-- 引入footer 用JQ方式 -->
				<footer class="footer"></footer>
				<script>
					$(function() {
						$(".footer").load(
								window.location.pathname.substring(0,
										window.location.pathname
												.indexOf('/', 2))
										+ "/back-end/partials/_footer.html");
					});
				</script>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	
	<!-- Modal -->
<div class="modal fade " id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">設定</h5>
        <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close" style="border: 0px;background-color: aliceblue;">X</button>
      </div>
      <div class="modal-body">
                <div class=" grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">酒吧基本資料</h4>
                            <p id ="mem_p" class="card-description">會員編號:</p>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="fpub_name" value="" placeholder="pub_name">
                                <label for="fpub_name">酒吧名稱</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="number" class="form-control" id="fpub_nop" value="" placeholder="pub_nop">
                                <label for="fpub_nop">酒吧可接受預約人數</label>

                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="fpub_address" value=""
                                    placeholder="pub_address"> <label for="fpub_address">酒吧地址</label>
                            </div>

                            <div class="container px-4">
                                <div class="row gx-5">
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="fpub_lng" value=""
                                                placeholder="pub_lng"> <label for="fpub_lng">經度</label>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="fpub_lat" value=""
                                                placeholder="pub_lat"> <label for="fpub_lat">緯度</label>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="fpub_open" placeholder="pub_open"
                                    style="display: none">
                                <div class="open_div">
                                    <label>營業時間 </label>
                                    <div style="border: 1px solid #e8eff9; padding: 10px;">
                                        <div id="div1" class="d1 o1">
                                            <div>星期一:</div>
                                            <button id="b1" type="button" class="btn btn-danger b1" data-toggle="modal"
                                                data-target="#exampleModal1">未設定</button>
                                        </div>
                                        <div id="div2" class="d1 o1">
                                            <div>星期二:</div>
                                            <button id="b2" type="button" class="btn btn-danger b1" data-toggle="modal"
                                                data-target="#exampleModal2">未設定</button>
                                        </div>
                                        <div id="div3" class="d1 o1">
                                            <div>星期三:</div>
                                            <button id="b3" type="button" class="btn btn-danger b1" data-toggle="modal"
                                                data-target="#exampleModal3">未設定</button>
                                        </div>
                                        <div id="div4" class="d1 o1">
                                            <div>星期四:</div>
                                            <button id="b4" type="button" class="btn btn-danger b1" data-toggle="modal"
                                                data-target="#exampleModal4">未設定</button>
                                        </div>
                                        <div id="div5" class="d1 o1">
                                            <div>星期五:</div>
                                            <button id="b5" type="button" class="btn btn-danger b1" data-toggle="modal"
                                                data-target="#exampleModal5">未設定</button>
                                        </div>
                                        <div id="div6" class="d1 o1">
                                            <div>星期六:</div>
                                            <button id="b6" type="button" class="btn btn-danger b1" data-toggle="modal"
                                                data-target="#exampleModal6">未設定</button>
                                        </div>
                                        <div id="div7" class="d1 o1">
                                            <div>星期日:</div>
                                            <button id="b7" type="button" class="btn btn-danger b1" data-toggle="modal"
                                                data-target="#exampleModal7">未設定</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>酒吧圖片</label> <input id="pub_img" type="file" name="img[]"
                                    class="file-upload-default" accept="image/gif, image/jpeg, image/png">
                                <div class="input-group col-xs-12">
                                    <input type="text" class="form-control file-upload-info" disabled
                                        placeholder="Upload Image"> <span class="input-group-append">
                                        <button class="file-upload-browse btn btn-primary" type="button">上傳</button>
                                    </span>
                                </div>
                            </div>
                            <div class="form-floating">
                                <label for="fpub_detail">酒吧描述</label>
                                <textarea class="form-control" placeholder="pub_detail" id="fpub_detail"
                                    style="height: 100px"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=" grid-margin stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title"></h4>
                            <p class="card-description">廠商基本資料</p>

                            <div class="form-group row">
                                <label for="firm_name" class="col-sm-3 col-form-label">廠商名稱</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" value="" id="firm_name"
                                        placeholder="廠商名稱">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="firm_addr" class="col-sm-3 col-form-label">廠商地址</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" value="" id="firm_addr"
                                        placeholder="廠商地址">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="firm_tel_no" class="col-sm-3 col-form-label">廠商電話</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" value="" id="firm_tel_no"
                                        placeholder="廠商電話">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="firm_email" class="col-sm-3 col-form-label">廠商電子郵件</label>
                                <div class="col-sm-9">
                                    <input type="email" class="form-control" value="" id="firm_email"
                                        placeholder="廠商電子郵件">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="firm_tax_id" class="col-sm-3 col-form-label">廠商統一編號</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" value="" id="firm_tax_id"
                                        placeholder="廠商統一編號">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
        <button id="btn"type="button" class="btn btn-primary">修改</button>
      </div>
    </div>
  </div>
</div>
	<!-- container-scroller -->
	<!-- base:js -->
	<script>document</script>
	<script
		src="<%=request.getContextPath()%>/back-end/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/back-end/js/off-canvas.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/todolist.js"></script>
	<!-- endinject -->
	<!-- plugin js for this page -->
	<script
		src="<%=request.getContextPath()%>/back-end/vendors/progressbar.js/progressbar.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-end/vendors/chart.js/Chart.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- Custom js for this page-->

	<script src="<%=request.getContextPath()%>/back-end/js/dashboard.js"></script>
	<script
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/getModel.js"></script>
	<!-- End custom js for this page-->
	<script>
	$(document).ready(function() {
		document.querySelectorAll('.btn-group>Button').forEach(e=>{e.addEventListener('click',()=>{change_word()})})
	change_word();
	});
	function change_word(){
	if(document.querySelector('.dataTables_empty')!==null){
		document.querySelector('.dataTables_empty').innerText='查無資料';
	}
	document.querySelector('.dataTables_length>label').innerHTML=document.querySelector('.dataTables_length>label').innerHTML.replace("Show","顯示");
	document.querySelector('.dataTables_length>label').innerHTML=document.querySelector('.dataTables_length>label').innerHTML.replace("entries","項");
	document.querySelector('.dataTables_filter>label').innerHTML=document.querySelector('.dataTables_filter>label').innerHTML.replace("Search","全局搜尋");
	document.querySelector('#dataTables_info').innerHTML=document.querySelector('#dataTables_info').innerHTML.replace("Showing","總共");
	document.querySelector('#dataTables_info').innerHTML=document.querySelector('#dataTables_info').innerHTML.replace("entries","項");
	document.querySelector('#dataTables_previous').innerHTML=document.querySelector('#dataTables_previous').innerHTML.replace("Previous","前一頁");
	document.querySelector('#dataTables_next').innerHTML=document.querySelector('#dataTables_next').innerHTML.replace("Next","下一頁");
	}
	</script>
</body>

</html>