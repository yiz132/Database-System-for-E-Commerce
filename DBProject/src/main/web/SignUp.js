function NewUser(){
    var name = $('#UserName-register').val();
    //alert(name);
    var password = $('#SecondPassword-register').val();
    var radios = document.getElementsByName('Character');
    for (var i = 0, length = radios.length; i < length; i++) {
        if (radios[i].checked) {
            var role = radios[i].value;
            break;
        }
    }
    var Url="http://localhost:8080/dbproject/home/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password
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

$(function(){
    $("input[type='radio']").click(function(){
        $("input[type='radio'][name='"+$(this).attr('name')+"']").parent().removeClass("checked")
        $(this).parent().addClass("checked");
    });
});


// $(document).ready(function () {
//     $("#MoreCustomer").click(function () {
//         $("#MoreCustomer").animate({
//             width: '200px'
//         },400);
//         $("#MoreSalesPerson").animate({
//             width: '0px'
//         },400);
//         $("#MoreSalesPerson").css("display","none");
//
//     })
//
// })
