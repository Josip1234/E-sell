var app=angular.module('formValidation',[]);

app.config(function($sceDelegateProvider) {
              $sceDelegateProvider.resourceUrlWhitelist([
                'http://localhost/e-sell/php/nicknames_from_sellers.php',
                'http://localhost:8080/e-sell/en/seller/profile',
				'http://localhost/e-sell/php/email_from_sellers.php'
              ]);
            });
app.controller('validateForm', function($scope,$http){
	$scope.data=$http.get("http://localhost/e-sell/php/nicknames_from_sellers.php").then(function(response){
        $scope.myData = response.data.nickname;
    });
	$scope.emails=$http.get("http://localhost/e-sell/php/email_from_sellers.php").then(function(response){
        $scope.emailData = response.data.email;
    });
    //used to get previous entered values in form
	$scope.fname=document.getElementById("fname").value;
	$scope.lname=document.getElementById("lname").value;

	$scope.location=document.getElementById("location").value;
	$scope.nickname=document.getElementById("nickname").value;

	
	$scope.contact=document.getElementById("contact").value;
	$scope.email=document.getElementById("email").value;

	$scope.error=false;
	$scope.incomplete=true;
	$scope.$watch('fname', function(){$scope.validate();})
	$scope.$watch('lname', function(){$scope.validate();})
	$scope.$watch('location', function(){$scope.validate();})
	$scope.$watch('nickname', function(){$scope.validate();})
	$scope.$watch('contact', function(){$scope.validate();})
	$scope.$watch('email', function(){$scope.validate();})
	
	$scope.fnameLength=function(){
		return $scope.fname.length;
	};
	$scope.lnameLength=function(){
		return $scope.lname.length;
	};
    $scope.locationLength=function(){
		return $scope.location.length;
	};
	  $scope.nicknameLength=function(){
		return $scope.nickname.length;
	};
	  $scope.contactLength=function(){
		return $scope.contact.length;
	};
	
	  $scope.emailLength=function(){
		return $scope.email.length;
	};
	
	$scope.validate=function(){
			$scope.fname=document.getElementById("fname").value;
	$scope.lname=document.getElementById("lname").value;
	$scope.location=document.getElementById("location").value;
	$scope.nickname=document.getElementById("nickname").value;
	$scope.contact=document.getElementById("contact").value;
	$scope.email=document.getElementById("email").value;
		//this is working because it is a string from php 
		//check if there is dupolicate nickname in database
			if($scope.myData.some(code => code.value === $scope.nickname)==true){
		  $scope.error=true;
		  $scope.alreradyExists=true;	
		}else{
			$scope.error=false;
			$scope.alreradyExists=false;
		}
		//value is in json
		if($scope.emailData.some(em => em.value === $scope.email)==true){
			$scope.error=true;
			$scope.alreradyExistsEmail=true;	
		  }else{
			  $scope.error=false;
			  $scope.alreradyExistsEmail=false;
		  }
		  
		
		
	   	if($scope.fname.length==0 || $scope.lname.length==0 || $scope.location.length==0 || $scope.nickname.length==0 || $scope.contact.length==0 || $scope.email.length==0){
		$scope.error=true;
		$scope.showError=true;
		$scope.incomplete=true;
	   }else{
		//just in case first part do not work
		if($scope.myData.some(code => code.value === $scope.nickname)==true){
		  $scope.error=true;
		  $scope.alreradyExists=true;	
		}else{
			$scope.error=false;
			$scope.alreradyExists=false;
		}
			if($scope.emailData.some(em => em.value === $scope.email)==true){
			$scope.error=true;
			$scope.alreradyExistsEmail=true;	
		  }else{
			  $scope.error=false;
			  $scope.alreradyExistsEmail=false;
		  }
		  $scope.incomplete=false;
		
	}
	};
	
});