var jumpId = GetRequest();
var stringId = JSON.stringify(jumpId);
var id = JSON.parse(stringId);
ScanAllProduct();
//alert(id.value);

function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        var strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}

var pid = 0;
function ScanAllProduct(){
    $.ajax({
        type: "post",
        url: "http://localhost:8080/dbproject/aggregation/showallproducts",
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var product = JSON.parse(str);
            for( var i = 0; i<product.length; i++) {
                var picture = product[i].picture;
                var name = product[i].name;
                var price = product[i].price;
                var id = product[i].id;
                document.getElementById('AllProductDiv').innerHTML =document.getElementById('AllProductDiv').innerHTML+ "<div id=\"ProductDiv\" class=\"ProductDiv\" onclick=\"EnterDetail()\">\n" +
                    "    <div class=\"ProductPhotoDiv\" style=\"background-image: url(" + picture + ")\"></div>\n" +
                    "    <div class=\"ProductNameDiv\">" + name + "</div>\n" +
                    "    <div class=\"ProductPriceDiv\">$" + price + "</div>\n" +
                    "</div>";
            }
        },
        error: function (request, status, error) {
            //alert(request.responseText);
            alert(1);
        }
    });
}


function SearchProduct() {
    var keyWord = document.getElementById('SearchInput').value;
    if (keyWord  == ''){
        ScanAllProduct();
    }
    else {
        $.ajax({
            type: "post",
            url: "",
            data: {
                keyword: keyWord
            },
            dataType: "json",
            success: function(msg){
                var data=eval(msg);
                var str = JSON.stringify(data);
                var obj = JSON.parse(str);
                var picture = obj.picture;
                var name = obj.name;
                var price = obj.price;
                var pid = obj.id;
                document.getElementById('AllProductDiv').innerHTML=document.getElementById('AllProductDiv').innerHTML+"<div id="+pid+" class=\"ProductDiv\" onclick=\"EnterDetail()\">\n" +
                    "    <div class=\"ProductPhotoDiv\" style=\"background-image: url("+picture+")\"></div>\n" +
                    "    <div class=\"ProductNameDiv\">"+name+"</div>\n" +
                    "    <div class=\"ProductPriceDiv\">$"+price+"</div>\n" +
                    "</div>";
            },
            error: function (request, status, error) {
                //alert("Sign up failed");

            }
        });
    }
}

function SearchPress() {

    if(event.keyCode==13)
    {
        SearchProduct();
    }

}


function SortChange(){
    //alert(document.getElementById('Sort').value);
    var sort = document.getElementById('Sort').value;
    var Url="";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            sort: sort,

        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var obj = JSON.parse(str);
            var picture = obj.picture;
            var name = obj.name;
            var price = obj.price;
            var pid = obj.id;
            document.getElementById('AllProductDiv').innerHTML="<div id="+pid+" class=\"ProductDiv\" onclick=\"EnterDetail()\">\n" +
                "    <div class=\"ProductPhotoDiv\" style=\"background-image: url("+picture+")\"></div>\n" +
                "    <div class=\"ProductNameDiv\">"+name+"</div>\n" +
                "    <div class=\"ProductPriceDiv\">$"+price+"</div>\n" +
                "</div>";

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}

function EnterDetail(){
     window.location.href = "ProductDetail.html?value=" + id + "&pid" + pid;
}

