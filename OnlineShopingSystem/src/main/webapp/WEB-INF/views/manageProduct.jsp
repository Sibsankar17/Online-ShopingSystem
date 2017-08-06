<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<c:if test="${not empty saveMessage}">
			<div class="col-ms-12">
				<div class="alert alert-sucess alert-dismissible"
					style="background: green">
					<button type="button" class="close btn btn-primary"
						data-dismiss="alert">Close&times;</button>
					<p align="center" style="font-size: large;">${saveMessage}</p>
				</div>
			</div>
		</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h2>ProductMannagement</h2>
				</div>
				<div class="panel-body">
					<form:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST"
						enctype="multipart/form-data">
						<form:hidden path="id" />
						<form:hidden path="code" />
						<form:hidden path="active" />
						<form:hidden path="supplierId" />
						<form:hidden path="purchases" />
						<form:hidden path="views" />
						<div class="form-group">
							<label class="control-label col-md-3" for="name">Product
								Name:</label>
							<div class="col-md-9">
								<form:errors path="name" cssClass="ErrorElement" element="em" />
								<form:input type="text" path="name" id="name"
									placeholder="Enter Product Name" class="form-control" />

							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="brand">Brand
								Name:</label>
							<div class="col-md-9">
								<form:errors path="brand" cssClass="ErrorElement" element="em" />
								<form:input type="text" path="brand" id="brand"
									placeholder="Enter Brand Name" class="form-control" />

							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="description">
								Description: </label>
							<div class="col-md-9">
								<form:errors path="description" cssClass="ErrorElement"
									element="em" />
								<form:textarea path="description" id="description"
									placeholder="About This Product" class="form-control" />

							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="unitPrice">Unit
								Price:</label>
							<div class="col-md-9">
								<form:errors path="unitPrice" cssClass="ErrorElement"
									element="em" />
								<form:input type="number" path="unitPrice" id="unitPrice"
									placeholder="Enter Price In &#8360" class="form-control" />
							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="quantity">Quantity:</label>
							<div class="col-md-9">

								<form:input type="number" path="quantity" id="quantity"
									placeholder="Enter Available Item" class="form-control" />
							</div>

						</div>
						<!-- FOr Uploading Images -->
						<div class="form-group">
							<label class="control-label col-md-3" for="file">Select
								an Image:</label>
							<div class="col-md-9">
								<form:errors path="file" cssClass="ErrorElement" element="em" />
								<form:input type="file" path="file" id="file"
									class="form-control" />
							</div>

						</div>
						<div class="form-group">
							<label class="control-label col-md-3" for="categoryId">Quantity
								Available:</label>
							<div class="col-md-9">

								<form:select path="categoryId" id="categoryId"
									class="form-control" items="${categories}" itemLabel="name"
									itemValue="id" />

							</div>
							<c:if test="${product.id==0}">
								<div class="text-left">
									<br />
									<button type="button" data-toggle="modal"
										data-target="#newCategory" class="btn btn-primary btn-sm">ADD
										NEW CATEGORY</button>
								</div>

							</c:if>

						</div>

						<div class="form-group">
							<div class="col-md-offset-10 col-md-2">

								<input type="submit" name="submit" id="submit" value="SUBMIT"
									class="btn btn-primary" />
							</div>

						</div>
					</form:form>

				</div>
			</div>

		</div>


	</div>
	<div class="row">
		<div class="col-xs-12">
			<h2>Product Available</h2>
		</div>
		<div class="col-xs-12">
			<div style="overflow: auto;">
				<table id="productTable" class="table table-striped table-borderd">
					<thead>
						<tr>
							<th>ID</th>
							<th>&#160;</th>
							<th>NAME</th>
							<th>BRAND</th>
							<th>PRICE</th>
							<th>Quantity</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>

					</thead>
					<tfoot>
						<tr>
							<th>ID</th>
							<th>&#160;</th>
							<th>NAME</th>
							<th>BRAND</th>
							<th>PRICE</th>
							<th>Quantity</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>

					</tfoot>
				</table>
			</div>

		</div>

	</div>
<div class="modal fade" id="newCategory" role="dialog" tabindex="-1">
 	<div class="modal-dialog" role="document">
 		<div class="modal-content">
 			<!-- Modal Header -->
 			<div class="modal-header">
 				<button type="button" class="close" data-dismiss="modal">
 					<span>&times;</span>
 				</button>
 				<h4 class="modal-title">Add New Category</h4>
 			</div>
 			<div class="modal-body">
 				<!-- Category Form -->
 				<form:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category"
 					method="POST" class="form-horizontal">
					 					
 					<div class="form-group"> 						
 						<label for="category_name" class="control-label col-md-4">Category Name</label>
 						<div class="col-md-8"> 		
 							<form:input type="text" path="name" id="category_name" class="form-control"/>  						
 						</div> 						 					
 					</div>

 					<div class="form-group"> 						
 						<label for="category_description" class="control-label col-md-4">Category Description</label>
 						<div class="col-md-8"> 		
 							<form:textarea cols="" rows="5" path="description" id="category_description" class="form-control"/>  						
 						</div> 						 					
 					</div>
 				
  					<div class="form-group"> 						 						
 						<div class="col-md-offset-4 col-md-8"> 		
 							<input type="submit" value="Add Category" class="btn btn-primary"/>	  						
 						</div> 						 					
 					</div>				
 				
 				</form:form>
 			</div>
 		</div> 		
 	</div>
 
 </div>
</div>