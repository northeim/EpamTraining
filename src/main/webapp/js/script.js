

function onReadyPage() {
    var objectJ = JSON.parse('{"aaa":"fdsfd",' +
        '"bbb":"ggg",' +
        '"rrr":"ttt"}');
    var obj = {};
    obj['content'] = [10,20,20,30];
    obj['name'] = "Fedorov";

    var txt = "";
    var x;
    for(x in objectJ) {
        txt += (x + " : " + objectJ[x] + "<br>");
    }
    document.getElementById("demo").innerHTML = txt + JSON.stringify(objectJ) + JSON.stringify(obj);
}

function getAjaxObj() {

    var ajaxRequest;

    try {
        ajaxRequest = new XMLHttpRequest();
    } catch (e) {
        try {
            ajaxRequest = ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                ajaxRequest = ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                ajaxRequest = null;
            }
        }
    }
    return ajaxRequest;
}

function validateInput() {
    var ajaxRequest = getAjaxObj();
    var inNumberValue = document.getElementById("inNumber").value;
    var url = "/test?inNumber=" + inNumberValue;
    ajaxRequest.onreadystatechange = processRequest;
    ajaxRequest.open("GET", url, true);
    ajaxRequest.send(null);
}

function processRequest() {
    if (this.readyState == 4 && this.status == 200) {
        var txt = "";
        txt += this.getAllResponseHeaders() + "<br>";
        txt += this.responseText;

        document.getElementById("ajaxResult").innerHTML = txt;
    }
}

var deg = 0;

function rotate() {
    var element1 = document.getElementById("default");
    var element2 = document.getElementById("transform3");

    if (deg >= 90) {
        deg = 0;
    } else {
        deg += 90;
    }



    element1.style.transform = "rotateY("+deg+"deg)";
    element2.style.transform = "rotateY("+(deg-90) +"deg)";
}