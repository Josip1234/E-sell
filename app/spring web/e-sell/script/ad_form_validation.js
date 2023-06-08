var app=angular.module('formValidation',[]);

app.controller('validateForm', function($scope,$http){


	$scope.time_until_expire=document.getElementById("time_until_expire").value;
	$scope.ad_shown=document.getElementById("ad_shown").value;



	$scope.error=false;
	$scope.incomplete=true;
	$scope.$watch('time_until_expire', function(){$scope.validate();})
	$scope.$watch('ad_shown', function(){$scope.validate();})


	$scope.time_until_expireLength=function(){
		return $scope.time_until_expire.length;
	};
    $scope.ad_shownLength=function(){
		return $scope.ad_shown.length;
	};
	

	$scope.validate=function(){
	$scope.time_until_expire=document.getElementById("time_until_expire").value;
	$scope.ad_shown=document.getElementById("ad_shown").value;

		  
		
		
	   	if($scope.time_until_expire.length==0 || $scope.ad_shown.length==0){
		$scope.error=true;
		$scope.showError=true;
		$scope.incomplete=true;
	   }
	};
	
});