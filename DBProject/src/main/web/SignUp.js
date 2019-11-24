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

    const Url="http://localhost:8080/dbproject/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,
            role: role,

        },
        dataType: "json",
        success: function(msg){
            alert("success!");
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
