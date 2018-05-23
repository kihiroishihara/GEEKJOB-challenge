package org.mypackage.JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class jdbc11 extends HttpServlet{
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
        
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
            // 受け取るパラメータの文字コード
            request.setCharacterEncoding("UTF-8");
            int i = Integer.parseInt(request.getParameter("ID"));
            int a = Integer.parseInt(request.getParameter("age"));
            String n = request.getParameter("name");
            String t = request.getParameter("tel");
            String b = request.getParameter("birthday");
            
            db_st.setInt(5, i);//profilesID
            db_st.setString(1, n);// name
            db_st.setString(2, t);//tell
            db_st.setInt(3, a);//age
            db_st.setString(4, b);//birthday
         
            
            //SQL文の実行
            int result = db_st.executeUpdate();
            if(result == 0){
                out.println("該当するデータがありません。");
             }else{
                out.println("profilesID:" + i + "が更新されました。");
             }
            
           //PreparedStatementの取得
            db_st = db_con.prepareStatement("SELECT profilesID,name,tel,age,birthday FROM profile");
           
            //SQL文の実行
            db_data = db_st.executeQuery();
            //ResultSetのデータの有無をチェック
            //ResultSetから特定のカラムの情報を取得
            while(db_data.next()){
                out.println("ID：" + db_data.getInt("profilesID"));
                out.println("名前：" + db_data.getString("name"));
                out.println("電話番号：" + db_data.getString("tel"));
                out.println("年齢：" + db_data.getInt("age"));
                out.println("生年月日：" + db_data.getString("birthday"));
            }
   
        } catch (SQLException e) {
            out.println("データベースにアクセス出来ませんでした。" + e.getMessage());
        } catch (Exception o) {
            out.println(o.getMessage());
        }finally {
            if (db_con != null){
                try {
                    db_data.close();
                    db_st.close();
                    db_con.close();
                } catch (Exception i) {
                    out.println("クローズできませんでした。" + i.getMessage());
                }
            }
        }
    }
   }

  
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}