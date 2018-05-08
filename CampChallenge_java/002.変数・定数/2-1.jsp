<%-- 
    Document   : 2-1
    Created on : 2018/05/08, 11:08:58
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
String name = "Kihiro Ishihara";

out.print("私の名前は石原希比呂です。");

out.print(name);
%>
    </body>
</html>
