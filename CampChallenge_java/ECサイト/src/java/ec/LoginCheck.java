package ec;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//ログインチェック
//・ログイン情報が正しいか判断

public class LoginCheck extends HttpServlet {

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
           
            //未入力がある場合はloginerror.jspへ
            if(request.getParameter("name").equals("") || request.getParameter("password").equals("")){
                //loginerror画面にフォワード
                request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
            }else{
                //passwordが正しいか判断
                UserDataDTO loginpass = new UserDataDTO();
                loginpass.setName(request.getParameter("name"));System.out.print(request.getParameter("name"));
                UserDataDTO login = UserDataDAO .getInstance().login(loginpass);
                String cpass = login.getPassword();System.out.print(cpass);
                int cflg = login.getDaleteFlg();System.out.print(cflg);
                
                //passwordが正しい場合は元の画面に，誤っている場合はログインページへ
                if(cpass.equals(request.getParameter("password"))){
                    //deleteFlgが1の場合はログインできない
                    if(cflg == 0){
                    // セッションへ登録
                    session.setAttribute("login",login);
                    String url = request.getParameter("url") ;
                    response.sendRedirect(url);
                    session.setAttribute("url", url);
                    }else{
                    //loginerror画面にフォワード
                    request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
                    }
                }else{
                    //loginerror画面にフォワード
                    request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
                }
            }
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
