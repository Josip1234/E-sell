window.onload = function(){
let x = document.cookie;
 var y = document.getElementById("an").value=x.match(/(?<=article_number=).*/);;
y.value=x;
document.cookie = "article_number=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}