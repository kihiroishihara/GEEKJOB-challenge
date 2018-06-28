package ec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//トップページ
//・このシステムの簡単な説明が記載されている。テキストは自由
//・キーワード検索フォームが設置されている。検索の遷移先はsearchで、GETメソッド。未入力ならエラーを表示

public class Top extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //セッションスタート
        HttpSession session = request.getSession(); 
        //リクエストパラメータの文字コードをUTF-8に変更
        request.setCharacterEncoding("UTF-8");
        
        //不正アクセスを防止するために、ランダムな値をセッションに格納
        if(session.getAttribute("ac")==null){
           session.setAttribute("ac", (int) (Math.random() * 1000));
        }
        System.out.print(session.getAttribute("ac"));
        
        
        
        //top画面にフォワード
        request.getRequestDispatcher("/top.jsp").forward(request, response);   
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
