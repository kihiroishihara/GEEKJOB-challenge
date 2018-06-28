package ec;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//
public class Add extends HttpServlet {
    
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
            request.setCharacterEncoding("UTF-8");
            ArrayList<SearchData> cl = new ArrayList<>();
            ArrayList<SearchData> udl = (ArrayList<SearchData>)session.getAttribute("cl");
            SearchData add = new SearchData();
            add.setName(request.getParameter("name"));
            add.setUri(request.getParameter("uri"));
            add.setCode(request.getParameter("code"));
            add.setPrice(Integer.valueOf(request.getParameter("price")));
            add.setSearch(request.getParameter("search"));
            if(udl==null){
                cl.add(add);
            }else{
                for(int i=0; i<udl.size(); i++){
                cl.add(udl.get(i));
                System.out.print(udl.get(i));
               }
                cl.add(add);
            }
     
            
            //ユーザー情報群をセッションに格納
            session.setAttribute("cl", cl);
            session.setAttribute("s", request.getParameter("search"));
            
            request.getRequestDispatcher("/add.jsp").forward(request, response);
            
        
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

