package ec;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//
public class MyUpdateResult extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        //セッションスタート
        HttpSession session = request.getSession();
        
        try{
            //リクエストパラメータの文字コードをUTF-8に変更
            request.setCharacterEncoding("UTF-8");
            
            //アクセスルートチェック
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからの入力を取得して、JavaBeansに格納
            UserData udu = new UserData();
            udu.setName(request.getParameter("name"));
            udu.setPassword(request.getParameter("password"));
            udu.setMail(request.getParameter("mail"));
            udu.setAddress(request.getParameter("address"));

            //ユーザー情報群をセッションに格納
            session.setAttribute("udu", udu);
            System.out.println("Session updated!!");
            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO update = new UserDataDTO();
            udu.UD2DTOMapping(update);
            update.setUserID(Integer.parseInt(request.getParameter("id")));
            
            //DBへデータの挿入
            UserDataDAO .getInstance().update(update);
            
            //結果画面での表示用に入力パラメータ―をリクエストパラメータとして保持
            request.setAttribute("udu", udu);
            
            request.getRequestDispatcher("/myupdateresult.jsp").forward(request, response); 
        }catch(Exception e){
            System.err.println(e);
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
        
   
