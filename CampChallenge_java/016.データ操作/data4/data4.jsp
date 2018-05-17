

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
        // 1. type の値を元に，商品種別の日本語情報を表示してください。
        if(request.getParameter("type").equals("1")){
            out.println("購入した商品は 雑貨 です。");    
        }else if(request.getParameter("type").equals("2")){
            out.println("購入した商品は 生食食品 です。");
        }else if(request.getParameter("type").equals("3")){
            out.println("購入した商品は その他 です。");
        }
        // 2. 商品の単価を求め，画面に表示してください。
        int total = Integer.parseInt(request.getParameter("total"));
        int count = Integer.parseInt(request.getParameter("count"));
        out.println("単価は" + total / count + "円。");
        // 3. 商品購入総額に応じてポイントを計算し，その値を画面に表示してください。
        //なお，ポイントの計算は，商品購入総額を基準にして，以下の要領で行います。 
        //3000 円未満 ... 0% 
        //3000 円以上で5000円未満 ... 購入総額の 4% 
        //5000 円以上 ... 購入総額の 5%
        if(total < 3000){
            out.println("ポイントは 0ポイント です。");    
        }else if(total >= 3000 && total < 5000){
            double point1 = total * 0.04;
            out.println("ポイントは " + point1 +  "ポイント です。");
        }else if(total >= 5000){
            double point2 = total * 0.05;
            out.println("ポイントは " + point2 +  "ポイント です。");;
        }
        %>
    </body>
</html>
