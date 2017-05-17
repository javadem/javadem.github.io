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
					<li><a href="/admin/shopingCart">Кошик</a></li>
						<li><a href="/">Home</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="row">
		<div class="col-md-3 col-xs-12">
			<form:form class="form-horizontal" action="/admin/user" method="GET"
				modelAttribute="filter" id="filter">
				<custom:hiddenInputs excludeParams="search, userIds" />
				<div class="form-group">
					<div class="col-sm-12">
						<form:input type="text" class="form-control" path="search"
							placeholder="Search" />
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
					<form:form class="form-horizontal" action="/admin/user"
						method="POST" modelAttribute="user">

						<div class="form-group">
							<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors
									path="username" /></label>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-10">
								<form:input type="text" class="form-control" path="username"
									id="name" />
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors
									path="email" /></label>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<form:input type="text" class="form-control" path="email"
									id="name" />
							</div>
						</div>

						<div class="form-group">
							<label for="name" class="col-sm-offset-2 col-sm-10"><form:errors
									path="password" /></label>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<form:input type="text" class="form-control" path="password"
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
			
<h1>=========Admin-user-jsp========</h1>			
	


		<div class="row">
			<div class="col-md-1 col-xs-1">
				<h3>user id</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>user name</h3>
			</div>
			<div class="col-md-3 col-xs-3">
					<h3>User email</h3>
				</div>
			<div class="col-md-2 col-xs-3">
				<h3>Show user</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Update</h3>
			</div>
			<div class="col-md-1 col-xs-1">
				<h3>Delete</h3>
			</div>
		</div>

		<c:forEach items="${users}" var="user">
			<div class="row">
				<div class="col-md-1 col-xs-1">${user.id}</div>
				<div class="col-md-2 col-xs-2">${user.username}</div>
				<div class="col-md-3 col-xs-3">${user.email}</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-success" href="/admin/user/${user.id}">show user</a>
				</div>
				<div class="col-md-2 col-xs-2">
					<a class="btn btn-warning"
						href="/admin/user/update/${user.id}">update</a>
				</div>
				<div class="col-md-1 col-xs-1">
					<a class="btn btn-danger"
						href="/admin/user/delete/${user.id}">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>
	
	
	
			

<%-- 	<div class="col-md-2 col-xs-12">
		<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="username" />
						<custom:sort innerHtml="Name desc" paramValue="username,desc" />
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
	</div> --%>
</security:authorize>


