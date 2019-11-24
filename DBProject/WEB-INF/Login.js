function NewUser()
{

    var name = $('#UserName-register').val();
    var password = $('#SecondPassword-register').val();
    //var Crt;

     // var Y = $('#CharacterChoose').offset().left;
     // if(Y<119){
     //     Crt="homecus";
         $.post(
             //"./Register.php",
             {
                 name:name,
                 password:password,
                 //crt:Crt
             },
             function(result){
                 //window.location='homecus.html';
                 alert('login!');
             });
    // }
    //  else{
    //      Crt="buscus"
    //      $.post(
    //          "./Register.php",
    //          {
    //              name:name,
    //      //      password:password,
    //              crt:Crt
    //          },
    //          function(result){
    //              window.location='buscus.html';
    //          });
    //  }



}
