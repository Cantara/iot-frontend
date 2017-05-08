//var wsUri = "ws://localhost:8086/application/ws";// "ws://" + document.location.host + "/application/ws";
//var wsUri = "wss://iotlab.cantara.no/devices/ws";
var websocket = [];

var interval;
var isWsOpen = false;

function openWS(wsUri) {
    websocket = new WebSocket(wsUri);

    websocket.onmessage = function(evt) { onMessage(evt) };
    websocket.onerror = function(evt) { onError(evt) };
    websocket.onopen = function(evt) { onOpen(evt) };
    websocket.onclose = function(evt) {onClose(evt)};

}

function closeWS() {
    clearInterval(interval);
    websocket.close();
}

function onMessage(evt) {
    console.log("received over websockets: " + evt.data);
    try {

        // var data = JSON.parse(evt.data);
        // var payload = data.payload;

        //addToGraph(payload);
        // updatePresentation(payload);
        writeText(evt.data);

    } catch (e){
        console.log(e);
    }
}


function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function onOpen() {
    writeToScreen("<b>Connected</b> to " + wsUri);
    websocket.send("subscribe device baardlTI");
    interval= setInterval(wsPing,1000);
    isWsOpen = true;
}
function onClose(evt) {
    isWsOpen = false;
    writeText("Disconnected from " + wsUri);
}

function wsPing(){
    websocket.send("ping");
}

function subscribeSensorId(sensorId) {
    if (isWsOpen) {
        websocket.send("subscribe device " + sensorId);
    } else {
        writeText("ERROR: You must connect first.");
    }
}

var output = document.getElementById("output");

function writeToScreen(message) {
    if (output==null)
    {output = document.getElementById("output");}

    output.innerHTML = message + "<br>";
}

function writeText(message) {
    if (output==null)
    {output = document.getElementById("output");}

    var content = document.createTextNode(message);
    output.appendChild(content);
    var br = document.createElement("br");
    output.appendChild(br);
}

function sendText(json) {
    console.log("sending text: " + json);
    websocket.send(json);
}

