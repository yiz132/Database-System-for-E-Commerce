var id = GetRequest();
var stringA = JSON.stringify(id);
var obj = JSON.parse(stringA);
ProductOnload();

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

function  ProductOnload() {
    var Url="http://localhost:8080/dbproject/aggregation/showallproducts/salesperson";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            id: obj.value,
        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var product = JSON.parse(str);
            //alert(product[0].id);
            for( var i = 0; i<product.length; i++){
                var picture = product[i].picture;
                var name = product[i].name;
                var price = product[i].price;
                var inventory = product[i].inventory;
                var pid = product[i].id;
                document.getElementById('ListTable').innerHTML =document.getElementById('ListTable').innerHTML + " <tr id="+pid+">\n" +
                    "        <td style=\"width: 90px;background-image: url("+picture+"); background-size: cover\"></td>\n" +
                    "        <td>"+name+"</td>\n" +
                    "        <td>$"+price+"</td>\n" +
                    "        <td>"+inventory+"</td>\n" +
                    "    </tr>";
            }


        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}



function SearchProduct() {
    var keyWord = document.getElementById('SearchInput').value;
    if (keyWord  == ''){
        ProductOnload();
    }
    var Url="";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            id: obj.value,
            keyword: keyWord
        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var product = JSON.parse(str);
            for( var i = 0; i<product.length; i++){
                var picture = product[i].picture;
                var name = product[i].name;
                var price = product[i].price;
                var inventory = product[i].inventory;
                var pid = product[i].id;
                document.getElementById('ListTable').innerHTML =document.getElementById('ListTable').innerHTML + " <tr id="+pid+">\n" +
                    "        <td style=\"width: 90px;background-image: url("+picture+"); background-size: cover\"></td>\n" +
                    "        <td>"+name+"</td>\n" +
                    "        <td>$"+price+"</td>\n" +
                    "        <td>"+inventory+"</td>\n" +
                    "    </tr>";
            }


        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}

function SearchPress() {

    if(event.keyCode==13)
    {
        SearchProduct();
    }

}
function LogOut() {

    window.location.href = "SignIn.html";
}
function SortChange(){
    //alert(document.getElementById('Sort').value);
    var sort = document.getElementById('Sort').value;
    var Url="";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            id : obj.value,
            keyword: sort,
        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var product = JSON.parse(str);
            //alert(product[0].id);
            for( var i = 0; i<product.length; i++){
                var picture = product[i].picture;
                var name = product[i].name;
                var price = product[i].price;
                var inventory = product[i].inventory;
                var pid = product[i].id;
                document.getElementById('ListTable').innerHTML =document.getElementById('ListTable').innerHTML + " <tr id="+pid+">\n" +
                    "        <td style=\"width: 90px;background-image: url("+picture+"); background-size: cover\"></td>\n" +
                    "        <td>"+name+"</td>\n" +
                    "        <td>$"+price+"</td>\n" +
                    "        <td>"+inventory+"</td>\n" +
                    "    </tr>";
            }


        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}
$(document).ready(function(){
$('#ListTable').on('click','tr', function() {
    //alert(this.id);
    EnterUpdate(this.id);
    });
});

function EnterUpdate(pid){
    window.location.href = "Update.html?value=" + obj.value + "&pid=" + pid;
}

function AddNewProduct(){
    window.location.href = "Update.html?value=" + obj.value + "&pid=" + 0;
}
