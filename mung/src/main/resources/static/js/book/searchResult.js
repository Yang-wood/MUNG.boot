$(document).ready(function() {
	$("#serchForm").submit(function(e) {
		e.prevenDefault();
		const formData = $(this).serialize();
		
		$.ajax({
			url: "/api/book/search",
			processData : false,
			contentType : false,
			data : formData,
			type : "get",
			dataType : "json",
			success : function(rs) {
				console.log(rs);
				
				showResult(rs);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});
	});
});