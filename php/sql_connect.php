<?php
header("Access-Control-Allow-Origin: *");
$user="root";
$host="localhost";
$password="";
$database="esell";
$charset="utf8";
$dbc=mysqli_connect($host,$user,$password,$database);
mysqli_set_charset($dbc,$charset);
ini_set("display_errors",0);
if(!$dbc){
	die("Cannot connect to the database.");
}

?>