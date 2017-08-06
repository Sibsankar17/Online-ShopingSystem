<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<!-- Breadcrumb -->
	<div class="row">

		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">HOME</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>

			</ol>

		</div>
	</div>
	<div class="row">
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">
				<img src="${imeges}/${product.code}.jpg" class="img img-responsive">
			</div>
		</div>
		<div class="col-xs-12 col-sm-8">
			<h2>${product.name}</h2>
			<hr />
			<p>
				<b>${product.description}</b>
			</p>
			<hr />
			<h3>
				Price:&#8360;<strong>${product.unitPrice}/-</strong>
			</h3>
			<hr />

			<c:choose>
				<c:when test="${product.quantity<1}">
					<h4>
						Item:Available:<span style="color:red">Out Of Stock</span>
					</h4>
				</c:when>
				<c:otherwise>
					<h4>Item:Available:-${product.quantity}</h4>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${product.quantity<1}">
					<h5>
						<a href="javascript:void(0)"
							class="btn btn-sucess disabled ">ADD TO CART</a>&#160; 
							<a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
					</h5>
				</c:when>
				<c:otherwise>
					<h5>
						<a href="${contextRoot}/cart/add/${product.id}"
							class="btn btn-sucess" style="background:green">ADD TO CART</a>&#160; <a
							href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
					</h5>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
</div>