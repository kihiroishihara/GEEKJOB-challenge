<%-- 
    Document   : 3-1
    Created on : 2018/05/08, 11:56:55
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

final int BASE = 10000;
int num = 500;

int tasu = BASE + num;
int hiku = BASE - num;
int kake = BASE * num;
int wari = BASE / num;
int amari = BASE % num;

out.println(++num);
out.println(num++);
out.println(--num);
out.println(num--);
out.println(tasu);
out.println(hiku);
out.println(kake);
out.println(wari);
out.println(amari);
%>
       
    </body>
</html>
