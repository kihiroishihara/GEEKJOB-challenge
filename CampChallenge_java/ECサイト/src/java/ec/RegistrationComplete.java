package ec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//会員登録-完了画面
//・プロフィール用のDBに値を挿入。この際、現在時(年日時分)を組み込み関数で取得し、追加。
//・「以上の内容で登録しました。」とregistration_confirmのようにフォームで入力された値を表示
//・「トップページへ戻る」のリンクが、目立つ場所に設置されている

public class RegistrationComplete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
            
            //セッションに格納したユーザー情報群を呼び出し
            UserData ud = (UserData)session.getAttribute("ud");
            System.out.println("ユーザー情報群を呼び出し");
            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO userdata = new UserDataDTO();
            ud.UD2DTOMapping(userdata);
            System.out.println("DB専用のパラメータに変換");
            //DBへデータの挿入
            UserDataDAO.getInstance().insert(userdata);
            System.out.println("データの挿入");
            
            //成功したのでセッションの値を削除
            session.removeAttribute("ud");
            
            //結果画面での表示用に入力パラメータ―をリクエストパラメータとして保持
            request.setAttribute("ud", ud);
            System.out.println("リクエストパラメータとして保持");
            
            request.getRequestDispatcher("/registrationcomplete.jsp").forward(request, response);
        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
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

