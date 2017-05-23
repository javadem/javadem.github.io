<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>



<security:authorize access="isAuthenticated()">



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
					<li class="active"><a href="/admin/shopingCart">Кошик</a></li>
					<li><a href="/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>


<h1>ADMIN shopingCart</h1>






<div class="row">
	

	<div class="col-md-7 col-xs-12">

		<div class="row">
			<div class="col-md-12 col-xs-12">
<%-- 				<form:form class="form-horizontal" action="/admin/shopingCart"
					method="POST" modelAttribute="shopingCart" >

					<input type="hidden" value="${shopingCart.id}" name="shopingCartId">

- 					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Id</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="id" id="name" />
						</div>
					</div> 
					
					<div class="form-group">
						<label class="col-sm-2 control-label">User</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="users"
								itemLabel="username" itemValue="id" 
								items="${users}" />
						</div>
					</div>

 					<div class="form-group">
						<label class="col-sm-2 control-label">Product</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="products"
								itemLabel="nameProduct" itemValue="id"
								items="${products}" />

						</div>
					</div> 
					
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Count</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="count"
								id="name" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Create</button>
						</div>
					</div>
				</form:form> --%>
			</div>
		</div>
 		<div class="row">
			<div class="col-md-2 col-xs-2">
				<h3>Cart id</h3>
			</div>
<!-- 			<div class="col-md-2 col-xs-2">
				<h3>Product</h3>
			</div> -->
<!-- 			<div class="col-md-2 col-xs-2">
				<h3>User</h3>
			</div> -->
<!-- 			<div class="col-md-2 col-xs-2">
				<h3>Update</h3>
			</div> -->
			<div class="col-md-2 col-xs-2">
				<h3>Delete</h3>
			</div><div class="col-md-2 col-xs-2">
				<h3>view</h3>
			</div>
		</div>
		<c:forEach items="${shopingCarts}" var="shopingCart">
			<div class="row">
				<div class="col-md-2 col-xs-2">${shopingCart.id}</div>
		
<%-- 				<div class="col-md-2 col-xs-2">
					 <c:forEach items="${users}" var="user"> 
						<div class="row">
							<div class="col-md-2 col-xs-2">${user.username}</div>
						</div>
					</c:forEach> 
				 </div>  --%>
<%-- 				<div class="col-md-2 col-xs-2">
					<a class="btn btn-warning" href="/admin/shopingCart/update/${shopingCart.id}">update</a>
				</div> --%>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-danger" href="/admin/shopingCart/delete/${shopingCart.id}">delete</a>
				</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-success"
						href="/admin/shopingCart/${shopingCart.id}">view</a>
				</div>
			</div>
		</c:forEach> 
	</div>

</div>

</security:authorize>