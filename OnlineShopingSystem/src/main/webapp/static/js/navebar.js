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
	default:
		$('#product').addClass('active');
		$('#a_'+menu).addClass('active');

	}
})