package ec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//会員登録-確認画面
//・フォームで入力された文字や選択を表示し、「上記の内容で登録いたします。よろしいですか？」と表示。 
//　「はい」でregistration_complete「いいえ」でregistrationに値を保持したまま(戻った時にフォーム入力済みになっている)遷移
//・もし入力が不足していた場合はどの項目のデータが不足しているのかを表示。insertに値を保持したまま遷移するリンクを表示

public class RegistrationConfirm extends HttpServlet {

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
            UserData ud = new UserData();
            ud.setName(request.getParameter("name"));
            ud.setPassword(request.getParameter("password"));
            ud.setMail(request.getParameter("mail"));
            ud.setAddress1(request.getParameter("address1"));
            ud.setAddress2(request.getParameter("address2"));
            ud.setAddress3(request.getParameter("address3"));
            
            //ユーザー情報群をセッションに格納
            session.setAttribute("ud", ud);
            System.out.println("ユーザー情報群をセッションに格納完了");
            
            //registrationcomplete画面にフォワード
            request.getRequestDispatcher("/registrationconfirm.jsp").forward(request, response);
        }catch(Exception e){
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
