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

out.print(++num);out.println();
out.print(num++); out.println();
out.print(--num); out.println();
out.print(num--);out.println();
out.print(tasu);out.println();
out.print(hiku);out.println();
out.print(kake);out.println();
out.print(wari);out.println();
out.print(amari);out.println();
%>
       
    </body>
</html>
