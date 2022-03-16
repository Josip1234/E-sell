window.onload = function(){
let x = document.cookie;
 var y = document.getElementById("an").value=x.match(/(?<=article_number=).*/);;
y.value=x;
document.cookie = "article_number=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}
var app=angular.module('detailsFormValidation',[]);

app.controller('validateDetailsForm', function($scope){

	document.getElementById("show_error").style.display = 'none';
	$scope.types_id=document.getElementById("types_id").value;
 
    $scope.$watch('types_id', function(){$scope.validate();})
		
	
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
	
	  $scope.emailLength=function(){
		return $scope.email.length;
	};
	
	$scope.validate=function(){
		$scope.error=true;
	$scope.incomplete=true;
	  var selected=document.getElementById("types_id").value;

	  if(parseInt(selected)===0){
     document.getElementById("show_error").style.display = '';
		$scope.error=true;
	$scope.incomplete=true;
	}else{
		     document.getElementById("show_error").style.display = 'none';
			$scope.error=false;
	$scope.incomplete=false;
	}
    
}
	
});