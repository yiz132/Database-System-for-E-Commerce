function SignUp_jump() {
    window.location.href = "SignUp.html"
}

function SignIn(){
    var name = $('#UserName-register').val();
    //alert(name);
    var password = $('#FirstPassword-register').val();
    var Url="http://localhost:8080/dbproject/home/signin";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,

        },
        dataType: "json",
        success: function(msg) {
            var jsonObject = JSON.parse(msg);
            alert(jsonObject.username);
            //alert("success!");
            // var data = '';
            // if (msg != '') {
            //     //data = eval("(" + msg + ")");
            //     alert(msg);
            // }
        },
        error: function (request, status, error) {
            alert(request.responseText);

        }

    });
}
