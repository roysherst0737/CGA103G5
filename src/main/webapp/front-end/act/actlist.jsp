<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.act.model.*"%>

<%
Act_Service actSvc = new Act_Service();
List<Act_VO> list = actSvc.getAll();
pageContext.setAttribute("list", list);
%>




<!DOCTYPE html>
<html lang="zh-Hant">
<!-- Basic(head都不用動) -->

<head>
<meta charset="utf-8">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>朧醴 LonelyBar</title>
<meta name="keywords" content="LonelyBar Index">
<meta name="description" content="This is template from Theme Wagon.">
<meta name="author" content="Theme Wagon">

<!-- Site Icons -->
<link rel="shortcut icon" href="../images/favicon.ico"
	type="image/x-icon">
<link rel="lonelybar-icon" href="../images/Logo2.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="../css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="../css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="../css/custom.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<style>
.btn {
	width: auto;
	height: auto;
}
</style>

</head>

<body>

	<div id=top_nav_mainTop>
		<%@ include file="/front-end/partials/_mainTop.jsp"%>
	</div>

	<!-- !!!!!! 從以下開始修改到Start Instagram Feed" !!!!!!-->

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>Shop</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Shop</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start Shop Page  -->
	<div class="shop-box-inner">
		<div class="container">
			<div class="row">
				<div
					class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
					<div class="right-product-box">
						<div class="product-item-filter row">
							<div class="col-12 col-sm-8 text-center text-sm-left">
								<div class="toolbar-sorter-right">
									<span>Sort by </span> <select id="basic"
										class="selectpicker show-tick form-control"
										data-placeholder="$ USD">
										<option data-display="Select">Nothing</option>
										<option value="1">Popularity</option>
										<option value="2">High Price â High Price</option>
										<option value="3">Low Price â High Price</option>
										<option value="4">Best Selling</option>
									</select>
								</div>
								<p>Showing all 4 results</p>
							</div>
							<div class="col-12 col-sm-4 text-center text-sm-right">
								<ul class="nav nav-tabs ml-auto">
									<li><a class="nav-link active" href="#grid-view"
										data-toggle="tab"> <i class="fa fa-th"></i>
									</a></li>
									<li><a class="nav-link" href="#list-view"
										data-toggle="tab"> <i class="fa fa-list-ul"></i>
									</a></li>
								</ul>
							</div>
						</div>

						<table>
							<tr>
								<th>活動名稱</th>
								<th></th>
								<th>內容</th>
								<th>地點</th>
							</tr>
							<%@ include file="page1.file"%>
							<c:forEach var="actVO" items="${list}" begin="<%=pageIndex%>"
								end="<%=pageIndex+rowsPerPage-1%>">

								<tr>
									<td>${actVO.act_name}</td>
									<td><img
										src="<%=request.getContextPath()%>/Show_Act_pic_Servlet?act_pic_no=${actVO.act_picVO.act_pic_no}"
										width=300px height=200px></td>
									<td>${actVO.act_detail}</td>
									<td>${actVO.act_loc}</td>
									<td><a
										href="<%=request.getContextPath()%>/front-end/act/act-detail.jsp?${actVO.act_no}"
										data-toggle="tooltip" data-placement="right" title="View"><i
											class="fas fa-eye"></i></a></td>
								</tr>

							</c:forEach>
							<%@ include file="page2.file"%>
						</table>


						<div class="product-categorie-box">
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane fade show active"
									id="grid-view">
									<div class="row">
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<p class="sale">Sale</p>
													</div>

													<img src="images/img-pro-01.jpg" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="View"><i
																	class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart" href="#">Add to Cart</a>
													</div>
												</div>
												<div class="why-text">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>$9.79</h5>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<p class="new">New</p>
													</div>
													<img src="images/img-pro-02.jpg" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="View"><i
																	class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart" href="#">Add to Cart</a>
													</div>
												</div>
												<div class="why-text">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>$9.79</h5>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<p class="sale">Sale</p>
													</div>
													<img src="images/img-pro-03.jpg" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="View"><i
																	class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart" href="#">Add to Cart</a>
													</div>
												</div>
												<div class="why-text">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>$9.79</h5>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<p class="new">New</p>
													</div>
													<img src="images/img-pro-01.jpg" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="View"><i
																	class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart" href="#">Add to Cart</a>
													</div>
												</div>
												<div class="why-text">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>$9.79</h5>
												</div>
											</div>
										</div>



										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<p class="sale">Sale</p>
													</div>
													<img src="images/img-pro-02.jpg" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="View"><i
																	class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart" href="#">Add to Cart</a>
													</div>
												</div>
												<div class="why-text">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>$9.79</h5>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<p class="sale">Sale</p>
													</div>
													<img src="images/img-pro-03.jpg" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="View"><i
																	class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart" href="#">Add to Cart</a>
													</div>
												</div>
												<div class="why-text">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>$9.79</h5>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<p class="sale">Sale</p>
													</div>
													<img src="images/img-pro-01.jpg" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="View"><i
																	class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart" href="#">Add to Cart</a>
													</div>
												</div>
												<div class="why-text">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>$9.79</h5>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<p class="sale">Sale</p>
													</div>
													<img src="images/img-pro-02.jpg" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="View"><i
																	class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart" href="#">Add to Cart</a>
													</div>
												</div>
												<div class="why-text">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>$9.79</h5>
												</div>
											</div>
										</div>
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<div class="type-lb">
														<p class="new">New</p>
													</div>
													<img src="images/img-pro-03.jpg" class="img-fluid"
														alt="Image">
													<div class="mask-icon">
														<ul>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="View"><i
																	class="fas fa-eye"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Compare"><i
																	class="fas fa-sync-alt"></i></a></li>
															<li><a href="#" data-toggle="tooltip"
																data-placement="right" title="Add to Wishlist"><i
																	class="far fa-heart"></i></a></li>
														</ul>
														<a class="cart" href="#">Add to Cart</a>
													</div>
												</div>
												<div class="why-text">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>$9.79</h5>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div role="tabpanel" class="tab-pane fade" id="list-view">
									<div class="list-view-box">
										<div class="row">
											<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
												<div class="products-single fix">
													<div class="box-img-hover">
														<div class="type-lb">
															<p class="new">New</p>
														</div>
														<img src="images/img-pro-01.jpg" class="img-fluid"
															alt="Image">
														<div class="mask-icon">
															<ul>
																<li><a href="#" data-toggle="tooltip"
																	data-placement="right" title="View"><i
																		class="fas fa-eye"></i></a></li>
																<li><a href="#" data-toggle="tooltip"
																	data-placement="right" title="Compare"><i
																		class="fas fa-sync-alt"></i></a></li>
																<li><a href="#" data-toggle="tooltip"
																	data-placement="right" title="Add to Wishlist"><i
																		class="far fa-heart"></i></a></li>
															</ul>

														</div>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
												<div class="why-text full-width">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>
														<del>$ 60.00</del>
														$40.79
													</h5>
													<p>Integer tincidunt aliquet nibh vitae dictum. In
														turpis sapien, imperdiet quis magna nec, iaculis ultrices
														ante. Integer vitae suscipit nisi. Morbi dignissim risus
														sit amet orci porta, eget aliquam purus sollicitudin. Cras
														eu metus felis. Sed arcu arcu, sagittis in blandit eu,
														imperdiet sit amet eros. Donec accumsan nisi purus, quis
														euismod ex volutpat in. Vestibulum eleifend eros ac
														lobortis aliquet. Suspendisse at ipsum vel lacus vehicula
														blandit et sollicitudin quam. Praesent vulputate semper
														libero pulvinar consequat. Etiam ut placerat lectus.</p>
													<a class="btn hvr-hover" href="#">Add to Cart</a>
												</div>
											</div>
										</div>
									</div>
									<div class="list-view-box">
										<div class="row">
											<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
												<div class="products-single fix">
													<div class="box-img-hover">
														<div class="type-lb">
															<p class="sale">Sale</p>
														</div>
														<img src="images/img-pro-02.jpg" class="img-fluid"
															alt="Image">
														<div class="mask-icon">
															<ul>
																<li><a href="#" data-toggle="tooltip"
																	data-placement="right" title="View"><i
																		class="fas fa-eye"></i></a></li>
																<li><a href="#" data-toggle="tooltip"
																	data-placement="right" title="Compare"><i
																		class="fas fa-sync-alt"></i></a></li>
																<li><a href="#" data-toggle="tooltip"
																	data-placement="right" title="Add to Wishlist"><i
																		class="far fa-heart"></i></a></li>
															</ul>

														</div>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
												<div class="why-text full-width">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>
														<del>$ 60.00</del>
														$40.79
													</h5>
													<p>Integer tincidunt aliquet nibh vitae dictum. In
														turpis sapien, imperdiet quis magna nec, iaculis ultrices
														ante. Integer vitae suscipit nisi. Morbi dignissim risus
														sit amet orci porta, eget aliquam purus sollicitudin. Cras
														eu metus felis. Sed arcu arcu, sagittis in blandit eu,
														imperdiet sit amet eros. Donec accumsan nisi purus, quis
														euismod ex volutpat in. Vestibulum eleifend eros ac
														lobortis aliquet. Suspendisse at ipsum vel lacus vehicula
														blandit et sollicitudin quam. Praesent vulputate semper
														libero pulvinar consequat. Etiam ut placerat lectus.</p>
													<a class="btn hvr-hover" href="#">Add to Cart</a>
												</div>
											</div>
										</div>
									</div>
									<div class="list-view-box">
										<div class="row">
											<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
												<div class="products-single fix">
													<div class="box-img-hover">
														<div class="type-lb">
															<p class="sale">Sale</p>
														</div>
														<img src="images/img-pro-03.jpg" class="img-fluid"
															alt="Image">
														<div class="mask-icon">
															<ul>
																<li><a href="#" data-toggle="tooltip"
																	data-placement="right" title="View"><i
																		class="fas fa-eye"></i></a></li>
																<li><a href="#" data-toggle="tooltip"
																	data-placement="right" title="Compare"><i
																		class="fas fa-sync-alt"></i></a></li>
																<li><a href="#" data-toggle="tooltip"
																	data-placement="right" title="Add to Wishlist"><i
																		class="far fa-heart"></i></a></li>
															</ul>

														</div>
													</div>
												</div>
											</div>
											<div class="col-sm-6 col-md-6 col-lg-8 col-xl-8">
												<div class="why-text full-width">
													<h4>Lorem ipsum dolor sit amet</h4>
													<h5>
														<del>$ 60.00</del>
														$40.79
													</h5>
													<p>Integer tincidunt aliquet nibh vitae dictum. In
														turpis sapien, imperdiet quis magna nec, iaculis ultrices
														ante. Integer vitae suscipit nisi. Morbi dignissim risus
														sit amet orci porta, eget aliquam purus sollicitudin. Cras
														eu metus felis. Sed arcu arcu, sagittis in blandit eu,
														imperdiet sit amet eros. Donec accumsan nisi purus, quis
														euismod ex volutpat in. Vestibulum eleifend eros ac
														lobortis aliquet. Suspendisse at ipsum vel lacus vehicula
														blandit et sollicitudin quam. Praesent vulputate semper
														libero pulvinar consequat. Etiam ut placerat lectus.</p>
													<a class="btn hvr-hover" href="#">Add to Cart</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
					<div class="product-categori">
						<div class="search-product">
							<form action="#">
								<input class="form-control" placeholder="Search here..."
									type="text">
								<button type="submit">
									<i class="fa fa-search"></i>
								</button>
							</form>
						</div>
						<div class="filter-sidebar-left">
							<div class="title-left">
								<h3>Categories</h3>
							</div>
							<div
								class="list-group list-group-collapse list-group-sm list-group-tree"
								id="list-group-men" data-children=".sub-men">
								<div class="list-group-collapse sub-men">
									<a class="list-group-item list-group-item-action"
										href="#sub-men1" data-toggle="collapse" aria-expanded="true"
										aria-controls="sub-men1">Fruits & Drinks <small
										class="text-muted">(100)</small>
									</a>
									<div class="collapse show" id="sub-men1"
										data-parent="#list-group-men">
										<div class="list-group">
											<a href="#"
												class="list-group-item list-group-item-action active">Fruits
												1 <small class="text-muted">(50)</small>
											</a> <a href="#" class="list-group-item list-group-item-action">Fruits
												2 <small class="text-muted">(10)</small>
											</a> <a href="#" class="list-group-item list-group-item-action">Fruits
												3 <small class="text-muted">(10)</small>
											</a> <a href="#" class="list-group-item list-group-item-action">Fruits
												4 <small class="text-muted">(10)</small>
											</a> <a href="#" class="list-group-item list-group-item-action">Fruits
												5 <small class="text-muted">(20)</small>
											</a>
										</div>
									</div>
								</div>
								<div class="list-group-collapse sub-men">
									<a class="list-group-item list-group-item-action"
										href="#sub-men2" data-toggle="collapse" aria-expanded="false"
										aria-controls="sub-men2">Vegetables <small
										class="text-muted">(50)</small>
									</a>
									<div class="collapse" id="sub-men2"
										data-parent="#list-group-men">
										<div class="list-group">
											<a href="#" class="list-group-item list-group-item-action">Vegetables
												1 <small class="text-muted">(10)</small>
											</a> <a href="#" class="list-group-item list-group-item-action">Vegetables
												2 <small class="text-muted">(20)</small>
											</a> <a href="#" class="list-group-item list-group-item-action">Vegetables
												3 <small class="text-muted">(20)</small>
											</a>
										</div>
									</div>
								</div>
								<a href="#" class="list-group-item list-group-item-action">
									Grocery <small class="text-muted">(150) </small>
								</a> <a href="#" class="list-group-item list-group-item-action">
									Grocery <small class="text-muted">(11)</small>
								</a> <a href="#" class="list-group-item list-group-item-action">
									Grocery <small class="text-muted">(22)</small>
								</a>
							</div>
						</div>
						<div class="filter-price-left">
							<div class="title-left">
								<h3>Price</h3>
							</div>
							<div class="price-box-slider">
								<div id="slider-range"></div>
								<p>
									<input type="text" id="amount" readonly
										style="border: 0; color: #fbb714; font-weight: bold;">
									<button class="btn hvr-hover" type="submit">Filter</button>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Shop Page -->

	<!-- Start Instagram Feed  -->
	<div class="instagram-box">
		<div class="main-instagram owl-carousel owl-theme">
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-01.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-02.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-03.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-04.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-05.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-06.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-07.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-08.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-09.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-05.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Instagram Feed  -->

	<!-- !!!!!!此行以下都不要修改!!!!!!-->
	<!-- Start Footer  -->
	<footer>
		<%@ include file="/front-end/partials/_footer.jsp"%>
	</footer>
	<!-- End Footer  -->

	<!-- Start copyright  -->
	<div class="footer-copyright">
		<p class="footer-company">
			All Rights Reserved. &copy; 2022 <a href="#">LonelyBar</a> Design By
			: <a href="https://html.design/">CGA103G5</a>
		</p>
	</div>
	<!-- End copyright  -->

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

	<!-- ALL JS FILES -->
	<script src="<%=request.getContextPath()%>/front-end/js/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script
		src="<%=request.getContextPath()%>/front-end/js/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/form-validator.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/bootsnav.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/baguetteBox.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/inewsticker.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/isotope.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/jquery.superslides.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/bootstrap-select.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/images-loded.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/contact-form-script.js"></script>
	<!-- 該文件需部屬較慢 -->
	<script id="customjs"
		src="<%=request.getContextPath()%>/front-end/js/custom.js"></script>
</body>

</html>