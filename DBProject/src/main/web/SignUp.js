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

        var Url="http://localhost:8080/dbproject/aggregation/showallstores";
        $.ajax({
            type: "get",
            url: Url,
            dataType: "json",
            success: function(msg) {
                var data=eval(msg);
                var str = JSON.stringify(data);
                var stores = JSON.parse(str);
                for( var i = 0; i<stores.length; i++){
                    document.getElementById('Store').innerHTML=document.getElementById('Store').innerHTML+"<option value =\""+stores[i]+"\" >"+stores[i]+"</option>";
                }

            },
            error: function (request, status, error) {
                alert(request.responseText);

            }
        });

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

        var Url="http://localhost:8080/dbproject/aggregation/showallregions";
        $.ajax({
            type: "get",
            url: Url,
            dataType: "json",
            success: function(msg) {
                var data=eval(msg);
                var str = JSON.stringify(data);
                var regions = JSON.parse(str);
                for( var i = 0; i<regions.length; i++){
                    document.getElementById('StoreManager_StoreRegion').innerHTML=document.getElementById('StoreManager_StoreRegion').innerHTML+"<option value =\""+regions[i]+"\" >"+regions[i]+"</option>";
                }

            },
            error: function (request, status, error) {
                alert(request.responseText);

            }
        });

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
            window.location.href =  "Scan.html?value=" + name;
        },
        error: function (request, status, error) {
            alert("Sign up failed");

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

    var Url="http://localhost:8080/dbproject/business/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,
            address: address,
            category: company_category,
            gross: company_gross,
            account: account

        },
        dataType: "json",
        success: function(msg){
            window.location.href =  "Scan.html?value=" + name;
        },
        error: function (request, status, error) {
            alert("Sign up failed");

        }
    });
}

function NewSalesPerson(){
    var name = $('#UserName-register').val();
    var password = $('#SecondPassword-register').val();
    var role = "SalesPerson";
    var email = $('#SalesPerson_Email').val();
    var job_title = $('#SalesPerson_JobTitle').val();
    var salary = $('#SalesPerson_Salary').val();
    var store = $('#Store').val();

    var Url="http://localhost:8080/dbproject/salesperson/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,
            role: role,
            email: email,
            title: job_title,
            salary: salary,
            store_name:store

        },
        dataType: "json",
        success: function(msg){
            var data=eval(msg);
            var str = JSON.stringify(data);
            var salesperson = JSON.parse(str);
            window.location.href =  "SalesPersonIndex.html?value=" + salesperson.id;
        },
        error: function (request, status, error) {
            alert("Sign up failed");

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
    //alert(email);
    var Url="http://localhost:8080/dbproject/storemanager/register";
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
            window.location.href =  "StoreManagerIndex.html?value=" + name;
        },
        error: function (request, status, error) {
            alert("Sign up failed");

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

    var Url="http://localhost:8080/dbproject/regionmanager/register";
    $.ajax({
        type: "post",
        url: Url,
        data: {
            name: name,
            password: password,
            email: email,
            salary: salary,
            region_name: region_name,
        },
        dataType: "json",
        success: function(msg){
            window.location.href =  "RegionManagerIndex.html?value=" + name;
        },
        error: function (request, status, error) {
            alert("Sign up failed");

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



$(document).ready(function(){
    $('#UserName-register').bind('input propertychange', function() {
        var UserNameText = $(this).val();
        if (UserNameText == ''){
            $('#UserName-result').text("*");
        }
        else if (UserNameText.length > 0 && UserNameText.length <= 5) {
            $('#UserName-result').text("Username is too short");
        } else {
            var Url = "http://localhost:8080/dbproject/aggregation/checkregister";
            $.ajax({
                type: "get",
                url: Url,
                data: {
                    name: UserNameText,
                },
                dataType: "text",
                success: function (msg) {
                    if(msg != ''){
                        $('#UserName-result').text("Username registered");
                    }
                    else{
                        $('#UserName-result').text("");
                    }
                },
                error: function (request, status, error) {

                }
            });
        }
    })
})

$(document).ready(function(){
    $('#SecondPassword-register').bind('input propertychange', function() {
        var SecondPassword = $(this).val();
        var FirstPassword = $('#FirstPassword-register').val();
        if (SecondPassword != FirstPassword) {
            $('#SecondPassword-result').text("Passwords are not the same");
        } else {
            $('#SecondPassword-result').text("");
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

$(document).ready(function(){
    $('#HomeCustomer_Age').bind('input propertychange', function() {
        var HomeCustomer_Age = $(this).val();
        if (HomeCustomer_Age == '') {
            $('#HomeCustomer_Age-result').text("*");
        } else {
            $('#HomeCustomer_Age-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#HomeCustomer_Gender').bind('input propertychange', function() {
        var HomeCustomer_Gender = $(this).val();
        if (HomeCustomer_Gender == '') {
            $('#HomeCustomer_Gender-result').text("*");
        } else {
            $('#HomeCustomer_Gender-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#HomeCustomer_Address').bind('input propertychange', function() {
        var HomeCustomer_Address = $(this).val();
        if (HomeCustomer_Address == '') {
            $('#HomeCustomer_Address-result').text("*");
        } else {
            $('#HomeCustomer_Address-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#HomeCustomer_Marriage').bind('input propertychange', function() {
        var HomeCustomer_Marriage = $(this).val();
        if (HomeCustomer_Marriage == '') {
            $('#HomeCustomer_Marriage-result').text("*");
        } else {
            $('#HomeCustomer_Marriage-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#HomeCustomer_Income').bind('input propertychange', function() {
        var HomeCustomer_Income = $(this).val();
        if (HomeCustomer_Income == '') {
            $('#HomeCustomer_Income-result').text("*");
        } else {
            $('#HomeCustomer_Income-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#HomeCustomer_Account').bind('input propertychange', function() {
        var HomeCustomer_Account = $(this).val();
        if (HomeCustomer_Account == '') {
            $('#HomeCustomer_Account-result').text("*");
        } else {
            $('#HomeCustomer_Account-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#BusinessCustomer_Address').bind('input propertychange', function() {
        var BusinessCustomer_Address = $(this).val();
        if (BusinessCustomer_Address == '') {
            $('#BusinessCustomer_Address-result').text("*");
        } else {
            $('#BusinessCustomer_Address-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#BusinessCustomer_Gross').bind('input propertychange', function() {
        var BusinessCustomer_Gross = $(this).val();
        if (BusinessCustomer_Gross == '') {
            $('#BusinessCustomer_Gross-result').text("*");
        } else {
            $('#BusinessCustomer_Gross-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#BusinessCustomer_Account').bind('input propertychange', function() {
        var BusinessCustomer_Account = $(this).val();
        if (BusinessCustomer_Account == '') {
            $('#BusinessCustomer_Account-result').text("*");
        } else {
            $('#BusinessCustomer_Account-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#SalesPerson_Email').bind('input propertychange', function() {
        var SalesPerson_Email = $(this).val();
        if (SalesPerson_Email == '') {
            $('#SalesPerson_Email-result').text("*");
        } else {
            $('#SalesPerson_Email-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#SalesPerson_JobTitle').bind('input propertychange', function() {
        var SalesPerson_JobTitle = $(this).val();
        if (SalesPerson_JobTitle == '') {
            $('#SalesPerson_JobTitle-result').text("*");
        } else {
            $('#SalesPerson_JobTitle-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#SalesPerson_Salary').bind('input propertychange', function() {
        var SalesPerson_Salary = $(this).val();
        if (SalesPerson_Salary == '') {
            $('#SalesPerson_Salary-result').text("*");
        } else {
            $('#SalesPerson_Salary-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#StoreManager_StoreName').bind('input propertychange', function() {
        var StoreManager_StoreName = $(this).val();
        if (StoreManager_StoreName == '') {
            $('#StoreManager_StoreName-result').text("*");
        } else {
            $('#StoreManager_StoreName-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#StoreManager_StoreAddress').bind('input propertychange', function() {
        var StoreManager_StoreAddress = $(this).val();
        if (StoreManager_StoreAddress == '') {
            $('#StoreManager_StoreAddress-result').text("*");
        } else {
            $('#StoreManager_StoreAddress-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#StoreManager_Email').bind('input propertychange', function() {
        var StoreManager_Email = $(this).val();
        if (StoreManager_Email == '') {
            $('#StoreManager_Email-result').text("*");
        } else {
            $('#StoreManager_Email-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#StoreManager_Salary').bind('input propertychange', function() {
        var StoreManager_Salary = $(this).val();
        if (StoreManager_Salary == '') {
            $('#StoreManager_Salary-result').text("*");
        } else {
            $('#StoreManager_Salary-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#RegionManager_RegionName').bind('input propertychange', function() {
        var RegionManager_RegionName = $(this).val();
        if (RegionManager_RegionName == '') {
            $('#RegionManager_RegionName-result').text("*");
        } else {
            $('#RegionManager_RegionName-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#RegionManager_Email').bind('input propertychange', function() {
        var RegionManager_Email = $(this).val();
        if (RegionManager_Email == '') {
            $('#RegionManager_Email-result').text("*");
        } else {
            $('#RegionManager_Email-result').text("");
        }
    })
})

$(document).ready(function(){
    $('#RegionManager_Salary').bind('input propertychange', function() {
        var RegionManager_Salary = $(this).val();
        if (RegionManager_Salary == '') {
            $('#RegionManager_Salary-result').text("*");
        } else {
            $('#RegionManager_Salary-result').text("");
        }
    })
})
