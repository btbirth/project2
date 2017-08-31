angular.module("magazineAPI",["ngRoute"]);
angular.module("magazineAPI").controller("allArticleCtrl",
		function($scope, $http){
			$http({
				method : "GET",
				url : "Article/all"
			}).then(function(response){
				$scope.articles = response.data;
				
			});
		})
		
angular.module("magazineAPI").config(function($routeProvider, $locationProvider){
	$locationProvider.hashPrefix("");
	$routeProvider.when("Gumball/Article/all", {
		templateUrl : "pages/dashone.html",
		controller : "allArticleCtrl",

	}).when("Article/all", {
		templateUrl : "viewArticle.html",
		controller : "articleCtrl"
	}).otherwise({
		templateUrl : "pages/dashone.html",
		controller : "allArticleCtrl",
	});
})