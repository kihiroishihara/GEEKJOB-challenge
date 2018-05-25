
<%@page contentType="text/html"  pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%!
// サーブレットのinitメソッドに相当
public void jspInit() {
    try {
        // JDBCドライバをロード
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>在庫管理システムの作成-商品登録完了</title>
    </head>
    <body>
        <% 
        String l = (String)session.getAttribute("login");
        if(l != null){
        %>
        <h1>登録完了</h1>
        
        
        <%      
        // データベースへのアクセス開始
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        try {
            // データベースに接続するConnectionオブジェクトの取得
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","KIHIRO","kihi2525");
            // データベース操作を行うためのStatementオブジェクトの取得
            db_st = db_con.prepareStatement("INSERT INTO Zzaiko(ID,name,price,zaiko)VALUES(?, ?, ?, ?)");
            
            request.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(request.getParameter("id"));
            String n = request.getParameter("name");
            int p = Integer.parseInt(request.getParameter("p"));
            int z = Integer.parseInt(request.getParameter("z"));
            
            db_st.setInt(1, id);
            db_st.setString(2, n);
            db_st.setInt(3, p);
            db_st.setInt(4, z);
            
            //SQL文の実行
            int result = db_st.executeUpdate();
            out.println("「" + n +  "」が追加されました。<br><br>--登録内容--<br>");
            //PreparedStatementの取得
            db_st = db_con.prepareStatement("SELECT ID,name,price,zaiko FROM Zzaiko WHERE ID=?");
             db_st.setInt(1, id);
           
            //SQL文の実行
            db_data = db_st.executeQuery();
            
            //ResultSetのデータの有無をチェック
            //ResultSetから特定のカラムの情報を取得
            while(db_data.next()){
                out.println("ID：" + db_data.getInt("id") +"<br>");
                out.println("商品名：" + db_data.getString("name")+"<br>");
                out.println("価格：" + db_data.getInt("price")+"<br>");
                out.println("在庫数：" + db_data.getInt("zaiko")+"<br>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // データベースとの接続をクローズ
            try { db_data.close(); } catch (Exception e) {}
            try { db_st.close(); } catch (Exception e) {}
            try { db_con.close(); } catch (Exception e) {}
        }
                
%>
<br><br><br><br>
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


        <br>
        <p>続けて登録する商品の情報を入力してください。</p>
        <form action="./jdbc13_2" method="post">
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
