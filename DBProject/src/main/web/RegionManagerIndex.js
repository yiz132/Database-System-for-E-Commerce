function SearchBusiness() {
    var keyWord = document.getElementById('SearchInput').value;
    var sort = document.getElementById('Sort').value;
    document.getElementById('ListTable').innerHTML ="<tr style=\"height: 10px;\">\n" +
        "        <th style=\"height: 10px; border: 1px  lightpink; border-style: none none solid none;\">Region</th>\n" +
        "        <th style=\"height: 10px;  border: 1px  lightpink; border-style: none none solid none;\">Sales</th>\n" +
        "        <th style=\"height: 10px;  border: 1px  lightpink; border-style: none none solid none;\">Profit</th>\n" +
        "    </tr>";
    var Url="http://localhost:8080/dbproject/regionmanager/searchAndSort/regions";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            search_keyword: keyWord,
            sort_keyword: sort,
        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var manager = JSON.parse(str);
            for( var i = 0; i<manager.length; i++) {
                var regions = manager[i].name;
                var sales = manager[i].total_sales;
                var profit = manager[i].total_profits;
                document.getElementById('ListTable').innerHTML = document.getElementById('ListTable').innerHTML + "\n" +
                    "    <tr>\n" +
                    "        <td>" + regions + "</td>\n" +
                    "        <td>" + sales + "</td>\n" +
                    "        <td>" + profit + "</td>\n" +
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
        SearchBusiness();
    }

}

var id = GetRequest();
var stringA = JSON.stringify(id);
var obj = JSON.parse(stringA);
onloadManager();

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
function onloadManager() {
    var Url="http://localhost:8080/dbproject/regionmanager/showtrans/allregions";
    $.ajax({
        type: "get",
        url: Url,
        data: {
        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var manager = JSON.parse(str);
            for( var i = 0; i<manager.length; i++) {
                var regions = manager[i].name;
                var sales = manager[i].total_sales;
                var profit = manager[i].total_profits;
                document.getElementById('ListTable').innerHTML = document.getElementById('ListTable').innerHTML + "\n" +
                    "    <tr>\n" +
                    "        <td>" + regions + "</td>\n" +
                    "        <td>" + sales + "</td>\n" +
                    "        <td>" + profit + "</td>\n" +
                    "    </tr>";
            }

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}


//AUTO HIGH TO LOW
// function SortChange(){
//     //alert(document.getElementById('Sort').value);
//     var sort = document.getElementById('Sort').value;
//     if(sort == 'Stores'){
//         window.location.href =  "SortByStore.html?value=" + obj.value;
//     }
//     var Url="";
//     $.ajax({
//         type: "post",
//         url: Url,
//         data: {
//             sort: sort,
//             id: obj.value
//
//         },
//         dataType: "json",
//         success: function(msg) {
//             var data=eval(msg);
//             var str = JSON.stringify(data);
//             var manager = JSON.parse(str);
//             var regions = manager.regions;
//             var sales = manager.sales;
//             var profit = manager.profit;
//             document.getElementById('ListTable').innerText =document.getElementById('ListTable').innerText + "\n" +
//                 "    <tr>\n" +
//                 "        <td>"+regions+"</td>\n" +
//                 "        <td>"+sales+"</td>\n" +
//                 "        <td>"+profit+"</td>\n" +
//                 "    </tr>";
//
//         },
//         error: function (request, status, error) {
//             //alert(request.responseText);
//
//         }
//     });
// }
