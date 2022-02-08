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
        $scope.article_numbers=document.getElementsByClassName("article_number");
        
		
          for (var i = 0; i < $scope.article.length; i++) {
	         var value1=$scope.article[i].article_number;
	         
	         for (var j = 0; j < $scope.article_numbers.length; j++) {
		          
		          var value2=$scope.article_numbers[j].innerHTML;
		          var valueToWrite=$scope.article[i].article_name;
	         if(value1===value2){
		var index=j;
		alert(value2);
		alert(index);
		document.getElementById(value2).innerHTML=valueToWrite;
		
		}
	         
	         
	}
		   
		   
		};
	
      
      
    });
	$scope.emails=$http.get("http://localhost/e-sell/php/article_basic_prices.php").then(function(response){
        $scope.emailData = response.data.Article;
    });
	
	$scope.print=function(){
		alert($scope.ar);
	}

	
/*for (var i = 0; i < article_numbers.length; i++) {
    var article=article_numbers[i].innerHTML;
    	//alert(article);
    	alert($scope.myData.some(code => code.article_number));
    if($scope.myData.some(code => code.article_number === article)==true){
	alert(article);
}
}*/
});