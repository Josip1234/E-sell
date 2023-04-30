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

function selectArticleTypes(){
	include("sql_connect.php");
	$sql="SELECT type FROM article_types";
	$result=mysqli_query($dbc,$sql);
	return $result;
}

function selectImagesFromStorage(){
	include("sql_connect.php");
	$sql="SELECT nickname,article_number,type, relative_link FROM storage_system";
	$result=mysqli_query($dbc,$sql);
	return $result;
}

function getStorageResults(){
	$result=selectImagesFromStorage();
	$array=array();
	while($row=mysqli_fetch_array($result)){
		array_push($array, array("nickname"=>$row["nickname"],"article_number"=>$row["article_number"], "type"=>$row["type"],"relative_link"=>$row["relative_link"] ));
	}
	$toJson=json_encode($array,JSON_UNESCAPED_UNICODE);
	$data.=openBracket1().getQuotation()."storage_system".getQuotation().getColon().$toJson.closeBracket1();
	return $data;
}

function retrieveValuesOfArticlesAndNumbers(){
	$result=selectArticleNamesAndNumbers();
	$array=array();
	while($row=mysqli_fetch_array($result)){
		array_push($array, array("article_number"=>$row["article_number"],"article_name"=>$row["article_name"]));
	}
	$toJson=json_encode($array,JSON_UNESCAPED_UNICODE);
	$data.=openBracket1().getQuotation()."article".getQuotation().getColon().$toJson.closeBracket1();
	return $data;
	
}

function selectArticleNumbersWithPrices(){
	include("sql_connect.php");
	$sql = "SELECT ar_num,price FROM article_basic_details;";
	$result=mysqli_query($dbc,$sql);
	return $result;
}

function retrievePricesFromArticleDetails(){
	$result=selectArticleNumbersWithPrices();
	$array=array();
	while($row=mysqli_fetch_array($result)){
		array_push($array, array("article_number"=>$row["ar_num"],"price"=>$row["price"]));
	}
	$toJson=json_encode($array,JSON_UNESCAPED_UNICODE);
	$data.=openBracket1().getQuotation()."article".getQuotation().getColon().$toJson.closeBracket1();
	return $data;
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

function retrieveTypesFromArticleTypes(){
	$result=selectUniqueFromTables("article_types","type");
	$array=array();
	while($row=mysqli_fetch_array($result)){
		array_push($array,array("value"=>$row["type"]));
	}
	$convertToJson=json_encode($array,JSON_UNESCAPED_UNICODE);
	$data.=openBracket1().getQuotation()."types".getQuotation().getColon().$convertToJson.closeBracket1();
	return $data;
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
function selectArticleNamesAndNumbers(){
	include("sql_connect.php");
	$sql = "SELECT article_number,article_name FROM articles";
	$result=mysqli_query($dbc,$sql);
	return $result;
}

function selectProductPicturesOfList(){
	include("sql_connect.php");
	$sql = "SELECT `nickname`, `article_number`, `user_folder`, `article_folder`, `file_name`, `file_extension`, `local_path`, `url`, `type`, `relative_link` FROM `storage_system` WHERE `type`='Product_list_picture';
	";
	$result=mysqli_query($dbc,$sql);
	return $result;
}

function selectListProductPictures(){
	$result=selectProductPicturesOfList();
	$array=array();
	while($row=mysqli_fetch_array($result)){
		array_push($array, array("nickname"=>$row["nickname"],"article_number"=>$row["article_number"],"user_folder"=>$row["user_folder"],"article_folder"=>$row["article_folder"],"file_name"=>$row["file_name"],
	    "file_extension"=>$row["file_extension"], "local_path"=>$row["local_path"],"url"=>$row["url"],"type"=>$row["type"],"relative_link"=>$row["relative_link"]
	));
	}
	$toJson=json_encode($array,JSON_UNESCAPED_UNICODE);
	$data.=openBracket1().getQuotation()."storage_system".getQuotation().getColon().$toJson.closeBracket1();
	return $data;
	
}


?>