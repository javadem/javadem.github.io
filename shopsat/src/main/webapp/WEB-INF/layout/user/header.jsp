<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--  <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  --%>



<!DOCTYPE html>
<html>
<head>
<security:csrfMetaTags />
<meta charset="UTF-8">

<script type="text/javascript" src="/resources/js/jquery-3.1.1.min.js"></script>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<script src="/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/chosen.min.css">
<script type="text/javascript">
	$(function() {
		$("select").chosen();
	});
</script>
<style type="text/css">
body {
	padding-bottom: 70px;
	padding-top: 70px;
}
</style>
<title><tiles:getAsString name="title" /></title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="/resources/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/chosen.min.css">
</head>
<style>
.navbar-brand {
	padding: 0 15px;
}
</style>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#one" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="/" class="navbar-brand"> <img
				src="/resources/img/brang.jpg" class="img img-thumbnail"
				width="56px">
			</a>
		</div>
		<div class="collapse navbar-collapse" id="one">
			<ul class="nav navbar-nav">
				<li><a href="">Link 1</a></li>
				<li class="dropdown"><a href="" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Dropdown <span class="caret"></span>
				</a>
					<ul class="dropdown-menu">
						<li><a href="">Menu 1</a></li>
						<li><a href="">Menu 2</a></li>
						<li><a href="">Menu 3</a></li>
						<li><a href="">Menu 4</a></li>
					</ul></li>
			</ul>
			<security:authorize access="!isAuthenticated()">
				<form:form class="navbar-form navbar-right" action="/login"
					method="POST">
					<div class="form-group">
						<input class="form-control" placeholder="Login" name="login">
					</div>
					<div class="form-group">
						<input class="form-control" placeholder="Password" type="password"
							name="password">
					</div>
					<div class="checkbox">
						<label> <input name="remember-me" type="checkbox">
							Remember me
						</label>
					</div>
					<button class="btn btn-primary">Sign in</button>
				</form:form>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<form:form class="navbar-form navbar-right" action="/logout"
					method="POST">
					<button class="btn btn-primary">Sign out</button>
				</form:form>
				
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/admin">Admin</a></li>
						<li class="dropdown"><a href="" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"> Entities <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">

								<li><a href="/admin/category">Category</a></li>
								<li><a href="/admin/typeProduct">Type product</a></li>
								<li><a href="/admin/country">Country</a></li>
								<li><a href="/admin/producer">Producer</a></li>
								<li><a href="/admin/model">Model</a></li>
								<li><a href="/admin/measure">Measure</a></li>
								<li><a href="/admin/product">Product</a></li>
								<li><a href="/admin/user">User</a></li>
								<li><a href="/admin/shopingCart">Carts</a></li>
								<li><a href="/">Home</a></li>
							</ul></li>
					</ul>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_USER')">
					<ul class="nav navbar-nav navbar-right">
					<%-- <sec:authentication property="principal.username" /> --%>
						<li><a href="/user/user/<sec:authentication property="principal.id" />">USER <sec:authentication property="principal.username" /></a></li>
					<%-- 	<li><a href="/user/user/${user.id}">USER ${user.username}</a></li> --%>
					</ul>
				</security:authorize>
			</security:authorize>
		</div>
	</div>
</nav>

<div class="containerLow"></div>

<div class="container">
		<div class="row">
			<div class="">

				<header>
					<a href="/"><img src="resources/images/logo.jpg" alt="logo"></a>
					<form name="search" action="#" method="get"
						class="form-inline form-search pull-right">
						<div class="input-group">
							<label class="sr-only" for="searchInput">Search</label> <input
								class="form-control" id="searchInput" type="text" name="search"
								placeholder="Search">
							<div class="input-group-btn">
								<button type="submit" class="btn btn-primary">GO</button>
							</div>
						</div>
					</form>


				</header>

				<div class="heading">
					<h1>Інтернет магазин обладнання для цифрового телебачення</h1>
				</div>

				<nav class="navbar navbar-default">
					<ul class="nav navbar-nav navbar-left">
						<li class="active"><a href="/">Home</a></li>
				<!-- 		<li><a href="/user/category">КАТЕГОРІЇ</a></li> -->
						<li><a href="/user/product">ТОВАРИ</a></li>
			<!-- 			<li><a href="/user/shopingCart">shopCART</a></li>
						<li><a href="/user/cart">CARTs</a></li> -->
							<%-- <c:forEach items="${page.content}" var="category">
								<li><a href="/user/${category.nameCategory}">${category.nameCategory}</a></li> 
							</c:forEach> --%>
						<li><a href="/resources/about.html">Про нас</a></li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
					
			<li><security:authorize access="!isAuthenticated()"><a href="/registration">Реєстрація</a></security:authorize></li>
			<li><security:authorize access="!isAuthenticated()"><a href="/login">Вхід</a></security:authorize></li>

						<!-- <li><a href="/valute/">Валюта</a></li> -->
						<li><a href="/resources/contacts.html"> <span
								class="glyphicon glyphicon-earphone" aria-hidden="true"></span>
								Контакти
						</a></li>
						
						<li><security:authorize access="isFullyAuthenticated()"><a href="/user/user/<sec:authentication property="principal.id" />"> <span
								class="glyphicon glyphicon-user" aria-hidden="true"></span>
								Аккаунт</a></security:authorize></li>
								
						<li><security:authorize access="!isAuthenticated()">
	 					<a href="/user/shopingCart/${user.id}"> <span 
								class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
								Кошик
						</a></security:authorize></li>

						<li><security:authorize access="hasRole('ROLE_USER')">
							<ul class="nav navbar-nav navbar-right">
							<%-- <sec:authentication property="principal.username" /> --%>
								<li><a href="/user/shopingCart/<sec:authentication property="principal.id" />">КОШИК</a></li>
							<%-- 	<li><a href="/user/user/${user.id}">USER ${user.username}</a></li> --%>
							</ul>
						</security:authorize></li>

						<li>
							<security:authorize access="isAuthenticated()">
								<form:form class="navbar-form navbar-right" action="/logout"
									method="POST">
									<button class="btn btn-primary">Вихід</button>
								</form:form>
							</security:authorize>
						</li>
						
					</ul>
				</nav>
</div></div></div>	
				