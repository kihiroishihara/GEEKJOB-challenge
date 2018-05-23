package org.mypackage.JDBC;

import java.sql.*;


class jdbc5 {
    public static void main (String[] args) throws SQLException, ClassNotFoundException{
        
        //データベースへ接続
        Connection db_con = null;
        PreparedStatement db_st = null;
        ResultSet db_data = null;
        
        
        try{
            // Mysql用のJDBCドライバのインスタンスを生成
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  
            // DriverManagerによる接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","KIHIRO","kihi2525");
            
            //PreparedStatementの取得
            db_st = db_con.prepareStatement("SELECT profilesID,name,tel,age,birthday FROM profile WHERE(name LIKE ?);");
            db_st.setString(1,"%m%");//profilesID
            //SQL文の実行
            db_data = db_st.executeQuery();
            //ResultSetのデータの有無をチェック
            //ResultSetから特定のカラムの情報を取得
            while(db_data.next()){
                System.out.println("ID：" + db_data.getInt("profilesID"));
                System.out.println("名前：" + db_data.getString("name"));
                System.out.println("電話番号：" + db_data.getString("tel"));
                System.out.println("年齢：" + db_data.getInt("age"));
                System.out.println("生年月日：" + db_data.getString("birthday"));
            }
   
        } catch (SQLException e) {
            System.out.println("データベースにアクセス出来ませんでした。" + e.getMessage());
        } catch (Exception o) {
            System.out.println(o.getMessage());
        }finally {
            if (db_con != null){
                try {
                    db_data.close();
                    db_st.close();
                    db_con.close();
                } catch (Exception i) {
                    System.out.println("クローズできませんでした。" + i.getMessage());
                }
            }
        }
    }
}    