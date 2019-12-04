var id = GetRequest();
var stringA = JSON.stringify(id);
var obj = JSON.parse(stringA);
OrderOnload();
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
function LogOut() {

    window.location.href = "SignIn.html";
}
function OrderOnload() {
    var Url="http://localhost:8080/dbproject/aggregation/findtransbycid";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            customer_id: obj.value
        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var order = JSON.parse(str);

            for( var i = 0; i<order.length; i++){
                var picture = order[i].picture;
                var name = order[i].name;
                var total = order[i].total;
                var date = order[i].date;
                document.getElementById('ListTable').innerHTML =document.getElementById('ListTable').innerHTML + " <tr>\n" +
                    "        <td style=\"width: 90px;background-image: url("+picture+"); background-size: cover\"></td>\n" +
                    "        <td>"+name+"</td>\n" +
                    "        <td>$"+total+"</td>\n" +
                    "        <td>"+date+"</td>\n" +
                    "    </tr>";
            }
        },
        error: function (request, status, error) {
          //  alert(request.responseText);

        }
    });
}

function SearchOrder() {
    var keyWord = document.getElementById('SearchInput').value;
    document.getElementById('ListTable').innerText="";
    if (keyWord  == ''){
        OrderOnload();
    }
    else {
        $.ajax({
            type: "post",
            url: "",
            data: {
                keyword: keyWord,
                name: obj.value,
            },
            dataType: "json",
            success: function(msg){
                var data=eval(msg);
                var str = JSON.stringify(data);
                var order = JSON.parse(str);
                var picture = order.picture;
                var name = order.name;
                var total = parseInt(order.price)  *parseInt(order.number) ;
                var date = order.date;
                document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + "\n" +
                    "    <tr>\n" +
                    "        <td style=\"width: 90px;background-image: url("+picture+"); background-size: cover\"></td>\n" +
                    "        <td>"+name<+"/td>\n" +
                    "        <td>"+total+"</td>\n" +
                    "        <td>"+date+"</td>\n" +
                    "    </tr>";
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
        SearchOrder();
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
            name: obj.value,
            sort: sort,

        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var order = JSON.parse(str);
            var picture = order.picture;
            var name = order.name;
            var total = parseInt(order.price)  *parseInt(order.number) ;
            var date = order.date;
            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + "\n" +
                "    <tr>\n" +
                "        <td style=\"width: 90px;background-image: url("+picture+"); background-size: cover\"></td>\n" +
                "        <td>"+name<+"/td>\n" +
                "        <td>"+total+"</td>\n" +
                "        <td>"+date+"</td>\n" +
                "    </tr>";

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}
