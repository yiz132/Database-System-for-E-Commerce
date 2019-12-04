
var date = GetRequest();
var stringDate = JSON.stringify(date);
var obj = JSON.parse(stringDate);
// alert(obj.value);
// alert(obj.pid);
ProductDetail();
balanceOnload();
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

function balanceOnload() {
    $.ajax({
        type: "post",
        url: "http://localhost:8080/dbproject/aggregation/showbalance",
        data: {
            customer_id: obj.value,
        },
        dataType: "text",
        success: function(msg){
                document.getElementById('Balance').innerText=document.getElementById('Balance').innerText+msg;
        },
        error: function (request, status, error) {
        }
    });
}
function AddBalance() {
    var add_balance = document.getElementById('balanceInput').value;
    $.ajax({
        type: "post",
        url: "http://localhost:8080/dbproject/aggregation/addbalance",
        data: {
            add_balance: add_balance,
            customer_id: obj.value
        },
        dataType: "text",
        success: function(msg){
            document.getElementById('Balance').innerText="Your Balance $"+msg;
        },
        error: function (request, status, error) {
        }
    });
}
function CancelCheckOut() {
    window.location.href =  "Scan.html?value=" + obj.value;
}

function LogOut() {

    window.location.href = "SignIn.html";
}

function CheckOut(){
    var number = parseInt($('#Transact_Number').val());
    var date = new Date();
    var Url="http://localhost:8080/dbproject/aggregation/checkout";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            customer_id: obj.value,
            product_id: obj.pid,
            counts: number,
        },
        dataType: "text",
        success: function(msg){
            if(msg == 'Account balance not enough'){
                alert(msg);
            }

            else{
                window.location.href = "OrderReview.html?value=" + obj.value;
            }

        },
        error: function (request, status, error) {

        }
    });
}


function ProductDetail(){
    $.ajax({
        type: "post",
        url: "http://localhost:8080/dbproject/aggregation/findbypid",
        data: {
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
            document.getElementById('ProductPrice').innerText = "$"+price;
            document.getElementById('ProductDescription').innerText = description;
            document.getElementById('StockNumber').innerText = inventory;

        },
        error: function (request, status, error) {
            //alert(request.responseText);
            //alert(1);
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
