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
		
		<div class="content">
     <div class="wrapper">
     <%@include file="./common/navbar.jsp"%>

	    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	        <div class="container">
	            <!-- Brand and toggle get grouped for better mobile display -->
	            <div class="navbar-header">
	                <a class="navbar-brand" href="${contextRoot}/home">Back TO Home Page</a>
	            </div>
			</div>
		</nav>
			
		
		<div class="content">
		
			<div class="container">
			
				<div class="row">
				
					<div class="col-xs-12">
					
						
						<div class="jumbotron">
						
							<h1>${errorTitle}</h1>
							<hr/>
						
							<blockquote style="word-wrap:break-word">
								
							<blink>	${errorDesc}</blink>
							
							</blockquote>						
						
						</div>
						
											
					</div>					
				
				</div>
			
			</div>
							
		</div>			

		</div>
		<!-- Footer Path-->
		<%@include file="./common/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		<!-- DAtatable Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- DAtatable Bootstrap Plugin -->
		<script src="${js}/dataTables.bootstrap.js"></script>
		<script src="${js}/navebar.js"></script>
	</div>
</body>

</html>
