

function SearchBusiness() {
    var keyWord = document.getElementById('SearchInput').value;
    var sort = document.getElementById('Sort').value;
    var Url = "http://localhost:8080/dbproject/regionmanager/searchAndSort/regions";

    document.getElementById('ListTable').innerHTML = "<tr style=\"height: 10px;\">\n" +
        "        <th style=\"height: 10px; border: 1px  lightpink; border-style: none none solid none;\">Region</th>\n" +
        "        <th style=\"height: 10px;  border: 1px  lightpink; border-style: none none solid none;\">Sales</th>\n" +
        "        <th style=\"height: 10px;  border: 1px  lightpink; border-style: none none solid none;\">Profit</th>\n" +
        "    </tr>";


    $.ajax({
        type: "post",
        url: Url,
        data: {
            search_keyword: keyWord,
            sort_keyword: sort,
        },
        dataType: "json",
        success: function (msg) {
            var data = eval(msg);
            var str = JSON.stringify(data);
            var manager = JSON.parse(str);
            var canvasregions = new Array()
            var canvassales = new Array()
            var canvasprofits = new Array()
            for (var j = 0; j < manager.length; j++) {
                canvasregions[j] = manager[j].name;
                canvassales[j] = manager[j].total_sales;
                canvasprofits[j] = manager[j].total_profits;
            }

            for (var i = 0; i < manager.length; i++) {
                var regions = manager[i].name;
                var sales = manager[i].total_sales;
                var profit = manager[i].total_profits;
                document.getElementById('ListTable').innerHTML = document.getElementById('ListTable').innerHTML + "\n" +
                    "    <tr>\n" +
                    "        <td>" + regions + "</td>\n" +
                    "        <td>" + sales + "</td>\n" +
                    "        <td>" + profit + "</td>\n" +
                    "    </tr>";
            }
            ShowCanvas(canvasregions,canvassales,canvasprofits);

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });

}

function ShowCanvas(canvasregions,canvassales,canvasprofits) {
    var sort = document.getElementById('Sort').value;
    if(sort == 'Stores'){
        window.location.href = "SortByStore.html?value=" + obj.value;
    }
    else if(sort == 'SalesHighToLow' || sort == 'SalesLowToHigh'){
        //document.getElementById('ListTable').innerHTML ="";
        document.getElementById('CanvasDiv').innerHTML = "";
        document.getElementById('CanvasDiv').innerHTML = "<canvas id=\"a_canvas\" class=\"Canvas\" width=\"1000\" height=\"700\"></canvas>";
        document.getElementById('CanvasDiv').style.top = 130 + document.getElementById('ListTable').offsetHeight+"px";
       // alert(document.getElementById('ListTable').offsetHeight);
        sales(canvasregions,canvassales);

    }
    else if(sort == 'ProfitHighToLow' || sort == 'ProfitLowToHigh'){
        //document.getElementById('ListTable').innerHTML ="";
        document.getElementById('CanvasDiv').innerHTML = "";
        document.getElementById('CanvasDiv').innerHTML = "<canvas id=\"a_canvas\" class=\"Canvas\" width=\"1000\" height=\"700\"></canvas>";
        document.getElementById('CanvasDiv').style.top = 130 + document.getElementById('ListTable').offsetHeight+"px";

        profits(canvasregions,canvasprofits);

    }
    else {
        document.getElementById('CanvasDiv').innerHTML = "";
    }
}

function SearchPress() {

    if(event.keyCode==13)
    {
        SearchBusiness();
    }

}

var id = GetRequest();
var stringA = JSON.stringify(id);
var obj = JSON.parse(stringA);
onloadManager();

function GetRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        var strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = decodeURIComponent(strs[i].split("=")[1]);
        }
    }
    return theRequest;
}
function LogOut() {

    window.location.href = "SignIn.html";
}
function onloadManager() {
    var Url="http://localhost:8080/dbproject/regionmanager/showtrans/allregions";
    $.ajax({
        type: "get",
        url: Url,
        data: {
        },
        dataType: "json",
        success: function(msg) {
            var data=eval(msg);
            var str = JSON.stringify(data);
            var manager = JSON.parse(str);
            for( var i = 0; i<manager.length; i++) {
                var regions = manager[i].name;
                var sales = manager[i].total_sales;
                var profit = manager[i].total_profits;
                document.getElementById('ListTable').innerHTML = document.getElementById('ListTable').innerHTML + "\n" +
                    "    <tr>\n" +
                    "        <td>" + regions + "</td>\n" +
                    "        <td>" + sales + "</td>\n" +
                    "        <td>" + profit + "</td>\n" +
                    "    </tr>";
            }

        },
        error: function (request, status, error) {
            //alert(request.responseText);

        }
    });
}

function sales(canvasregions,canvassales){
    //alert(canvasregions);
    var data = canvassales;
    var xinforma = canvasregions;

    var a_canvas = document.getElementById('a_canvas');
    var context = a_canvas.getContext("2d");


    // draw background
    var gradient = context.createLinearGradient(0, 0, 0, 300);


    // gradient.addColorStop(0,"#e0e0e0");
    //gradient.addColorStop(1,"#ffffff");


    context.fillStyle = gradient;

    context.fillRect(0, 0, a_canvas.width, a_canvas.height);

    var realheight = a_canvas.height - 15;
    var realwidth = a_canvas.width - 40;
    // draw outline
    var grid_cols = data.length + 1;
    var grid_rows = 4;
    var cell_height = realheight / grid_rows;
    var cell_width = realwidth / grid_cols;
    context.lineWidth = 1;
    context.strokeStyle = "#a0a0a0";

    // end draw outline
    context.beginPath();
    // ready to draw x
    /*for(var row = 1; row <= grid_rows; row++){
      var y = row * cell_height;
      context.moveTo(0,y);
      context.lineTo(a_canvas.width, y);
    }*/

    //draw x
    context.moveTo(0, realheight);
    context.lineTo(realwidth, realheight);


    //ready to draw y
    context.moveTo(0, 20);
    context.lineTo(0, realheight);
    context.lineWidth = 1;
    context.strokeStyle = "black";
    context.stroke();


    var max_v = 0;

    for (var i = 0; i < data.length; i++) {
        if (data[i] > max_v) {
            max_v = data[i]
        }
        ;
    }
    max_v = max_v * 1.1;
    // data to axis
    var points = [];
    for (var i = 0; i < data.length; i++) {
        var v = data[i];
        var px = cell_width * (i + 1);
        var py = realheight - realheight * (v / max_v);
        //alert(py);
        points.push({"x": px, "y": py});
    }

    //draw shape
    for (var i in points) {
        var p = points[i];
        context.beginPath();
        context.fillStyle = "lightgrey";
        context.fillRect(p.x, p.y, 15, realheight - p.y);

        context.fill();
    }

    //add text
    for (var i in points) {
        var p = points[i];
        context.beginPath();
        context.fillStyle = "black";
        if(p.y < -500)
        {p.y = 10;}
        //alert(p.y);
        context.fillText(data[i], p.x , p.y  );
        // context.fillText(data[i], p.x + 1, p.y - 15);
        context.fillText(xinforma[i], p.x + 1, realheight + 12);
        context.fillText('Regions', realwidth, realheight + 12);
        context.fillText('Sales', 0, 10);
    }


}


function profits(canvasregions,canvasprofits){
    var data = canvasprofits;
    var xinforma = canvasregions;
    var a_canvas = document.getElementById('a_canvas');
    var context = a_canvas.getContext("2d");



    var gradient = context.createLinearGradient(0, 0, 0, 300);


    // gradient.addColorStop(0,"#e0e0e0");
    //gradient.addColorStop(1,"#ffffff");


    context.fillStyle = gradient;

    context.fillRect(0, 0, a_canvas.width, a_canvas.height);

    var realheight = a_canvas.height - 15;
    var realwidth = a_canvas.width - 40;

    var grid_cols = data.length + 1;
    var grid_rows = 4;
    var cell_height = realheight / grid_rows;
    var cell_width = realwidth / grid_cols;
    context.lineWidth = 1;
    context.strokeStyle = "#a0a0a0";


    context.beginPath();

    /*for(var row = 1; row <= grid_rows; row++){
      var y = row * cell_height;
      context.moveTo(0,y);
      context.lineTo(a_canvas.width, y);
    }*/


    context.moveTo(0, realheight);
    context.lineTo(realwidth, realheight);



    context.moveTo(0, 20);
    context.lineTo(0, realheight);
    context.lineWidth = 1;
    context.strokeStyle = "black";
    context.stroke();


    var max_v = 0;

    for (var i = 0; i < data.length; i++) {
        if (data[i] > max_v) {
            max_v = data[i]
        }
        ;
    }
    max_v = max_v * 1.1;

    var points = [];
    for (var i = 0; i < data.length; i++) {
        var v = data[i];
        var px = cell_width * (i + 1);
        var py = realheight - realheight * (v / max_v);
        //var py = cell_height * (i+1);
        //alert(py);
        points.push({"x": px, "y": py});
    }


    for (var i in points) {
        var p = points[i];
        context.beginPath();
        context.fillStyle = "lightblue";
        context.fillRect(p.x, p.y, 15, realheight - p.y);

        context.fill();
    }


    for (var i in points) {
        var p = points[i];
        context.beginPath();
        context.fillStyle = "black";
         if(p.y < -500)
         {p.y = 10;}
        //alert(p.y);
        context.fillText(data[i], p.x , p.y  );
        context.fillText(xinforma[i], p.x + 1, realheight + 12);
        context.fillText('Regions', realwidth, realheight + 12);
        context.fillText('Profits', 0, 10);
    }


}
