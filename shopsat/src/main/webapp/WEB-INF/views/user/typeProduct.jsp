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
					<li><a href="/user/category">Category</a></li>
					<li class="active"><a href="/user/typeProduct">Type
							product</a><span class="sr-only">(current)</span></li>
					<li><a href="/user/country">Country</a></li>
					<li><a href="/user/producer">Producer</a></li>
					<li><a href="/user/model">Model</a></li>
					<li><a href="/user/measure">Measure</a></li>
					<li><a href="/user/product">Product</a></li>
					<li><a href="/user/user">User</a></li>
					<li><a href="/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

<div class="row">
	<div class="col-md-3 col-xs-12">
		<form:form class="form-horizontal" action="/user/typeProduct"
			method="GET" modelAttribute="filter" id="filter">
			<custom:hiddenInputs excludeParams="search, typeProductIds" />
			<div class="form-group">
				<div class="col-sm-12">
					<form:input type="text" class="form-control" path="search"
						placeholder="Search" />
				</div>
			</div>

 			<div class="form-group">
				<div class="col-sm-1 col-md-1 col-xs-1 col-lg-1">
					<form:checkboxes items="${categories}" path="categoryIds"
						itemLabel="nameCategory" itemValue="id" />
				</div>
			</div> 



			<div class="form-group">
				<div class="col-sm-12">
					<button type="submit" class="btn btn-primary">Search</button>
				</div>
			</div>
		</form:form>
	</div>

	<div class="col-md-7 col-xs-12">

		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/user/typeProduct"
					method="POST" modelAttribute="typeProduct"
					>

				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-xs-3">
				<h3>TypeProduct</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Category</h3>
			</div>
			
		</div>
		<c:forEach items="${page.content}" var="typeProduct">
			<div class="row">
			<ul>
				<li><div class="col-md-3 col-xs-3"><a href="">${typeProduct.nameTypeProduct}</a></div>
				<div class="col-md-3 col-xs-3">${typeProduct.category.nameCategory}</div></li>
			</ul>
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
					<custom:sort innerHtml="Name asc" paramValue="nameTypeProduct" />
					<custom:sort innerHtml="Name desc"
						paramValue="nameTypeProduct,desc" />
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
</div>