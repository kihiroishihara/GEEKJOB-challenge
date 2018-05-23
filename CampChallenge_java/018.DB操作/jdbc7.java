package org.mypackage.JDBC;

import java.sql.*;


class jdbc7 {
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
            db_st = db_con.prepareStatement("UPDATE profile SET name=?,tel=?,age=?,birthday=? WHERE profilesID=?");
            //『?』の置き換え 
            db_st.setString(1, "MichaelJackson");//name
            db_st.setString(2, "0120-441-222");//tel
            db_st.setInt(3, 25);//age
            db_st.setString(4, "1192/2/9");//birthday
            db_st.setInt(5, 2);//profilesID
             //SQL文の実行
            int result = db_st.executeUpdate();
            System.out.println(result + "行が変更されました。");
            
            //PreparedStatementの取得
            db_st = db_con.prepareStatement("SELECT profilesID,name,tel,age,birthday FROM profile");
           
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