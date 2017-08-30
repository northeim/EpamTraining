

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


