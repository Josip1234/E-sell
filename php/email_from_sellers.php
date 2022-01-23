<?php 
include("functions.php");

$result=selectUniqueFromTables("sellers","email");
$totalValues=returnNumberOfrecords("sellers");
$json=createJsonFromUniques($result,$totalValues,"email");
printString($json);
	

?>