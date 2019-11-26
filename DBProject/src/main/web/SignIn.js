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
            var data=eval(msg);
            //alert(data);
            var str = JSON.stringify(data);
            //alert(str);
            var obj = JSON.parse(str);
            alert(obj.name);


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
