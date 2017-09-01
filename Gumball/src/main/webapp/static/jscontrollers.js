angular.module("magazineAPI",["ngRoute"]);
angular.module("magazineAPI").controller("allArticleCtrl",
		function($scope, $http,$location){
			
			$http({
				method : "GET",
				url : "/Gumball/Article/all"
			}).then(function(response){
				$scope.articles = response.data;
				
			});
			$scope.makeComment = function(){
				console.log($scope.newComment);
				$http({
					method : "POST",
					url : "/Gumball/Comment/create",
					data: $scope.newComment
				})
			}
		})
angular.module("magazineAPI").controller("favoritesCtrl",
		function($scope, $http ){
			
			$http({
				method : "GET",
				url : "/Gumball/Article/favorites"
			}).then(function(response){
				$scope.articles = response.data;
				console.log(response.data)
			});

		})
		
angular.module("magazineAPI").config(function($routeProvider, $locationProvider){
	$locationProvider.hashPrefix("");
	
	$routeProvider.when("Article/all", {
		templateUrl : "viewArticle.html",
		controller : "articleCtrl"
	}).when("/favorites", {
		templateUrl : "dashtwo.html",
		controller : "favoritesCtrl"
	}).otherwise({
		templateUrl : "dashone.html",
		controller : "allArticleCtrl",
	});
})