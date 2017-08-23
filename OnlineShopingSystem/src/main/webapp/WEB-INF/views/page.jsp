<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="imeges" value="/resources/imeges" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>OnlineShoping -${title}</title>
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot='${contextRoot}'
</script>

 <!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap flatly theme -->
<link href="${css}/bootstrap-flatly-theme.css" rel="stylesheet">

<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${css}/main.css" rel="stylesheet">
</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./common/navbar.jsp"%>
		<div class="content">
			<!-- Page Content -->
			<c:if test="${onClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>
			<c:if test="${onClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<c:if test="${onClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>
			<c:if
				test="${onClickAllProduct==true or onClickCategoryProduct==true}">
				<%@include file="productList.jsp"%>
			</c:if>
			<c:if test="${onClickShowProduct==true}">
				<%@include file="Product.jsp"%>
			</c:if>
			<c:if test="${onClickManageProduct==true}">
			<%@include file="manageProduct.jsp" %>
			</c:if>

		</div>
		<!-- Footer Path-->
		<%@include file="./common/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>
		<!-- jQuery Validation -->
		<script src="${js}/jquery.validate.js"></script>
		

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		<!-- DAtatable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- DAtatable Bootstrap Plugin -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		<!-- Bootbox js -->
		<script src="${js}/bootbox.min.js"></script>
		<script src="${js}/navebar.js"></script>
	</div>
</body>

</html>
