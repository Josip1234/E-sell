function deleteCookies(){
    document.cookie = "article_number=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/e-sell/en;";
    document.cookie = "article_name=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/e-sell/en;";
  }
  function storeValues(){
    var gallery_name=document.getElementById("name").value;

document.cookie = "article_name="+gallery_name;
   
 return true;

}