$( document ).ready(function() {
	
	// GET REQUEST
	$("#getAllUserId").click(function(event){
		event.preventDefault();
		ajaxGet();
	});
	
	// DO GET
	function ajaxGet(){
		$.ajax({
			type : "GET",
			url : window.location + "api/mongo/user/user",
			success: function(result){
				if(result.status == "Done"){
					$('#getResultDiv ul').empty();
					var userList = "";
					$.each(result.data, function(i, user){
						var user = "- User with Id = " + i + ", name = " + user.name + ", surname = " + user.surname + "<br>";
						$('#getResultDiv .list-group').append(user)
			        });
					console.log("Success: ", result);
				}else{
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
})