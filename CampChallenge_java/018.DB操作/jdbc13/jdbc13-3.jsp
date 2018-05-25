<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理システムの作成-作業選択</title>
    </head>
    <body>
        <h1>作業選択ページ</h1>
        
        <% 
        String l = (String)session.getAttribute("login");
        if(l != null){
        %>
        
        作業を選択をしてください。
        <form action="./jdbc13-4.jsp" method="post">
        <select name="type">
         <option value="" selected="selected">選択してください</option>
         <option value="1">商品登録</option>
         <option value="2">商品閲覧</option>
         <option value="3">ログアウト</option>
         </select> 
         <!-- 送信 --> 
         <input type="submit" name="submit" value="送信">
          </form>
        
        <% 
        }else{
            response.sendRedirect("jdbc13-1.html");
        }
        
        %>
    </body>
</html>
