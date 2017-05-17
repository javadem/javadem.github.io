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



	<div class="container">
		<div class="row">
			<div class="">

				<div class="content">
				



<div class="row ">
	<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3 searchProducts">

		<form:form class="form-horizontal" action="/user/product"
			method="GET" modelAttribute="filter" id="filter">
			<custom:hiddenInputs
				excludeParams="search, minPrice, maxPrice, modelIds, description, measureIds" />
			<div class="form-group">
				<div class="col-sm-12">
					<form:input type="text" class="form-control" path="search"
						placeholder="Пошук по назві" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-6 col-xs-6">
					<form:input type="text" class="form-control" path="minPrice"
						placeholder="Min ціна" />
				</div>
				<div class="col-sm-6 col-xs-6">
					<form:input type="text" class="form-control" path="maxPrice"
						placeholder="Max ціна" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-12">
					<form:input type="text" class="form-control" path="description"
						placeholder="Пошук в описі" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-12">
					<input class="form-control" type="text" placeholder="Фільтр по категорії" readonly>
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
					<input class="form-control" type="text" placeholder="Фільтр по країні" readonly>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-1 col-md-1 col-xs-1 col-lg-1">
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
					<input class="form-control" type="text" placeholder="фільтр по виміру" readonly>
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
	
	
	

	<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">

		<c:forEach items="${page.content}" var="product">
			<div class="row productsList">
				<div class="row">
					<div class="col-md-2 col-xs-2">
						<img class="img-rounded" width="100%"
							src="/images/item/${product.id}.jpg?version=${product.version}"></img>
					</div>
					
				<div class="col-md-10 col-xs-10">	
					<div class="col-md-4 col-xs-4"><b>${product.nameProduct}</b></div>
					<div class="col-md-2 col-xs-2">${product.price} грн</div>
					<div class="col-md-1 col-xs-1">${product.measure.nameMeasure}</div>
					<div class="col-md-2 col-xs-2">${product.model.nameModel}</div>
					<div class="col-md-1 col-xs-1">
						<a class="btn btn-success"
							href="/user/product/${product.id}">Купити</a>
					</div>
				</div>
				<div class="row">
					<div class="col-md-10 col-xs-10 userDescription">${product.description}</div>
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-warning"
							href="/user/product/${product.id}">Перегляд</a>
					</div>
					
					
				</div>
				</div>
			</div>
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
						<custom:sort innerHtml="Name asc" paramValue="Назва А-Я" />
						<custom:sort innerHtml="Name desc" paramValue="Назва Я=А" />
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
				
				
	



				</div>


			</div>

		</div>
	</div>









