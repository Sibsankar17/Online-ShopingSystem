<div class="container">

	<div class="row">
		<div class="col-md-3">
			<%@include file="./common/sidebar.jsp"%>
		</div>
		<div class="col-md-9">
			<!-- Breadcrumb Component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${onClickAllProduct == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Product</li>
						</ol>

					</c:if>
					<c:if test="${onClickCategoryProduct == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>

					</c:if>
				</div>
			</div>

		</div>
	</div>

</div>