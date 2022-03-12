var app = angular.module("newArticlevalidation",[]);
app.config(function($sceDelegateProvider) {
              $sceDelegateProvider.resourceUrlWhitelist([
                'http://localhost/e-sell/php/article_names_numbers.php'
              ]);
            });
app.controller("validateNewArticle", function($scope,$http){
		$scope.myData=$http.get("http://localhost/e-sell/php/article_names_numbers.php").then(function(response){
			      $scope.data = response.data.article;
        })
	$scope.article_number=document.getElementById("article_number").value;
	$scope.article_name=document.getElementById("article_name").value;
	$scope.error=false;
	$scope.incomplete=true;
    $scope.$watch('article_number', function(){$scope.validate();})
    $scope.$watch('article_name', function(){$scope.validate();})
	
	$scope.articleNumberLength=function(){
		return $scope.article_number.length;
	};
	
	$scope.articleNameLength=function(){
		return $scope.article_name.length;
	}
	
	
		$scope.validate=function(){
			$scope.article_number=document.getElementById("article_number").value;
			document.getElementById("sendArNum").value=	$scope.article_number;
	$scope.article_name=document.getElementById("article_name").value;
	  	if($scope.data.some(an => an.article_number === $scope.article_number)==true){
		  $scope.error=true;
		  $scope.alreradyExists=true;	
		  $scope.showError=true;
		  $scope.incomplete=true;
		}else{
			$scope.error=false;
			$scope.alreradyExists=false;
		    $scope.showError=false;
		    $scope.incomplete=true;
		}
		
		
		
		
	   	if($scope.article_number.length==0 || $scope.article_name.length==0){
		  $scope.error=true;
	
		  $scope.incomplete=true;
	   }else{
		$scope.incomplete=false;
  	if($scope.Data.some(an => an.article_number === $scope.article_number)==true){
		  $scope.error=true;
		  $scope.alreradyExists=true;	
		  $scope.incomplete=true;
		}else{
			$scope.error=false;
			$scope.alreradyExists=false;
			$scope.incomplete=false;
		}
		  
		
	}
	};
	
});
