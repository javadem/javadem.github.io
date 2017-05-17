<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<style>
#filter>.form-group>.col-sm-12>span {
	display: block;
}
</style>

<div class="container">
	<div class="row">
		<div class="">
			<div class="content">


		
		<aside class="col-xs-5 col-sm-4 col-md-3 col-lg-3">
		<div class="aside">
		                <ul class="list-group submenu">
		                    <li class="list-group-item active">Супутникове ТБ</li>
		                    <li class="list-group-item"><a href="/donec/">Ресивери</a></li>
		                    <li class="list-group-item"><a href="/vestibulum/">Антени</a></li>
		                    <li class="list-group-item"><a href="/etiam/">Конвертори</a></li>
		                    <li class="list-group-item"><a href="/phasellus/">Перемикачі</a></li>
		                    <li class="list-group-item"><a href="/cras/">Кронштейни</a></li>
		                </ul>
		                 
		                <ul class="list-group submenu">
		                    <li class="list-group-item active">Ефірне ТБ Т2</li>
		                    <li class="list-group-item"><a href="/donec/">Приймачі</a></li>
		                    <li class="list-group-item"><a href="/vestibulum/">Антени</a></li>
		                    <li class="list-group-item"><a href="/etiam/">Підсилювачі</a></li>
		                    <li class="list-group-item"><a href="/phasellus/">Розгалужники</a></li>
		                    <li class="list-group-item"><a href="/cras/">Cras et nisi vitae odio</a></li>
		                </ul> 
		                 
		                <div class="panel panel-primary">
		                    <div class="panel-heading">Наші магазини</div>
		                    <div class="panel-body">
		                        <img src="/images/map.png" class="img-responsive" alt="Our offices">
		                    </div>
		                </div> 
		</div>                
		</aside>
		
		
		<div class="col-xs-7 col-sm-8 col-md-9 col-lg-9">
		<div class="productContent">
			<div class="row">
			
			
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
			
					<img class="img-rounded" width="100%"
									src="/images/item/${product.id}.jpg?version=${product.version}"></img>
			
				</div>
				
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
					<div class="rowDetails">
						
							<div class="row">
								<div class="nameProduct">
								<div class="col-md-12 col-xs-12 blockDetails">${product.nameProduct}</div></div>
								</div>
								
							<div class="row">	
								<div class="col-md-12 col-xs-12 blockDetails">${product.model.nameModel}</div>
								</div>
								
								
							<div class="row">	
								<div class="col-md-7 col-xs-7 col-md-7 col-lg-7 blockDetails">${product.price} грн</div>
									
								<div class="col-md-5 col-xs-5 col-md-5 col-lg-5 blockDetails"> / ${product.measure.nameMeasure}</div>
							</div>
							

							
							<div class="row">
								<div class="col-md-offset-3 col-md-4 col-xs-4 col-md-6 col-lg-6 blockDetails">
								 <security:authorize access="isAuthenticated()"> 
									<a class="btn btn-success btn-block" href="/user/product/buyPR/${product.id}">Купити</a>
								 </security:authorize> 
								
								<security:authorize access="!isAuthenticated()"> 
									<a class="btn btn-success btn-block" href="/user/product/buyNA/${product.id}">Купити</a>
								 </security:authorize> 
								</div>
							</div>
					</div>		
				</div>
					
			</div>
			
			
			<div class="row">
				<div class="col-xs-7 col-sm-8 col-md-12 col-lg-12">
					<div class="descriptionProduct">${product.description}</div>
				</div>
			</div>
		</div>
		</div>
		

			</div>
		</div>
	</div>
</div>












