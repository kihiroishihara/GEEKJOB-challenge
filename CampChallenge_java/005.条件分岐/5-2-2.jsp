<%-- 
    Document   : 5-2-2
    Created on : 2018/05/08, 14:08:38
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
char c = 'い';
switch ( c ) {
case 'A':
out.print("英語");
break;
case 'あ':
out.print("日本語");
break;
}
%>
    </body>
</html>
