<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>


<div class="container">

<div class="containerLow"></div>


<div class="row">
	<div class="col-sm-12 col-xs-12">
		<security:authorize access="!isAuthenticated()">
			<form:form class="form-horizontal" action="/login" method="POST">
				<div class="form-group">
					<label for="login" class="col-sm-2 control-label">Логін</label>
					<div class="col-sm-8">
						<input class="form-control" name="login" id="login">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">Пароль</label>
					<div class="col-sm-8">
						<input class="form-control" name="password" id="password">
					</div>
				</div>
	
				<div class="form-group">
					<label for="remember-me" class="col-sm-2 control-label">Запам`ятати мене</label>
					<div class="col-sm-1">
						<input name="remember-me" type="checkbox" class="form-control">
					</div>
				</div>
	
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">Ввійти</button>
	
					</div>
				</div>
			</form:form>
		</security:authorize>

		<div class="col-sm-3 col-xs-3">
			<security:authorize access="!isAuthenticated()">
				<a href="/registration"><button type="submit" class="btn btn-default">Реєстрація</button></a>
			</security:authorize>
		</div>
		<br>
		<br>
	</div>
</div>
</div>
