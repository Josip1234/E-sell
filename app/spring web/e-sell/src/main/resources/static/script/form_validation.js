var app=angular.module('formValidation',[]);

app.config(function($sceDelegateProvider) {
              $sceDelegateProvider.resourceUrlWhitelist([
                'http://localhost/e-sell/php/nicknames_from_sellers.php',
                'http://localhost:8080/e-sell/en/registration',
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
	$scope.fname=document.getElementById("fname").value;
	$scope.lname=document.getElementById("lname").value;
	$scope.dateofbirth=document.getElementById("dateofbirth").value;
	$scope.location=document.getElementById("location").value;
	$scope.nickname=document.getElementById("nickname").value;
	$scope.contact=document.getElementById("contact").value;
	$scope.email=document.getElementById("email").value;
	$scope.hash_password=document.getElementById("hash_password").value;
	$scope.error=false;
	$scope.incomplete=true;
	$scope.$watch('fname', function(){$scope.validate();})
	$scope.$watch('lname', function(){$scope.validate();})
	$scope.$watch('dateofbirth', function(){$scope.validate();})
	$scope.$watch('location', function(){$scope.validate();})
	$scope.$watch('nickname', function(){$scope.validate();})
	$scope.$watch('contact', function(){$scope.validate();})
	$scope.$watch('email', function(){$scope.validate();})
	$scope.$watch('hash_password', function(){$scope.validate();})
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
	  $scope.passwordLength=function(){
		return $scope.hash_password.length;
	};
	
	$scope.validate=function(){
		//check if there is dupolicate nickname in database
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
		  
		
		
	   	if($scope.fname.length==0 || $scope.lname.length==0 || $scope.dateofbirth.length==0 || $scope.location.length==0 || $scope.nickname.length==0 || $scope.contact.length==0 || $scope.email.length==0 || $scope.hash_password.length==0){
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