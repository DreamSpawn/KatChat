/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getMessages() {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {
		if (xhttp.readyState === 4 && xhttp.status === 200) {
			updateText(xhttp.responseText);
		}
	};
	xhttp.open("GET", "messages", true);
	xhttp.send();
}

function updateText(text) {
	var messages = document.getElementById("messages");
	messages.value = messages.value + text;
	
	getMessages();
}

function sendText(){
	
}