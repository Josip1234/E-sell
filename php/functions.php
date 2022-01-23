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
function returnNumberOfrecords($table){
	include("sql_connect.php");	
	$countSql="SELECT COUNT(*) AS total FROM $table";
	$cnt=mysqli_query($dbc,$countSql);
	$resOfCount=mysqli_fetch_assoc($cnt);
	$totalValues=$resOfCount['total'];
	return $totalValues;
	}

	function selectUniqueFromTables($tables,$uniqueValue){
		include("sql_connect.php");
		$sql1= "SELECT $uniqueValue FROM $tables";
		$result=mysqli_query($dbc,$sql1);
		return $result;
	}

	function createJsonFromUniques($result,$totalValues,$tableColumn){
		$concatString=makeFirstPart($tableColumn);
		$count=0;
		$valueKey="value";
	while($row=mysqli_fetch_array($result)){
		$count=$count+1;
		if($count==$totalValues){
				$concatString.=openBracket1();
			 $concatString.=addValueToKey($valueKey,$row[$tableColumn]);
			$concatString.=closeBracket1();
			$concatString.=closeBracket2();
		}else{
		$concatString.=openBracket1();
		   $concatString.=addValueToKey($valueKey,$row[$tableColumn]);
			$concatString.=closeBracket1();
			$concatString.=getComma();
		}
		
	}
	$concatString.=closeBracket1();
		return $concatString;
	}


?>