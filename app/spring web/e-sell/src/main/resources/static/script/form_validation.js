var app=angular.module('formValidation',[]);

app.config(function($sceDelegateProvider) {
              $sceDelegateProvider.resourceUrlWhitelist([
                'http://localhost/e-sell/php/nicknames_from_sellers.php',
                'http://localhost:8080/e-sell/en/registration'
              ]);
            });
app.controller('validateForm', function($scope,$http){
	$scope.data=$http.get("http://localhost/e-sell/php/nicknames_from_sellers.php").then(function(response){
        $scope.myData = response.data.nickname;
    });
	$scope.fname=document.getElementById("fname").value;
	$scope.lname=document.getElementById("lname").value;
	$scope.dateofbirth=document.getElementById("dateofbirth").value;
	$scope.location=document.getElementById("location").value;
	$scope.nickname=document.getElementById("nickname").value;
	$scope.contact=document.getElementById("contact").value;
	$scope.email=document.getElementById("email").value;
	$scope.hash_password=document.getElementById("hash_password").value;
	$scope.error=false;
	$scope.$watch('fname', function(){$scope.validate();})
	$scope.$watch('lname', function(){$scope.validate();})
	$scope.$watch('dateofbirth', function(){$scope.validate();})
	$scope.$watch('location', function(){$scope.validate();})
	$scope.$watch('nickname', function(){$scope.validate();})
	$scope.$watch('contact', function(){$scope.validate();})
	$scope.$watch('email', function(){$scope.validate();})
	$scope.$watch('hash_password', function(){$scope.validate();})
    
	$scope.validate=function(){
		
			if($scope.myData.some(code => code.value === $scope.nickname)==true){
		  $scope.error=true;
		  $scope.alreradyExists=true;	
		}else{
			$scope.error=false;
			$scope.alreradyExists=false;
		}
		
		
		
	   	if($scope.fname.length==0 || $scope.lname.length==0 || $scope.dateofbirth.length==0 || $scope.location.length==0 || $scope.nickname.length==0 || $scope.contact.length==0 || $scope.email.length==0 || $scope.hash_password.length==0){
		$scope.error=true;
		$scope.showError=true;
	   }else{
		//just in case first part do not work
		if($scope.myData.some(code => code.value === $scope.nickname)==true){
		  $scope.error=true;
		  $scope.alreradyExists=true;	
		}else{
			$scope.error=false;
			$scope.alreradyExists=false;
		}
		
	}
	};
	
});