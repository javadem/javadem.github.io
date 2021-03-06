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
					<li class="active"><a href="/admin">АДМІНКА</a></li>
					<li><a href="/admin/category">Категорія</a></li>
					<li><a href="/admin/typeProduct">Тип товару</a></li>
					<li><a href="/admin/country">Країна</a></li>
					<li class="active"><a href="/admin/producer">Виробник</a></li>
					<li><a href="/admin/model">Модель</a></li>
					<li><a href="/admin/measure">Вимір</a></li>
					<li><a href="/admin/product">Товар</a></li>
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
		<form:form class="form-horizontal" action="/admin/producer"
			method="GET" modelAttribute="filter" id="filter">
			<custom:hiddenInputs excludeParams="search, producerIds" />
			<div class="form-group">
				<div class="col-sm-12">
					<form:input type="text" class="form-control" path="search"
						placeholder="Search" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-1 col-md-1 col-xs-1 col-lg-1">
					<form:checkboxes items="${countries}" path="countryIds"
						itemLabel="nameCountry" itemValue="id" />
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
				<form:form class="form-horizontal" action="/admin/producer"
					method="POST" modelAttribute="producer"
					enctype="multipart/form-data">

					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors
								path="nameProducer" /></label>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Назва</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="nameProducer"
								id="name" />
						</div>
					</div>


					<div class="form-group">
						<label class="col-sm-2 control-label">Країна</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="country"
								itemLabel="nameCountry" itemValue="id" items="${countries}" />

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
			<div class="col-md-3 col-xs-3">
				<h3>Виробник</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Країна</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Оновити</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Видалити</h3>
			</div>
		</div>
		<c:forEach items="${page.content}" var="producer">
			<div class="row">
				<div class="col-md-3 col-xs-3">${producer.nameProducer}</div>
				<div class="col-md-3 col-xs-3">${producer.country.nameCountry}</div>

				<div class="col-md-2 col-xs-2">
					<a class="btn btn-warning"
						href="/admin/producer/update/${producer.id}">Оновити</a>
				</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-danger"
						href="/admin/producer/delete/${producer.id}">Видалити</a>
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
					<custom:sort innerHtml="Name asc" paramValue="nameProducer" />
					<custom:sort innerHtml="Name desc" paramValue="nameProducer,desc" />
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