function NewUser(){
    var name = $('#UserName-register').val();
    alert(name);
    var password = $('#SecondPassword-register').val();
    const Url="http://localhost:8080/dbproject/register";
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
