<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!-- <script src="http://bootstrap-ru.com/204/assets/js/bootstrap-carousel.js"></script> -->

<div class="content">
<div class="container">
<div class="row">
	<div class="col-sm-12 col-xs-12">
<!-- 		<h2>Hello</h2> -->
		<security:authorize
			access="isAuthenticated() and hasRole('ROLE_ADMIN')">
			<a href="/admin">admin</a>
			<%-- 	<security:authentication property="principal.email"/> --%>
		</security:authorize>
		<security:authorize
			access="isAuthenticated() and hasRole('ROLE_USER')">
			<!-- <a href="/user">user</a> -->
			<%-- 	<security:authentication property="principal.email"/> --%>
		</security:authorize>
<%-- 		<security:authorize access="!isAuthenticated()">
 			<a href="/registration">registration</a>
			<a href="/login">login</a> 
		</security:authorize>
 --%>
	</div>
</div>


			

					<div class="row">
						<div class="col-md-8 indexblock1">
							<img src="resources/images/digital_TV.jpg" class="img-responsive">
						</div>
						<div class="col-md-3 indexblock2">
							<div class="row">
								<img src="resources/images/dm_8000_1.jpg" class="img-responsive">
							</div>
							<div class="row">
								<img src="resources/images/duo2-small.jpg"
									class="img-responsive">
							</div>
							<div class="row">
								<img src="resources/images/sx9-combo.jpeg"
									class="img-responsive">
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="jumbotron">
								<h2>Що таке цифрове телебачення?</h2>
								<p>Сучасні вікові люди ведуть високотехнологічне життя деякі
									дивовижні інструменти високих технологій. Цифрове телебачення є
									одним з них. Це фантастична модифікація вашого старого
									телебачення в сучасному стилі. Цифрове телебачення може
									розширити ваш досвід телебачення спостерігаючи найдивовижнішим
									якістю зображення, гладкі особливо біг і надзвичайно гарна
									якість звуку. Це ідеальна передача відео і аудіо з цифровою
									високотехнологічний процес. Цифрове телебачення є модульований
									версія аналогового телебачення для багатоцільового
									використання.</p>
								<p>
									<a class="btn btn-primary btn-lg" href="#" role="button">Дізнатись
										більше</a>
								</p>
							</div>
						</div>
					</div>

				</div>
</div>
