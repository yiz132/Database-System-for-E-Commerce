function CheckOut(){
    var number = $('#Transact_Number').val();
    var date = new Date();
    //Transact
    var Url="";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            c_id: obj.value,
            p_id: obj.pid,
            number: number,
            //date: date.toLocaleDateString(),
        },
        dataType: "json",
        success: function(msg){
            window.location.href = "OrderReview.html?value=" + obj.id;
        },
        error: function (request, status, error) {
            //alert(request.responseText);
            //alert(1);

        }
    });
}

var date = GetRequest();
var stringDate = JSON.stringify(date);
var obj = JSON.parse(stringDate);
// alert(obj.value);
// alert(obj.pid);
ProductDetail();
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

function ProductDetail(){
    $.ajax({
        type: "post",
        url: "",
        data: {
            id: obj.value,
            pid: obj.pid,

        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var product = JSON.parse(str);
            var picture = product.picture;
            var name = product.name;
            var price = product.price;
            var description = product.description;
            var inventory = product.inventory;
            document.getElementById('ProductPhoto').style.backgroundImage = 'url('+ picture +')';
            document.getElementById('ProductName').innerText = name;
            document.getElementById('ProductPrice').innerText = price;
            document.getElementById('ProductDescription').innerText = description;
            document.getElementById('StockNumber').innerText = inventory;

        },
        error: function (request, status, error) {
            //alert(request.responseText);
            alert(1);
        }
    });
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
