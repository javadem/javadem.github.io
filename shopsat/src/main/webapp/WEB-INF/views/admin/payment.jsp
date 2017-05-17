<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



	<div class="container">
		<div class="row">
			<div class="">

				<div class="content">



<div class="row">

<h1>==========USER_payment</h1>






<div class="row">
	
		<div class="col-md-7 col-xs-12">
	<div class="col-md-7 col-xs-12">
	
		


<!--  		<div class="row">
			<div class="col-md-2 col-xs-2">
				<h3>payment id</h3>
			</div>
			<div class="col-md-2 col-xs-2">
				<h3>Amount</h3>
			</div>
			<div class="col-md-6 col-xs-6">
				<h3>text</h3>
			</div>

		</div> -->

			<div class="row">
<%-- 				<div class="col-md-2 col-xs-2">${payment.id}</div>
				
				<div class="col-md-2 col-xs-2">${payment.amount} грн</div> --%>
			
				<div class="col-md-6 col-xs-6">${payment.text}</div> 
				
			</div>

	</div>

<div class="col-md-1 col-xs-1">
					<a class="btn btn-danger"
						href="/admin/payment/delete/${payment.id}">delete</a>
				</div>


</div>
</div>
</div>

				</div>


			</div>

		</div>
	</div>


</body>
</html>