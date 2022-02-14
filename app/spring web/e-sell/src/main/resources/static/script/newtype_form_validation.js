var app=angular.module('type_validation',[]);

app.config(function($sceDelegateProvider) {
              $sceDelegateProvider.resourceUrlWhitelist([
                'http://localhost/e-sell/php/article_types.php',
                'http://localhost:8080/e-sell/en/articles/newtype'
              ]);
 });
 
 app.controller('validateType', function($scope,$http){
	//we need to sttringfy this or use custom php script
	$http.get("http://localhost/e-sell/php/article_types.php").then(function(response){
        $scope.res = response.data.types;
    });
	$scope.type=document.getElementById("type").value;
	$scope.error=false;
	$scope.incomplete=true;
	$scope.typeLength=function(){
		return $scope.type.length;
	};
    $scope.$watch('type', function(){$scope.validate();})
	$scope.validate=function(){
	  	if($scope.res.some(type => type.value === $scope.type)==true){
		  $scope.error=true;
		  $scope.alreradyExists=true;	
		} 
	};
	
	
});