$(document).ready(function () {
    var name = $('#UserName-register').val();
    var password = $('#SecondPassword-register').val();
    const Url='';
    $('.Information-submit').click(function () {
        $.ajax({
            url:Url,
            type: 'post',
            data: {
                name: name,
                password: password,

            },
            dataType: 'json',
            success:function (msg) {
                alert("success!");

            }
        })

    })
})
