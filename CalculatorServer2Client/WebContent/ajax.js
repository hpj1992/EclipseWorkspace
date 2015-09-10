$(document).ready(function() {
	$('#userName').blur(function(event) {
		var name = $('#userName').val();
		$.get('AjaxServlet', {
			userName : name
		}, function(responseText) {
			$('#ajaxResponse').text(responseText);
		});
	});
	
	$('#dv').click(function(event) {
		var a = $('#a').val();
		var b = $('#b').val();
		//var val = $("input[type=submit][clicked=true]").val();
		var action=event.target.id;
		//alert(action);
		//var action=$('#action').val();
		$.get('CalculatorServlet', {
			a:a,
			b:b,
			action:action
		}, function(responseText) {
			$('#result').text(responseText);
		});
	});
});
