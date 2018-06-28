package ec;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyComplete extends HttpServlet {

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
            
            //ログインデータのIDと現在の購入金額を呼び出し
            UserDataDTO id = new UserDataDTO();
            id.setName(request.getParameter("name"));
            UserDataDTO idd = UserDataDAO.getInstance().login(id);
            int cpass = idd.getUserID();
            int total = idd.getTotal();
                
            //カートに入っている商品のコードと配送方法を登録する
            ArrayList<SearchData> udl = (ArrayList<SearchData>)session.getAttribute("cl");
            for(int i=0; i<udl.size(); i++){
                UserDataDTO userdata = new UserDataDTO();
                userdata.setUserID(cpass);
                userdata.setItemCode(udl.get(i).getCode());
                userdata.setType(Integer.parseInt(request.getParameter("optionsRadios")));
                //DBへデータの挿入
                UserDataDAO.getInstance().item(userdata);
            }
                 
            //ユーザーデータベースの総購入金額を更新
            UserDataDTO update = new UserDataDTO();
            update.setUserID(cpass);
            update.setTotal(total + Integer.parseInt(request.getParameter("total")));
            //DBへデータの挿入
            UserDataDAO .getInstance().updatetotal(update);
            
            //カートの中身を空にする
            session.removeAttribute("cl");
          
            //buycomplete画面にフォワード
            request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
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