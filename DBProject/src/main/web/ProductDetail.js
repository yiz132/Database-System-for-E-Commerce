function CheckOut(){
    var number = $('#Transact_Number').val();
    var date = new Date();
    //Transact
    var Url="";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            c_id: c_id,
            p_id: p_id,
            number: number,
            date: date.toLocaleDateString(),
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
