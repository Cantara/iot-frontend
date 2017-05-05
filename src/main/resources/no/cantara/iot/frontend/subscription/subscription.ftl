
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="robots" content="noindex, nofollow">
    <meta name="googlebot" content="noindex, nofollow">
    <title>IoT Device Data Demo</title>
    <link rel="stylesheet" href="/frontend/css/styleguide.css">
    <link rel="stylesheet" href="/frontend/css/prettyprint.css">
    <link rel="stylesheet" href="/frontend/css/albatross.css">
    <script type="text/javascript" src="/frontend/js/lib/jquery-1.9.1.js"></script>
</head>

<body>
<div align="center">
    <h1>AWS IoT</h1>
</div>
<hr/>
<table>
    <tr>
        <td>
            <img src="/frontend/images/image1.jpg" id="imageElement" height="400"><br/>
        </td>
        <td><input id="open" type="button" value="Connect" onclick="openWS('${wsUrl}');" /> <input id="close" type="button" value="Disconnect" onclick="closeWS('${wsUrl}');" />
            <h3>Sensor updates</h3>
            <label for="sensorid">Sensor id: </label><input type="text" id="sensorid" name="sensorid"/><input type="button" value="Subscribe to updates"
                   onclick="subscribeSensorId(document.getElementById('sensorid').value)" />


            <h3>Console Log</h3>
            <div id="output"></div>
        </td>
    </tr>
</table>
<!--<script src="/IotFrontend/properties/override.js"/>-->
<!--<script src="/frontend/js/properties_override.js"/>-->
<script src="/frontend/js/properties.js"/>
<script src="/frontend/js/presenter.js"/>
<script src="/frontend/js/devicedata.js"></script>
<script src="/frontend/js/websocket.js"></script>



</body>

</html>

