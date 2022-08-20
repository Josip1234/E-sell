window.onload = function(){
		document.getElementById("show_error").style.display = 'none';
		document.getElementById("show_error2").style.display='none';
		document.getElementById("show_error3").style.display='none';
		document.getElementById("show_error4").style.display='none';
	document.getElementById("showPriceError").style.display='none';
	document.getElementById("types_id3").disabled = true;
	document.getElementById("types_id2").disabled = true;
let x = document.cookie;
 var y = document.getElementById("an").value=x.match(/(?<=article_number=).*/);
y.value=x;
document.cookie = "article_number=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}
var app=angular.module('detailsFormValidation',[]);

app.controller('validateDetailsForm', function($scope){


	$scope.types_id=document.getElementById("types_id").value;
	
	
	$scope.types_id2=document.getElementById("types_id2").value;
	
	
	$scope.types_id3=document.getElementById("types_id3").value;
	
	
	
	$scope.price=document.getElementById("price").value;
	
		
	$scope.article_condition=document.getElementById("article_condition").value;
	
	
 
    $scope.$watch('types_id', function(){$scope.validate();})
    $scope.$watch('types_id2', function(){$scope.validate();})
	$scope.$watch('types_id3', function(){$scope.validate();})
	$scope.$watch('price',function(){$scope.validate()});
    
    	
	$scope.priceLn=function(){
		return $scope.price.length;
	};
	$scope.arconLn=function(){
		return $scope.article_condition.length;
	};

	
	window.onchange=function(){
		$scope.price=document.getElementById("price").value;
		if($scope.price.length===0){
			$scope.error=true;
				document.getElementById("showPriceError").style.display='';
				document.getElementById("subbut").disabled=true;
		}else{
			$scope.error=false;
			document.getElementById("subbut").disabled=false;
			document.getElementById("showPriceError").style.display='none';
		}
	}
	
	$scope.validate=function(){
				
	$scope.article_condition=document.getElementById("article_condition").value;
	$scope.price=document.getElementById("price").value;

	  
		$scope.error=true;
	  var selected=document.getElementById("types_id").value;
	  var selected_subtype=document.getElementById("types_id2").value;
	  var second_subtype=document.getElementById("types_id3").value;
	  

	  	
	  if(parseInt(selected)===0){
		document.getElementById("types_id2").disabled = true;
     document.getElementById("show_error").style.display = '';
		$scope.error=true;
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);
	}else{
			document.getElementById("types_id2").disabled = false;
		     document.getElementById("show_error").style.display = 'none';
			$scope.error=false;
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);

	}
	
	
	  if(parseInt(selected_subtype)===0){
		document.getElementById("types_id3").disabled = true;
     document.getElementById("show_error2").style.display = '';
		$scope.error=true;
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);
	}else{
		document.getElementById("types_id3").disabled = false;
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
		$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);
	
}else{
	document.getElementById("show_error4").style.display='none';
	$scope.incomplete=checkForIncomplete(selected,selected_subtype,second_subtype);

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