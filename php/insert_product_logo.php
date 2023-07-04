<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insert new picture at location</title>
</head>
<body>
<form action="insert_product_logo.php" method="post" enctype="multipart/form-data">
    <?php 
      echo selectLogos();
    ?>
  Select image to upload:
  <input type="file" name="url" id="url">
  <input type="submit" value="Upload Image" name="submit">
</form>
</body>
</html>
<?php
function insertIntoLogoTable($article_number,$url){
    $location="http://localhost/e-sell/app/spring%20web/e-sell/logos/";
	include("sql_connect.php");
	$sql = "INSERT INTO `logo` (`article_number`, `url`) VALUES (NULL, '', '')";
	$result=mysqli_query($dbc,$sql);
	return $result;
}

//if there are no logos in logo table use storage system
function selectLogosFromDatabase(){
	include("sql_connect.php");
	$sql = "SELECT * FROM logo";
	$result=mysqli_query($dbc,$sql);
    if(mysqli_affected_rows($dbc)===0){
        echo "No data";
    }
	return $result;
}
//select logos return select choice
function selectLogos(){
	$result=selectLogosFromDatabase();
	$array=array();
  
	while($row=mysqli_fetch_array($result)){
		echo $row["article_number"];
        echo $row["url"];
    }
	return $data;
	
}


?>