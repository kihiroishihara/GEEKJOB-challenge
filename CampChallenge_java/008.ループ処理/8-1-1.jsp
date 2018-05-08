<%-- 
    Document   : 8-1-1
    Created on : 2018/05/08, 16:19:23
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

{
          long answer = 1;

          for( long i=1; i<=20; i++ ){
     answer = answer * 8;
}

      
         out.println(answer);
     }

%>

    </body>
</html>
