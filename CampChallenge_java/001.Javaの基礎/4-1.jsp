<%-- 
    Document   : 4-1
    Created on : 2018/05/08, 12:54:42
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
String NAME = "groove";
String TEXT = "gear";

out.print(NAME + "-" + TEXT);
%>
    </body>
</html>
