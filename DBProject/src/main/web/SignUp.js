function Locate() {
    $("html,body").animate({scrollTop:"0" + "px"}, 500);
}

function Detail() {
    var radios = document.getElementsByName('Character');
    for (var i = 0, length = radios.length; i < length; i++) {
        if (radios[i].checked) {
            var role = radios[i].value;
            break;
        }
    }
    if(role == 'HomeCustomer'){

        document.getElementById("HomeCustomerDiv").style.display="none";
        document.getElementById("HomeCustomer-submit").style.display="none";
        document.getElementById("BusinessCustomerDiv").style.display="none";
        document.getElementById("BusinessCustomer-submit").style.display="none";
        document.getElementById("SalesPersonDiv").style.display="none";
        document.getElementById("SalesPerson-submit").style.display="none"
        document.getElementById("StoreManagerDiv").style.display="none";
        document.getElementById("StoreManager-submit").style.display="none";
        document.getElementById("RegionManagerDiv").style.display="none";
        document.getElementById("RegionManager-submit").style.display="none";

        document.getElementById("HomeCustomerDiv").style.display="block";
        document.getElementById("HomeCustomer-submit").style.display="block";
        document.getElementById("LogoDivBottom").style.display="block";
        $("html,body").animate({scrollTop:"1000" + "px"}, 500);
    }
    else if(role == 'BusinessCustomer'){
        document.getElementById("HomeCustomerDiv").style.display="none";
        document.getElementById("HomeCustomer-submit").style.display="none";
        document.getElementById("SalesPersonDiv").style.display="none";
        document.getElementById("SalesPerson-submit").style.display="none"
        document.getElementById("StoreManagerDiv").style.display="none";
        document.getElementById("StoreManager-submit").style.display="none";
        document.getElementById("RegionManagerDiv").style.display="none";
        document.getElementById("RegionManager-submit").style.display="none";

        document.getElementById("BusinessCustomerDiv").style.display="block";
        document.getElementById("BusinessCustomer-submit").style.display="block";
        document.getElementById("LogoDivBottom").style.display="block";
        $("html,body").animate({scrollTop:"1000" + "px"}, 500);

    }
    else if(role == 'SalesPerson'){
        document.getElementById("HomeCustomerDiv").style.display="none";
        document.getElementById("HomeCustomer-submit").style.display="none";
        document.getElementById("BusinessCustomerDiv").style.display="none";
        document.getElementById("BusinessCustomer-submit").style.display="none";
        document.getElementById("StoreManagerDiv").style.display="none";
        document.getElementById("StoreManager-submit").style.display="none";
        document.getElementById("RegionManagerDiv").style.display="none";
        document.getElementById("RegionManager-submit").style.display="none";

        document.getElementById("SalesPersonDiv").style.display="block";
        document.getElementById("SalesPerson-submit").style.display="block"
        document.getElementById("LogoDivBottom").style.display="block";;
        $("html,body").animate({scrollTop:"1000" + "px"}, 500);

    }
    else if(role == 'StoreManager'){
        document.getElementById("HomeCustomerDiv").style.display="none";
        document.getElementById("HomeCustomer-submit").style.display="none";
        document.getElementById("BusinessCustomerDiv").style.display="none";
        document.getElementById("BusinessCustomer-submit").style.display="none";
        document.getElementById("SalesPersonDiv").style.display="none";
        document.getElementById("SalesPerson-submit").style.display="none"
        document.getElementById("RegionManagerDiv").style.display="none";
        document.getElementById("RegionManager-submit").style.display="none";

        document.getElementById("StoreManagerDiv").style.display="block";
        document.getElementById("StoreManager-submit").style.display="block";
        document.getElementById("LogoDivBottom").style.display="block";
        $("html,body").animate({scrollTop:"1000" + "px"}, 500);

    }
    else if(role == 'RegionManager'){

        document.getElementById("HomeCustomerDiv").style.display="none";
        document.getElementById("HomeCustomer-submit").style.display="none";
        document.getElementById("BusinessCustomerDiv").style.display="none";
        document.getElementById("BusinessCustomer-submit").style.display="none";
        document.getElementById("SalesPersonDiv").style.display="none";
        document.getElementById("SalesPerson-submit").style.display="none"
        document.getElementById("StoreManagerDiv").style.display="none";
        document.getElementById("StoreManager-submit").style.display="none";

        document.getElementById("RegionManagerDiv").style.display="block";
        document.getElementById("RegionManager-submit").style.display="block";
        document.getElementById("LogoDivBottom").style.display="block";
        $("html,body").animate({scrollTop:"1000" + "px"}, 500);

    }
    else{ // infinite
        //document.getElementsByName('Character').style.animation= "fade 600ms infinite";
        //$("#Character1").css({"-webkit-animation":"twinkling 1s infinite ease-in-out"});


    }
}



function NewHomeCustomer(){
    var name = $('#UserName-register').val();
    var password = $('#SecondPassword-register').val();
    var role = "HomeCustomer";
    var age = $('#HomeCustomer_Age').val();
    var gender = $('#HomeCustomer_Gender').val();
    var address = $('#HomeCustomer_Address').val();
    var marriage_status = $('#HomeCustomer_Marriage').val();
    var income = $('#HomeCustomer_Income').val();
    var account = $('#HomeCustomer_Account').val();

    var Url="http://localhost:8080/dbproject/home/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,
            role: role,
            age: age,
            gender: gender,
            address: address,
            marriage_status: marriage_status,
            income: income,
            account: account

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

function NewBusinessCustomer(){
    var name = $('#UserName-register').val();
    var password = $('#SecondPassword-register').val();
    var radios = document.getElementsByName('Character');
    var role = "BusinessCustomer";
    var address = $('#BusinessCustomer_Address').val();
    var company_category = $('#BusinessCustomer_Category').val();
    var company_gross = $('#BusinessCustomer_Gross').val();
    var account = $('#BusinessCustomer_Account').val();

    var Url="http://localhost:8080/dbproject/home/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,
            role: role,
            address: address,
            company_category: company_category,
            company_gross: company_gross,
            account: account

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

function NewSalesPerson(){
    var name = $('#UserName-register').val();
    var password = $('#SecondPassword-register').val();
    var role = "SalesPerson";
    var email = $('#Salesperson_Email').val();
    var job_title = $('#SalesPerson_JobTitle').val();
    var salary = $('#SalesPerson_Salary').val();

    var Url="http://localhost:8080/dbproject/home/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,
            role: role,
            email: email,
            job_title: job_title,
            salary: salary

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

function NewStoreManager(){
    var name = $('#UserName-register').val();
    var password = $('#SecondPassword-register').val();
    var role = "StoreManager";
    var email = $('#StoreManager_Email').val();
    var job_title = "StoreManager";
    var salary = $('#StoreManager_Salary').val();
    var store_name = $('#StoreManager_StoreName').val();
    var store_address = $('#StoreManager_StoreAddress').val();
    var store_region = $('#StoreManager_StoreRegion').val();
    alert(email);
    var Url="http://localhost:8080/dbproject/home/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,
            role: role,
            email: email,
            job_title: job_title,
            salary: salary,
            store_name: store_name,
            store_address: store_address,
            store_region: store_region
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

function NewRegionManager(){
    var name = $('#UserName-register').val();
    var password = $('#SecondPassword-register').val();
    var role = "RegionManager";
    var email = $('#RegionManager_Email').val();
    var job_title = "RegionManager";
    var salary = $('#RegionManager_Salary').val();
    var region_name = $('#RegionManager_RegionName').val();

    var Url="http://localhost:8080/dbproject/home/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,
            role: role,
            email: email,
            job_title: job_title,
            salary: salary,
            region_name: region_name,
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
