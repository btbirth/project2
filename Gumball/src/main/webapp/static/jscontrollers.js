



var login = function(username,password){
	console.log(username);
	var user = {
		"username":username,
		"password":password
	};
	console.log("here");
	console.log(user.username);
	$http({
		method : "POST",
		url : "/Reader/login",
		data: user
	})
}