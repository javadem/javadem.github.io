 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

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
					<li class="active"><a href="/admin/model">Model</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/measure">Measure</a></li>
					<li><a href="/admin/product">Product</a></li>
					<li><a href="/admin/user">User</a></li>
					<li><a href="/admin/order">Order</a></li>
					<li><a href="/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>



	
		<div class="row">
			<div class="col-md-2 col-xs-2">
				<h3>Order number</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>User Name</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>List product</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Update</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Delete</h3>
			</div>
		</div>
		<c:forEach items="${page.content}" var="order"> 
		<%-- 	<c:forEach items="${orders}" var="order"> --%>
			<div class="row">
				<div class="col-md-2 col-xs-2">${order.id}</div>
				<div class="col-md-3 col-xs-3">${order.user.username}</div>
				<div class="col-md-2 col-xs-2">${order.product}</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-warning" href="/user/order/update/${order.id}">update</a>
				</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-danger" href="/user/order/delete/${order.id}">delete</a>
				</div>
			</div>
		</c:forEach>


<%-- <div class="col-md-2 col-xs-12">
	<div class="row">
		<div class="col-md-6 col-xs-6 text-center">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Sort <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<custom:sort innerHtml="Name asc" paramValue="nameModel" />
					<custom:sort innerHtml="Name desc" paramValue="nameModel,desc" />
				</ul>
			</div>
		</div>
		<div class="col-md-6 col-xs-6 text-center">
			<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>  --%>


<%-- 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

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
					<li class="active"><a href="/admin/measure">Measure</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/product">Product</a></li>
					<li><a href="/admin/user">User</a></li>
					<li><a href="/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

<div class="row">
	<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/admin/order"
			method="get" class="form-inline">
			<div class="form-group">
				<form:input path="search" placeholder="search" class="form-control" />
				<custom:hiddenInputs excludeParams="search" />
				<button type="submit" class="btn btn-primary">Ok</button>
			</div>
		</form:form>
	</div>

	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/order"
					method="POST" modelAttribute="order"
					>

				

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="order"
								id="name" />
						</div>
					</div>


					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-4">
				<h3>order name</h3>
			</div>
			<div class="col-md-4 col-xs-4">
				<h3>Update</h3>
			</div>
			<div class="col-md-4 col-xs-4">
				<h3>Delete</h3>
			</div>
		</div>
		<c:forEach items="${page.content}" var="order">
			<div class="row">
				<div class="col-md-4 col-xs-4">${order.id}</div>
				<div class="col-md-4 col-xs-4">
					<a class="btn btn-warning"
						href="/admin/order/update/${order.id}">update</a>
				</div>
				<div class="col-md-4 col-xs-4">
					<a class="btn btn-danger"
						href="/admin/order/delete/${order.id}">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>

<div class="col-md-2 col-xs-12">
	<div class="row">
		<div class="col-md-6 col-xs-6 text-center">
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					Sort <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<custom:sort innerHtml="Name asc" paramValue="nameMeasure" />
					<custom:sort innerHtml="Name desc" paramValue="nameMeasure,desc" />
				</ul>
			</div>
		</div>
		<div class="col-md-6 col-xs-6 text-center">
			<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
		</div>
	</div>

</div>

<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>  --%>