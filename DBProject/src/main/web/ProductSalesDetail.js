function SearchBusiness() {

}

function SearchPress() {

    if(event.keyCode==13)
    {
        SearchBusiness();
    }

}

var date = GetRequest();
var stringDate = JSON.stringify(date);
var obj = JSON.parse(stringDate);
// alert(obj.value);
// alert(obj.pid);

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
            // var data=eval(msg);
            // //alert(data);
            // var str = JSON.stringify(data);
            // //alert(str);
            // var obj = JSON.parse(str);
            // alert(obj.name);

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}
