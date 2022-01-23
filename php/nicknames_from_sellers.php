<?php
include("functions.php");


$result=selectUniqueFromTables("sellers","nickname");
$totalValues=returnNumberOfrecords("sellers");
$json=createJsonFromUniques($result,$totalValues,"nickname");
printString($json);
	

?>