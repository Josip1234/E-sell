<?php
include("functions.php");


function selectNicknamesFromSellers(){
	include("sql_connect.php");
	$sql1= "SELECT `nickname` FROM `sellers`;";
    $result=mysqli_query($dbc,$sql1);
	return $result;
}

function returnNumberOfrecordsFromSellers(){
include("sql_connect.php");	
$countSql="SELECT COUNT(*) AS total FROM `sellers`;";
$cnt=mysqli_query($dbc,$countSql);
$resOfCount=mysqli_fetch_assoc($cnt);
$totalValues=$resOfCount['total'];
return $totalValues;
}


function createJsonFromNicknames($result,$totalValues){
	$concatString=makeFirstPart("nickname");
	$count=0;
	$valueKey="value";
while($row=mysqli_fetch_array($result)){
	$count=$count+1;
	if($count==$totalValues){
			$concatString.=openBracket1();
	     $concatString.=addValueToKey($valueKey,$row['nickname']);
		$concatString.=closeBracket1();
		$concatString.=closeBracket2();
	}else{
	$concatString.=openBracket1();
	   $concatString.=addValueToKey($valueKey,$row['nickname']);
		$concatString.=closeBracket1();
		$concatString.=getComma();
	}
	
}
$concatString.=closeBracket1();
	return $concatString;
}

$result=selectNicknamesFromSellers();
$totalValues=returnNumberOfrecordsFromSellers();
$json=createJsonFromNicknames($result,$totalValues);
printString($json);
	




?>