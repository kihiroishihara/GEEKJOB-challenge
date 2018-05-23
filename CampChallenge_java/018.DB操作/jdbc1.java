package org.mypackage.JDBC;

import java.sql.*;


class jdbc1 {
    public static void main (String[] args){
        
        //データベースへ接続
        Connection db_con = null;
        
        try{
            // Mysql用のJDBCドライバのインスタンスを生成
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  
            // DriverManagerによる接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db?characterEncoding=UTF-8&serverTimezone=JST","KIHIRO","kihi2525");
             
        } catch (SQLException e) {
            System.out.println("データベースにアクセス出来ませんでした。" + e.getMessage());
        } catch (Exception o) {
            System.out.println(o.getMessage());
        }finally {
            if (db_con != null){
                try {
                    db_con.close();
                } catch (Exception i) {
                    System.out.println("クローズできませんでした。" + i.getMessage());
                }
            }
        }
    }
}    