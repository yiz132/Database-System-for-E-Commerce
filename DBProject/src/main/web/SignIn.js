function SignUp_jump() {
    window.location.href = "Login.html"
}

function SignIn(){
    var name = $('#UserName-register').val();
    //alert(name);
    var password = $('#FirstPassword-register').val();
    const Url="http://localhost:8080/dbproject/login/home";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,

        },
        dataType: "json",
        success: function(msg){
            alert("success!");
        }
    });
}
