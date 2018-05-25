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
import javax.servlet.http.HttpSession;

public class jdbc13 extends HttpServlet{
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
            
            //IDから情報を取得
            //PreparedStatementの取得
            db_st = db_con.prepareStatement("SELECT profilesID,password,name,tell,address,age,birthday FROM Zuser WHERE profilesID = ?");
            // 受け取るパラメータの文字コード
            request.setCharacterEncoding("UTF-8");
            int ID = Integer.parseInt(request.getParameter("ID"));
            String ps =request.getParameter("password");
            
            //『?』の置き換え
            db_st.setInt(1, ID);// name
            //SQL文の実行
            db_data = db_st.executeQuery();
            //ResultSetのデータの有無をチェック
            //ResultSetから特定のカラムの情報を取得
            while(db_data.next()){
                if(db_data.getString("password").equals(ps)){
                    // セッションへ登録
                    HttpSession session = request.getSession();
                    // セッションへ登録
                    session.setAttribute("login", "成功");
                    response.sendRedirect("jdbc13-3.jsp");
                }else{
                    response.sendRedirect("jdbc13-2.html");
                    break;
                }
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