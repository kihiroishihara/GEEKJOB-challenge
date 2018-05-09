<%-- 
    Document   : newjsp
    Created on : 2018/05/09, 16:01:40
    Author     : Kihiro
--%>

<%@page import="org.camp.servlet.Resultdata" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
  <%
    Resultdata data = (Resultdata)request.getAttribute("Data");
  %>
  <meta http-equiv="contentType" content="text/html: charset=UTF-8">
  <title>JSP Page</title>
  </head>
  <body>
  <%
    if(data != null){
      out.print("<h1>あなたの" + data.getD() + "の運勢は、" + data.getLuck() + "です</h1>");
    }
  %>
  </body>
</html>


