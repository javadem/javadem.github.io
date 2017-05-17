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
					<li><a href="/admin/producer">Виробник</a></li>
					<li class="active"><a href="/admin/model">Модель</a></li>
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
	<div class="col-md-3 col-xs-6">
		<form:form class="form-horizontal" action="/admin/model" method="GET"
			modelAttribute="filter" id="filter">
			<custom:hiddenInputs excludeParams="search, modelIds" />
			<div class="form-group">
				<div class="col-sm-12">
					<form:input type="text" class="form-control" path="search"
						placeholder="Пошук по назві моделі" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-12">
					<input class="form-control" type="text" placeholder="Фільтр по типу товару" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-1 col-md-1 col-xs-1 col-lg-1">
					<form:checkboxes items="${typeProducts}" path="typeProductIds"
						itemLabel="nameTypeProduct" itemValue="id" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
					<input class="form-control" type="text" placeholder="Фільтр по виробнику" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-1 col-md-1 col-xs-1 col-lg-1">
					<form:checkboxes items="${producers}" path="producerIds"
						itemLabel="nameProducer" itemValue="id" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
					<button type="submit" class="btn btn-primary">Пошук</button>
				</div>
			</div>
		</form:form>
	</div>

	<div class="col-md-8 col-xs-6">

		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/model"
					method="POST" modelAttribute="model" >

					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors
								path="nameModel" /></label>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Назва</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" path="nameModel"
								id="name" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Тип товару</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="typeProduct"
								itemLabel="nameTypeProduct" itemValue="id"
								items="${typeProducts}" />

						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">Виробник</label>
						<div class="col-sm-10">
							<form:select class="form-control" path="producer"
								itemLabel="nameProducer" itemValue="id" items="${producers}" />
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
				<h3>Назва моделі</h3>
			</div>
			<div class="col-md-3 col-xs-3">
				<h3>Тип товару</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Виробник</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Оновити</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Видалити</h3>
			</div>
		</div>
		<c:forEach items="${page.content}" var="model">
			<div class="row productsList">
				<div class="col-md-2 col-xs-2"><b>${model.nameModel}</b></div>
				<div class="col-md-3 col-xs-3">${model.typeProduct.nameTypeProduct}</div>
				<div class="col-md-2 col-xs-2">${model.producer.nameProducer}</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-warning" href="/admin/model/update/${model.id}">Оновити</a>
				</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-danger" href="/admin/model/delete/${model.id}">Видалити</a>
				</div>
			</div>
		</c:forEach>
	</div>

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
					<custom:sort innerHtml="Name asc" paramValue="nameModel" />
					<custom:sort innerHtml="Name desc" paramValue="nameModel,desc" />
					<custom:sort innerHtml="TypeProduct asc" paramValue="nameTypeProduct" />
					<custom:sort innerHtml="TypeProduct desc" paramValue="nameTypeProduct,desc" />
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