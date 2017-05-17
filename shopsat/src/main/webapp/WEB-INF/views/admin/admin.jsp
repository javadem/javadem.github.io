<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/admin">АДМІНКА</a></li>
					<li><a href="/admin/category">Категорія</a></li>
					<li><a href="/admin/typeProduct">Тип товару</a></li>
					<li><a href="/admin/country">Країна</a></li>
					<li><a href="/admin/producer">Виробник</a></li>
					<li><a href="/admin/model">Модель</a></li>
					<li><a href="/admin/measure">Вимір</a></li>
					<li><a href="/admin/product">Товар</a></li>
					<li><a href="/admin/user">Користувач</a></li>
					<li><a href="/admin/shopingCart">Кошик</a></li>
					<li><a href="/">Home</a></li>
					<li>
						<security:authorize access="isAuthenticated()">
				<form:form class="navbar-form navbar-right" action="/logout"
					method="POST">
					<button class="btn btn-primary">Вихід</button>
				</form:form>
				
				</security:authorize>
					</li>

				</ul>
			</div>
			
			
			
		</div>
	</nav>
</div>


<div class="container">
	<div class="row">
		<div class="">
			<div class="content">
			
			<h1>ADMINKA</h1>
			
			
			<ul class="nav navbar-nav">
					<!-- <li class="active"><a class="btn btn-success" href="/admin">АДМІНКА</a></li> -->
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/admin/category">Категорія</a></div></li>
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/admin/typeProduct">Тип товару</a></div></li>
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/admin/country">Країна</a></div></li>
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/admin/producer">Виробник</a></div></li>
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/admin/model">Модель</a></div></li>
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/admin/measure">Вимір</a></div></li>
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/admin/product">Товар</a></div></li>
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/admin/user">Користувач</a></div></li>
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/admin/shopingCart">Кошик</a></div></li>
					<li><div class="col-md-2 col-xs-2"><a class="btn btn-success" href="/">Home</a></div></li>
					<li>
						<security:authorize access="isAuthenticated()">
							<form:form class="navbar-form navbar-right" action="/logout" method="POST">
								<button class="btn btn-primary">Вихід</button>
							</form:form>
						</security:authorize>
					</li>
				</ul>
			

			</div>
		</div>
	</div>
</div>



			

