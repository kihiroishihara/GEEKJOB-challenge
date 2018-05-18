<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        // ■表示例 
         //例１「 84 = 2 * 2 * 3 * 7 」 
         //例２「396 = 2 * 2 * 3 * 3 あまり 11 」 
         //例３「997 = あまり 997 」 
         //例１にあるように，原則，すべての素数を列挙し，元の値とともに画面表示してください。 
         //例２にあるように，求める素因数は，１桁のもののみとします。
         //このとき，分解しきれなかった数については，「あまり○」の要領で表示させてください。 
         //例３にあるように，対象とする数が素数の場合に，特別な処理を記述する必要はありません。
         //ただし，「この数は素数です」といった表示を行っても構いません。 
         
         
         // 受け取るパラメータの文字コード
         request.setCharacterEncoding("UTF-8");
         //文字列を数字に型変換
         int X = Integer.parseInt(request.getParameter("Primefactors"));
         int Y = X ;
         //入力数字＝
         out.println(X + "=");
         
         //素因数分解(2，3，5，7)
         for(int i = 2 ; X > 1 && i < 8 ; i++){
             while(X % i == 0){
                 out.print(i + "×");
                 X /= i;    
             }
         }
         
         
         //あまりの表示
         if(X != 1){
             if(X == Y){
                 out.println("この数字は素数です。");    
             }else{
             out.println("1 あまり" + X);
             }
         }
         
         
         
         %>
    </body>
</html>
