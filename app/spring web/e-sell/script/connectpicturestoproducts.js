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
        //alert($scope.data[0].nickname);
        //var res=document.getElementsByClassName("article_seller")[0].textContent;
        //alert(res);
        //checkForNickname("Jobo",$scope.data);
        checkForUnique("nickname","Jobo",$scope.data);
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


function checkForUnique(whatToCheck,value,list){
  lowercase=whatToCheck.toLowerCase();
  alert("What to check in json array: "+ lowercase);
  for (let j = 0; j < list.length; j++) {
    if(lowercase==="nickname"){
      if(value===list[j].nickname){
        alert(whatToCheck+" is the same.");
        alert(list[j].nickname);
        break;
      }else{
        alert(whatToCheck+" is different.")
        alert(list[j].nickname);
      }
    }
   
  }
}




//NApomena za svaki article number korisnik bi trebao upisati samo jedanput Product_list_picture za pojedini proizvod. Za logo ista stvar smao što će korisnik trebati izabrati možda i sti logo ali će se samo id promijeniti. 
//Možda bi bilo bolje za brandove napraviti posebnu tablicu.