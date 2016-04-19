<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="login" class="servlet.Login" scope="session" />
<jsp:setProperty name="login" property="*" />

<html>
    <head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome to KatChat <jsp:getProperty name="login" property="userName" /></title>
        <link href="style.css" type="text/css" rel="stylesheet" />

    </head>
    <body>
        <div class=head>
            <h1>Velkommen <jsp:getProperty name="login" property="userName" /></h1>
        </div>
        <div class=content>
            <form>
               
                   
                        <textarea id="messagesTextArea" readonly="readonly" rows="10" cols="50"></textarea><br>
                        <input type="text" id="message"  name="message" size="50" >
                        <input type="button" onclick="postMessage();"  value="send">
                        
                        
                       </form>
        <div id="content">
            <% if (application.getAttribute("messages") != null) {%>
            <%= application.getAttribute("messages")%>
            <% }%>
        </div>
                
                           <script>
                                        function postMessage() {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("POST", "WsChatServlet?t="+new Date(), false);
                xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
               // var nameText = escape(document.getElementById("name").value);
                var messageText = escape(document.getElementById("message").value);
                document.getElementById("message").value = "";
                xmlhttp.send("message="+messageText);
            }
                               
                               
            var messagesWaiting = false;
            function getMessages(){
                if(!messagesWaiting){
                    messagesWaiting = true;
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange=function(){
                        if (xmlhttp.readyState===4 && xmlhttp.status===200) {
                            messagesWaiting = false;
                            var contentElement = document.getElementById("content");
                           var name = "<%= login.getUserName()%>";
                             messagesTextArea.value += xmlhttp.responseText;
                        }
                    }
                    xmlhttp.open("GET", "WsChatServlet?t="+new Date(), true);
                    xmlhttp.send();
                }
            }
            setInterval(getMessages, 1000);
        </script>
  

     




        </div>
    </body>
</html>
