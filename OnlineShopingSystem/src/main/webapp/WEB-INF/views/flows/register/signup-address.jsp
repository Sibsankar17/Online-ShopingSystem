<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@include file="../common/flows-header.jsp"%>

  <br/>
<%@ include file="../common/flows-navbar.jsp"%>

<div class="container">

	<div class="row">

		<div class="col-md-6 col-md-offset-3">

			<div class="panel panel-primary">

				<div class="panel-heading">
					<h4>Register- Address</h4>
				</div>

				<div class="panel-body">

					<sf:form method="POST" class="form-horizontal" id="billingForm"
						modelAttribute="address">


						<div class="form-group">
							<label class="control-label col-md-4" for="address1">Address
								Line 1:</label>
							<div class="col-md-8">
								<sf:input type="text" path="address1" class="form-control"
									placeholder="Enter Address Line One" />

								<sf:errors path="address1" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="address2">Address
								Line2:</label>
							<div class="col-md-8">
								<sf:input type="text" path="address2" class="form-control"
									placeholder="Enter Address 2" />

								<sf:errors path="address2" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="city">City</label>
							<div class="col-md-8">
								<sf:input type="text" path="city" class="form-control"
									placeholder="Enter City Name" />

								<sf:errors path="city" cssClass="help-block" element="em" />


							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="pincode">Pin
								Code</label>
							<div class="col-md-8">
								<sf:input type="text" path="pincode" class="form-control"
									placeholder="XXXXXX" />

								<sf:errors path="pincode" cssClass="help-block" element="em" />


							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="state">State</label>
							<div class="col-md-8">
								<sf:input type="text" path="state" class="form-control"
									placeholder="Enter State Name" />

								<sf:errors path="state" cssClass="help-block" element="em" />

							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="country">Country</label>
							<div class="col-md-8">
								<sf:input type="text" path="country" class="form-control"
									placeholder="Enter Country Name" />

								<sf:errors path="country" cssClass="help-block" element="em" />

							</div>
						</div>


						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<!-- submit button for moving to the personal -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_personal">

									<span class="glyphicon glyphicon-chevron-left"></span>Previous

								</button>

								<!-- submit button for moving to the confirm -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_confirm">

									Next <span class="glyphicon glyphicon-chevron-right"></span>

								</button>

							</div>
						</div>


					</sf:form>
				</div>
			</div>
		</div>
	</div>

</div>

<%@include file="../common/flows-footer.jsp"%>