<?php 

function openBracket1(){
	return "{";
}
function openBracket2(){
	return "[";
}
function getComma(){
	return ",";
}
function closeBracket1(){
	return "}";
}
function closeBracket2(){
	return "]";
}
function getColon(){
	return ":";
}
function getQuotation(){
	return "\"";
}

function addValueToKey($valueKey,$field){
	return getQuotation().$valueKey.getQuotation().getColon().getQuotation().$field.getQuotation();
}

function makeFirstPart($value){
	return openBracket1().getQuotation().$value.getQuotation().getColon().openBracket2();
}
function printString($value){
	echo $value;
}

?>