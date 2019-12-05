var jumpId = GetRequest();
var stringId = JSON.stringify(jumpId);
var obj = JSON.parse(stringId);
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
                var pid = product[i].id;
                document.getElementById('AllProductDiv').innerHTML =document.getElementById('AllProductDiv').innerHTML+ "<div  name=\"ProductDiv\" class=\"ProductDiv\" onclick=\"EnterDetail("+pid+")\" >\n" +
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
    var sort = document.getElementById('Sort').value;
    var category = document.getElementById('SortCategory').value;
    document.getElementById('AllProductDiv').innerHTML="";

        $.ajax({
            type: "post",
            url: "http://localhost:8080/dbproject/aggregation/sortallproducts",
            data: {
                search_keyword: keyWord,
                sort_keyword: sort,
                category:category
            },
            dataType: "json",
            success: function(msg){
                var data=eval(msg);
                var str = JSON.stringify(data);
                var product = JSON.parse(str);

                for( var i = 0; i<product.length; i++) {
                    var picture = product[i].picture;
                    var name = product[i].name;
                    var price = product[i].price;
                    var pid = product[i].id;

                    document.getElementById('AllProductDiv').innerHTML =document.getElementById('AllProductDiv').innerHTML+ "<div  name=\"ProductDiv\" class=\"ProductDiv\" onclick=\"EnterDetail("+pid+")\" >\n" +
                        "    <div class=\"ProductPhotoDiv\" style=\"background-image: url(" + picture + ")\"></div>\n" +
                        "    <div class=\"ProductNameDiv\">" + name + "</div>\n" +
                        "    <div class=\"ProductPriceDiv\">$" + price + "</div>\n" +
                        "</div>";
                }
            },
            error: function (request, status, error) {

            }
        });

}
function HistoryOrder() {
    window.location.href = "OrderReview.html?value=" + obj.value;
}
function LogOut() {

    window.location.href = "SignIn.html";
}

function SearchPress() {

    if(event.keyCode==13)
    {
        SearchProduct();
    }

}
//
// function SortChange(){
//     //alert(document.getElementById('Sort').value);
//     var sort = document.getElementById('Sort').value;
//     var category = document.getElementById('SortCategory').value;
//     document.getElementById('AllProductDiv').innerHTML="";
//     var Url="http://localhost:8080/dbproject/aggregation/sortallproducts";
//     $.ajax({
//         type: "post",
//         url: Url,
//         data: {
//             sort: sort,
//             category: category
//         },
//         dataType: "json",
//         success: function(msg) {
//             var data=eval(msg);
//             var str = JSON.stringify(data);
//             var product = JSON.parse(str);
//             for( var i = 0; i<product.length; i++) {
//                 var picture = product[i].picture;
//                 var name = product[i].name;
//                 var price = product[i].price;
//                 var pid = product[i].id;
//                 document.getElementById('AllProductDiv').innerHTML =document.getElementById('AllProductDiv').innerHTML+ "<div  name=\"ProductDiv\" class=\"ProductDiv\" onclick=\"EnterDetail("+pid+")\" >\n" +
//                     "    <div class=\"ProductPhotoDiv\" style=\"background-image: url(" + picture + ")\"></div>\n" +
//                     "    <div class=\"ProductNameDiv\">" + name + "</div>\n" +
//                     "    <div class=\"ProductPriceDiv\">$" + price + "</div>\n" +
//                     "</div>";
//             }
//
//         },
//         error: function (request, status, error) {
//         }
//     });
// }

function EnterDetail(pid){
     window.location.href = "ProductDetail.html?value=" + obj.value + "&pid=" + pid;
}

