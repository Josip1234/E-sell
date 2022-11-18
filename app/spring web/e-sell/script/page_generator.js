let table="<table>";
let thead="<thead>";
let row="<tr>";
let header="<th>";
let header2="</th>";
let row2="</tr>";
let thead2="</thead>";
let tbody="<tbody>";
let td="<td>";
let td2="</td>";
let tbody2="</tbody>";
let table2="</table>";

let ol="<ol>";
let li="<li>";
let li2="</li>";
let ol2="</ol>";

let ul="<ul>";
let ul2="</ul>";

let p="<p>";
let strong="<strong>";
let strong2="</strong>";
let p2="</p>";
let newline="<br>";


function generate_list(list_type, data){
	let size_data=returnArraySize(data);
	separate_array(data);
	let list="";
	if(list_type==="ordered"){
		list+=ol;
	}else{
		list+=ul;
	}
	
	  for (let index = 0; index < size_data; index++) {
		  list+=li;
		  list+=strong+key_array[index]+":"+strong2+value_array[index];
		  list+=li2;
	  }
	
	if(list_type==="ordered"){
		list+=ol2;
	}else{
		list+=ul2;
	}
	document.getElementById("look_on_site").innerHTML="<h1>Technical specifications:</h1>"+list;
	return list;
}

let key_array=[];
let value_array=[];

//separate key value by :
//add only even numbers to the key arrays

function separate_array(some_array){

	let separate_string="";
	
	for (let index = 0; index < some_array.length; index++) {
		const element = some_array[index];
		separate_string=element.split(":");
			key_array.push(separate_string[0]);
		

			value_array.push(separate_string[1]);
		
			
	}

}
//return size of a array
function returnArraySize(array){
	return array.length;
}
//empty the arrays after finished
function generateParagraph(number,data){
	separate_array(data);
	let sizeOfKeys=returnArraySize(key_array);
	let para="";
	para+=generateKeyOrValue(sizeOfKeys,key_array,value_array);	
	document.getElementById("look_on_site").innerHTML="<h1>Technical specifications:</h1>"+para;
	key_array=[];
	value_array=[];
	return para;
}

function generateKeyOrValue(number,data1,data2){
	let keyval="";
		   for (let index = 0; index < number; index++) {
			   
            keyval+=strong+data1[index]+":"+strong2;
			     keyval+=data2[index];
				 keyval+=newline;
			   
       }
	
	
	
	
	return keyval;
}


function generate_table(data){
let generate_table_header="";
let generate_table_body="";
let gentable="";
separate_array(data);
generate_table_header=generateHeaderOrBody("header",return_number_of_values_in_array(key_array),key_array);
generate_table_body=generateHeaderOrBody("body",return_number_of_values_in_array(value_array),value_array);
gentable+=table;
gentable+=thead;
gentable+=row;
gentable+=generate_table_header;
gentable+=row2;
gentable+=thead2;
gentable+=tbody;
gentable+=generate_table_body;
gentable+=tbody2;
gentable+=table2;
document.getElementById("look_on_site").innerHTML="<h1>Technical specifications:</h1>"+gentable;
return table;
}

function return_number_of_values_in_array(array){
	let count=0;
	for (let index = 0; index < array.length; index++) {
		count+=1;
	}
	return count;
}

function generateHeaderOrBody(header_or_body, number, data){
    let table_element="";
    if(header_or_body=="header"){
       for (let index = 0; index < number; index++) {
            table_element+=header+data[index]+header2;
       }
    }else if(header_or_body=="body"){
        for (let index = 0; index < number; index++) {
            table_element+=td;
            table_element+=data[index];
            table_element+=td2;
        }
    }else{
        header_or_body="";
    }
    return table_element;
}


var app=angular.module('descriptions',[]);
app.controller('descriptionDisplay', function($scope){
	$scope.description1 = "Brand: Steve Madden, US Shoe Size: 10, Style: Fashion, Color: Brown, Upper Material: Synthetic, Department: Women, Type: Boots, Heel Style: Stiletto Heel, Height: Med (1 3/4 in. to 2 3/4 in.), Occasion: Boots, Model: Jessamy, Calf Width: Normal, Shoe Width: Medium (B M) MPN- JG-4767732, UPC: 195945597675";
	$scope.display_mode="";

	$scope.sizeOfDesc=function(){
		return $scope.description1.length;
	};

	$scope.separate_data=function(){
		//separate by , first to get separate data from string divided by ,
		let sepdat = $scope.description1.split(",");
		if($scope.display_mode==="paragraph"){
			let sizeOfData=sepdat.length;
			generateParagraph(sizeOfData,sepdat);
			key_array=[];
			value_array=[];
		}else if($scope.display_mode==="ordered"){
              generate_list("ordered",sepdat);
		}else if($scope.display_mode==="unordered"){
			generate_list("unordered",sepdat);
		}else if($scope.display_mode==="table"){
			 generate_table(sepdat);
			 key_array=[];
			value_array=[];
		}
		return sepdat;
	}
    

	

	
});
