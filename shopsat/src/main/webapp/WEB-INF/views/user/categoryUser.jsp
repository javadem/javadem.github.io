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
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/user">User</a></li>
					<li class="active"><a href="/user/category">Category</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/user/typeProduct">Type product</a></li>
					
					<li><a href="/user/product">Product</a></li>
					<li><a href="/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

<div class="row">
	<div class="col-md-3 col-xs-12">
		<form:form modelAttribute="filter" action="/user/category" method="get" class="form-inline">
			<div class="form-group">
				<form:input path="search" placeholder="search" class="form-control" />
				<custom:hiddenInputs excludeParams="search"/>
				<button type="submit" class="btn btn-primary">Ok</button>
			</div>
		</form:form>
	</div>
	
			
	
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/user/category" method="POST" modelAttribute="category" enctype="multipart/form-data">
				
					<div class="form-group">
						<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors path="nameCategory"/></label>
					</div>
				
					<div class="form-group">
    					<label for="name" class="col-sm-2 control-label">Name</label>
    					<div class="col-sm-10">
      						<form:input type="text" class="form-control" path="nameCategory" id="name"/>
    					</div>
  					</div>
  					
  					
  					
  				
				</form:form>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4 col-xs-4"><h3>Category name</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Choice</h3></div>
			
		</div>
		
			<c:forEach items="${page.content}" var="category">
				<div class="row">
				<div class="col-md-4 col-xs-4">${category.nameCategory}</div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/user/category/choice/${category.id}">choice</a></div>
					
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
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="nameCategory"/>
						<custom:sort innerHtml="Name desc" paramValue="nameCategory,desc"/>
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
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>