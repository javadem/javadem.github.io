<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-sm-12 col-xs-12 parent">
		<c:forEach items="${products}" var="product">
			<div>
				<img src="/images/item/${product.id}.jpg?version=${product.version}" width="100%">
				<p>${product.nameProduct}</p>
				<p>${product.price} грн</p>
				<div>
					<a href="/del/${product.id}" class="btn btn-primary">З корзини</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>



