<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>



<div class="container">
	<div class="row">
		<div class="">
			<div class="content">



<div class="row oneBlock">
	

	<div class="col-md-12 col-xs-12">


		
 		
<%-- 			<div class="row">
				<div class="col-md-2 col-xs-2">
					<h3>Cart id</h3>
				</div>
				
				
				<div class="col-md-2 col-xs-2">
					<h3>Update</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Delete</h3>
				</div>
			</div>
			
			
				<div class="row">
					<div class="col-md-2 col-xs-2">${shopingCart.id}</div>
					
					
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-warning" href="/user/shopingCart/update/${shopingCart.id}">update</a>
					</div>
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-danger" href="/user/shopingCart/delete/${shopingCart.id}">delete</a>
					</div>
				</div> --%>
				
				<br>
				
			<div class="row">
			
				<div class="col-md-1 col-xs-1">
					<h3>Id</h3>
				</div>
				<div class="col-md-3 col-xs-3">
					<h3>Назва товару</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Ціна</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>К-ть</h3>
				</div>
				<div class="col-md-2 col-xs-2">
					<h3>Перегляд</h3>
				</div>

 				<div class="col-md-1 col-xs-1">
					<h3>Delete</h3>
				</div> 
			</div>
			<c:forEach items="${products}" var="product">
				<div class="row listProductsInCart ">
					
					<div class="col-md-1 col-xs-1">${product.id}</div>
					
					<div class="col-md-3 col-xs-3">${product.nameProduct}</div>
					
					<div class="col-md-2 col-xs-2">${product.price} грн</div>
					
					<div class="col-md-2 col-xs-2">${shopingCart.count}</div>
					
					<div class="col-md-2 col-xs-2">
						<a class="btn btn-success"
							href="/user/product/${product.id}">Перегляд</a>
					</div>
	

 					<div class="col-md-1 col-xs-1">
						<a class="btn btn-danger"
							href="/user/shopingCart/${shopingCart.id}/deleteProductFromCart/${product.id}">delete</a>
					</div> 
				</div>
				<br>
			</c:forEach>
			
			<div class="row">
				<div class="col-md-4 col-xs-4">
					<h2>Загальна вартість = ${shopingCart.amount} грн</h2>
				</div>
				
				<div class="col-md-2 col-xs-2">	
				<security:authorize access="isAuthenticated()"> 
					<a class="btn btn-success" href="/user/shopingCart/createPayment/${shopingCart.id}">Створити рахунок</a>
				</security:authorize>
				
				<security:authorize access="!isAuthenticated()">
					<a class="btn btn-warning" href="/login">Ввійти в аккаунт</a>
					<!-- <a class="btn btn-warning" href="/registration">Registration</a> -->
					<%-- <a class="btn btn-warning" href="/user/user/${shopingCart.id}">Ввійти в аккаунт</a> --%>
				</security:authorize>
				</div> 
				
			</div>
			
		
	</div>
		


</div>




			</div>
		</div>
	</div>
</div>

