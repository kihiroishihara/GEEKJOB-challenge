<%-- 
    Document   : 8-1-2
    Created on : 2018/05/08, 16:52:56
    Author     : Kihiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
String text = "A";

for (int i = 0; i < 30; i++) {
    out.print(text);
}

%>
    </body>
</html>
