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
            table_element+=row;
            table_element+=td;
            table_element+=data;
            table_element+=td2;
            table_element+=row2;
            
        }
    }else{
        header_or_body="";
    }
    return table_element;
}