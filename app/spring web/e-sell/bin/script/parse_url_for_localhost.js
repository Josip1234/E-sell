function parse(){
    var collections = document.getElementsByClassName("img");
    for(var index=0;index<collections.length;index++){
        var url=collections[index].src;
        var alt=collections[index].alt;
        var newUrl=url.replace("http://localhost:8080/e-sell/en/","http://localhost/e-sell/app/spring%20web/e-sell/");
        var newAlt=alt.replace(".jpg","");
        collections[index].src=newUrl;
        collections[index].alt=newAlt;
    }
}