var app=angular.module('articleBasic',[]);

app.config(function($sceDelegateProvider) {
              $sceDelegateProvider.resourceUrlWhitelist([
                'http://localhost/e-sell/php/article_basic_prices.php',
                'http://localhost/e-sell/php/article_names_numbers.php'
              ]);
            });
app.controller('articleBasicDetails', function($scope,$http){
	
	$scope.data=$http.get("http://localhost/e-sell/php/article_names_numbers.php").then(function(response){
        $scope.article = response.data.article;
        //need to see how to access data outside this scope
          $scope.ar=$scope.article[3].article_number;
      
    });
	$scope.emails=$http.get("http://localhost/e-sell/php/article_basic_prices.php").then(function(response){
        $scope.emailData = response.data.Article;
    });
	var article_numbers=document.getElementsByClassName("article_number");

	
/*for (var i = 0; i < article_numbers.length; i++) {
    var article=article_numbers[i].innerHTML;
    	//alert(article);
    	alert($scope.myData.some(code => code.article_number));
    if($scope.myData.some(code => code.article_number === article)==true){
	alert(article);
}
}*/
});