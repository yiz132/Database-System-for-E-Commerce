function SearchBusiness() {

    var keyWord = document.getElementById('SearchInput').value;
    if (keyWord  == ''){
        OnloadProductInformation();
    }
    var Url="";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            keyword: keyWord,
            id: obj.value,
            pid: obj.pid
        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var information = JSON.parse(str);
            var product = information.product;
            var customer = information.customer;
            var transaction = information.Transaction;
            var price =information.price;
            var sales =information.sales;
            var total = parseInt(price) * parseInt(sales);

            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + "<tr>\n" +
                "        <td>"+product+"</td>\n" +
                "        <td>"+customer+"</td>\n" +
                "        <td>"+transaction+"</td>\n" +
                "        <td>"+total+"</td>\n" +
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
        SearchBusiness();
    }

}

var id = GetRequest();
var stringA = JSON.stringify(id);
var obj = JSON.parse(stringA);
OnloadProductInformation();

function OnloadProductInformation(){
    $.ajax({
        type: "post",
        url: "",
        data:{
            id: obj.value,
            pid: obj.pid},
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var information = JSON.parse(str);
            var product = information.product;
            var customer = information.customer;
            var transaction = information.Transaction;
            var price =information.price;
            var sales =information.sales;
            var total = parseInt(price) * parseInt(sales);

            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + "<tr>\n" +
                "        <td>"+product+"</td>\n" +
                "        <td>"+customer+"</td>\n" +
                "        <td>"+transaction+"</td>\n" +
                "        <td>"+total+"</td>\n" +
                "    </tr>";
        },
        error: function (request, status, error) {
        }
    });
}

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




function SortChange(){
    //alert(document.getElementById('Sort').value);
    var sort = document.getElementById('Sort').value;

    var Url="";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            id : obj.value,
            pid: obj.pid,
            sort: sort,

        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var information = JSON.parse(str);
            var product = information.product;
            var customer = information.customer;
            var transaction = information.Transaction;
            var price =information.price;
            var sales =information.sales;
            var total = parseInt(price) * parseInt(sales);

            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + "<tr>\n" +
                "        <td>"+product+"</td>\n" +
                "        <td>"+customer+"</td>\n" +
                "        <td>"+transaction+"</td>\n" +
                "        <td>"+total+"</td>\n" +
                "    </tr>";

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}
