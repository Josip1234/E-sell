var app=angular.module('pictureConnection',[]);

app.config(function($sceDelegateProvider) {
              $sceDelegateProvider.resourceUrlWhitelist([
                'http://localhost/e-sell/php/storage_system_select_picture_list_product.php',
                'http://localhost:8080/e-sell/en/products'
              ]);
            });
app.controller('connectPicture', function($scope,$http){
	$scope.data=$http.get("http://localhost/e-sell/php/storage_system_select_picture_list_product.php").then(function(response){
        $scope.data = response.data;
    });
  $scope.article_number=document.getElementsByClassName("article_number");
  alert($scope.article_number);
	alert($scope.data);
});