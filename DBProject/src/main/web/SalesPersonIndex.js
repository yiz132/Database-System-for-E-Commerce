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
    var Url="";
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
            var picture = product.picture;
            var name = product.name;
            var price = product.price;
            var stock = product.stock;
            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + " <tr>\n" +
                "        <td style=\"width: 90px;background-image: url("+picture+"); background-size: cover\"></td>\n" +
                "        <td>"+name+"</td>\n" +
                "        <td>"+price+"</td>\n" +
                "        <td>"+stock+"</td>\n" +
                "    </tr>";

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
            var picture = product.picture;
            var name = product.name;
            var price = product.price;
            var stock = product.stock;
            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + " <tr>\n" +
                "        <td style=\"width: 90px;background-image: url("+picture+"); background-size: cover\"></td>\n" +
                "        <td>"+name+"</td>\n" +
                "        <td>"+price+"</td>\n" +
                "        <td>"+stock+"</td>\n" +
                "    </tr>";

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

function SortChange(){
    //alert(document.getElementById('Sort').value);
    var sort = document.getElementById('Sort').value;
    var Url="";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            id : obj.value,
            sort: sort,

        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var product = JSON.parse(str);
            var picture = product.picture;
            var name = product.name;
            var price = product.price;
            var stock = product.stock;
            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + " <tr>\n" +
                "        <td style=\"width: 90px;background-image: url("+picture+"); background-size: cover\"></td>\n" +
                "        <td>"+name+"</td>\n" +
                "        <td>"+price+"</td>\n" +
                "        <td>"+stock+"</td>\n" +
                "    </tr>";

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}
$(document).ready(function(){
$('#ListTable').on('click','tr', function() {
    EnterUpdate();
    });
});

function EnterUpdate(){
    window.location.href = "Update.html?value=" + id + "&pid" + pid;
}

function AddNewProduct(){
    window.location.href = "Update.html" + id + "&pid" + 0;
}
