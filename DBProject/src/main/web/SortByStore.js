function SearchBusiness() {
    var keyWord = document.getElementById('SearchInput').value;
    if (keyWord  == ''){
        onloadStore();
    }
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
            var manager = JSON.parse(str);
            var store = manager.store;
            var sales = manager.sales;
            var profit = manager.profit;
            var category = manager.category;
            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + "\n" +
                "    <tr>\n" +
                "        <td>"+store+"</td>\n" +
                "        <td>"+sales+"</td>\n" +
                "        <td>"+profit+"</td>\n" +
                "        <td>"+category+"</td>\n" +
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
onloadStore();

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

function onloadStore() {
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
            var manager = JSON.parse(str);
            var store = manager.store;
            var sales = manager.sales;
            var profit = manager.profit;
            var category = manager.category;
            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + "\n" +
                "    <tr>\n" +
                "        <td>"+store+"</td>\n" +
                "        <td>"+sales+"</td>\n" +
                "        <td>"+profit+"</td>\n" +
                "        <td>"+category+"</td>\n" +
                "    </tr>";

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}

//AUTO HIGH TO LOW
function SortChange(){
    //alert(document.getElementById('Sort').value);
    var sort = document.getElementById('Sort').value;
    // if(sort == 'Stores'){
    //     window.location.href =  "RegionManagerIndex.html?value=" + name;
    // }
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
            var manager = JSON.parse(str);
            var store = manager.store;
            var sales = manager.sales;
            var profit = manager.profit;
            var category = manager.category;
            document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + "\n" +
                "    <tr>\n" +
                "        <td>"+store+"</td>\n" +
                "        <td>"+sales+"</td>\n" +
                "        <td>"+profit+"</td>\n" +
                "        <td>"+category+"</td>\n" +
                "    </tr>";

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}
