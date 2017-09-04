angular.module("magazineAPI",["ngRoute"]);
angular.module("magazineAPI").controller("createCtrl", function($scope, $http){
	$scope.createArticle  = function(){
		$http({
				method:"POST",
				url: "/Gumball/Article/create",
				data:$scope.newArticle
		}).then(function(response){
			console.log(response.status);
		})
	}
})
angular.module("magazineAPI").controller("myArticlesCtrl",
		function($scope, $http){
			$http({
				method: "GET",
				url : "/Gumball/Article/myArticles"
			
			}).then(function(response){
				$scope.articles = response.data;
			});
	})


		
angular.module("magazineAPI").config(function($routeProvider, $locationProvider){
	$locationProvider.hashPrefix("");
	
	$routeProvider.when("/create", {
		templateUrl : "NewArticle.html",
		controller : "createCtrl"
	}).when("/myArticles", {
		templateUrl : "dashthree.html",
		controller : "myArticlesCtrl"
	});
})