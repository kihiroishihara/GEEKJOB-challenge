<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理システムの作成-作業選択</title>
    </head>
    <body>
        <%
        // 受け取るパラメータの文字コード
        request.setCharacterEncoding("UTF-8");
        // 1. type の値を元に，商品種別の日本語情報を表示してください。
        if(request.getParameter("type").equals("1")){
            response.sendRedirect("jdbc13-5.jsp");    
        }else if(request.getParameter("type").equals("2")){
            response.sendRedirect("jdbc13-7.jsp");
        }else if(request.getParameter("type").equals("3")){
            session.removeAttribute("login");
            response.sendRedirect("jdbc13-1.html");
        }else if(request.getParameter("type").equals("")){
            response.sendRedirect("jdbc13-3.jsp");
        }
        %>
        
    </body>
</html>
