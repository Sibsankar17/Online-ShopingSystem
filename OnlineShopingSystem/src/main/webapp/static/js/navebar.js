$(function() {

	switch (menu) {
	case 'About':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'Products':
		$('#product').addClass('active');
		break;
	case 'ProductManagement':
		$('#productManage').addClass('active');
		break;
	default:
		if (menu == "Home")
			break;
		$('#product').addClass('active');
		$('#a_' + menu).addClass('active');

	}
	// jquery datatable

	var $table = $('#productListTable');
	if ($table.length) {
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/all/product';
		} else {
			jsonUrl = window.contextRoot + '/json/category/'
					+ window.categoryId + '/product';

		}
	}
	// console.log('inside the table');
	$table
			.DataTable({
				lengthMenu : [ [ 5, 8, 12, -1 ],
						[ '5:Record', '8:Record', '12:Record', 'All' ] ],
				ajax : {
					url : jsonUrl,
					dataSrc : ''
				},
				columns : [
						{
							data : 'code',
							mRender : function(data, type, row) {
								return '<img src="' + window.contextRoot
										+ '/resources/imeges/' + data
										+ '.jpg" class="imageData"/>'
							}
						},

						{
							data : 'name'
						},
						{
							data : 'brand'
						},
						{
							data : 'unitPrice',
							mRender : function(data, type, row) {
								return '&#8360;:' + data;
							}
						},
						{
							data : 'quantity',
							mRender : function(data, type, row) {
								if (data < 1) {
									return '<span style="color:red" >Out Of Stock</span>';
								}
								return data;
							}
						},
						{
							data : 'views'
						},
						{
							data : 'id',
							mRender : function(data, type, row) {
								var str = '';
								str += '<a href="'
										+ window.contextRoot
										+ '/show/'
										+ data
										+ '/product" class="btn btn-primary" style="color:green;background:yellow">View</a>&#160';
								if (row.quantity < 1) {
									str += '<a href="javascript:void(0)" class="btn btn-primary disabled" style="color:red;padding:0px">AddToCart</a>';
								} else {
									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product"class="btn btn primary" style="background:green">AddToCart</a>';
								}

								return str;
							}
						} ]
			})

	// data table for admin
	// ---------------------------------

	var $productsTable = $('#productTable');
	// execute the below code only where we have this table
	if ($productsTable.length) {
		// console.log('Inside the table!');
		var jsonUrl = window.contextRoot + '/json/admin/all/product';
		$productsTable
				.DataTable({

					lengthMenu : [ [ 10, 20, 40, -1 ],
							[ '10Records', '20Records', '40Records', 'ALL' ] ],
					pageLength : 30,
					ajax : {
						url : jsonUrl,
						dataSrc : ''
					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/imeges/'
											+ data
											+ '.jpg" class="dataTableImg"/>';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of Stock!</span>';
									}
									return data;
								}
							},
							
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<label class="switch">';
									if (data) {
										str += '<input type="checkbox" checked="checked" value="'
												+ row.id + '" />';
									} else {
										str += '<input type="checkbox" value="'
												+ row.id + '" />';
									}
									str += '<div class="slider"></div></label>';
									return str;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {
									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-warning">';
									str += '<span class="glyphicon glyphicon-pencil"></span></a>';
									return str;
								}
							} ],
					initComplete : function() {
						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'You want to activate the product?'
													: 'You want to deactivate the product?';
											var value = checkbox.prop('value');
											bootbox
													.confirm({
														size : 'medium',
														title : 'Product Activation & Deactivation',
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {
																console
																		.log(value);
																var activationUrl = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				activationUrl,
																				function(
																						data) {
																					bootbox
																							.alert({
																								size : 'medium',
																								title : 'Information',
																								message : data
																							});
																				});

															} else {
																checkbox
																	.prop(
																				'checked',
																				!checked);
															}
														}
													});
										});
					}
				});
	}
	// Jquery validation for Category Form..
	var $categoryForm=$('#categoryForm');
	if($categoryForm.length){
		$categoryForm.validate({
			
	rules : {
		
		name : {
			
			required: true,
			minlength: 2
			
		},
		
		description: {
			required: true
		}
		
	},
	
	messages : {
		
		name : {
			
			required: 'Please add the category name!',
			minlength: 'The category name should not be less than 2 characters'
			
		},
		
		description: {
			
			required: 'Please add a description for this category!'
		}
		
		
	},
	errorElement: 'em',
	errorPlacement: function(error, element) {
		// add the class of help-block
		error.addClass('ErrorElement');
		// add the error element after the input element
		error.insertAfter(element);				
	}
});


}

})