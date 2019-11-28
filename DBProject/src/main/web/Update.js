//new product  update product


function UploadProduct(){
    var name = $('#Update_name').val();
    var price = $('#Update_price').val();
    var category = $('#Update_category').val();
    var inventory = $('#Update_inventory').val();
    var description = $('#Update_description').val();
    //var photoUrl = document.getElementById('PhotoUrl').value;
    var photo = document.getElementById('FileUpload').files[0];
    //alert(photo);
    //update product
    var Url="http://localhost:8080/dbproject/salesperson/addproduct";
    $.ajax({
        type: "post",
        url: Url,
        // processData: false,
        // contentType: false,
        data: {
            name: name,
            price: price,
            category: category,
            inventory: inventory,
            description: description,
            photo: photo
        },
        dataType: "json",
        success: function(msg){
            alert(msg);
            //alert(request.responseText);
        },
        error: function (request, status, error) {
            alert(request.responseText);
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
