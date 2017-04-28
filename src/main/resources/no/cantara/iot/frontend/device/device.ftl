<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <link rel="stylesheet" href="css/diagram-js.css" />
    <link rel="stylesheet" href="vendor/bpmn-font/css/bpmn.css" />
    <link rel="stylesheet" href="vendor/bpmn-font/css/bpmn-embedded.css" />

    <style type="text/css">
        html, body, #canvas, #canvas > div {
            height: 100%;
        }

        .icon-custom-triangle {
            background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" fill="#3CAA82" width="270" height="240"><path d="M8,40 l 15,-27 l 15,27 z"/></svg>');
        }
        .icon-custom-circle {
            background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" stroke-width="8" stroke="#48a" fill="none" viewBox="0 0 120 120"><circle cx="60" cy="60" r="40"/></svg>');
        }
        .icon-custom-startEvent {
            background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" stroke-width="2" stroke="#008000" fill="#98FB98" viewBox="0 0 120 120"><circle cx="60" cy="60" r="40"/></svg>');
        }
        .icon-custom-endEvent {
            background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" stroke-width="4" stroke="#FF0000" fill="#FFE4E1" viewBox="0 0 120 120"><circle cx="60" cy="60" r="40"/></svg>');
        }
        .icon-custom-activity {
            background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" stroke-width="2" stroke="#00008B" fill="#F0F8FF" viewBox="0 0 120 120"><rect x="20" y="20" rx="10" ry="10" width="90" height="67" style="fill:#F0F8FF;stroke:#00008B;stroke-width:2" /></svg>');
        }
        .icon-custom-gateway {
            background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" stroke-width="2" stroke="#DAA520" fill="#FFFFE0" viewBox="0 0 120 120"><rect x="40" y="20" width="67" height="67" style="fill:#FFFFE0;stroke:#DAA520;stroke-width:2" transform="rotate(45 50 50)" /></svg>');
        }
        .icon-custom-dataObject {
            background: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" stroke-width="2" stroke="#DAA520" fill="#FFFFE0" viewBox="0 0 120 120"><rect x="20" y="20" width="90" height="67" style="fill:#FFFFE0;stroke:#DAA520;stroke-width:2" /></svg>');
        }

    </style>

    <!--
      this is an example of how to use bpmn-js in a standalone application built with
      CommonJS modules + browserify
    -->

    <title>Devices</title>
</head>
<body>

<h1>Devices</h1>

<div id="canvas"></div>

<script src="./app.js"></script>
</body>
</html>
