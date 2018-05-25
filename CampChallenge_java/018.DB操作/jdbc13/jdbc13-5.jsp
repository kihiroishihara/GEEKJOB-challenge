<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>在庫管理システムの作成-商品登録</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <% 
        String l = (String)session.getAttribute("login");
        if(l != null){
        %>
        <h1>商品登録ページ</h1>
        作業を選択をしてください。
        <form action="./jdbc13-4.jsp" method="post">
        <select name="type">
         <option value="" selected="selected">選択してください</option>
         <option value="2">商品閲覧</option>
         <option value="3">ログアウト</option>
         </select> 
         <!-- 送信 --> 
         <input type="submit" name="submit" value="送信">
        </form>
        
        <p>登録する商品の情報を入力してください。</p>
        <form action="./jdbc13-6.jsp" method="post">
         <!--profilesID,name,tel,age,birthday-->
         <p>登録番号<br><input type="text" name="id" required></p>
         <p>商品名<br><input type="text" name="name" required></p>
         <p>値段<br><input type="text" name="p" required></p>
         <p>在庫数<br><input type="text" name="z" required></p>
         <!-- 送信 --> 
         <input type="submit" name="submit" value="送信">
         <br>
        </form>
     <% 
        }else{
            response.sendRedirect("jdbc13-1.html");
        }
        
        %>  
        
    </body>
</html>
