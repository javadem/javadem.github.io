<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<div class="container">


<div class="row">
	<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/user/category"
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
				<form:form class="form-horizontal" action="/user/category"
					method="POST" modelAttribute="category"
					>

				</form:form>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4 col-xs-4">
				<h3>Category name</h3>
			</div>
			
		</div>

		<c:forEach items="${page.content}" var="category">
			<div class="row">
				<ul>
					<li><div class="col-md-4 col-xs-4"><a href="">${category.nameCategory}</a></div></li>
				</ul>
				
			</div>
		</c:forEach>
	
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>

<div>
	<div class="col-md-2 col-xs-12">
		<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="nameCategory" />
						<custom:sort innerHtml="Name desc" paramValue="nameCategory,desc" />
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
