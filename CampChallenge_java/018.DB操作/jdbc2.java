package org.mypackage.JDBC;

import java.sql.*;


class jdbc2 {
    public static void main (String[] args) throws SQLException, ClassNotFoundException{
        
        //データベースへ接続
        Connection db_con = null;
        PreparedStatement db_st = null;
        
        
        try{
            // Mysql用のJDBCドライバのインスタンスを生成
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  
            // DriverManagerによる接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","KIHIRO","kihi2525");
            
            //PreparedStatementの取得
            db_st = db_con.prepareStatement("INSERT INTO profile(profilesID, name, tel, age, birthday)VALUES(?, ?, ?, ?, ?)");
            //『?』の置き換え 
            db_st.setInt(1, 6);//profilesID
            db_st.setString(2, "山田花子");// name
            db_st.setString(3, "090-1234-5678");//tell
            db_st.setInt(4, 12);//age
            db_st.setString(5, "2008/7/5");//birthday
            
            
            //SQL文の実行
            int result = db_st.executeUpdate();
            System.out.println(result + "行が追加されました。");
            
            
        } catch (SQLException e) {
            System.out.println("データベースにアクセス出来ませんでした。" + e.getMessage());
        } catch (Exception o) {
            System.out.println(o.getMessage());
        }finally {
            if (db_con != null){
                try {
                    db_st.close();
                    db_con.close();
                } catch (Exception i) {
                    System.out.println("クローズできませんでした。" + i.getMessage());
                }
            }
        }
    }
}    