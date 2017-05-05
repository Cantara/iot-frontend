//var wsUri = "ws://localhost:8086/application/ws";// "ws://" + document.location.host + "/application/ws";
//var wsUri = "wss://iotlab.cantara.no/devices/ws";
var websocket = [];

var interval;

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

function updateTemperature(temperature) {
    var x = (new Date()).getTime(); // current time
    var series = chart.series[0];
    if ($.isNumeric(temperature)) {
        var temp = parseFloat(temperature);
        series.addPoint([x, temp], true, true);
    } else
    {
        console.log("Temperature is not a number: " + temperature);
    }
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
    websocket.send("subscribe device 4d6e848e-d99e-40c7-9c61-1744c525bfd8-de44fce1-ecb3-483d-ac22-113a3269bfc1");
    websocket.send("subscribe device 8225ae39-b0db-4377-bc8b-83d0c8cb1534");
    interval= setInterval(wsPing,1000);
}
function onClose(evt) {
    writeText("Disconnected from " + wsUri);
}

function wsPing(){
    websocket.send("ping");
}


// For testing purposes
var output = document.getElementById("output");
var grahdata = document.getElementById("grap");

function addToGraph(payload) {
    if (grahdata==null)
    {grahdata = document.getElementById("graph");}
    //output.innerHTML += message + "<br>";
    var graphText = "Temperature: <b>" + payload.temperature + "</b>";
    grahdata.innerHTML = graphText + "<br>";
    updateTemperature(payload.temperature);
}

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

