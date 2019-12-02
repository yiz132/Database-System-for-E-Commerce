function SignUp_jump() {
    window.location.href = "SignUp.html"
}

$(function(){
    $("input[type='radio']").click(function(){
        $("input[type='radio'][name='"+$(this).attr('name')+"']").parent().removeClass("checked")
        $(this).parent().addClass("checked");
    });
});

var jumpURL = '';
var role = '';
function Detail() {
    var radios = document.getElementsByName('Character');
    for (var i = 0, length = radios.length; i < length; i++) {
        if (radios[i].checked) {
            role = radios[i].value;
            break;
        }
    }
    if(role == 'HomeCustomer'){
        jumpURL = 'http://localhost:8080/dbproject/home/signin';

    }
    else if(role == 'BusinessCustomer'){
        jumpURL = 'http://localhost:8080/dbproject/business/signin';

    }
    else if(role == 'SalesPerson'){
        jumpURL = 'http://localhost:8080/dbproject/salesperson/signin';

    }
    else if(role == 'StoreManager'){
        jumpURL = 'http://localhost:8080/dbproject/storemanager/signin';

    }
    else if(role == 'RegionManager'){
        jumpURL = 'http://localhost:8080/dbproject/regionmanager/signin';

     }
    // else{ // infinite
    //     //document.getElementsByName('Character').style.animation= "fade 600ms infinite";
    //     //$("#Character1").css({"-webkit-animation":"twinkling 1s infinite ease-in-out"});
    //
    //
    // }
    SignIn();
}

function SignIn(){
    var name = $('#UserName-register').val();
    var password = $('#FirstPassword-register').val();
    $.ajax({
        type: "post",
        url: jumpURL,
        data: {
            name: name,
            password: password,

        },
        dataType: "json",
        success: function(msg) {
              var data=eval(msg);
              var str = JSON.stringify(data);
              var obj = JSON.parse(str);

            if(role == 'HomeCustomer'){
                window.location.href =  "Scan.html?value=" + obj.id;

            }
            else if(role == 'BusinessCustomer'){
                window.location.href =  "Scan.html?value=" + obj.id;

            }
            else if(role == 'SalesPerson'){
                window.location.href =  "SalesPersonIndex.html?value=" + obj.id;

            }
            else if(role == 'StoreManager'){
                window.location.href =  "StoreManagerIndex.html?value=" + obj.id;

            }
            else if(role == 'RegionManager'){
                window.location.href =  "RegionManagerIndex.html?value=" + obj.id;

            }


        },
        error: function (request, status, error) {
            //alert(request.responseText);
            alert("Username or password is wrong");

        }
    });
}

$(document).ready(function(){
    $('#UserName-register').bind('input propertychange', function() {
        var UserNameregister = $(this).val();
        if (UserNameregister == '') {
            $('#UserName-result').text("*");
        } else {
            $('#UserName-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#FirstPassword-register').bind('input propertychange', function() {
        var FirstPassword = $(this).val();
        if (FirstPassword == '') {
            $('#FirstPassword-result').text("*");
        } else {
            $('#FirstPassword-result').text("");
        }
    })
})
