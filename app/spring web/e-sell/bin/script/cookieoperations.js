function deleteCookies(){
    document.cookie = "article_number=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/e-sell/en;";
    document.cookie = "article_number=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/e-sell/en/articles;";
    document.cookie = "article_name=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/e-sell/en;";
  }
  function storeValues(){
    var gallery_name=document.getElementById("name").value;

document.cookie = "article_name="+gallery_name;
   
 return true;

}
function add_article_num_cookie(){
  var cook=document.getElementById("ar_num").value;

  document.cookie = "article_num="+cook;
     
   return true;
  
 }
 function delete_article_num_cookie(){
  document.cookie = "article_num=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/e-sell/en/deletion/deleteAdvert;";
 }


 function more_information(id,host){
  
  document.cookie = "article_number="+id;
  
  if(host==="undefined"){
    host='/e-sell/en/articles/productDetail';
  }
  location.href = host;
}
