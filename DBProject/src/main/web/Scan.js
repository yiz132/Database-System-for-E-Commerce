function SearchProduct() {

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

function EnterDetail(){
     var P_id = 1;
     window.location.href = "ProductDetail.html?value=" + P_id;
}
