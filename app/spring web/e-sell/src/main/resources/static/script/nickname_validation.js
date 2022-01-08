var app=angular.module('nicknameValidation',[]);

app.config(function($sceDelegateProvider) {
              $sceDelegateProvider.resourceUrlWhitelist([
                'http://localhost/e-sell/php/nicknames_from_sellers.php',
                'http://localhost:8080/e-sell/en/registration'
              ]);
            });
app.controller('validateCtrl', function($scope,$http){
	  $http.get("http://localhost/e-sell/php/nicknames_from_sellers.php").then(function(response){
        $scope.myData = response.data.nickname;
    });
});