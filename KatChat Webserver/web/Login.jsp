<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="login" class="servlet.Login" scope="session" />
<jsp:setProperty name="login" property="*" />

<html>
    <head>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Welcome to KatChat</title>
        <link href="style.css" type="text/css" rel="stylesheet" />

    </head>
    <body>
        <div class=head>
            <h1>Log ind</h1>
            <br>
        </div>
        <div class=content>
            <form method="POST" action="LoginServlet">
                <fieldset>
                    <input type="hidden" name="handling" value="null"> <label>Bruger ID:</label>
                    <input name="userID" type="text" >
                    <label>Password:</label> <input name="password" type="password">
                    <input type="submit" name="handling" value="log ind">
                     <table>
                </tr>
            </table>
        </form>


                </fieldset>   

            </form>


        </div>
    </body>
</html>