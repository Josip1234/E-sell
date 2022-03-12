let x = document.cookie;
 var y = document.getElementById("article_number");
 alert(y);
y.value=x;
alert(y);
document.cookie = "article_number=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
