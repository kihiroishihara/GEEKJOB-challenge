
<%@page contentType="text/html"  pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<% 
        String l = (String)session.getAttribute("login");
        if(l != null){
        %>
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
<title>在庫管理システムの作成-商品登録完了-商品一覧</title>
</head>

<body>
<h1>商品一覧ページ</h1>


    作業を選択をしてください。<form action="./jdbc13-4.jsp" method="post">
    <select name="type">
        <option value="" selected="selected">選択してください</option>
        <option value="1">商品登録</option>
        <option value="3">ログアウト</option>
    </select> 
    <!-- 送信 --> 
    <input type="submit" name="submit" value="送信">
    </form>

<br><br>

<table border='1'><tr><th>ID</th><th>商品名</th><th>価格</th><th>在庫数</th></tr>

<%      // データベースへのアクセス開始
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        try {
            // データベースに接続するConnectionオブジェクトの取得
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","KIHIRO","kihi2525");
            // データベース操作を行うためのStatementオブジェクトの取得
            db_st = db_con.prepareStatement("SELECT ID,name,price,zaiko FROM Zzaiko");
            // SQL()を実行して、結果を得る
            db_data = db_st.executeQuery();

            // 得られた結果をレコードごとに表示
            while (db_data.next()) {
                
%>
                <tr>
                <%-- レコードのIDフィールドを表示 --%>
                <td><%= db_data.getInt("ID")%></td>
                <%-- レコードのNAMEフィールドを表示 --%>
                <td><%= db_data.getString("name")%></td>
                <%-- レコードのPRICEフィールドを表示 --%>
                <td><%= db_data.getInt("price")%></td>
                <%-- レコードのZAIKOフィールドを表示 --%>
                <td><%= db_data.getInt("zaiko")%></td>
                </tr>
<%
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
</table>
<% 
        }else{
            response.sendRedirect("jdbc13-1.html");
        }
        
        %>  
</body>
</html>