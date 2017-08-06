<%@include file="../common/flows-header.jsp"%>

<div class="container">
	<div class="row">

		<!-- column to display the personal details -->
		<div class="col-sm-6">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Personal Details</h4>
				</div>
				<div class="panel-body">

					<div class="text-center">

						<h4>NAME: ${registerModel.user.firstName}&&
							${registerModel.user.lastName}</h4>

						<h5>Email: ${registerModel.user.email}</h5>

						<h5>Contact Number: ${registerModel.user.contactNumber}</h5>

						<h5>Role: ${registerModel.user.role}</h5>

					</div>


				</div>
				<div class="panel-footer">
					<a href="${flowExecutionUrl}&_eventId_personal"
						class="btn btn-primary">Click To Edit</a>

				</div>
			</div>

		</div>

		<!-- column to display the address  -->
		<div class="col-sm-6">

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Address</h4>
				</div>
				<div class="panel-body">
					<div class="text-center">
						<h4>ADDRESS LINE 1:${registerModel.address.address1}</h4>
						<h4>ADDRESS LINE 2:${registerModel.address.address2}</h4>
						<h4>CITY:${registerModel.address.city}</h4>
						<h4>PINCODE:${registerModel.address.pincode}</h4>
						<h4>STATE: ${registerModel.address.state}</h4>
						<h4>COUNTRY:${registerModel.address.country}</h4>
					</div>
				</div>
				<div class="panel-footer">
					<!-- anchor to move to the edit of address -->
					<a href="${flowExecutionUrl}&_eventId_address"
						class="btn btn-primary">Click To Edit</a>
				</div>
			</div>

		</div>

	</div>

	<!-- to provide the confirm button after displaying the details -->
	<div class="row">
		<div class="col-sm-4 col-sm-offset-4">

			<div class="text-center">

				<a href="${flowExecutionUrl}&_eventId_submit"
					class="btn btn-primary">Confirm and Submit</a>

			</div>

		</div>
	</div>
</div>
<%@include file="../common/flows-footer.jsp"%>