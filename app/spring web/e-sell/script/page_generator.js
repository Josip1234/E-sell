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

function generate_list(list_type, number_of_items, data){
	let list="";
	if(list_type="ordered"){
		list+=ol;
	}else{
		list+=ul;
	}
	
	  for (let index = 0; index < number_of_items; index++) {
		  list+=li;
		  list+=data;
		  list+=li2;
	  }
	
	if(list_type="ordered"){
		list+=ol2;
	}else{
		list+=ul2;
	}
	document.getElementById("test3").innerHTML=list;
	return list;
}

function generateParagraph(number,data){
	let para="";
	para+=generateKeyOrValue(number,"key",data);
	para+=generateKeyOrValue(number, "value",data);	
	document.getElementById("test2").innerHTML=para;
	return para;
}

function generateKeyOrValue(number,data){
	let keyval="";
		   for (let index = 0; index < number; index++) {
			   
            keyval+=strong+data+":"+strong2;
			     keyval+=data;
			   
       }
	
	
	
	return keyval;
}


function generate_table(number_of_rows, number_of_headers, data){
let generate_table_header="";
let generate_table_body="";
let gentable="";
generate_table_header=generateHeaderOrBody("header",number_of_headers,data);
generate_table_body=generateHeaderOrBody("body",number_of_rows,data);
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
alert(gentable);
document.getElementById("test").innerHTML=gentable;
return table;
}

function generateHeaderOrBody(header_or_body, number, data){
    let table_element="";
    if(header_or_body=="header"){
       for (let index = 0; index < number; index++) {
            table_element+=header+data+header2;
       }
    }else if(header_or_body=="body"){
        for (let index = 0; index < number; index++) {
            table_element+=td;
            table_element+=data;
            table_element+=td2;
        }
    }else{
        header_or_body="";
    }
    return table_element;
}


var app=angular.module('descriptions',[]);
app.controller('descriptionDisplay', function($scope){
	$scope.description1 = "Brand: Steve Madden, US Shoe Size: 10, Style: Fashion, Color: Brown, Upper Material: Synthetic, Department: Women, Type: Boots, Heel Style: Stiletto Heel, Height: Med (1 3/4 in. to 2 3/4 in.), Occasion: Boots, Model: Jessamy, Calf Width: Normal, Shoe Width: Medium (B, M),MPN: JG-4767732, UPC: 195945597675";

	$scope.sizeOfDesc=function(){
		return $scope.description1.length;
	};

	$scope.separate_data=function(){
		const sepdat = $scope.description1.split(",");
		return sepdat;
	}
    
	var array=new Array($scope.description1);
	$scope.display_mode="";
});
