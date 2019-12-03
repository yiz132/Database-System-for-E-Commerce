var id = GetRequest();
var stringA = JSON.stringify(id);
var obj = JSON.parse(stringA);
if(obj.pid == 0){
}
else{
    OnloadProductInformation();

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

function OnloadProductInformation(){
    $.ajax({
        type: "post",
        url: "",
        data:{ pid: obj.pid},
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var obj = JSON.parse(str);
            var picture = obj.picture;
            var name = obj.name;
            var price = obj.price;
            var inventory = obj.inventory;
            var category = obj.category;
            var description = obj.description;
            pid = obj.id;
            document.getElementById('Update_name').value = name;
            document.getElementById('Update_price').value = price;
            document.getElementById('Update_inventory').value = inventory;
            document.getElementById('Update_category').value = category;
            document.getElementById('Update_description').value = description;
            document.getElementById('Upload_ProductPhoto').style.backgroundImage = 'url('+ picture +')';
        },
        error: function (request, status, error) {
        }
    });
}

//ProductOnload();

function UploadProduct(){
    var name = $('#Update_name').val();
    var price = $('#Update_price').val();
    var category = $('#Update_category').val();
    var inventory = $('#Update_inventory').val();
    var description = $('#Update_description').val();
    var photoUrl = document.getElementById('PhotoUrl').value;
    //update product
    var Url="http://localhost:8080/dbproject/salesperson/addproduct";
    $.ajax({
        type: "post",
        url: Url,
        // processData: false,
        // contentType: false,
        data: {
            salesperson_id: obj.value,
            name: name,
            price: price,
            category: category,
            inventory: inventory,
            description: description,
            picture: photoUrl
        },
        dataType: "json",
        success: function(msg){
            window.location.href =  "SalesPersonIndex.html?value=" + obj.value;
        },
        error: function (request, status, error) {
            //alert(request.responseText);
            //alert(1);

        }
    });
}

function OnloadProductPhoto() {
    var imgFile = document.getElementById('FileUpload').files[0];
    var fr = new FileReader();

    fr.onload = function () {
        document.getElementById('Upload_ProductPhoto').style.backgroundImage ="url(" + fr.result + ")";
        document.getElementById('PhotoUrl').value = fr.result;
    };

    fr.readAsDataURL(imgFile);


}
