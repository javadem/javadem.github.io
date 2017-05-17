<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>


<security:authorize access="isAuthenticated()">

<div class="container">
	<div class="row">
		<div class="">
			<div class="content">


	<div class="row oneBlock">

		<div class="col-md-7 col-xs-12">

			<div class="row">
			
			<h1>Сторінка користувача ${user.username}</h1>
			
<%-- 			
				<div class="col-md-12 col-xs-12">
					<form:form class="form-horizontal" action="/user/user"
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
			
	 --%>		
			
			<div class="row">
				<div class="col-md-2 col-xs-2">
					<h3>Логін</h3>
				</div>
				<div class="col-md-3 col-xs-3">
					<h3>E-mail</h3>
				</div>
				
				<div class="col-md-2 col-xs-2">
					<h3>Оновити</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Видалити</h3>
				</div>
				<div class="col-md-3 col-xs-3">
					<h3>Кошик</h3>
				</div>
			</div>
			
			
				<div class="row">
					<div class="col-md-2 col-xs-2">${user.username}</div>
					<div class="col-md-3 col-xs-3">${user.email}</div>
					
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-warning" href="/user/user/update/${user.id}">Оновити</a>
					</div>
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-danger" href="/user/user/delete/${user.id}">Видалити</a>
					</div>
					<div class="col-md-2 col-xs-2">
						<c:forEach items="${shopingCarts}" var="shopingCart">
							<div class="row">
								<div class="col-md-3 col-xs-3">
									<a class="btn btn-success"
										href="/user/shopingCart/${shopingCart.id}">Кошик</a>
								</div>
							</div>
						</c:forEach> 
					</div>
				</div>
				
				<br>
				
<%--  			<div class="row">
			
				<div class="col-md-2 col-xs-2">
					<h3>Cart id</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>view</h3>
				</div>
 				<div class="col-md-2 col-xs-2">
					<h3>Update</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Delete</h3>
				</div> 
			</div>
			<c:forEach items="${shopingCarts}" var="shopingCart">
				<div class="row">
					
					<div class="col-md-2 col-xs-2">${shopingCart.id}</div>
					
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-success"
							href="/user/shopingCart/${shopingCart.id}">view</a>
					</div>
	
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-warning"
							href="/user/shopingCart/update/${shopingCart.id}">update</a>
					</div>
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-danger"
							href="/user/shopingCart/delete/${shopingCart.id}">delete</a>
					</div>
				</div>
			</c:forEach>  --%>
			<br>
		</div>
	</div>			
				
			
		</div>
		

	
			</div>
		</div>
	</div>
</div>
	
	
	
</security:authorize>








<security:authorize access="!isAuthenticated()">

<div class="container">
	<div class="row">
		<div class="">
			<div class="content">


	<div class="row oneBlock">

		<div class="col-md-7 col-xs-12">

			<div class="row">
			
			<h1> NEW USER ACCAUNT</h1>
			
			
				<div class="col-md-12 col-xs-12">
					<form:form class="form-horizontal" action="/user/userUnit"
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
			
			
			
			<!-- <div class="row">
				<div class="col-md-2 col-xs-2">
					<h3>User name</h3>
				</div>
				<div class="col-md-3 col-xs-3">
					<h3>User email</h3>
				</div>
				
				<div class="col-md-2 col-xs-2">
					<h3>Update</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Delete</h3>
				</div>
				<div class="col-md-3 col-xs-3">
					<h3>View cart</h3>
				</div>
			</div> -->
			
			
<%-- 				<div class="row">
					<div class="col-md-2 col-xs-2">${user.username}</div>
					<div class="col-md-3 col-xs-3">${user.email}</div>
					
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-warning" href="/user/user/update/${user.id}">Update</a>
					</div>
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-danger" href="/user/user/delete/${user.id}">Delete</a>
					</div>
					<div class="col-md-2 col-xs-2">
						<c:forEach items="${shopingCarts}" var="shopingCart">
							<div class="row">
								<div class="col-md-3 col-xs-3">
									<a class="btn btn-success"
										href="/user/shopingCart/${shopingCart.id}">View cart</a>
								</div>
							</div>
						</c:forEach> 
					</div>
				</div> --%>
				
				<br>
				
<%--  			<div class="row">
			
				<div class="col-md-2 col-xs-2">
					<h3>Cart id</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>view</h3>
				</div>
 				<div class="col-md-2 col-xs-2">
					<h3>Update</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Delete</h3>
				</div> 
			</div>
			<c:forEach items="${shopingCarts}" var="shopingCart">
				<div class="row">
					
					<div class="col-md-2 col-xs-2">${shopingCart.id}</div>
					
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-success"
							href="/user/shopingCart/${shopingCart.id}">view</a>
					</div>
	
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-warning"
							href="/user/shopingCart/update/${shopingCart.id}">update</a>
					</div>
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-danger"
							href="/user/shopingCart/delete/${shopingCart.id}">delete</a>
					</div>
				</div>
			</c:forEach>  --%>
			<br>
		</div>
				
				
			
		</div>
		

	
			</div>
		</div>
	</div>
</div>
	
	
	
</security:authorize>

