<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="../common/flows-header.jsp"%>
		<br />
		<%@ include file="../common/flows-navbar.jsp"%>


		<div class="contener">
			<div class="row">

				<div class="col-md-6 col-md-offset-3">

					<div class="panel panel-primary">

						<div class="panel-heading">
							<h4>Register:Personal</h4>
						</div>

						<div class="panel-body">

							<form:form method="POST" class="form-horizontal"
								id="registerForm" modelAttribute="user">


								<div class="form-group">
									<label class="control-label col-md-4">First Name</label>
									<div class="col-md-8">
										<form:input type="text" path="firstName" class="form-control"
											placeholder="First Name" />

										<form:errors path="firstName" cssClass="ErrorElement"
											element="em" />

									</div>
								</div>


								<div class="form-group">
									<label class="control-label col-md-4">Last Name</label>
									<div class="col-md-8">
										<form:input type="text" path="lastName" class="form-control"
											placeholder="Last Name" />

										<form:errors path="lastName" cssClass="ErrorElement"
											element="em" />

									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-4">Email</label>
									<div class="col-md-8">
										<form:input type="text" path="email" class="form-control"
											placeholder="abc@zyx.com" />

										<form:errors path="email" cssClass="ErrorElement" element="em" />

									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-4">Contact Number</label>
									<div class="col-md-8">
										<form:input type="text" path="contactNumber"
											class="form-control" placeholder="XXXXXXXXXX" maxlength="10" />

										<form:errors path="contactNumber" cssClass="ErrorElement"
											element="em" />


									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-4">Password</label>
									<div class="col-md-8">
										<form:input type="password" path="password"
											class="form-control" placeholder="Password" />

										<form:errors path="password" cssClass="ErrorElement"
											element="em" />


									</div>
								</div>	 
								<div class="form-group">
									<label class="control-label col-md-4">Password</label>
									<div class="col-md-8">
										<form:input type="password" path="confirmPassword"
											class="form-control" placeholder=" Re-Enter Password" />

										<form:errors path="confirmPassword" cssClass="ErrorElement"
											element="em" />


									</div>
								</div>     

								<!-- radio button using bootstrap class of radio-inline -->
								<div class="form-group">
									<label class="control-label col-md-4">Select Role</label>
									<div class="col-md-8">
										<label class="radio-inline"> <form:radiobutton
												path="role" value="USER" checked="checked" /> User
										</label> <label class="radio-inline"> <form:radiobutton
												path="role" value="SUPPLIER" /> Supplier
										</label>
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-offset-4 col-md-8">
										<button type="submit" class="btn btn-primary"
											name="_eventId_address">

											Next><span
												class="glyphicon glyphicon-chevron-right"></span>

										</button>

									</div>
								</div>

							</form:form>
						</div>
					</div>
				</div>
			</div>

		</div>
		<%@include file="../common/flows-footer.jsp"%>
	</div>
</body>

</html>