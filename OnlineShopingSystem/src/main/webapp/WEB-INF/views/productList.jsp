<div class="container">

	<div class="row">
		<div class="col-md-2">
			<%@include file="./common/sidebar.jsp"%>
		</div>
		<div class="col-md-10">
			<!-- Breadcrumb Component -->
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${onClickAllProduct == true}">
						<script>
							window.categoryId = '';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Product</li>
						</ol>

					</c:if>
					<c:if test="${onClickCategoryProduct == true}">

						<script>
							window.categoryId ='${category.id}';
						</script>
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>

					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">

					<table id="productListTable"
						class="table table-striped table-borderd">
						<thead style="background-color:#ffffa8">
							<tr>
							    <th></th>
								<th>NAME</th>
								<th>BRAND</th>
								<th>PRICE</th>
								<th>AVABLE_ITEM</th>
								<th>VIEWS</th>
								<th>ACTION</th>
							</tr>

						</thead>


					</table>

				</div>

			</div>
		</div>
	</div>

</div>