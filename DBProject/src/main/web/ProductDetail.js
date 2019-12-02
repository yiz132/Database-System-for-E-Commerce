function CheckOut(){
    var number = $('#Transact_Number').val();
    var date = new Date();
    //Transact
    var Url="";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            c_id: c_id,
            p_id: p_id,
            number: number,
            date: date.toLocaleDateString(),
        },
        dataType: "json",
        success: function(msg){
            alert(msg);
            //alert(request.responseText);
        },
        error: function (request, status, error) {
            //alert(request.responseText);
            //alert(1);

        }
    });
}
var name = GetRequest();
var stringA = JSON.stringify(name);
//alert(stringA);

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

$(document).ready(function(){
    $('#Transact_Number').bind('input propertychange', function() {
        var Transact_Number = $(this).val();
        //alert($('#StockNumber').text());
        if (Transact_Number > parseInt($('#StockNumber').text())) {
            $("#Transact_Number").css("color","red");
            $("#CheckOut").attr("disabled", true);
        } else {
            $("#Transact_Number").css("color","black");
            $("#CheckOut").attr("disabled", false);
        }
    })
})
