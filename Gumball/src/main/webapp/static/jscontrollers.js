angular.module("magazineAPI",["ngRoute"]);
angular.module("magazineAPI").controller("allArticleCtrl",
		function($scope, $http){
			$scope.newFavorite = {};
			$scope.addFavorite = function(articleId){
				console.log(articleId)
				$scope.newFavorite.id = articleId;
				$http({
					method : "POST",
					url : "/Article/addFavorite",
					data : $scope.newFavorite
				})
			};
			$scope.checkFavs = function(articleId,favs){
				
				count = 0;
				for(count = 0; count<favs.length; count++){
					
					if(articleId == favs[count].id){
						return false;
					}
				}
				return true;
			}
			$scope.newComment = {};
			$scope.makeComment = function(articleId){
				$scope.newComment.article = articleId;
				console.log($scope.newComment);
				$http({
					method : "POST",
					url : "/Gumball/Comment/create",
					data: $scope.newComment
				})
			};
	
			
			$http({
				method : "GET",
				url : "/Article/all"
			}).then(function(response){
				$scope.articles = response.data;
				
			});
			
			$http({
				method : "GET",
				url :"/Article/favorites"	 		
			}).then(function(response){
				$scope.favorites = response.data;			
			});
			
			
			


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