var app=angular.module('pictureConnection',[]);

app.config(function($sceDelegateProvider) {
              $sceDelegateProvider.resourceUrlWhitelist([
                'http://localhost/e-sell/php/storage_system_select_picture_list_product.php',
                'http://localhost:8080/e-sell/en/products'
              ]);
            });
app.controller('connectPicture', function($scope,$http){
	$scope.data=$http.get("http://localhost/e-sell/php/storage_system_select_picture_list_product.php").then(function(response){
        $scope.data = response.data.storage_system;
        alert($scope.data[0].nickname);
        var res=document.getElementsByClassName("article_seller")[0].textContent;
        alert(res);
        checkForNickname("Jobo",$scope.data);
    });
  
    //var res=document.getElementsByClassName("article_seller").textContent;
    //alert(res);
   /* const allArticleNumbersByClass = document.getElementsByClassName("article_number");
    let result = document.getElementsByClassName('article_number');
    for (let i = 0; i < allArticleNumbersByClass.length; i++) {
      result += `\n  ${allArticleNumbersByClass[i].textContent}`;
    }*/
   /* const article_number=document.getElementsByClassName("article_number")[0].textContent;
    alert(article_number);*/

    /*const allArticleSellerByClass = document.getElementsByClassName("article_seller");
    let result2 = document.getElementsByClassName('article_seller');
    for (let i = 0; i < allArticleSellerByClass.length; i++) {
      result += allArticleSellerByClass[i].textContent;
    }
    const article_sell=document.getElementsByClassName("article_seller");
    alert(article_sell.textContent);
*/

});

function checkForNickname(nickname,list){
  for (let i = 0; i < list.length; i++) {
    if(nickname===list[i].nickname){
      alert("Nickname is the same.");
      alert(list[i].nickname);
      break;
    }else{
      alert("Nickname is different.")
      alert(list[i].nickname);
    }
  }
}

