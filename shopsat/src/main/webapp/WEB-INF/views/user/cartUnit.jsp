<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>




<!-- 
<h1>=============USERCartUNIT==============</h1>


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
					<li><a href="/admin">Adminka</a></li>
					<li><a href="/admin/category">Category</a></li>
					<li><a href="/admin/typeProduct">Type product</a></li>
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/producer">Producer</a></li>
					<li><a href="/admin/model">Model</a></li>
					<li><a href="/admin/measure">Measure</a></li>
					<li><a href="/admin/product">Product</a></li>
					<li><a href="/admin/user">User</a></li>
					<li><a href="/admin/shopingCart">shopingCarts</a></li>
					<li class="active"><a href="/admin/cart">Carts</a><span
						class="sr-only">(current)</span></li>	
					<li><a href="/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div> -->


<h1>=============USERCartUNIT==============</h1>


<div class="row">
	

	<div class="col-md-7 col-xs-12">

		<div class="row">
			<div class="col-md-12 col-xs-12">
<%-- 				<form:form class="form-horizontal" action="/admin/cart"
					method="POST" modelAttribute="cart" >

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
							<form:select class="form-control" path="user"
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
<h1>=============USERCartUNIT==============</h1>	
		
 		<div class="row">
			<div class="col-md-2 col-xs-2">
				<h3>Cart id</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>List Products</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>User</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Update</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Delete</h3>
			</div>
		</div>
		
			<div class="row">
				<div class="col-md-2 col-xs-2">${cart.id}</div>
			<%-- 	<div class="col-md-3 col-xs-3">${shopingCart.product.nameProduct}</div> --%>
				<div class="col-md-3 col-xs-3">
					<div >${shopingCart.product.nameProduct}</div> 
					<c:forEach items="${products}" var="cart">
						<div class="row">
							
						 	<div class="col-md-3 col-xs-3">${shopingCart.product.nameProduct}</div> 

							</div>

					</c:forEach> 
				</div>
				<!-- <div class="col-md-3 col-xs-3">prod-list</div> -->
			
				<div class="col-md-2 col-xs-2">${cart.user.username}</div>
	<!-- 			<div class="col-md-2 col-xs-2">user#</div>  -->
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-warning" href="/user/cart/update/${cart.id}">update</a>
				</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-danger" href="/user/cart/delete/${cart.id}">delete</a>
				</div>
			</div>
		
	</div>

</div>

