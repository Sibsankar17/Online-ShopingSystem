<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p class="lead">Shop Name</p>
<div class="list-group">
<c:forEach items="${categories}" var="cat">
	<a href="${contextRoot}/show/Category/${cat.id}/products" class="list-group-item" id="a_${category.name}">${cat.name}</a>
	</c:forEach> 
</div>