<%-- 
    Document   : 8-2
    Created on : 2018/05/08, 17:04:21
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

int num = 1000;
while ( num < 100 == false) {
    num = num / 2;
    out.print( num );
}


%>

    </body>
</html>
