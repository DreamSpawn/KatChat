<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
	<head>
        <title>Kat Chat</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="CSS/default.css">
		<script type="text/javascript" src="Javascript/scripts.js"></script>
	</head>
	<body onload="getMessages()">
		<textarea id="messages" readonly></textarea>
		<BR>
		<input type="text" id="input" onkeypress="if (event.keyCode === 13) sendMessage();">
		<button onclick="sendMessage()">Send</button>
	</body>
</html>