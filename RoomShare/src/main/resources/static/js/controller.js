$(document).ready(function() {
	var Control_URI = 'http://localhost:8080/';
	$('#userFormId').submit(
		function(event) {
			var username = $('#inputEmail3').val();
			var password = $('#inputPassword3').val();				
			var data = 'username='
					+ encodeURIComponent(username)
					+ '&password='
					+ encodeURIComponent(password);
			    $.ajax({
				url : $("#userFormId").attr("action"),
				data : data,
				type : "POST",

				success : function(response) {
					
				},
				error : function(xhr, status, error) {
					
				}
			});
			return false;
		});
	});
 