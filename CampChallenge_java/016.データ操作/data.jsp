<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        // 受け取るパラメータの文字コード
        request.setCharacterEncoding("UTF-8");
        // テキストボックスの情報
        out.print(request.getParameter("Name"));
        // ラジオボタンの情報
        out.print(request.getParameter("men"));
        out.print(request.getParameter("rady"));
        // テキストエリアの情報
        out.print(request.getParameter("Text"));
        %>
    </body>
</html>
