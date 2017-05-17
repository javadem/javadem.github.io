<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<style>
#filter>.form-group>.col-sm-12>span {
	display: block;
}
</style>

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
					<li class="active"><a href="/admin/product">Товар</a></li>
					<li><a href="/admin/user">Користувач</a></li>
					<li><a href="/admin/shopingCart">Кошик</a></li>
					<li><a href="/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>


<div class="row">
	<div class="col-md-3 col-xs-12">

		<%-- <form:form class="form-horizontal" action="/admin/product"
			method="GET" modelAttribute="filter" id="filter">
			<custom:hiddenInputs
				excludeParams="search, minPrice, maxPrice, modelIds, description, measureIds" />
			<div class="form-group">
				<div class="col-sm-12">
					<form:input type="text" class="form-control" path="search"
						placeholder="Search by name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6 col-xs-6">
					<form:input type="text" class="form-control" path="minPrice"
						placeholder="Min price" />
				</div>
				<div class="col-sm-6 col-xs-6">
					<form:input type="text" class="form-control" path="maxPrice"
						placeholder="Max price" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
					<form:checkboxes items="${models}" path="modelIds"
						itemLabel="nameModel" itemValue="id" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:input type="text" class="form-control" path="description"
						placeholder="Search by description" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:checkboxes items="${measures}" path="measureIds"
						itemLabel="nameMeasure" itemValue="id" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
					<button type="submit" class="btn btn-primary">Search</button>
				</div>
			</div>
		</form:form> --%>
		<form:form class="form-horizontal" action="/admin/product"
			method="GET" modelAttribute="filter" id="filter">
			<custom:hiddenInputs
				excludeParams="search, minPrice, maxPrice, modelIds, description, measureIds" />
			<div class="form-group">
				<div class="col-sm-12">
					<form:input type="text" class="form-control" path="search"
						placeholder="Search by name" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6 col-xs-6">
					<form:input type="text" class="form-control" path="minPrice"
						placeholder="Min price" />
				</div>
				<div class="col-sm-6 col-xs-6">
					<form:input type="text" class="form-control" path="maxPrice"
						placeholder="Max price" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
					<form:input type="text" class="form-control" path="description"
						placeholder="Search by description" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-12">
					<input class="form-control" type="text" placeholder="Search by category" readonly>
				</div>
			</div>	
			<div class="form-group">
				<div class="col-sm-12 col-md-12 col-xs-12 col-lg-12">
					<form:checkboxes items="${categories}" path="categoryIds"
						itemLabel="nameCategory" itemValue="id" />
				</div>
			</div> 
			
			<div class="form-group">
				<div class="col-sm-12">
					<input class="form-control" type="text" placeholder="Search by type" readonly>
				</div>
			</div>
 			<div class="form-group">
				<div class="col-sm-12 col-md-12 col-xs-12 col-lg-12">
					<form:checkboxes items="${typeProducts}" path="typeProductIds"
						itemLabel="nameTypeProduct" itemValue="id" />
				</div>
			</div>		
			
			<div class="form-group">
				<div class="col-sm-12">
					<input class="form-control" type="text" placeholder="Search by producer" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12 col-md-12 col-xs-12 col-lg-12">
					<form:checkboxes items="${producers}" path="producerIds"
						itemLabel="nameProducer" itemValue="id" />
				</div>
			</div>  
			
			<div class="form-group">
				<div class="col-sm-12">
					<input class="form-control" type="text" placeholder="Search by country" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12 col-md-12 col-xs-12 col-lg-12">
					<form:checkboxes items="${countries}" path="countryIds"
						itemLabel="nameCountry" itemValue="id" />
				</div>
			</div>  	
			
<%-- 			<div class="form-group">
				<div class="col-sm-12">
					<input class="form-control" type="text" placeholder="Search by model" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:checkboxes items="${models}" path="modelIds"
						itemLabel="nameModel" itemValue="id" />
				</div>
			</div>  --%>
			
			<div class="form-group">
				<div class="col-sm-12">
					<input class="form-control" type="text" placeholder="Search by measure" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-12">
					<form:checkboxes items="${measures}" path="measureIds"
						itemLabel="nameMeasure" itemValue="id" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-12">
					<button type="submit" class="btn btn-primary">Пошук</button>
				</div>
			</div>
		</form:form>
		
	</div>

	<div class="col-md-9 col-xs-9">

		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/product"
					method="POST" modelAttribute="product"
					enctype="multipart/form-data">

					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors
								path="nameProduct" /></label>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors
								path="description" /></label>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors
								path="price" /></label>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Назва</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="nameProduct"
								id="name" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Модель</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="model"
								itemLabel="nameModel" itemValue="id" items="${models}" />
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Опис</label>

						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="description"
								id="name" />
						</div>

					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Ціна</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="price"
								id="name" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Вимір</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="measure"
								itemLabel="nameMeasure" itemValue="id" items="${measures}" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<label class="btn btn-default btn-file">Огляд<input
								type="file" name="file" style="display: none;">
							</label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Створити</button>
						</div>
					</div>

				</form:form>
			</div>
		</div>

		<div class="row">
			<div class="col-md-2 col-xs-2">
				<h3>Фото</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Назва товару</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Модель</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Опис</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Ціна</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Вимір</h3>
			</div>
<!-- 			<div class="col-md-1 col-xs-1">
				<h3>Update</h3>
				<h3>Delete</h3>
			</div> -->
<!-- 			<div class="col-md-2 col-xs-2">
				<h3>Огляд</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Купити</h3>
			</div> -->
		</div>

		<c:forEach items="${page.content}" var="product">
			<div class="row productsList">
				<div class="col-md-2 col-xs-2">
					<img class="img-rounded" width="100%"
						src="/images/item/${product.id}.jpg?version=${product.version}"></img>
				</div>
				<div class="col-md-2 col-xs-2">${product.nameProduct}</div>
				<div class="col-md-2 col-xs-2">${product.model.nameModel}</div>
				<div class="col-md-2 col-xs-2 adminDescription">${product.description}</div>
				<div class="col-md-1 col-xs-1">${product.price} грн</div>
				<div class="col-md-1 col-xs-1">${product.measure.nameMeasure}</div>

				<div class="col-md-2 col-xs-2">
					<a class="btn btn-warning"
						href="/admin/product/update/${product.id}">update</a>
					<a class="btn btn-danger"
						href="/admin/product/delete/${product.id}">delete</a>
				</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-success"
						href="/admin/product/${product.id}">Огляд</a>
				</div>
<%-- 				<div class="col-md-2 col-xs-2">
					<a class="btn btn-success"
						href="/admin/product/buy/${product.id}">Купити</a>
					
				</div> --%>
			</div>
			<br>
		</c:forEach>
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
						<custom:sort innerHtml="Name asc" paramValue="nameProduct" />
						<custom:sort innerHtml="Name desc" paramValue="nameProduct,desc" />
						<custom:sort innerHtml="Price asc" paramValue="price" />
						<custom:sort innerHtml="Price desc" paramValue="price,desc" />
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
</div>


<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>
