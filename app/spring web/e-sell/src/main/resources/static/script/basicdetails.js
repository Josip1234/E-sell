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
	
	document.getElementById("show_error2").style.display='none';
	$scope.types_id2=document.getElementById("types_id2").value;
	
	document.getElementById("show_error3").style.display='none';
	$scope.types_id3=document.getElementById("types_id3").value;
	
	document.getElementById("show_error4").style.display='none';
 
    $scope.$watch('types_id', function(){$scope.validate();})
    $scope.$watch('types_id2', function(){$scope.validate();})
	$scope.$watch('types_id3', function(){$scope.validate();})
	
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
	  var selected_subtype=document.getElementById("types_id2").value;
	  var second_subtype=document.getElementById("types_id3").value;

	  if(parseInt(selected)===0){
     document.getElementById("show_error").style.display = '';
		$scope.error=true;
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);
	}else{
		     document.getElementById("show_error").style.display = 'none';
			$scope.error=false;
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);
	}
	
	
	  if(parseInt(selected_subtype)===0){
     document.getElementById("show_error2").style.display = '';
		$scope.error=true;
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);
	}else{
		     document.getElementById("show_error2").style.display = 'none';
			$scope.error=false;
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);
	}
	
   
   if(parseInt(second_subtype)===0){
     document.getElementById("show_error3").style.display = '';
		$scope.error=true;
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);
	}else{
		     document.getElementById("show_error3").style.display = 'none';
	$scope.error=false;
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);
	}
	
	
 if(checkForAlreadySelectedTypesOrSubtypes(selected,selected_subtype,second_subtype)==true){
		document.getElementById("show_error4").style.display='';
		$scope.incomplete=true;
	
}else{
	document.getElementById("show_error4").style.display='none';
	$scope.incomplete=false;

}
}
	
});
//check for incompleted selected values
function checkForIncomplete(type,subtype,subtype2){
	var incomplete=false;
	if(parseInt(type)===0){
		incomplete=true;
		return incomplete;
	}else 	if(parseInt(subtype)===0){
		incomplete=true;
		return incomplete;
	}else if(parseInt(subtype2)===0){
	incomplete=true;
	return incomplete;
	}else{
		return incomplete;
	}
}
//check if selected values are true this will be validated after all fields are selected
function checkForAlreadySelectedTypesOrSubtypes(type,subtype,subtype2){
	var sameValues=false;
	if(parseInt(subtype)===parseInt(type)){
		sameValues=true;
		return sameValues;
	}else if(parseInt(subtype)===parseInt(subtype2)){
			sameValues=true;
		return sameValues;
	}
	else if(parseInt(subtype2)===parseInt(type)){
		sameValues=true;
		return sameValues;
	}else if(parseInt(subtype2)===parseInt(subtype)){
		sameValues=true;
		return sameValues;
	}else if(parseInt(type)===parseInt(subtype)){
		sameValues=true;
		return sameValues;
	}else if(parseInt(type)===parseInt(subtype2)){
		sameValues=true;
		return sameValues;
	}else{
		sameValues=false;
		return sameValues;
	}
}